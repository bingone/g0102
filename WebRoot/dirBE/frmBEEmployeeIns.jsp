<%@ page language="java"  pageEncoding="gb2312"%>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.text.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frmBEEmployeeIns.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="image/backgrand/work.jpg">
   <!-- 判断是否正确输入了数据 -->
     <script type="text/javascript">			
			function validate(){
				//得到这两个文本框的内容
				edtEmpName1 = document.frmBEEmployee.edtEmpName.value;
				edtSex1 = document.frmBEEmployee.edtSex.value;
				edtDepartment1 = document.frmBEEmployee.edtDepartment.value;
				edtPost1 = document.frmBEEmployee.edtPost.value;
				edtWorkDate1 = document.frmBEEmployee.edtWorkDate.value;			
				if(edtEmpName1==""){
					alert("员工姓名不能为空");
					document.frmBEEmployee.edtEmpName.focus();//聚焦
					return;}
				if(edtSex1==""){
					alert("员工性别不能为空");
					document.frmBEEmployee.edtSex.focus();//聚焦
					return;}
				if(edtDepartment1==""){
					alert("所属部门不能为空");
					document.frmBEEmployee.edtDepartment.focus();//聚焦
					return;}
				if(edtWorkDate1==""){
					alert("参加工作时间不能为空");		
					document.frmBEEmployee.edtWorkDate.focus();	
					return;	}	
				if(edtPost1==""){
					alert("员工所属不能为空");
					document.frmBEEmployee.edtPost.focus();//聚焦
					return;}					
				document.frmBEEmployee.submit();					
			}
		</script>
     
     <!-- 插入  -->
     <form name="frmBEEmployee" action="servlet/servBEEmployeeIns" method="post" >
       <table align="center" >
       <tr><td><h1>插入员工基本信息</h1></td></tr>
       
       <tr><td><h3>**员工姓名：</h3></td><td><input type="text" name="edtEmpName"></td></tr>
       <tr><td><h3>**员工性别：</h3></td><td><input type="radio" name="edtSex" value="男" checked>男
                                <input type="radio" name="edtSex" value="女">女
                            </td></tr>
       <tr align="left"><td><h3>**所属部门：</h3></td>
            <td> <select name="edtDepartment" size="1" id="edtDepartment" >            
                   <jsp:include page="/servlet/servNoDesc" flush="true" >
                   <jsp:param name="flag" value="2" />            
                   </jsp:include>
                  <%= request.getAttribute("sString")%>
                 </select> </td>    
          </tr>
       <tr><td><h3>**所属岗位：</h3></td>
              <td> <select name="edtPost" size="1" id="edtPost" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="1" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> </td> 
           </tr>
       <tr><td><h3>**参加工作日期：</h3></td><td><input type="text" name="edtWorkDate"></td></tr>
       <tr><td><h3>出生日期：</h3></td><td><input type="text" name="edtBirthday"></td></tr>
       <tr><td><h3>薪水：</h3></td><td><input type="text" name="edtSalary"></td></tr>
       <tr><td><h3>家庭住址：</h3></td><td><input type="text" name="edtAddress"></td></tr>
       <tr><td><h3>联系电话：</h3></td><td><input type="text" name="edtTelphone"></td></tr>
       <tr><td><h3>email地址：</h3></td><td><input type="text" name="edtEmail"></td></tr>
       <tr height="100">
          <td><input type="button" onclick="validate()" value="提交"></td>
          <td><input type="reset" value="重置"></td>
       </tr>
       </table>
    </form>    
  </body>
</html>
