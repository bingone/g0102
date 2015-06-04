package dao.PRO;
import java.sql.CallableStatement; //���������ô洢��������������ӿ�
import java.sql.ResultSet;
import java.sql.Types;
import connDB.connDB2015;
import vo.DT.voDTPost;
import java.util.ArrayList;

public class daoProceduce {
	connDB2015 connDB = new connDB2015();  //�������ݿ�
	
	//�����Զ���ȡ��ŵĴ洢���� 
	public String getAutoNo(String tableName)
	{
		CallableStatement cstmt = null;
		String sAutoNo = null;
		String sSql = "{call AUTO_No(?,?)}";
		try {
			cstmt = connDB.getConn().prepareCall(sSql);
			cstmt.setString(1, tableName);
			cstmt.registerOutParameter(2,oracle.jdbc.OracleTypes.VARCHAR); 
			cstmt.execute();
			sAutoNo = cstmt.getString(2);				
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();
			return sAutoNo;	
		}			
	}	
	
	//���÷��ؼ�¼���Ĺ��� 
	public ArrayList qryDTPost()
	{
		ArrayList DTPostList=new ArrayList();
		
		ResultSet rs = null;
		CallableStatement cstmt = null;
		String spName = "{call qryDTPost(?)}";
		try {
			cstmt = connDB.getConn().prepareCall(spName);
			cstmt.registerOutParameter(1,oracle.jdbc.OracleTypes.CURSOR); 
			cstmt.execute();
			rs = (ResultSet)cstmt.getObject(1);
			while (rs.next())
			{
			  //ʵ����vo
				voDTPost dtPostAll=new voDTPost();
				dtPostAll.setPostNo(rs.getString("postNo"));
				dtPostAll.setPostName(rs.getString("postName"));
				dtPostAll.setIfVoid(rs.getInt("ifVoid"));
				DTPostList.add(dtPostAll);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();			
		}
		return DTPostList;		
	}	
	
	//���ú��� 
	public float getEmpSal(String empNo)
	{
		CallableStatement cstmt = null;
		String sEmpName = null;
		float sal=0;
		
		String sSql = "{?=call get_enosal(?,?)}";
		try {
			cstmt = connDB.getConn().prepareCall(sSql);
			cstmt.registerOutParameter(1,oracle.jdbc.OracleTypes.DECIMAL); 
			cstmt.setString(2, empNo);
			cstmt.registerOutParameter(3,oracle.jdbc.OracleTypes.VARCHAR); 
			cstmt.execute();
			sEmpName = cstmt.getString(3);
			sal = cstmt.getFloat(1);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();
			return sal;	
		}
	}

}
