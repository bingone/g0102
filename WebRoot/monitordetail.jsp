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
    
    <title>My JSP 'monitordetail.jsp' starting page</title>
    
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
  			goodnum=document.monitordetail.goodnum.value;
  			badnum=document.monitordetail.badnum.value;
  			if(goodnum==""){
  				alert("�ϸ���������Ϊ�գ�");
  				document.monitordetail.goodnum.focus();
  				return;
  			}
  			if(badnum==""){
  				alert("���ϸ���������Ϊ�գ�");
  				document.monitordetail.badnum.focus();
  				return;
  			}
  			document.monitordetail.submit();
  		}
  </script>
    <h1 align="center">�ʼ���ϸ����дҳ��</h1>
    <form name="monitordetail" action="servlet/servBDMonitordetail"method="post">
    <table width="450" border="3">
    <tr>
    <td align="center">��ر��</td>
    <td></td>
    </tr>
    <tr>
    <td align="center">��Ʒ���</td>
    <td></td>
    </tr>
    <tr>
    <td align="center">�ϸ�����</td>
    <td><input type="text" name="goodnum"></td>
    </tr>
    <tr>
    <td align="center">���ϸ�����</td>
    <td><input type="text" name="badnum"></td>
    </tr>
    <tr>
    <td align="center">���Ҫ��</td>
    <td>
    <select name="specifiction" size="1" id="specifiction" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="12" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
    </tr>
    <tr>
    <td align="center">����Ҫ��</td>
    <td>
    <select name="requality" size="1" id="requality" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="13" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
    </tr>
    <tr>
    <td align="center">��װҪ��</td>
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
    <td align="center"><input type="button" onclick="validate()"value="�ύ"></td>
    <td><input type="reset" value="����"></td>
    </tr>
    </table>
    </form>
  </body>
  </center>
</html>
