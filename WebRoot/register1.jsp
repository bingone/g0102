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
    
    <title>供应商注册页</title>
    
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
  background:url("image/u=3680119711,4264562288&fm=21&gp=0.jpg");
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
		zip = document.loginForm.zip.value;
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
					alert("名称不能为空");
					document.loginForm.name.focus();//聚焦
					return;
		}
		
		if(phone==""){
			alert("电话不能为空!");
			document.loginForm.phone.focus();//聚焦
			return;
		}
		if(zip==""){
			alert("邮编不能为空!");
			document.loginForm.zip.focus();//聚焦
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
		document.loginForm.submit();	
	}
</script>
    <h1 align="center">欢迎注册，成为本系统的用户 </h1><br>
    <form name="loginForm" action="check.jsp" method="post">
   <input type="hidden" name="pathname" value="servlet/servBECustomerIns" > 
  	<table width="450">
  	<p align="center"><b>新供应商注册</b></p>
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
  	<td align="center">*名称</td>
  	<td><input type="text" name="name"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*地址</td>
  	<td>
  	<select name="address1" size="1" id="address1" onChange="redirec(document.loginForm.address1.options.selectedIndex)">            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="3" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
    </select> 
    <select name="address2" size="1" id="address2" onChange="redirec(document.loginForm.address2.options.selectedIndex)">            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="4" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
    </select> 
    <select name="address3" size="1" id="address3" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="5" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
    </select>
    </td>
  	</tr>
  	<tr align="left">
  	<td align="center">*电话</td>
  	<td><input type="text" name="phone"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*邮编</td>
  	<td><input type="text" name="zip"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">验证码</td>
  	<td><%@ include file="fresh.jsp" %></td>
  	</tr>
  	<tr>
  	<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"onclick="checkForm()"value="完成注册"></td>
  	<td><input type="reset"value="重置"></td>
  	</tr>
  	</table> 	
  </form>
 <!--  <script language="javascript"> 
//获取一级和二级菜单长度 
var select1_len = document.loginForm.address1.value;
if(select1_len.leg==3){
var select2 = new Array(select1_len);
}
var select2_len = document.loginForm.address2.value; 

var select3 = new Array(select2_len);  
//把一级和二级菜单都设为数组 
for (i=0; i<select1_len; i++) 
{ select2[i] = new Array();} 
for (i=0; i<select2_len; i++) 
{ select3[i] = new Array();} 

//联动函数 
function redirec(x) 
{ 
var temp = document.loginForm.address2; 
for (i=0;i<select2[x].length;i++) 
{ temp.options[i]=new Option(select2[x][i].text,select2[x][i].value);} 
temp.options[0].selected=true; 
} 
</script>  -->
  </body>
  </center>
</html>

