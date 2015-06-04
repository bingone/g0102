<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'del.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
*{ margin:0px;padding:0px;}
.findmenu { background:#eee;width:200px;height:300px;margin:0 auto;}
  ul {list-style:none;}
  .findmenu ul li{ float:left;line-height:50px;text-align:center; position:relative;}
  ul li{ list-style:none;float:left;line-height:30px;}
  .findmenu a{ text-decoration:none;color:#000; display:block;width:150px;}
  a:hover{ text-decoration:none;color:#FFF; background-color:#f60;}
</style>
  </head>
  
  <body>
    <div class="findmenu">
     <ul>
	  <li><a href="delemployee.jsp" target="right">删除员工</a></li>
	  <li><a href="delcustomer.jsp" target="right">删除供应商</a></li>
	  <li><a href="delbranch.jsp" target="right">删除分店</a></li>
	  <li><a href="delproduct.jsp" target="right">删除商品</a></li>
    </ul>
    </div>
  </body>
</html>
