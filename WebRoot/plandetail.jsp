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
    
    <title>My JSP 'plandetail.jsp' starting page</title>
    
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
  <script type="text/javascript">function validate1(){
  		productNo=document.plandetail.productNo.value;
  		quantity=document.plandetail.quantity.value;
  		if(productNo==""){
  			alert("商品编号不能为空！");
  			document.plandetail.productNo.focus();
  			return;
  		}
  		if(quantity==""){
  			alert("采购数量不能为空！");
  			document.plandetail.quantity.focus();
  			return;
  		}
  		document.plandetail.submit();
  }
  </script>
  <h1 align="center">采购计划明细表填写页面</h1>
   <form name="plandetail" action="servlet/servBDPlandetailIns" method="post">
    <table width="500" border="3">
    <tr><h4 align="center">采购计划明细表</h4></tr>
    <tr>
    <td align="center">计划编号</td>
    <td><select name="employeeNo" size="1" id="employeeNo" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="17" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
    </tr>
    <tr>
    <td align="center">商品编号</td>
    <td><input type="text" name="productNo"></td>
    </tr>
    <tr>
    <td align="center">采购数量</td>
    <td><input type="text" name="quantity"></td>
    </tr>
    <tr>
    <td align="center"><input type="button" onclick="validate1()"value="提交"></td>
    <td><input type="reset" value="重置"></td>
    </tr>
    </table>
    </form>
  </body>
  </center>
</html>
