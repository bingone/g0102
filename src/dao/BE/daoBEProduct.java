package dao.BE;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import vo.BE.voBEEmployee;
import vo.BE.voBEProduct;
import vo.DT.voDTPost;
import dao.DT.daoDTPost;
import dao.PRO.daoProceduce;
import connDB.connDB2015;

public class daoBEProduct {
	connDB2015 connDB = new connDB2015();  //连接数据库
	daoProceduce getNo =new daoProceduce();

	//插入员工表 
//	public static void main(String[] args) {
//		new daoBEProduct().insBEProduct(new voBEProduct());
//	}
	public String insBEProduct(voBEProduct dtProduct)
	{
		//dtProduct.setProductName("milk");
		
		String flag = null;            //操作是否成功		
		PreparedStatement psmt = null;
		String sSql = "insert into BEProduct values(?,?,?,?,?,?)";
		//System.out.print(dtEmployee.getWorkDate());
		try {			
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(2, dtProduct.getProductName());
			psmt.setString(3,   dtProduct.getPackaging());
			psmt.setString(4, dtProduct.getProductclass());
			psmt.setString(5, dtProduct.getSpecifiction());
			psmt.setString(6, dtProduct.getRequality());
			//自动产生编号
			String sNo=getNo.getAutoNo("BEProduct").trim();
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
	public boolean updBEProduct(voBEProduct dtProduct)
	{
		try {
			if(delBEProduct(dtProduct)==false) return false;
			if(insBEProduct(dtProduct)== null) return false;		
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
	public boolean delBEProduct(voBEProduct dtProduct) {

		boolean flag = false;               //操作是否成功
		PreparedStatement psmt = null;
		String sSql = "delete from  BEProduct where ProductNo=?";	
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			psmt.setString(1, dtProduct.getProductNo());
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
	public ArrayList<voBEProduct> qryBEProduct(Map<String,String> parms) {
		ArrayList<voBEProduct> List=new ArrayList<voBEProduct>();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		StringBuilder sSql = new StringBuilder("select * from  BEProduct  where 1=1 ");
		for(Map.Entry<String, String> t:parms.entrySet()){ 
			sSql.append(" and "+t.getKey() + " = " + t.getValue());
		}
		sSql.append(" order by ProductNo");
		try {
			psmt = connDB.getConn().prepareStatement(sSql.toString());
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //实例化vo
				voBEProduct dtProduct = new voBEProduct();
				dtProduct.setProductNo(rs.getString("ProductNo"));
				dtProduct.setProductName(rs.getString("ProductName"));
				dtProduct.setPackaging(new daoDTPost().qryDTPost(rs.getString("Packaging"),"DTpackage"));
				dtProduct.setProductclass(new daoDTPost().qryDTPost(rs.getString("Productclass"),"DTtypegood"));
				dtProduct.setSpecifiction(new daoDTPost().qryDTPost(rs.getString("Specifiction"),"DTSpecifiction"));
				dtProduct.setRequality(new daoDTPost().qryDTPost(rs.getString("requality"),"DTrequality"));
				List.add(dtProduct);
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
