package serv.PRO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PRO.daoProceduce;

public class servAutoNo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servAutoNo() {
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
		
		String sx1 = request.getParameter("edtTableName").trim();
		try {
           
          //���ù�����    		
			daoProceduce dtAutoNo = new daoProceduce();
    	
    		String sAutoNo = dtAutoNo.getAutoNo(sx1);
    		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
    		out.println("<HTML>");
    		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
    		out.println("  <BODY>");
    		out.print("    This is ");
    		if (sAutoNo!=null){
    			out.print("    This autoNo is  "+sAutoNo);
    		}else{
    		out.print("    create autoNo error  ");;    		}
        }
        catch (NullPointerException e) {            
        }
		
        out.println("</HTML>");
		out.flush();
		out.close();
		
		
		
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
