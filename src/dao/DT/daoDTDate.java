package dao.DT;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import vo.DT.voDTDate;
import connDB.connDB2015;
public class daoDTDate {
	connDB2015 connDB = new connDB2015();  //�������ݿ�
	 
	   
	//�������ڱ� 
	public boolean insDTDate(voDTDate dtDate)
	{
		boolean flag = false;            //�����Ƿ�ɹ�		
		PreparedStatement psmt = null;
		String sSql = "insert into DTDate values(?,?)";
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtDate.getDateNo().trim());
		    psmt.setTimestamp(2,dtDate.getDateDesc());			
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
	
	//��ѯ���ڱ� 
	public ArrayList qryDTDate()
	{
		ArrayList DTDateList=new ArrayList();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		String sSql = "select * from DTDate";		
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //ʵ����vo
				voDTDate dtDTDateAll=new voDTDate();
				dtDTDateAll.setDateNo(rs.getString("dateNo")) ; 
				dtDTDateAll.setDateDesc(rs.getTimestamp("dateDesc"));				
				DTDateList.add(dtDTDateAll);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();
			connDB.closeConn();
		}
		return DTDateList;		
	}	
}
