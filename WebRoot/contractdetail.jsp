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
    
    <title>My JSP 'contractdetail.jsp' starting page</title>
    
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
  		contractNo=document.contractdetail.contractNo.value;
  		productNo=document.contractdetail.productNo.value;
  		quantity=document.contractdetail.quantity.value;
  		price=document.contractdetail.price.value;
  		if(contractNo==""){
  			alert("��ͬ��Ų���Ϊ�գ�");
  			document.contractdetail.contractNo.focus();
  			return;
  		}
  		if(productNo==""){
  			alert("��Ʒ��Ų���Ϊ�գ�");
  			document.contractdetail.productNo.focus();
  			return;
  		}
  		if(quantity==""){
  			alert("�ܽ���Ϊ�գ�");
  			document.contractdetail.quantity.focus();
  			return;
  		}
  		if(price==""){
  			alert("�ܽ���Ϊ�գ�");
  			document.contractdetail.price.focus();
  			return;
  		}
  		document.contractdetail.submit();
  }
  </script>
  <h1 align="center">�ɹ���ͬ��ϸ����дҳ��</h1>
    <form name="contractdetail" action="servlet/servBDContractdetail" method="post">
    <table width="450" border="3">
    <tr>
    <td align="center">��ͬ���</td>
    <td></td>
    </tr>
    <tr>
    <td align="center">��Ʒ���</td>
    <td></td>
    </tr>
    <tr>
    <td align="center">����</td>
    <td><input type="text" name="quantity"></td>
    </tr>
    <tr>
    <td align="center">����</td>
    <td><input type="text" name="price"></td>
    </tr>
    <tr>
    <td align="center"><input type="button" onclick="validate()" value="�ύ"></td>
    <td><input type="reset" value="����"></td>
    </tr>
    </table>
    </form>
  </body>
  </center>
</html>
