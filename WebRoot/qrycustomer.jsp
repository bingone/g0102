<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'qrycustomer.jsp' starting page</title>
    
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
    <form name="qryform" action="servlet/servBECustomerQry" method="post">
    <table width="450">
    <tr>
    <td align="center">请输入供应商编号</td><br>
    <td><input type="text" name="CustomerNo"></td>
    </tr>
    <tr>
    <td align="center">请输入供应商名称</td><br>
    <td><input type="text" name="CustomerName"></td>
    </tr>
    <tr>
    <td align="center"><input type="submit" value="查询"></td>
    </tr>
    </table>
    </form>
  </body>
</html>
