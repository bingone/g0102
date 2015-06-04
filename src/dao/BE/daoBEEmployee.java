package dao.BE;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import vo.BE.voBEEmployee;
import vo.DT.voDTPost;
import dao.DT.daoDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBEEmployee {
	connDB2015 connDB = new connDB2015();  //
	daoProceduce getNo =new daoProceduce();

	//
//	public static void main(String[] args) {
//		ArrayList list = new daoBEEmployee().qryBEEmployee(new HashMap<String,String>() );
//		for(Object obj:list){
//			System.out.println((voBEEmployee)obj);
//		}
//	}
	public String insBEEmployee(voBEEmployee dtEmployee)
	{
//		dtEmployee.setEmployeeName("xsy");
//		dtEmployee.setBirthday(new Date(System.currentTimeMillis()));
//		dtEmployee.setDepartmentNo("1");
//		dtEmployee.setHeadship("1");
//		dtEmployee.setHireDate(new Date(System.currentTimeMillis()));
//		dtEmployee.setSalary(23.3);
//		dtEmployee.setSex("M");
//		dtEmployee.setTelephone("1234567890");
		
		String flag = null;            //
		PreparedStatement psmt = null;
		String sSql = "insert into BEEmployee values(?,?,?,?,?,?,?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			
			psmt.setString(2, dtEmployee.getEmployeeName());
			psmt.setString(7, dtEmployee.getSex());
			psmt.setDate(3,   dtEmployee.getBirthday());
			psmt.setString(4, dtEmployee.getTelephone());
			psmt.setString(5, dtEmployee.getHeadship());
			psmt.setDouble(6, dtEmployee.getSalary());
			psmt.setString(8, dtEmployee.getDepartmentNo());
			psmt.setDate(9,   dtEmployee.getHireDate());
			//
			String sNo=getNo.getAutoNo("BEEmployee").trim();
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
	//
	public boolean updBEEmployee(voBEEmployee dtEmployee)
	{
		try {
			if(delBEEmployee(dtEmployee)==false) return false;
			if(insBEEmployee(dtEmployee)== null) return false;		
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
	///
	public boolean delBEEmployee(voBEEmployee dtEmployee) {

		boolean flag = false;               //
		PreparedStatement psmt = null;
		String sSql = "delete from  BEEmployee where  employeeNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtEmployee.getEmployeeNo());
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
	///
	public ArrayList<voBEEmployee> qryBEEmployee(Map<String,String> parms) {
		ArrayList<voBEEmployee> List=new ArrayList<voBEEmployee>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BEEmployee  where 1=1 ");
		for(Map.Entry<String, String> t:parms.entrySet()){ 
			sSql.append(" and "+t.getKey() + " = " + t.getValue());
		}
		sSql.append(" order by employeeNo");
		System.out.println(sSql);
		try {
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //
				voBEEmployee employee = new voBEEmployee();
				employee.setEmployeeNo(rs.getString("employeeNo"));
				employee.setEmployeeName(rs.getString("employeeName"));
				employee.setSex(rs.getString("sex"));
				employee.setBirthday(rs.getDate("birthday"));
				employee.setDepartmentNo(new daoDTPost().qryDTPost(rs.getString("departmentNo"),"DTdepartment" ));
				employee.setHeadship(new daoDTPost().qryDTPost(rs.getString("headship"), "DTheadship") );
				employee.setSalary(rs.getDouble("salary"));
				employee.setHireDate(rs.getDate("hiredate"));
				employee.setTelephone(rs.getString("telephone"));
	
				List.add(employee);
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
