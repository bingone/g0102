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
  				alert("��Ų���Ϊ�գ�");
  				document.formtable.number.foucs();
  				return;
  			}
  			if(name==""){
  				alert("���Ʋ���Ϊ�գ�");
  				document.formtable.name.foucs();
  				return;
  			}
  		/* 	if(ifvoid==""){
  				alert("�Ƿ���Ч����Ϊ�գ�");
  				document.formtable.ifvoid.foucs();
  				return;
  			} */
  			document.formtable.submit();			
  }
  </script>
  <h1 align="center">�����ֵ���дҳ��</h1>
    <form name="formtable" action="servlet/servDTPostIns" method="post">
    <table width="450">
    <tr>
    <td align="center">���</td>
    <td><input type="text" name="number"></td>
    </tr>
    <tr>
    <td align="center">����</td>
    <td><input type="text" name="name"></td>
    </tr>
    <tr>
    <td align="center">������</td>
    <td><input type="text"  name="foreignkey"></td>
    </tr>
    <!-- <tr>
    <td align="center">�Ƿ���Ч</td>
    <td><input type="text"  name="ifvoid"></td>
    </tr> -->
    <tr>
    <td align="center">ѡ��Ҫ��д���ֵ��</td>
    <td>
    <select  name="tableName">
  	<option value="DTProvice">ʡ/ֱϽ��/��������</option>
  	<option value="DTCity">��/�����ݱ�</option>
  	<option value="DTCounty">��/�ر�</option>
  	<option value="DTPbranch">�����ͱ�</option>
  	<option value="DTdepartment">���ű�</option>
  	<option value="DTheadship">ְ���</option>
  	<option value="DTpackage">��װ��</option>
  	<option value="DTpayway">����֧����ʽ��</option>
  	<option value="DTrereason">�˻����ɱ�</option>
  	<option value="DTrestate">�˻�״̬��</option>
  	<option value="DTshipstate">����״̬��</option>
  	<option value="DTspecifiction">����</option>
  	<option value="DTrequality">����Ҫ���</option>
  	<option value="DTrefunds">�˻�������</option>
  	<option value="DTtypegood">��Ʒ���ͱ�</option>
  	<option value="DTtabletype">�û����ͱ�</option>
  	</select>
  	</td>
    </tr>
    <tr>
    <td align="center"><input type="button" onclick="validate()" value="����ύ"></td>
    <td><input type="reset"  value="����"></td>
    </tr>
    </table>
    </form>
  </body>
  </center>
</html>
