package connDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connDB2015 {
private Connection conn = null;
	
	/*** ��������  ***/
	/*** �޲����� ****/
//public static void main(String[] args) {
//	new connDB2015().createConn();
//}
	private void createConn()
	{		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@210.35.205.2:1521:db2015";
		String userName = "g0102";
		String passWord = "p888888";
		if (conn == null)
		{
			try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url,userName,passWord); 				
				System.out.println("���ݿ����ӳɹ���");
			    } 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			    } 
			catch (SQLException e) {
				System.out.println("���ݿ�����ʧ�ܣ�");
				e.printStackTrace();
			    }  
		}		
	}
	/*** ����������****/
	/* private void createConn(String user,String pass)
	{			
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@192.168.11.4:1521:shopDB";
		if (conn == null)
		{
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,userName,passWord);
				System.out.println("���ݿ����ӳɹ���");
			    } 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			    } 
			catch (SQLException e) {
				System.out.println("���ݿ�����ʧ�ܣ�");
				e.printStackTrace();
			    }  
		}  */
	
	/***��ȡ����***/
	public Connection getConn(){
		if (conn == null) {
			createConn();
		}
		return conn;
	}

    /*** �ύ���� ***/
	 public void commitConn()
	 {
		try {
			conn.commit();			
		} catch (SQLException e){
			System.out.println("�ύ�쳣��");
		}
	 }
	 
	 /*** �ع����� ***/
	 public void rollbackConn()
	 {
		try {
			conn.rollback();			
		} catch (SQLException e){
			System.out.println("�ύ�쳣��");
		}
	 }
	 
	 /*** �ر����� ***/
	 public void closeConn()
	 {
		try {
			conn.close();
			conn = null;
		} catch (SQLException e){
			e.printStackTrace();
		}
	 }
}
