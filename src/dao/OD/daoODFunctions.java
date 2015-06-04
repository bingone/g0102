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
import vo.OD.voODFunctions;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoODFunctions {
	connDB2015 connDB = new connDB2015();  //�������ݿ�
	daoProceduce getNo =new daoProceduce();

	//����Ա���� 
//	public static void main(String[] args) {
//		new daoODFunctions().insODFunctions(new voODFunctions());
//	}
	public String insODFunctions(voODFunctions dtFunctions)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		String flag = null;            //�����Ƿ�ɹ�		
		PreparedStatement psmt = null;
		String sSql = "insert into ODFunctions values(?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(2, dtFunctions.getDescription());
			psmt.setDate(3, dtFunctions.getCreateDate());
			//�Զ��������
			String sNo=getNo.getAutoNo("ODFunctions").trim();
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
	//�����ֵ�� 
	public boolean updODFunctions(voODFunctions dtFunctions)
	{
		try {
			if(delODFunctions(dtFunctions)==false) return false;
			if(insODFunctions(dtFunctions)== null) return false;		
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
	public boolean delODFunctions(voODFunctions dtFunctions) {

		boolean flag = false;               //�����Ƿ�ɹ�
		PreparedStatement psmt = null;
		String sSql = "delete from  ODFunctions where functionNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtFunctions.getFunctionNo());
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
	///��ѯ
	public ArrayList<voODFunctions> qryODFunctions(Map<String,String> parms) {
		ArrayList<voODFunctions> List=new ArrayList<voODFunctions>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  ODFunctions  where 1=1 ");
		for(Map.Entry<String, String> t:parms.entrySet()){ 
			sSql.append(" and "+t.getKey() + " = " + t.getValue());
		}
		sSql.append(" order by ProductNo");
		try {
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //ʵ����vo
				voODFunctions dtFunctions = new voODFunctions();
				dtFunctions.setFunctionNo(rs.getString("functionNo"));
				dtFunctions.setCreateDate(rs.getDate("creatDate"));
				dtFunctions.setDescription(rs.getString("description"));
				List.add(dtFunctions);
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
