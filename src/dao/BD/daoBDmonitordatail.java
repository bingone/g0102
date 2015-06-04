package dao.BD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BD.voBDmonitordatail;
import vo.BE.voBECustomer;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBDmonitordatail {
	connDB2015 connDB = new connDB2015();  //连接数据库
	daoProceduce getNo =new daoProceduce();

	//插入员工表 
//	public static void main(String[] args) {
//		new daoBDmonitordatail().insBDmonitordatail(new voBDmonitordatail());
//	}
	public Boolean insBDmonitordatail(voBDmonitordatail dtmonitordatail)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		Boolean flag = false;            //操作是否成功		
		PreparedStatement psmt = null;
		String sSql = "insert into BDmonitordatail values(?,?,?,?,?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtmonitordatail.getMonitorNo());
			psmt.setString(2, dtmonitordatail.getProductNo());
			psmt.setInt(3, dtmonitordatail.getGoodnum());
			psmt.setInt(4, dtmonitordatail.getBadnum());
			psmt.setString(5, dtmonitordatail.getSpecifiction());
			psmt.setString(6, dtmonitordatail.getRequality());
			psmt.setString(7, dtmonitordatail.getRepackaging());
			//自动产生编号
			String sNo=getNo.getAutoNo("BDmonitordatail").trim();
			System.out.println(sNo);
			psmt.setString(1, sNo);
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
	public boolean updBDmonitordatail(voBDmonitordatail dtmonitordatail)
	{
		try {
			if(delBDmonitordatail(dtmonitordatail)==false) return false;
			if(insBDmonitordatail(dtmonitordatail)== null) return false;		
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
	public boolean delBDmonitordatail(voBDmonitordatail dtmonitordatail) {

		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  BDmonitordatail where monitordatailNo=? and productNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtmonitordatail.getMonitorNo());
			psmt.setString(2, dtmonitordatail.getProductNo());
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
	public ArrayList<voBDmonitordatail> qryBDmonitordatail(Map<String,String> parms) {
		ArrayList<voBDmonitordatail> List=new ArrayList<voBDmonitordatail>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BDmonitordatail  where 1=1 ");
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
				voBDmonitordatail dtmonitordatail = new voBDmonitordatail();
				dtmonitordatail.setMonitorNo(rs.getString("monitordatailNo"));
				dtmonitordatail.setProductNo(rs.getString("productNo"));
				dtmonitordatail.setGoodnum(rs.getInt("goodnum"));
				dtmonitordatail.setBadnum(rs.getInt("badnum"));
				dtmonitordatail.setSpecifiction(rs.getString("specifiction"));
				dtmonitordatail.setRequality(rs.getString("requality"));
				dtmonitordatail.setRepackaging(rs.getString("repackaging"));
				List.add(dtmonitordatail);
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
