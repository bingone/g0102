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
   <!-- �ж��Ƿ���ȷ���������� -->
     <script type="text/javascript">			
			function validate(){
				//�õ��������ı��������
				edtEmpName1 = document.frmBEEmployee.edtEmpName.value;
				edtSex1 = document.frmBEEmployee.edtSex.value;
				edtDepartment1 = document.frmBEEmployee.edtDepartment.value;
				edtPost1 = document.frmBEEmployee.edtPost.value;
				edtWorkDate1 = document.frmBEEmployee.edtWorkDate.value;			
				if(edtEmpName1==""){
					alert("Ա����������Ϊ��");
					document.frmBEEmployee.edtEmpName.focus();//�۽�
					return;}
				if(edtSex1==""){
					alert("Ա���Ա���Ϊ��");
					document.frmBEEmployee.edtSex.focus();//�۽�
					return;}
				if(edtDepartment1==""){
					alert("�������Ų���Ϊ��");
					document.frmBEEmployee.edtDepartment.focus();//�۽�
					return;}
				if(edtWorkDate1==""){
					alert("�μӹ���ʱ�䲻��Ϊ��");		
					document.frmBEEmployee.edtWorkDate.focus();	
					return;	}	
				if(edtPost1==""){
					alert("Ա����������Ϊ��");
					document.frmBEEmployee.edtPost.focus();//�۽�
					return;}					
				document.frmBEEmployee.submit();					
			}
		</script>
     
     <!-- ����  -->
     <form name="frmBEEmployee" action="servlet/servBEEmployeeIns" method="post" >
       <table align="center" >
       <tr><td><h1>����Ա��������Ϣ</h1></td></tr>
       
       <tr><td><h3>**Ա��������</h3></td><td><input type="text" name="edtEmpName"></td></tr>
       <tr><td><h3>**Ա���Ա�</h3></td><td><input type="radio" name="edtSex" value="��" checked>��
                                <input type="radio" name="edtSex" value="Ů">Ů
                            </td></tr>
       <tr align="left"><td><h3>**�������ţ�</h3></td>
            <td> <select name="edtDepartment" size="1" id="edtDepartment" >            
                   <jsp:include page="/servlet/servNoDesc" flush="true" >
                   <jsp:param name="flag" value="2" />            
                   </jsp:include>
                  <%= request.getAttribute("sString")%>
                 </select> </td>    
          </tr>
       <tr><td><h3>**������λ��</h3></td>
              <td> <select name="edtPost" size="1" id="edtPost" >            
                  <jsp:include page="/servlet/servNoDesc" flush="true" >
                  <jsp:param name="flag" value="1" />            
                  </jsp:include>
                  <%= request.getAttribute("sString")%>
               </select> </td> 
           </tr>
       <tr><td><h3>**�μӹ������ڣ�</h3></td><td><input type="text" name="edtWorkDate"></td></tr>
       <tr><td><h3>�������ڣ�</h3></td><td><input type="text" name="edtBirthday"></td></tr>
       <tr><td><h3>нˮ��</h3></td><td><input type="text" name="edtSalary"></td></tr>
       <tr><td><h3>��ͥסַ��</h3></td><td><input type="text" name="edtAddress"></td></tr>
       <tr><td><h3>��ϵ�绰��</h3></td><td><input type="text" name="edtTelphone"></td></tr>
       <tr><td><h3>email��ַ��</h3></td><td><input type="text" name="edtEmail"></td></tr>
       <tr height="100">
          <td><input type="button" onclick="validate()" value="�ύ"></td>
          <td><input type="reset" value="����"></td>
       </tr>
       </table>
    </form>    
  </body>
</html>
