<%@ page language="java"  pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frmAutoNo.jsp' starting page</title>    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is aoto to get No page. <br><br><br>
    
     <!-- �ж��Ƿ���ȷ���������� -->
     <script type="text/javascript">			
			function validate(){
				//�õ��������ı��������
				x1 = document.frmAutoNo.edtTableName.value;
				if(x1==""){
					alert("��������Ϊ��");
					document.frmAutoNo.edtTableName.focus();//�۽�
					return;
				}				
				document.frmAutoNo.submit();					
			}
		</script>
     
     <form name="frmAutoNo" action="servlet/servAutoNo" method="post" >
    
       ���������<input type="text" name="edtTableName"><br><br>

          <input type="button" onclick="validate()" value="�ύ">
         <input type="reset" value="����"><br>
   
    </form>    
    
  </body>
</html>
