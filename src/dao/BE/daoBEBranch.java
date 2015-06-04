package dao.BE;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BE.voBEBranch;
import vo.BE.voBECustomer;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBEBranch {
	connDB2015 connDB = new connDB2015();  //连接数据库
	daoProceduce getNo =new daoProceduce();

	//插入员工表 
//	public static void main(String[] args) {
//		new daoBEBranch().insBEBranch(new voBEBranch());
//	}
	public String insBEBranch(voBEBranch dtBranch)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		String flag = null;            //操作是否成功		
		PreparedStatement psmt = null;
		String sSql = "insert into BEBranch values(?,?,?,?,?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(2, dtBranch.getBranchName());
			psmt.setString(3,   dtBranch.getTelephone());
			psmt.setString(4, dtBranch.getAddress());
			psmt.setString(5, dtBranch.getBranchType());
			psmt.setString(6, dtBranch.getEmail());
			psmt.setString(7, dtBranch.getZip());
			//自动产生编号
			String sNo=getNo.getAutoNo("BEBranch").trim();
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
	public boolean updBEBranch(voBEBranch dtBranch)
	{
		try {
			if(delBEBranch(dtBranch)==false) return false;
			if(insBEBranch(dtBranch)== null) return false;		
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
	public boolean delBEBranch(voBEBranch dtBranch) {

		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  BEBranch where BranchNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtBranch.getBranchNo());
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
	public ArrayList<voBEBranch> qryBEBranch(Map<String,String> parms) {
		ArrayList<voBEBranch> List=new ArrayList<voBEBranch>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BEBranch  where 1=1 ");
		for(Map.Entry<String, String> t:parms.entrySet()){ 
			sSql.append(" and "+t.getKey() + " = " + t.getValue());
		}
		sSql.append(" order by BranchNo");
		try {
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //实例化vo
				voBEBranch dtBranch = new voBEBranch();
				dtBranch.setBranchNo(rs.getString("BranchNo"));
				dtBranch.setBranchName(rs.getString("BranchName"));
				dtBranch.setTelephone(rs.getString("Telephone"));
				dtBranch.setAddress(rs.getString("address"));
				dtBranch.setBranchType(rs.getString("branchType"));
				dtBranch.setEmail(rs.getString("email"));
				dtBranch.setZip(rs.getString("zip"));
				List.add(dtBranch);
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
