<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delproduct.jsp' starting page</title>
    
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
    <form name="delform" action="servlet/servBEProductDel" method="post">
    <table width="450">
    <tr>
    <td align="center">请输入删除商品编号</td><br>
    <td><input type="text" name="ProductNo"></td>
    </tr>
    <tr>
    <td align="center">请输入删除商品名称</td><br>
    <td><input type="text" name="ProductName"></td>
    </tr>
    <tr>
    <td align="center"><input type="submit" value="删除"></td>
    </tr>
    </table>
    </form>
  </body>
</html>
