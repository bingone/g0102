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
    
     <!-- 判断是否正确输入了数据 -->
     <script type="text/javascript">			
			function validate(){
				//得到这两个文本框的内容
				x1 = document.frmAutoNo.edtTableName.value;
				if(x1==""){
					alert("表名不能为空");
					document.frmAutoNo.edtTableName.focus();//聚焦
					return;
				}				
				document.frmAutoNo.submit();					
			}
		</script>
     
     <form name="frmAutoNo" action="servlet/servAutoNo" method="post" >
    
       输入表名：<input type="text" name="edtTableName"><br><br>

          <input type="button" onclick="validate()" value="提交">
         <input type="reset" value="重置"><br>
   
    </form>    
    
  </body>
</html>
