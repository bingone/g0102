<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="vo.DT.*"%>
<%@page import="dao.PRO.daoProceduce"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="image/backgrand/work.jpg">
      <!-- 查询  -->    
     <div align="center"><span class="style1"></span><BR>
      </div>
      <hr>
      <BR>
   <table border=2 bordercolor="#FF0000"  align="center">
      <tr>
         <td>岗位编号</td>
         <td>岗位描述</td>
         <td>是否作废</td>         
      </tr> 
      <%
        daoProceduce dtPost = new daoProceduce();
        ArrayList  dtPostList = dtPost.qryDTPost();
        int i=0;      
        while(i<dtPostList.size())  
        { voDTPost dtPostAll=(voDTPost)dtPostList.get(i);
          i++;
        %> 
           <tr>    
	         <td><%=dtPostAll.getPostNo()%> </td> 
	         <td><%=dtPostAll.getPostName()%> </td> 
	         <td><%=dtPostAll.getIfVoid()%> </td> 
		   </tr>    
           <%}
       %>      
   </table>
    
  </body>
</html>