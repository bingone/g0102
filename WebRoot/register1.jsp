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
    
    <title>��Ӧ��ע��ҳ</title>
    
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
					alert("���Ʋ���Ϊ��");
					document.loginForm.name.focus();//�۽�
					return;
		}
		
		if(phone==""){
			alert("�绰����Ϊ��!");
			document.loginForm.phone.focus();//�۽�
			return;
		}
		if(zip==""){
			alert("�ʱ಻��Ϊ��!");
			document.loginForm.zip.focus();//�۽�
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
		document.loginForm.submit();	
	}
</script>
    <h1 align="center">��ӭע�ᣬ��Ϊ��ϵͳ���û� </h1><br>
    <form name="loginForm" action="check.jsp" method="post">
   <input type="hidden" name="pathname" value="servlet/servBECustomerIns" > 
  	<table width="450">
  	<p align="center"><b>�¹�Ӧ��ע��</b></p>
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
  	<td align="center">*��ַ</td>
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
  	<td align="center">*�绰</td>
  	<td><input type="text" name="phone"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">*�ʱ�</td>
  	<td><input type="text" name="zip"></td>
  	</tr>
  	<tr align="left">
  	<td align="center">��֤��</td>
  	<td><%@ include file="fresh.jsp" %></td>
  	</tr>
  	<tr>
  	<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"onclick="checkForm()"value="���ע��"></td>
  	<td><input type="reset"value="����"></td>
  	</tr>
  	</table> 	
  </form>
 <!--  <script language="javascript"> 
//��ȡһ���Ͷ����˵����� 
var select1_len = document.loginForm.address1.value;
if(select1_len.leg==3){
var select2 = new Array(select1_len);
}
var select2_len = document.loginForm.address2.value; 

var select3 = new Array(select2_len);  
//��һ���Ͷ����˵�����Ϊ���� 
for (i=0; i<select1_len; i++) 
{ select2[i] = new Array();} 
for (i=0; i<select2_len; i++) 
{ select3[i] = new Array();} 

//�������� 
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

