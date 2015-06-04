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
    
    <title>My JSP 'branch.jsp' starting page</title>
    
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
  <script type="text/javascript">
  		function validate(){
  			name = document.branchForm.branchname.value;
  			phone = document.branchForm.phone.value;
  			email = document.branchForm.email.value;
  			zip = document.branchForm.zip.value;
  			if(name==""){
  				alert("名称不能为空！");
  				document.branchForm.branchname.focus();
  				return;
  			}
  			if(phone==""){
  				alert("电话不能为空！");
  				document.branchForm.phone.focus();
  				return;
  			}
  			if(email==""){
  				alert("邮箱不能为空！");
  				document.branchForm.email.focus();
  				return;
  			}
  			if(zip==""){
  				alert("邮编不能为空！");
  				document.branchForm.zip.focus();
  				return;
  			}
  			document.branchForm.submit();
  		}
  
  </script>
    <h1 align="center">超市店面信息表</h1>
    <form name="branchForm" action="servlet/servBEBranchIns" method="post">
    <table width="450">
    <tr>
    <td align="center">*店名称</td>
    <td><input type="text" name="branchname"></td>
    </tr>
    <tr>
    <td align="center">*店类型</td>
    <td><select name="Pbranch" size="1" id="Pbranch" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="6" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
    </tr>
    <td align="center">*地址</td>
  	<td>
  	<select name="address1" size="1" id="address1" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="3" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
    </select> 
    <select name="address2" size="1" id="address2" >            
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
  	<tr>
  	<td align="center">*电话</td>
  	<td><input type="text" name="phone"></td>
  	</tr>
  	<tr>
  	<td align="center">*邮箱</td>
  	<td><input type="text" name="email"></td>
  	</tr>
  	<tr>
  	<td align="center">*邮编</td>
  	<td><input type="text" name="zip"></td>
  	</tr>
  	<tr>
    <td align="center"><input type="button" onclick="validate()" value="完成提交"></td>
    <td><input type="reset"  value="重置"></td>
    </tr>
    </table>
    </form>
  </body>
  </center>
</html>
