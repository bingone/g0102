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
    
    <title>ϵͳ����Աע��ҳ</title>
    
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
					alert("Ա���˺Ų���Ϊ��");
					document.loginForm.account.focus();//�۽�
					return;}
		if(password==""){
					alert("���벻��Ϊ��");
					document.loginForm.password.focus();//�۽�
					return;}
		if(confirmPassword==""){
					alert("ȷ�����벻��Ϊ��");
					document.loginForm.confirmPassword.focus();//�۽�
					return;}
		if(name==""){
					alert("Ա����������Ϊ��");
					document.loginForm.name.focus();//�۽�
					return;
		}
		if(birthday==""){
			alert("�������ڲ���Ϊ��!");
			document.loginForm.birthday.focus();//�۽�
			return;
		}
		if(phone==""){
			alert("�绰����Ϊ��!");
			document.loginForm.phone.focus();//�۽�
			return;
		}
		if(salary==""){
			alert("нˮ����Ϊ��!");
			document.loginForm.salary.focus();//�۽�
			return;
		}
		if(hiredate==""){
			alert("�������ڲ���Ϊ��!");
			document.loginForm.hiredate.focus();//�۽�
			return;
		}
		if(password!=confirmPassword){
			alert("�������벻ƥ��!");
			document.loginForm.confirmPassword.focus();//�۽�
			return;
		}
		if(account.length<6||account.length>16){
			alert("�˺ų���ֻ��ΪΪ6����16λ��");
			document.loginForm.account.focus();//�۽�
			return;
		}
		if(password.length<6 || password.length>16){
			alert("���볤�Ȳ�������6���ַ������ö���16���ַ���");
			document.loginForm.password.focus();//�۽�
			return;
		}
		if((parseInt(hiredate.slice(0,4))-parseInt(birthday.slice(0,4)))<16){
			alert("ְ������������16�꣡");
			document.loginForm.hiredate.focus();//�۽�
			return;
		}
		document.loginForm.submit();	
	}
</script>
 
    <h1 align="center">��ӭע�ᣬ��Ϊ��ϵͳ���û� </h1><br>
   <form name="loginForm" action="check.jsp" method="post">
   <input type="hidden" name="pathname" value="servlet/servBEEmployeeIns" >
  	<table width="450">
  	<p align="center"><b>��ϵͳ����Աע��</b></p>
  	<tr align="left">
  	<td align="center">*ע���˺�</td>
  	<td><input type="text" name="account"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*��¼����</td>
  	<td><input type="password" name="password"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*ȷ������</td>
  	<td><input type="password" name="confirmPassword"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*����</td>
  	<td><input type="text" name="name"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*�Ա�</td>
  	<td><input type="radio" name="sex" value="M" checked >��
  	<input type="radio" name="sex" value="F">Ů</td>
  	</tr>
  	<tr align="left">
  	<td align="center">*��������</td>
  	<td>
  	<input type="text" name="birthday" onclick="new Calendar().show(this)">  
  	</td>
  	</tr>
  	<tr align="left">
  	<td align="center">*�绰</td>
  	<td><input type="text" name="phone"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*ְ��</td>
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
  	<td align="center">*нˮ</td>
  	<td><input type="text" name="salary"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*��������</td>
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
  	<td align="center">*��������</td>
  	<td>
     <input type="text" name="hiredate" onclick="new Calendar().show(this)">
	</td>
  	</tr>
  	<tr align="left">
  	<td align="center">��֤��</td>
  	<td><%@ include file="fresh.jsp" %></td>
  	</tr>
  	<tr>
  	<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"onclick="checkForm()" value="���ע��"></td>
  	<td><input type="reset"value="����"></td>
  	</tr>
  	</table> 	
  </form> 
  </body>
  </center>
</html>
