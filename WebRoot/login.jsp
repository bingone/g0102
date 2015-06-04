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
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style type="text/css">
  body{
  background:url("image/u=2656053009,3940387083&fm=21&gp=0.jpg");
  background-repeat:no-repeat;
background-size:1400px 768px;
  }
  </style>
  <script type="text/javascript">
  function validate(){
  		IDname = document.loginForm.IDname.value;
  		password = document.loginForm.password.value;
  		if(IDname==""){
  			alert("账号不能为空！");
  			doucment.loginForm.IDname.focus();
  			return;
  		}
  		if(password==""){
  			alert("密码不能为空！");
  			doucment.loginForm.password.focus();
  			return;
  		}
  		document.loginForm.submit();
  }
  </script>
  <body>
    <h1 align="center">登录界面</h1>
     <img src="image/login-main-top.jpg">
     <form name="loginForm" action="main.jsp" method="post">
    <table width="300" align="center">   
		<tr>
		   <td align="center">账号</td>
		   <td algin="left"><input type="text" name="IDname"></td>
		</tr>
		<tr>
		   <td align="center">密码</td>
		   <td align="left"><input type="password" name="password"></td>
		</tr>
		<tr>
		    <td align="center">验证码</td>
		     <td align="left">    
		   <%@ include file="fresh.jsp" %>
		   </td>
		</tr>
		<tr>
		   <td align="right">
		   <img src="image/login-main-btn.jpg" onclick="validate()">
		   </td>
		   <td align="left"> 
		   <img src="image/login-main-btn1.jpg" onclick="javascript:document.forms['loginForm'].reset();"style="cursor:pointer;">
		   <a href="findpassword.jsp">忘记密码</a>
		   </td>
		</tr>
	   </table>
	   </form>
  </body>
  </center>
</html>
