<%@ page language="java"  pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frmFunEmpSal.jsp' starting page</title>
    
	

  </head>
  
  <body>
    This is  get employee Sal page. <br><br><br>
    
     <!-- �ж��Ƿ���ȷ���������� -->
     <script type="text/javascript">			
			function validate(){
				//�õ��������ı��������
				x1 = document.frmEmpSal.edtEmpNo.value;
				if(x1==""){
					alert("��������Ϊ��");
					document.frmEmpSal.edtEmpNo.focus();//�۽�
					return;
				}				
				document.frmEmpSal.submit();					
			}
		</script>
     
     <form name="frmEmpSal" action="servlet/servEmpSal" method="post" >
    
       ����Ա����ţ�<input type="text" name="edtEmpNo"><br><br>

          <input type="button" onclick="validate()" value="�ύ">
         <input type="reset" value="����"><br>
   
    </form>    
    
  </body>

</html>
