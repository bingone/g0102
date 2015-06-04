package dao.BD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BD.voBDcontract;
import vo.BE.voBECustomer;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBDcontract {
	connDB2015 connDB = new connDB2015();  //连接数据库
	daoProceduce getNo =new daoProceduce();

	//插入员工表 
//	public static void main(String[] args) {
//		new daoBDcontract().insBDcontract(new voBDcontract());
//	}
	public String insBDcontract(voBDcontract dtcontract)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		String flag = null;            //操作是否成功		
		PreparedStatement psmt = null;
		String sSql = "insert into BDcontract values(?,?,?,?,?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(2, dtcontract.getCustomerNo());
			psmt.setString(3, dtcontract.getEmployeeNo());
			psmt.setDouble(4, dtcontract.getOrdersum());
			psmt.setDate(5, dtcontract.getSigndate());
			psmt.setString(6,dtcontract.getPaymentway());
			psmt.setString(7, dtcontract.getRefunds());
			
			//自动产生编号
			String sNo=getNo.getAutoNo("BDcontract").trim();
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
	//更新字典表 
	public boolean updBDcontract(voBDcontract dtcontract)
	{
		try {
			if(delBDcontract(dtcontract)==false) return false;
			if(insBDcontract(dtcontract)== null) return false;		
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
	public boolean delBDcontract(voBDcontract dtcontract) {

		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  BDcontract where contractNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtcontract.getContractNo());
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
	public ArrayList<voBDcontract> qryBDcontract(Map<String,String> parms) {
		ArrayList<voBDcontract> List=new ArrayList<voBDcontract>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BDcontract  where 1=1 ");
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
				voBDcontract dtcontract = new voBDcontract();
				dtcontract.setContractNo(rs.getString("contractNo"));
				dtcontract.setEmployeeNo(rs.getString("employeeNo"));
				dtcontract.setCustomerNo(rs.getString("customerNo"));
				dtcontract.setSigndate(rs.getDate("signdate"));
				dtcontract.setOrdersum(rs.getDouble("ordersum"));
				dtcontract.setPaymentway(rs.getString("paymentway"));
				dtcontract.setRefunds(rs.getString("refunds"));
				List.add(dtcontract);
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
