package dao.BD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BD.voBDcontractdatail;
import vo.BE.voBECustomer;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBDcontractdatail {
	connDB2015 connDB = new connDB2015();  //连接数据库
	daoProceduce getNo =new daoProceduce();

	//插入员工表 
//	public static void main(String[] args) {
//		new daoBDcontractdatail().insBDcontractdatail(new voBDcontractdatail());
//	}
	public Boolean insBDcontractdatail(voBDcontractdatail dtcontractdatail)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		Boolean flag = false;            //操作是否成功		
		PreparedStatement psmt = null;
		String sSql = "insert into BDcontractdatail values(?,?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtcontractdatail.getContractNo());
			psmt.setString(2, dtcontractdatail.getProductNo());
			psmt.setInt(3, dtcontractdatail.getQuantity());
			psmt.setDouble(4, dtcontractdatail.getPrice());
			
//			//自动产生编号
//			String sNo=getNo.getAutoNo("BDcontractdatail").trim();
//			System.out.println(sNo);
//			psmt.setString(1, sNo);
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
	//更新字典表 
	public boolean updBDcontractdatail(voBDcontractdatail dtcontractdatail)
	{
		try {
			if(delBDcontractdatail(dtcontractdatail)==false) return false;
			if(insBDcontractdatail(dtcontractdatail)== null) return false;		
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
	///删除
	public boolean delBDcontractdatail(voBDcontractdatail dtcontractdatail) {

		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  BDcontractdatail where contractdatailNo=? and productNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtcontractdatail.getContractNo());
			psmt.setString(2, dtcontractdatail.getProductNo());
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
	///查询
	public ArrayList<voBDcontractdatail> qryBDcontractdatail(Map<String,String> parms) {
		ArrayList<voBDcontractdatail> List=new ArrayList<voBDcontractdatail>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BDcontractdatail  where 1=1 ");
		for(Map.Entry<String, String> t:parms.entrySet()){ 
			sSql.append(" and "+t.getKey() + " = " + t.getValue());
		}
		sSql.append(" order by planNo");
		try {
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //实例化vo
				voBDcontractdatail dtcontractdatail = new voBDcontractdatail();
				dtcontractdatail.setContractNo(rs.getString("contractdatailNo"));
				dtcontractdatail.setProductNo(rs.getString("productNo"));
				dtcontractdatail.setQuantity(rs.getInt("quantity"));
				dtcontractdatail.setPrice(rs.getDouble("price"));

				List.add(dtcontractdatail);
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
