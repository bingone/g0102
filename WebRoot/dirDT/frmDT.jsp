<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frmDT.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
   <body  background="image/backgrand/work.jpg">
    <h2>业务字典维护</h2>
    <table> 
       <tr height="20">
          <td rowspan="4">
          </td>
          <td>&nbsp;&nbsp;</td>
       </tr>      
       <tr height="80">
          <td width="100">&nbsp;&nbsp;</td>          
          <td width="150">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
                                 日期数据维护</font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirDT/frmDTDateIns.jsp"><img src="image/button/myAdd.png">插入</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirPRO/frmAutoNo.jsp"><img src="image/button/myDelete.png">过程1</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirPRO/frmQryDTPost.jsp"><img src="image/button/myUpdate.png">过程2</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirPRO/frmFunEmpSal.jsp"><img src="image/button/myQuery.png">函数</a></font></strong></p>      
          </td>
       </tr>
       <tr height="80">
       <td width="100">&nbsp;&nbsp;</td>          
          <td width="150">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
                                 岗位表维护</font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main"  href="dirDT/frmDTPostIns.jsp"><img src="image/button/myAdd.png">插入</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirDT/frmDTPostDel.jsp"><img src="image/button/myDelete.png">删除</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirDT/frmDTPostUpt.jsp"><img src="image/button/myUpdate.png">更新</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirDT/frmDTPost.jsp"><img src="image/button/myQuery.png">查询</a></font></strong></p>      
          </td>
       </tr>
        <tr height="80">
       <td width="100">&nbsp;&nbsp;</td>          
          <td width="150">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
                                 图片数据维护</font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main"  href="dirDT/frmDTPostIns.jsp"><img src="image/button/myAdd.png">插入</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirDT/frmDTPostDel.jsp"><img src="image/button/myDelete.png">删除</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirDT/frmDTPostUpt.jsp"><img src="image/button/myUpdate.png">更新</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirDT/frmDTPost.jsp"><img src="image/button/myQuery.png">查询</a></font></strong></p>      
          </td>
       </tr>
       <tr height="80">
          <td width="100">&nbsp;&nbsp;</td>  
          <td width="100">&nbsp;&nbsp;</td>        
          <td width="150">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
                                 员工数据维护</font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="dirBE/frmBEEmployeeIns.jsp"><img src="image/button/myAdd.png">插入</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="indexMain.jsp"><img src="image/button/myDelete.png">删除</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="indexMain.jsp"><img src="image/button/myUpdate.png">更新</a></font></strong></p>      
          </td>
          <td width="100">
             <p><strong><font face="宋体" size="4"><font color="#FFFFFF"></font>
             <a target="main" href="indexMain.jsp"><img src="image/button/myQuery.png">查询</a></font></strong></p>      
          </td>
       </tr>      
     </table>
  </body>
</html>