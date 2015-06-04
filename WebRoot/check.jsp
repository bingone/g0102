<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'check.jsp' starting page</title>
    
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
    <%
    request.setCharacterEncoding("gb2312");
	String code = request.getParameter("code");
	//获取session中的验证码		
	String randStr = (String)session.getAttribute("randStr");

	if(!code.equals(randStr)){
	%>
		<script type="text/javascript">
		alert("验证码错误");  
      	window.history.back(-1);     
		</script>
	<%}
	else{
		String x = request.getParameter("pathname");
		request.getRequestDispatcher(request.getParameter("pathname")).forward(request, response);
	}

 %>
  </body>
</html>
