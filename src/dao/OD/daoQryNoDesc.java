package dao.OD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.DT.voDTDate;
import vo.OD.voNoDesc;
import connDB.connDB2015;
public class daoQryNoDesc {
	connDB2015 connDB = new connDB2015();  //
	//
	public ArrayList qryNoDesc(int flag)
	{
		ArrayList noDescList=new ArrayList();
		ResultSet rs = null;
		PreparedStatement psmt = null;
		String sSql=null;
		 switch (flag) {
	        case 1: {        //search post
	        	sSql = "select HeadShipNo,HeadShipName from DTHeadShip" ;
	             break;
	             }
	        case 2: {        //search department
	        	sSql = "select departmentNo,departmentName from DTDepartment" ;
	             break;
	             }
	        case 3: {        //search DTProvince 
	        	sSql = "select provinceNo,provinceName from DTProvince" ;
	             break;
	             }
	        case 4: {        //search DTCity
	        	sSql = "select cityNo,cityName from DTCity" ;
	             break;
	             }	 
	        case 5: {        //search DTCounty
	        	sSql = "select countyNo,countyName from DTCounty" ;
	             break;
	             }	 
	        case 6: {        //search DTPbranch 
	        	sSql = "select typeNo,typeName from DTPbranch" ;
	             break;
	             }	        	        
	        case 7: {        //search DTpackage 
	        	sSql = "select packageNo,packageName from DTpackage" ;
	             break;
	             }   
	        case 8: {        //search DTpayway 
	        	sSql = "select paywayNo,paywayName from DTpayway" ;
	             break;
	             }   
	        case 9: {        //search DTrereason 
	        	sSql = "select rereasonNo,rereasonName from DTrereason" ;
	             break;
	             }   
	        case 10: {        //search DTrerstate 
	        	sSql = "select stateNo,stateName from DTrerstate" ;
	             break;
	             }   
	        case 11: {        //search DTshipstate 
	        	sSql = "select shipstateNo,shiptateName from DTshipstate" ;
	             break;
	             }  
	        case 12: {        //search DTspecifiction 
	        	sSql = "select specifictionNo,specifictionName from DTspecifiction" ;
	             break;
	             }  
	        case 13: {        //search DTrequality 
	        	sSql = "select requalityNo,requalityName from DTrequality" ;
	             break;
	             }  
	        case 14: {        //search DTrefunds 
	        	sSql = "select refundsNo,refundsName from DTrefunds" ;
	             break;
	             }  
	        case 15: {        //search DTtypegood 
	        	sSql = "select typegoodNo,typegoodName from DTtypegood" ;
	             break;
	             }  
	        case 16: {        //search DTtabletype
	        	sSql = "select tabletypeNo,tabletypeName from DTtabletype" ;
	             break;
	             } 
	      }	
		
		try {
			psmt = connDB.getConn().prepareStatement(sSql);
			rs  = psmt.executeQuery();	
			while (rs.next())
			{
			  //
				voNoDesc noDescAll=new voNoDesc();
				noDescAll.setVoNo(rs.getString(1));
				noDescAll.setVoDesc(rs.getString(2));			
				noDescList.add(noDescAll);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}finally
		{
			connDB.commitConn();
			connDB.closeConn();
		}
		return noDescList;		
	}	
}
