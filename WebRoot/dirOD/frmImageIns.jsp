<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frmImageIns.jsp' starting page</title>
    
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
    ͼƬ����. <br>
    <!-- �ж��Ƿ���ȷ���������� -->
     <script type="text/javascript">			
			function validate(){
				//�õ��������ı��������
				x1 = document.frmImageIns.edtx1.value;
				
				if(x1==""){
					alert("���ڱ�Ų���Ϊ��");
					document.frmImageIns.edtx1.focus();//�۽�
					return;
				}
				
				document.frmImageIns.submit();					
			}
		</script>
     
    <form name="imageIns" action="servlet/servDTDateIns" method="post" >
       <table align="center" >
       <tr><td><h1>����ͼƬ��Ϣ</h1></td><td valign="top" width="200"><br></td><td valign="top"><br></td></tr>
       <tr><td>ͼƬ��ţ�</td><td ><input type="text" name="edtx1" ></td><td valign="top" ><br></td></tr>
       <tr><td> ѡ��ͼƬ��</td><td> <br> 
           <input type="file" name="image"> <br> 
       <td valign="top"><br></td></tr>
       <tr height="100">
          <td><input type="button" onclick="validate()" value="�ύ"></td>
          <td><input type="reset" value="����"></td><td valign="top"><br></td>
       </tr>
       </table>
    </form>    
  </body>
</html>
