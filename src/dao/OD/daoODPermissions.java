package dao.OD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import vo.OD.voODPermissions;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoODPermissions {
	connDB2015 connDB = new connDB2015();  //连接数据库
	daoProceduce getNo =new daoProceduce();

	//插入员工表 
//	public static void main(String[] args) {
//		new daoODPermissions().insODPermissions(new voODPermissions());
//	}
	public boolean insODPermissions(voODPermissions dtPermissions)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		boolean flag = false;            //操作是否成功		
		PreparedStatement psmt = null;
		String sSql = "insert into ODPermissions values(?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtPermissions.getUserNo());
			psmt.setDate(3, dtPermissions.getCreateDate());
			psmt.setString(2, dtPermissions.getFunctionNo());
			//自动产生编号
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
	public boolean updODPermissions(voODPermissions dtPermissions)
	{
		try {
			if(delODPermissions(dtPermissions)==false) return false;
			if(insODPermissions(dtPermissions)== false) return false;		
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
	public boolean delODPermissions(voODPermissions dtPermissions) {

		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  ODPermissions where functionNo=? and userNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtPermissions.getFunctionNo());
			psmt.setString(2, dtPermissions.getUserNo());
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
	public ArrayList<voODPermissions> qryODPermissions(Map<String,String> parms) {
		ArrayList<voODPermissions> List=new ArrayList<voODPermissions>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  ODPermissions  where 1=1 ");
		for(Map.Entry<String, String> t:parms.entrySet()){ 
			sSql.append(" and "+t.getKey() + " = " + t.getValue());
		}
		sSql.append(" order by ProductNo");
		try {
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //实例化vo
				voODPermissions dtPermissions = new voODPermissions();
				dtPermissions.setFunctionNo(rs.getString("functionNo"));
				dtPermissions.setCreateDate(rs.getDate("creatDate"));
				dtPermissions.setUserNo(rs.getString("userNo"));
				List.add(dtPermissions);
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
