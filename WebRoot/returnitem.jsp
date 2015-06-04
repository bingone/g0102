<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<center>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'returnitem.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h1 align="center">退货单填写页面</h1>
   <form name="returnitem" action="servlet/servBDReturnitem"method="post">
   <table width="450"border="3">
   <tr>
   <td align="center">合同编号</td>
   <td></td>
   </tr>
   <tr>
   <td align="center">退货理由</td>
   <td>
   <select name="rereason" size="1" id="rereason" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="9" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
   </td>
   </tr>
   <tr>
   <td align="center">退货状态</td>
   <td>
   <select name="state" size="1" id="state" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="10" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
   </td>
   </tr>
   <tr>
   <td align="center"><input type="submit"value="提交"></td>
   <td><input type="reset" value="重置"></td>
   </tr>
   </table>
   </form>
  </body>
  </center>
</html>
