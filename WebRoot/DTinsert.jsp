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
    
    <title>My JSP 'DTinsert.jsp' starting page</title>
    
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
  			number = document.formtable.number.value;
  			name = document.formtable.name.value;
  			//ifvoid = document.formtable.ifvoid.value;
  			if(number==""){
  				alert("编号不能为空！");
  				document.formtable.number.foucs();
  				return;
  			}
  			if(name==""){
  				alert("名称不能为空！");
  				document.formtable.name.foucs();
  				return;
  			}
  		/* 	if(ifvoid==""){
  				alert("是否有效不能为空！");
  				document.formtable.ifvoid.foucs();
  				return;
  			} */
  			document.formtable.submit();			
  }
  </script>
  <h1 align="center">数据字典填写页面</h1>
    <form name="formtable" action="servlet/servDTPostIns" method="post">
    <table width="450">
    <tr>
    <td align="center">编号</td>
    <td><input type="text" name="number"></td>
    </tr>
    <tr>
    <td align="center">名称</td>
    <td><input type="text" name="name"></td>
    </tr>
    <tr>
    <td align="center">外键编号</td>
    <td><input type="text"  name="foreignkey"></td>
    </tr>
    <!-- <tr>
    <td align="center">是否有效</td>
    <td><input type="text"  name="ifvoid"></td>
    </tr> -->
    <tr>
    <td align="center">选择要填写的字典表</td>
    <td>
    <select  name="tableName">
  	<option value="DTProvice">省/直辖市/自治区表</option>
  	<option value="DTCity">市/自治州表</option>
  	<option value="DTCounty">区/县表</option>
  	<option value="DTPbranch">店类型表</option>
  	<option value="DTdepartment">部门表</option>
  	<option value="DTheadship">职务表</option>
  	<option value="DTpackage">包装表</option>
  	<option value="DTpayway">货款支付方式表</option>
  	<option value="DTrereason">退货理由表</option>
  	<option value="DTrestate">退货状态表</option>
  	<option value="DTshipstate">配送状态表</option>
  	<option value="DTspecifiction">规格表</option>
  	<option value="DTrequality">质量要求表</option>
  	<option value="DTrefunds">退货条件表</option>
  	<option value="DTtypegood">商品类型表</option>
  	<option value="DTtabletype">用户类型表</option>
  	</select>
  	</td>
    </tr>
    <tr>
    <td align="center"><input type="button" onclick="validate()" value="完成提交"></td>
    <td><input type="reset"  value="重置"></td>
    </tr>
    </table>
    </form>
  </body>
  </center>
</html>
