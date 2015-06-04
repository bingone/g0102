package dao.BD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BD.voBDplandatail;
import vo.BE.voBECustomer;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBDplandatail {
	connDB2015 connDB = new connDB2015();  //连接数据库
	daoProceduce getNo =new daoProceduce();

	//插入员工表 
//	public static void main(String[] args) {
//		new daoBDplandatail().insBDplandatail(new voBDplandatail());
//	}
	public Boolean insBDplandatail(voBDplandatail dtplandatail)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		boolean flag = false;            //操作是否成功		
		PreparedStatement psmt = null;
		String sSql = "insert into BDplandatail values(?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtplandatail.getPlanNo());
			psmt.setString(2, dtplandatail.getProductNo());
			psmt.setInt(3,   dtplandatail.getQuantity());
			
			//自动产生编号
//			String sNo=getNo.getAutoNo("BDplandatail").trim();
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
	public boolean updBDplandatail(voBDplandatail dtplandatail)
	{
		try {
			if(delBDplandatail(dtplandatail)==false) return false;
			if(insBDplandatail(dtplandatail)== null) return false;		
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
	public boolean delBDplandatail(voBDplandatail dtplandatail) {

		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  BDplandatail where planNo=? and productNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtplandatail.getPlanNo());
			psmt.setString(2, dtplandatail.getProductNo());
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
	public ArrayList<voBDplandatail> qryBDplandatail(Map<String,String> parms) {
		ArrayList<voBDplandatail> List=new ArrayList<voBDplandatail>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BDplandatail  where 1=1 ");
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
				voBDplandatail dtplandatail = new voBDplandatail();
				dtplandatail.setPlanNo(rs.getString("planNo"));
				dtplandatail.setProductNo(rs.getString("productNo"));
				dtplandatail.setQuantity(rs.getInt("quantity"));
				List.add(dtplandatail);
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
