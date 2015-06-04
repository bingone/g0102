<%@ page pageEncoding="gb2312" import = "dao.DT.daoDTPost,vo.DT.voDTPost , java.util.ArrayList,java.util.*"%>
     <!-- 查询  -->    
     <div align="center"><span class="style1"></span><BR>
      </div>
      <hr>
      <BR>
   <table border=2 bordercolor="#FF0000"  align="center">
      <tr>
         <td>岗位编号</td>
         <td>岗位描述</td>
         <td>是否作废</td>         
      </tr> 
      <%   
        daoDTPost dtPost = new daoDTPost();
        ArrayList<voDTPost> dtPostList = dtPost.qryDTPost(new HashMap<String,String>(),null);
        int i=0;      
        while(i<dtPostList.size())  
        { voDTPost dtPostAll=(voDTPost)dtPostList.get(i);
          i++;
        %> 
           <tr>    
	         <td><%=dtPostAll.getPostNo()%> </td> 
	         <td><%=dtPostAll.getPostName()%> </td> 
	         <td><%=dtPostAll.getIfVoid()%> </td> 
		   </tr>    
           <%}
       %>      
   </table>