<%@ page language="java"  pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frmDTDateIns.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="js/Calendar3.js"></script>
  </head>
  
  <body>
     <!-- 查询  -->
    
    <%@ include file="frmDTDatePub.jsp" %>
    
    <!-- 判断是否正确输入了数据 -->
     <script type="text/javascript">			
			function validate(){
				//得到这两个文本框的内容
				x1 = document.frmDTDateIns.edtx1.value;
				x2 = document.frmDTDateIns.edtx2.value;
				if(x1==""){
					alert("日期编号不能为空");
					document.frmDTDateIns.edtx1.focus();//聚焦
					return;
				}
				else if(x2==""){
					alert("日期不能为空");		
					document.frmDTDateIns.edtx2.focus();	
					return;	
				}	
				document.frmDTDateIns.submit();					
			}
		</script>
     
     
     <!-- 插入  -->
     <form name="frmDTDateIns" action="servlet/servDTDateIns" method="post" >
       <table align="center" >
       <tr><td><h1>插入日期信息</h1></td><td valign="top" width="200"><br></td><td valign="top"><br></td></tr>
       <tr><td>日期编号：</td><td ><input type="text" name="edtx1" ></td><td valign="top" ><br></td></tr>
       <tr><td> 输入日期(yyyy-mm-dd)：</td><td><input type="text" name="edtx2" onclick="new Calendar().show(this)"></td><td valign="top"><br></td></tr>
       <tr height="100">
          <td><input type="button" onclick="validate()" value="提交"></td>
          <td><input type="reset" value="重置"></td><td valign="top"><br></td>
       </tr>
       </table>
    </form>    
  </body>
</html>
