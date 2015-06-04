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
     <!-- 查询  -->
     <%@ include file="frmDTPostPub.jsp" %>
     <!-- 判断是否正确输入了数据 -->
     <script type="text/javascript">			
			function validate(){
				//得到这两个文本框的内容
				sPostNo = document.frmDTPost.edtPostNo.value;
				sPostName = document.frmDTPost.edtPostName.value;
				if(sPostNo==""){
					alert("岗位编号不能为空");
					document.frmDTPost.edtPostNo.focus();//聚焦
					return;
				}
				else if(sPostName==""){
					alert("岗位描述不能为空");		
					document.frmDTPost.edtPostName.focus();	
					return;	
				}	
				document.frmDTPost.submit();					
			}
		</script>
     
     
     <!-- 插入  -->
     <form name="frmDTPost" action="servlet/servDTPostIns" method="post" >
       <table align="center" >
       <tr><td><h1>输入要修改的岗位信息</h1></td></tr>
       <tr><td>岗位编号：</td><td><input type="text" name="edtPostNo"></td></tr>
       <tr><td> 岗位描述 ：</td><td><input type="text" name="edtPostName"></td></tr>
       <tr height="100">
          <td><input type="button" onclick="validate()" value="提交"></td>
          <td><input type="reset" value="重置"></td>
       </tr>
       </table>
    </form>    
  </body>
</html>
