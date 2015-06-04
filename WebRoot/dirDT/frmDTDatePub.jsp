<%@ page pageEncoding="gb2312" %>
<%@ page import="java.util.*"%>
<%@page import="vo.DT.voDTDate"%>
<%@page import="dao.DT.daoDTDate"%>
     <!-- 查询  -->    
     <div align="center"><span class="style1"></span><BR>
      </div>
      <hr>
      <BR>
   <table border=2 bordercolor="#FF0000"  align="center">
      <tr>
         <td>日期编号</td>
         <td>日期描述</td>               
      </tr> 
      <%   
        daoDTDate dtDate = new daoDTDate();
        ArrayList  dtDateList = dtDate.qryDTDate();  
        int i=0;      
        while(i<dtDateList.size())  
        { voDTDate voDateAll=(voDTDate)dtDateList.get(i);
          i++;
        %> 
           <tr>    
	         <td><%=voDateAll.getDateNo()%> </td> 
	         <td><%=voDateAll.getDateDesc()%> </td> 	        
		   </tr>    
           <%}
       %>      
   </table>  