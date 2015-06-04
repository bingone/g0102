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
    
    <title>My JSP 'monitor.jsp' starting page</title>
    
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
  <h1 align="center">质量监控信息表填写页面</h1>
   <form name="monitor" action="servlet/servBDMonitor" mathod="post">
   <table width="450" border="3">
   <tr>
   <td align="center">合同编号</td>
   <td></td>
   </tr>
   <tr>
   <td align="center">职工编号</td>
   <td></td>
   </tr>
   <tr>
   <td align="center"><input type="submit" value="提交"></td>
   <td><input type="reset" value="重置"></td>
   </tr>
   </table>
   </form>
  </body>
  </center>
</html>
