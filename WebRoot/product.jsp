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
    
    <title>My JSP 'product.jsp' starting page</title>
    
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
  			name = document.productForm.productname.value;
  			if(name==""){
  				alert("���Ʋ���Ϊ�գ�");
  				document.productForm.productname.focus();
  				return;
  			}
  			
  			document.productForm.submit();
  		}
  
  </script>
    <h1 align="center">������Ϣ��֮��Ʒ��</h1>
    <form name="productForm" action="servlet/servBEProductIns" method="post">
    <table width="450">
    <tr>
    <td align="center">*��Ʒ����</td>
    <td><input type="text" name="productname"></td>
    </tr>
    <td align="center">*��װ</td>
  	<td>
  	<select name="package" size="1" id="package" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="7" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
  	</tr>
  	<tr>
  	<td align="center">*��Ʒ���</td>
  	<td><select name="typegood" size="1" id="typegood" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="15" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
  	</tr>
  	<tr>
  	<td align="center">*���</td>
  	<td><select name="specifiction" size="1" id="specifiction" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="12" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
  	</tr>
  	<tr>
  	<td align="center">*����Ҫ��</td>
  	<td><select name="requality" size="1" id="requality" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="13" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
  	</tr>
  	<tr>
    <td align="center"><input type="button" onclick="validate()" value="����ύ"></td>
    <td><input type="reset"  value="����"></td>
    </tr>
    </table>
    </form>
  </body>
  </center>
</html>
