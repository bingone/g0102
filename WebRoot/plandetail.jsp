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
    
    <title>My JSP 'plandetail.jsp' starting page</title>
    
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
  <script type="text/javascript">function validate1(){
  		productNo=document.plandetail.productNo.value;
  		quantity=document.plandetail.quantity.value;
  		if(productNo==""){
  			alert("��Ʒ��Ų���Ϊ�գ�");
  			document.plandetail.productNo.focus();
  			return;
  		}
  		if(quantity==""){
  			alert("�ɹ���������Ϊ�գ�");
  			document.plandetail.quantity.focus();
  			return;
  		}
  		document.plandetail.submit();
  }
  </script>
  <h1 align="center">�ɹ��ƻ���ϸ����дҳ��</h1>
   <form name="plandetail" action="servlet/servBDPlandetailIns" method="post">
    <table width="500" border="3">
    <tr><h4 align="center">�ɹ��ƻ���ϸ��</h4></tr>
    <tr>
    <td align="center">�ƻ����</td>
    <td><select name="employeeNo" size="1" id="employeeNo" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="17" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
    </tr>
    <tr>
    <td align="center">��Ʒ���</td>
    <td><input type="text" name="productNo"></td>
    </tr>
    <tr>
    <td align="center">�ɹ�����</td>
    <td><input type="text" name="quantity"></td>
    </tr>
    <tr>
    <td align="center"><input type="button" onclick="validate1()"value="�ύ"></td>
    <td><input type="reset" value="����"></td>
    </tr>
    </table>
    </form>
  </body>
  </center>
</html>
