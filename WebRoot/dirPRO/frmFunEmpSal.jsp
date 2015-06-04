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
    
     <!-- 判断是否正确输入了数据 -->
     <script type="text/javascript">			
			function validate(){
				//得到这两个文本框的内容
				x1 = document.frmEmpSal.edtEmpNo.value;
				if(x1==""){
					alert("表名不能为空");
					document.frmEmpSal.edtEmpNo.focus();//聚焦
					return;
				}				
				document.frmEmpSal.submit();					
			}
		</script>
     
     <form name="frmEmpSal" action="servlet/servEmpSal" method="post" >
    
       输入员工编号：<input type="text" name="edtEmpNo"><br><br>

          <input type="button" onclick="validate()" value="提交">
         <input type="reset" value="重置"><br>
   
    </form>    
    
  </body>

</html>
