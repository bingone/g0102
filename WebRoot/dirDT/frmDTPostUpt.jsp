<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="java.sql.*" %>
<%@ page import="dao.DT.*"%>
<%@ page import="vo.DT.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frmDTPostIns.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="image/backgrand/work.jpg">
     <!-- ��ѯ  -->
     <%@ include file="frmDTPostPub.jsp" %>
     <!-- �ж��Ƿ���ȷ���������� -->
     <script type="text/javascript">			
			function validate(){
				//�õ��������ı��������
				sPostNo = document.frmDTPost.edtPostNo.value;
				sPostName = document.frmDTPost.edtPostName.value;
				if(sPostNo==""){
					alert("��λ��Ų���Ϊ��");
					document.frmDTPost.edtPostNo.focus();//�۽�
					return;
				}
				else if(sPostName==""){
					alert("��λ��������Ϊ��");		
					document.frmDTPost.edtPostName.focus();	
					return;	
				}	
				document.frmDTPost.submit();					
			}
		</script>
     
     
     <!-- ����  -->
     <form name="frmDTPost" action="servlet/servDTPostIns" method="post" >
       <table align="center" >
       <tr><td><h1>����Ҫ�޸ĵĸ�λ��Ϣ</h1></td></tr>
       <tr><td>��λ��ţ�</td><td><input type="text" name="edtPostNo"></td></tr>
       <tr><td> ��λ���� ��</td><td><input type="text" name="edtPostName"></td></tr>
       <tr height="100">
          <td><input type="button" onclick="validate()" value="�ύ"></td>
          <td><input type="reset" value="����"></td>
       </tr>
       </table>
    </form>    
  </body>
</html>
