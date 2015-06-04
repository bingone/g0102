<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<center>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'plan.jsp' starting page</title>
    
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
  <script type="text/javascript">
  function validate(){
  		employeeNo=document.procureplan.employeeNo.value;
  		branchNo=document.procureplan.branchNo.value;
  		if(employeeNo==""){
  			alert("员工编号不能为空！");
  			document.procureplan.employeeNo.focus();
  			return;
  		}
  		if(branchNo==""){
  			alert("分店编号不能为空！");
  			document.procureplan.branchNo.focus();
  			return;
  		}
  		document.procureplan.submit();
  }
  
  </script>
 
    <h1 align="center">采购计划主表填写页面</h1>
    <form name="procureplan" action="servlet/servBDProcureplanIns" method="post">
    <table width="500" border="3">
    <tr><h4 align="center">采购计划主表</h4></tr>
    <tr>
    <td align="center">职工编号</td>
    <td><input type="text" name="employeeNo"></td>
    </tr>
    <tr>
    <td align="center">分店编号</td>
    <td><input type="text" name="branchNo"></td>
    </tr>
  
    <tr>
    <td align="center"><input type="button" onclick="validate()"value="提交"></td>
    <td><input type="reset" value="重置"></td>
    </tr>
    </table>
    </form>
  </body>
  </center>
</html>
