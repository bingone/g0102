<%@ page language="java"  pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frmDTDateIns.jsp' starting page</title>
    
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
  
  <body>
     <!-- ��ѯ  -->
    
    <%@ include file="frmDTDatePub.jsp" %>
    
    <!-- �ж��Ƿ���ȷ���������� -->
     <script type="text/javascript">			
			function validate(){
				//�õ��������ı��������
				x1 = document.frmDTDateIns.edtx1.value;
				x2 = document.frmDTDateIns.edtx2.value;
				if(x1==""){
					alert("���ڱ�Ų���Ϊ��");
					document.frmDTDateIns.edtx1.focus();//�۽�
					return;
				}
				else if(x2==""){
					alert("���ڲ���Ϊ��");		
					document.frmDTDateIns.edtx2.focus();	
					return;	
				}	
				document.frmDTDateIns.submit();					
			}
		</script>
     
     
     <!-- ����  -->
     <form name="frmDTDateIns" action="servlet/servDTDateIns" method="post" >
       <table align="center" >
       <tr><td><h1>����������Ϣ</h1></td><td valign="top" width="200"><br></td><td valign="top"><br></td></tr>
       <tr><td>���ڱ�ţ�</td><td ><input type="text" name="edtx1" ></td><td valign="top" ><br></td></tr>
       <tr><td> ��������(yyyy-mm-dd)��</td><td><input type="text" name="edtx2" onclick="new Calendar().show(this)"></td><td valign="top"><br></td></tr>
       <tr height="100">
          <td><input type="button" onclick="validate()" value="�ύ"></td>
          <td><input type="reset" value="����"></td><td valign="top"><br></td>
       </tr>
       </table>
    </form>    
  </body>
</html>
