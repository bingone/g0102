package serv.BE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BE.voBEBranch;
import dao.BE.daoBEBranch;

public class servBEBranchDel extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servBEBranchDel() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("gb2312");
		//将字符串转换为Timestamp
		try {
          //调用分店类
			voBEBranch dtBranch = new voBEBranch();
			String BranchNo = request.getParameter("BranchNo").trim();
			dtBranch.setBranchNo(BranchNo);
            boolean flag = new daoBEBranch().delBEBranch(dtBranch);
    		if (flag == true){
    			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        		out.println("<HTML>");
        		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        		out.println("  <BODY>");
        		out.print("branchNo deleted is: "+BranchNo);
        		out.println("</BODY></HTML>");
        		out.flush();
        		out.close();
    		}else{
    			out.print("<script>location.href='../delbranch.jsp';" +
    			"alert('delete error！');</script>");
    		}
        }
        catch (NullPointerException e) {
            
        }
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("aaa");
		doPost(request,response);
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
