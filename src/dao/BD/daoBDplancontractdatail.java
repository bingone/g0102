package dao.BD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BD.voBDplancontractdatail;
import vo.BE.voBECustomer;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBDplancontractdatail {
	connDB2015 connDB = new connDB2015();  //连接数据库
	daoProceduce getNo =new daoProceduce();

	//插入员工表 
//	public static void main(String[] args) {
//		new daoBDplancontractdatail().insBDplancontractdatail(new voBDplancontractdatail());
//	}
	public Boolean insBDplancontractdatail(voBDplancontractdatail dtplancontractdatail)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		Boolean flag = false;            //操作是否成功		
		PreparedStatement psmt = null;
		String sSql = "insert into BDplancontractdatail values(?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtplancontractdatail.getContractNo());
			psmt.setString(2, dtplancontractdatail.getPlanNo());
			
//			//自动产生编号
//			String sNo=getNo.getAutoNo("BDplancontractdatail").trim();
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
	public boolean updBDplancontractdatail(voBDplancontractdatail dtplancontractdatail)
	{
		try {
			if(delBDplancontractdatail(dtplancontractdatail)==false) return false;
			if(insBDplancontractdatail(dtplancontractdatail)== null) return false;		
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
	public boolean delBDplancontractdatail(voBDplancontractdatail dtplancontractdatail) {

		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  BDplancontractdatail where planNo=? and contractNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtplancontractdatail.getContractNo());
			psmt.setString(2, dtplancontractdatail.getPlanNo());
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
	public ArrayList<voBDplancontractdatail> qryBDplancontractdatail(Map<String,String> parms) {
		ArrayList<voBDplancontractdatail> List=new ArrayList<voBDplancontractdatail>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BDplancontractdatail  where 1=1 ");
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
				voBDplancontractdatail dtplancontractdatail = new voBDplancontractdatail();
				dtplancontractdatail.setContractNo(rs.getString("plancontractdatailNo"));
				dtplancontractdatail.setPlanNo(rs.getString("planNo"));

				List.add(dtplancontractdatail);
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
