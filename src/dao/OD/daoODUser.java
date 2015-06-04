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
import vo.OD.voODUser;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoODUser {
	connDB2015 connDB = new connDB2015();  //�������ݿ�
	daoProceduce getNo =new daoProceduce();

	//����Ա���� 
//	public static void main(String[] args) {
//		new daoODUser().insODUser(new voODUser());
//	}
	public boolean insODUser(voODUser dtUser)
	{
//		dtCustomer.setCustomerName("milk");
//		dtCustomer.setAddress("NC-JX00");
//		dtCustomer.setTelephone("123");
//		dtCustomer.setZip("222222");
		boolean flag = false;            //�����Ƿ�ɹ�		
		PreparedStatement psmt = null;
		String sSql = "insert into ODUser values(?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtUser.getUsername());
			psmt.setString(2, dtUser.getPassword());
			psmt.setString(3, dtUser.getUserType());
			//�Զ��������
			String sNo=getNo.getAutoNo("ODUser").trim();
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
	//�����ֵ�� 
	public boolean updODUser(voODUser dtUser)
	{
		try {
			if(delODUser(dtUser)==false) return false;
			if(insODUser(dtUser)==false) return false;		
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
	public boolean delODUser(voODUser dtUser) {

		boolean flag = false;               //�����Ƿ�ɹ�
		PreparedStatement psmt = null;
		String sSql = "delete from  ODUser where username=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtUser.getUsername());
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
	public ArrayList<voODUser> qryODUser(Map<String,String> parms) {
		ArrayList<voODUser> List=new ArrayList<voODUser>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  ODUser  where 1=1 ");
		for(Map.Entry<String, String> t:parms.entrySet()){ 
			sSql.append(" and "+t.getKey() + " = " + t.getValue());
		}
		sSql.append(" order by UserNo");
		try {
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //ʵ����vo
				voODUser dtUser = new voODUser();
				dtUser.setUsername(rs.getString("username"));
				dtUser.setPassword(rs.getString("password"));
				dtUser.setUserType(rs.getString("usertype"));
				List.add(dtUser);
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
