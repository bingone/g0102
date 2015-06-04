package serv.BE;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BE.voBEProduct;
import dao.BE.daoBEProduct;

public class servBEProductIns extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servBEProductIns() {
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

		
		//
		try {
          //
            voBEProduct voProduct = new voBEProduct();
            
            voProduct.setProductName(request.getParameter("productname").trim());
            voProduct.setPackaging(request.getParameter("package").trim());
            voProduct.setProductclass(request.getParameter("typegood").trim());
            voProduct.setSpecifiction(request.getParameter("specifiction").trim());
            voProduct.setRequality(request.getParameter("requality").trim());
    		String flag = new daoBEProduct().insBEProduct(voProduct);
    		if (flag != null){
    			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        		out.println("<HTML>");
        		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        		out.println("  <BODY>");
        		out.print("   employeeNo is "+flag);
        		out.println("</HTML>");
        		out.flush();
        		out.close();
    		}else{
    			out.print("<script>location.href='../product.jsp';" +
    			"alert('insert error');</script>");
    		}
        }
        catch (NullPointerException e) {
            
        }
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("success");
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
