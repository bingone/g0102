package serv.DT;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.DT.voDTPost;
import dao.DT.daoDTPost;

public class servDTPostQry extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servDTPostQry() {
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
		response.setCharacterEncoding("gb2312");
		String sPostNo = request.getParameter("edtPostNo").trim();
		String tablename = request.getParameter("tablename").trim();
		//调用岗位类
		out.print(sPostNo);
		voDTPost vodtPost = new voDTPost();
		daoDTPost dtPost = new daoDTPost();
		vodtPost.setPostNo(sPostNo);
		out.print(vodtPost.getPostNo());
		boolean flag = true;
		//dtPost.qryDTPost(vodtPost,tablename);
		out.print("aaaa");
		if (flag==false){
			out.print("<script>location.href='../dirDT/frmDTPostDel.jsp';" +
			"alert('delete fail！');</script>");
		}else{
			out.print("<script>location.href='../dirDT/frmDTPostDel.jsp';" +
			"alert('delete success！');</script>");
		}
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
