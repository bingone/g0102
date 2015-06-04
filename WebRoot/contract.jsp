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
    
    <title>My JSP 'contract.jsp' starting page</title>
    
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
    function validate1(){
  		customerNo=document.contract.customerNo.value;
  		employeeNo=document.contract.employeeNo.value;
  		ordersum=document.contract.ordersum.value;
  		if(customerNo==""){
  			alert("供应商编号不能为空！");
  			document.contract.customerNo.focus();
  			return;
  		}
  		if(employeeNo==""){
  			alert("员工编号不能为空！");
  			document.contract.employeeNo.focus();
  			return;
  		}
  		if(ordersum==""){
  			alert("总金额不能为空！");
  			document.contract.ordersum.focus();
  			return;
  		}
  		document.contract.submit();
  }
  </script>
  <h1 align="center">采购合同主表填写页面</h1>
   <form name="contract" action="servlet/servBDContractIns" method="post">
    <table width="500" border="3">
    <tr><h4 align="center">采购合同主表</h4></tr>
    <tr>
    <td align="center">供应商编号</td>
    <td><input type="text" name="customerNo"></td>
    </tr>
    <tr>
    <td align="center">职工编号</td>
    <td><input type="text" name="employeeNo"></td>
    </tr>
    <tr>
    <td align="center">总金额</td>
    <td><input type="text" name="ordersum"></td>
    </tr>
    <tr>
    <td align="center">货款支付方式</td>
    <td><select name="payway" size="1" id="payway" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="8" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
    </tr>
    <tr>
    <td align="center">退货条件</td>
    <td><select name="refunds" size="1" id="refunds" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="14" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> 
    </td>
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
