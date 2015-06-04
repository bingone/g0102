package dao.BD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BD.voBDreturnitem;
import vo.BE.voBECustomer;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBDreturnitem {
	connDB2015 connDB = new connDB2015();  //连接数据库
	daoProceduce getNo =new daoProceduce();

	//插入员工表 
//	public static void main(String[] args) {
//		new daoBDreturnitem().insBDreturnitem(new voBDreturnitem());
//	}
	public String insBDreturnitem(voBDreturnitem dtreturnitem)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		String flag = null;            //操作是否成功		
		PreparedStatement psmt = null;
		String sSql = "insert into BDreturnitem values(?,?,?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(2, dtreturnitem.getContractNo());
			psmt.setDate(3, dtreturnitem.getRuturndate());
			psmt.setString(4,dtreturnitem.getReturnReason());
			psmt.setString(5, dtreturnitem.getReturnStatus());
			
			//自动产生编号
			String sNo=getNo.getAutoNo("BDreturnitem").trim();
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
	public boolean updBDreturnitem(voBDreturnitem dtreturnitem)
	{
		try {
			if(delBDreturnitem(dtreturnitem)==false) return false;
			if(insBDreturnitem(dtreturnitem)== null) return false;		
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
	public boolean delBDreturnitem(voBDreturnitem dtreturnitem) {

		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  BDreturnitem where returnitemNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtreturnitem.getContractNo());
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
	public ArrayList<voBDreturnitem> qryBDreturnitem(Map<String,String> parms) {
		ArrayList<voBDreturnitem> List=new ArrayList<voBDreturnitem>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BDreturnitem  where 1=1 ");
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
				voBDreturnitem dtreturnitem = new voBDreturnitem();
				dtreturnitem.setContractNo(rs.getString("returnitemNo"));
				dtreturnitem.setReturnNo(rs.getString("returnNo"));
				dtreturnitem.setRuturndate(rs.getDate("ruturndate"));
				dtreturnitem.setReturnReason(rs.getString("returnReason"));
				dtreturnitem.setReturnStatus(rs.getString("returnStatus"));
				List.add(dtreturnitem);
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
