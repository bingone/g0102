package dao.BD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BD.voBDprocureplan;
import vo.BE.voBECustomer;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBDprocureplan {
	connDB2015 connDB = new connDB2015();  //连接数据库
	daoProceduce getNo =new daoProceduce();

	//插入员工表 
//	public static void main(String[] args) {
//		new daoBDprocureplan().insBDprocureplan(new voBDprocureplan());
//	}
	public String insBDprocureplan(voBDprocureplan dtprocureplan)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		String flag = null;            //操作是否成功		
		PreparedStatement psmt = null;
		String sSql = "insert into BDprocureplan values(?,?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(2, dtprocureplan.getEmployeeNo());
			psmt.setString(3,   dtprocureplan.getBranchNo());
			psmt.setDate(4, dtprocureplan.getPlandate());
			
			//自动产生编号
			String sNo=getNo.getAutoNo("BDprocureplan").trim();
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
	public boolean updBDprocureplan(voBDprocureplan dtprocureplan)
	{
		try {
			if(delBDprocureplan(dtprocureplan)==false) return false;
			if(insBDprocureplan(dtprocureplan)== null) return false;		
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
	public boolean delBDprocureplan(voBDprocureplan dtprocureplan) {

		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  BDprocureplan where planNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtprocureplan.getPlanNo());
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
	public ArrayList<voBDprocureplan> qryBDprocureplan(Map<String,String> parms) {
		ArrayList<voBDprocureplan> List=new ArrayList<voBDprocureplan>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BDprocureplan  where 1=1 ");
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
				voBDprocureplan dtprocureplan = new voBDprocureplan();
				dtprocureplan.setPlanNo(rs.getString("planNo"));
				dtprocureplan.setEmployeeNo(rs.getString("employeeNo"));
				dtprocureplan.setBranchNo(rs.getString("branchNo"));
				dtprocureplan.setPlandate(rs.getDate("plandate"));
				List.add(dtprocureplan);
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
