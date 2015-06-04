<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path3 = request.getContextPath();
String basePath3 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path3+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath3%>">
    
    <title>My JSP 'fresh.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
    <script type = "text/javascript">
    function refresh(){
		document.getElementById("imgVcode").src = "validate.jsp?timpstamp=" + new Date().getTime();
	}
    </script>
    <form name="fresh"action = "servlet/ValidateServlet" method = "post">
    	<input type = "text" id="freshcode" name = "code" size = "10">
    	<!-- 将验证码当成图片处理 -->
    	<img id='imgVcode'  src="validate.jsp" onclick="refresh()"/><br>
    </form>
</html>
