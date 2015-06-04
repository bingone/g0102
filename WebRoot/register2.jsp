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
    
    <title>系统管理员注册页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript" src="js/Calendar3.js"></script>
  </head> 
  <style type="text/css">
  body{
  background:url("image/u=3634840393,3805754774&fm=21&gp=0.jpg");
  background-repeat:no-repeat;
background-size:1400px 768px;
  }
  </style>
  <body>
 <script type="text/javascript">
 function checkForm(){
 		account = document.loginForm.account.value;
		password = document.loginForm.password.value;
		confirmPassword = document.loginForm.confirmPassword.value;
		name = document.loginForm.name.value;
		phone = document.loginForm.phone.value;
		salary = document.loginForm.salary.value;
		birthday = document.loginForm.birthday.value;
		hiredate = document.loginForm.hiredate.value;
		if(account==""){
					alert("员工账号不能为空");
					document.loginForm.account.focus();//聚焦
					return;}
		if(password==""){
					alert("密码不能为空");
					document.loginForm.password.focus();//聚焦
					return;}
		if(confirmPassword==""){
					alert("确认密码不能为空");
					document.loginForm.confirmPassword.focus();//聚焦
					return;}
		if(name==""){
					alert("员工姓名不能为空");
					document.loginForm.name.focus();//聚焦
					return;
		}
		if(birthday==""){
			alert("出生日期不能为空!");
			document.loginForm.birthday.focus();//聚焦
			return;
		}
		if(phone==""){
			alert("电话不能为空!");
			document.loginForm.phone.focus();//聚焦
			return;
		}
		if(salary==""){
			alert("薪水不能为空!");
			document.loginForm.salary.focus();//聚焦
			return;
		}
		if(hiredate==""){
			alert("雇用日期不能为空!");
			document.loginForm.hiredate.focus();//聚焦
			return;
		}
		if(password!=confirmPassword){
			alert("两次密码不匹配!");
			document.loginForm.confirmPassword.focus();//聚焦
			return;
		}
		if(account.length<6||account.length>16){
			alert("账号长度只能为为6——16位！");
			document.loginForm.account.focus();//聚焦
			return;
		}
		if(password.length<6 || password.length>16){
			alert("密码长度不得少于6个字符，不得多于16个字符！");
			document.loginForm.password.focus();//聚焦
			return;
		}
		if((parseInt(hiredate.slice(0,4))-parseInt(birthday.slice(0,4)))<16){
			alert("职工年龄必须大于16岁！");
			document.loginForm.hiredate.focus();//聚焦
			return;
		}
		document.loginForm.submit();	
	}
</script>
 
    <h1 align="center">欢迎注册，成为本系统的用户 </h1><br>
   <form name="loginForm" action="check.jsp" method="post">
   <input type="hidden" name="pathname" value="servlet/servBEEmployeeIns" >
  	<table width="450">
  	<p align="center"><b>新系统管理员注册</b></p>
  	<tr align="left">
  	<td align="center">*注册账号</td>
  	<td><input type="text" name="account"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*登录密码</td>
  	<td><input type="password" name="password"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*确认密码</td>
  	<td><input type="password" name="confirmPassword"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*姓名</td>
  	<td><input type="text" name="name"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*性别</td>
  	<td><input type="radio" name="sex" value="M" checked >男
  	<input type="radio" name="sex" value="F">女</td>
  	</tr>
  	<tr align="left">
  	<td align="center">*出生年月</td>
  	<td>
  	<input type="text" name="birthday" onclick="new Calendar().show(this)">  
  	</td>
  	</tr>
  	<tr align="left">
  	<td align="center">*电话</td>
  	<td><input type="text" name="phone"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*职务</td>
  	<td>
  	<select name="headship" size="1" id="edtPost" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="1" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
  	</td>
  	</tr>
  	<tr align="left">
  	<td align="center">*薪水</td>
  	<td><input type="text" name="salary"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*所属部门</td>
  	<td>
  	<select name="department" size="1" id="edtDepartment" >            
                   <jsp:include page="/servlet/servNoDesc" flush="true" >
                   <jsp:param name="flag" value="2" />            
                   </jsp:include>
                   <%= request.getAttribute("sString")%>
                  </select> 
  	</td>
  	</tr>
  	<tr align="left">
  	<td align="center">*雇用日期</td>
  	<td>
     <input type="text" name="hiredate" onclick="new Calendar().show(this)">
	</td>
  	</tr>
  	<tr align="left">
  	<td align="center">验证码</td>
  	<td><%@ include file="fresh.jsp" %></td>
  	</tr>
  	<tr>
  	<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"onclick="checkForm()" value="完成注册"></td>
  	<td><input type="reset"value="重置"></td>
  	</tr>
  	</table> 	
  </form> 
  </body>
  </center>
</html>
