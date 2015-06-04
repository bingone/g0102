package dao.DT;
import java.sql.*;

import connDB.connDB2015;
import vo.DT.voDTPost;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class daoDTPost {
	connDB2015 connDB = new connDB2015();  //连接数据库
	 
//	public static void main(String[] args) {
//		new daoDTPost().insDTPost(new voDTPost("12347","xxx","'123'"),"DTCity");
//		Map<String,Object> parms = new HashMap<String,Object>();  
//		String ss = "xxx";
//		parms.put("cityname","'"+ss+"'");
//		ArrayList<voDTPost> list=new daoDTPost().qryDTPost(parms, "dtcity");
//		for(voDTPost t:list){
//			System.out.println(t);
//		}
//	}
	//插入字典表
	public boolean insDTPost(voDTPost dtPost,String tableName)
	{
		boolean flag = false;            //操作是否成功		
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("insert into "+tableName+" values(?,?");
		if(dtPost.getForeignKey()!=null)
			sSql.append("," + dtPost.getForeignKey()+",1)");
		else sSql.append(",1)");
		try {			
			System.out.println(sSql.toString());
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			psmt.setString(1, dtPost.getPostNo().trim());
			psmt.setString(2, dtPost.getPostName().trim());
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
	public boolean uptDTPost(voDTPost dtPost,String tableName)
	{
		try {
			if(delDTPost(dtPost,tableName)==false) return false;
			if(insDTPost(dtPost,tableName)==false) return false;		
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
	
	//删除岗位表 
	public boolean delDTPost(voDTPost dtPost,String tableName)
	{
		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  "+tableName+"  where "+tableName.substring(2)+"No=?";		
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtPost.getPostNo().trim());
			System.out.println("aaaaaaa"+sSql);
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
	public String qryDTPost(String sNo,String tableName)
	{ 
		String res = null;//操作是否成功
		PreparedStatement psmt = null;
		String sSql = "select "+tableName.substring(2)+"name from "+tableName+"  where "+tableName.substring(2)+"No="+sNo;		
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
//			System.out.println(""+sSql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()){
				res = rs.getString(1);
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();
			connDB.closeConn();
		}
		return res;		
	}
	//查询岗位表 
	public ArrayList<voDTPost> qryDTPost(Map<String,String> parms,String tableName)
	{
		ArrayList<voDTPost> DTPostList=new ArrayList<voDTPost>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  "+tableName+"  where 1=1 ");
		for(Map.Entry<String, String> t:parms.entrySet()){ 
			sSql.append(" and "+t.getKey() + " = " + t.getValue());
		}
		sSql.append(" order by "+tableName.substring(2)+"No");
		try {
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //实例化vo
				voDTPost dtPostAll=new voDTPost();
				dtPostAll.setPostNo(rs.getString(tableName.substring(2)+"No"));
				dtPostAll.setPostName(rs.getString(tableName.substring(2)+"Name"));
				dtPostAll.setIfVoid(rs.getInt("ifVoid"));
				if(tableName.equals("DTcity") || tableName.equals("DTCounty"))
					dtPostAll.setForeignKey(rs.getString("foreignKey"));
				DTPostList.add(dtPostAll);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();
			connDB.closeConn();
		}
		return DTPostList;		
	}	

}
