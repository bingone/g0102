package serv.BD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import vo.BD.voBDcontract;
import vo.BD.voBDcontractdatail;
import vo.DT.voDTDate;
import dao.BD.daoBDcontract;
import dao.BD.daoBDcontractdatail;
import dao.DT.daoDTDate;

public class servBDcontractdatailIns extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servBDcontractdatailIns() {
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
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	
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
		
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		
		String sx1 = request.getParameter("edtx1").trim();
		String sx2 = request.getParameter("edtx2").trim();
		
		//½«×Ö·û´®×ª»»ÎªTimestamp
		try {
		      //
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				voBDcontractdatail vocontractdetail = new voBDcontractdatail();
				vocontractdetail.setContractNo(request.getParameter("contractNo").trim());
				vocontractdetail.setProductNo(request.getParameter("productNo").trim());
				vocontractdetail.setQuantity(Integer.parseInt(request.getParameter("quantity").trim()));
				vocontractdetail.setPrice(Double.parseDouble(request.getParameter("price")));
//		        try {
//					vocontract.setSigndate(new Date( sdf.parse(request.getParameter("signdate").trim()).getTime() ) );
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				Boolean flag = new daoBDcontractdatail().insBDcontractdatail(vocontractdetail);
				if (flag != null){
					out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		    		out.println("<HTML>");
		    		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		    		out.println("  <BODY>");
		    		out.print("   customerNo is "+flag);
		    		out.println("</HTML>");
		    		out.flush();
		    		out.close();
				}else{
					out.print("<script>location.href='../branch.jsp';" +
					"alert('insert error ');</script>");
				}
		    }
		    catch (NullPointerException e) {
		        
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
