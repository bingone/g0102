<%@ page pageEncoding="gb2312" import = "dao.DT.daoDTPost,vo.DT.voDTPost , java.util.ArrayList,java.util.*"%>
     <!-- ��ѯ  -->    
     <div align="center"><span class="style1"></span><BR>
      </div>
      <hr>
      <BR>
   <table border=2 bordercolor="#FF0000"  align="center">
      <tr>
         <td>��λ���</td>
         <td>��λ����</td>
         <td>�Ƿ�����</td>         
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