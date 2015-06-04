package dao.BD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vo.BD.voBDmonitor;
import vo.BE.voBECustomer;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBDmonitor {
	connDB2015 connDB = new connDB2015();  //�������ݿ�
	daoProceduce getNo =new daoProceduce();

	//����Ա���� 
//	public static void main(String[] args) {
//		new daoBDmonitor().insBDmonitor(new voBDmonitor());
//	}
	public String insBDmonitor(voBDmonitor dtmonitor)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		String flag = null;            //�����Ƿ�ɹ�		
		PreparedStatement psmt = null;
		String sSql = "insert into BDmonitor values(?,?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(2, dtmonitor.getContractNo());
			psmt.setString(3, dtmonitor.getEmployeeNo());
			psmt.setDate(4, dtmonitor.getMonitordate());
			
			//�Զ��������
			String sNo=getNo.getAutoNo("BDmonitor").trim();
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
	public boolean updBDmonitor(voBDmonitor dtmonitor)
	{
		try {
			if(delBDmonitor(dtmonitor)==false) return false;
			if(insBDmonitor(dtmonitor)== null) return false;		
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
	public boolean delBDmonitor(voBDmonitor dtmonitor) {

		boolean flag = false;               //�����Ƿ�ɹ�
		PreparedStatement psmt = null;
		String sSql = "delete from  BDmonitor where monitorNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtmonitor.getMonitorNo());
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
	public ArrayList<voBDmonitor> qryBDmonitor(Map<String,String> parms) {
		ArrayList<voBDmonitor> List=new ArrayList<voBDmonitor>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BDmonitor  where 1=1 ");
		for(Map.Entry<String, String> t:parms.entrySet()){ 
			sSql.append(" and "+t.getKey() + " = " + t.getValue());
		}
		sSql.append(" order by planNo");
		try {
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //ʵ����vo
				voBDmonitor dtmonitor = new voBDmonitor();
				dtmonitor.setMonitorNo(rs.getString("monitorNo"));
				dtmonitor.setContractNo(rs.getString("contractNo"));
				dtmonitor.setEmployeeNo(rs.getString("employeeNo"));
				dtmonitor.setMonitordate(rs.getDate("monitordate"));
				List.add(dtmonitor);
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
