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
import vo.BD.voBDmonitor;
import vo.BD.voBDmonitordatail;
import vo.DT.voDTDate;
import dao.BD.daoBDcontract;
import dao.BD.daoBDmonitor;
import dao.BD.daoBDmonitordatail;
import dao.DT.daoDTDate;

public class servBDmonitordetailIns extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servBDmonitordetailIns() {
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
				voBDmonitordatail vomonitordetail = new voBDmonitordatail();
				vomonitordetail.setProductNo(request.getParameter("productNo").trim());
				vomonitordetail.setMonitorNo(request.getParameter("monitorNo").trim());
				vomonitordetail.setGoodnum(Integer.parseInt(request.getParameter("goodnum").trim()));
				vomonitordetail.setBadnum(Integer.parseInt(request.getParameter("badnum").trim()));
				vomonitordetail.setSpecifiction(request.getParameter("specifiction").trim());
				vomonitordetail.setRequality(request.getParameter("requality").trim());
				vomonitordetail.setRepackaging(request.getParameter("repackaging").trim());
//		        try {
//		        	vomonitordetail.setMonitordate(new Date( sdf.parse(request.getParameter("monitordate").trim()).getTime() ) );
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				Boolean flag = new daoBDmonitordatail().insBDmonitordatail(vomonitordetail);
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
