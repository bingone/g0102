package dao.BE;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BE.voBECustomer;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBECustomer {
	connDB2015 connDB = new connDB2015();  //
	daoProceduce getNo =new daoProceduce();

	//
//	public static void main(String[] args) {
//		new daoBECustomer().insBECustomer(new voBECustomer());
//	}
	public String insBECustomer(voBECustomer dtCustomer)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		String flag = null;            //
		PreparedStatement psmt = null;
		String sSql = "insert into BECustomer values(?,?,?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(2, dtCustomer.getCustomerName());
			psmt.setString(3,   dtCustomer.getTelephone());
			psmt.setString(4, dtCustomer.getAddress());
			psmt.setString(5, dtCustomer.getZip());
			//
			String sNo=getNo.getAutoNo("BECustomer").trim();
			System.out.println(sNo);
			psmt.setString(1, sNo);
			int nReturn = psmt.executeUpdate();
			if (nReturn == 1) flag = sNo;			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();
			connDB.closeConn();
			
		}
		return flag;		
	}
	//
	public boolean updBECustomer(voBECustomer dtCustomer)
	{
		try {
			if(delBECustomer(dtCustomer)==false) return false;
			if(insBECustomer(dtCustomer)== null) return false;		
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();
			connDB.closeConn();
		}
		return true;		
	}
	///ɾ��
	public boolean delBECustomer(voBECustomer dtCustomer) {

		boolean flag = false;               //
		PreparedStatement psmt = null;
		String sSql = "delete from  BECustomer where CustomerNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtCustomer.getCustomerNo());
			int nReturn = psmt.executeUpdate();
			if (nReturn == 1) flag = true;			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();
			connDB.closeConn();
		}
		return flag;		
	}
	///
	public ArrayList<voBECustomer> qryBECustomer(Map<String,String> parms) {
		ArrayList<voBECustomer> List=new ArrayList<voBECustomer>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BECustomer  where 1=1 ");
		for(Map.Entry<String, String> t:parms.entrySet()){ 
			sSql.append(" and "+t.getKey() + " = " + t.getValue());
		}
		sSql.append(" order by customerNo");
		try {
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //
				voBECustomer dtCustomer = new voBECustomer();
				dtCustomer.setCustomerNo(rs.getString("CustomerNo"));
				dtCustomer.setCustomerName(rs.getString("CustomerName"));
				dtCustomer.setTelephone(rs.getString("Telephone"));
				dtCustomer.setAddress(rs.getString("address"));
				dtCustomer.setZip(rs.getString("zip"));
				List.add(dtCustomer);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();
			connDB.closeConn();
		}
		return List;		
	}	
}
