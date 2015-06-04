package serv.BE;

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

import vo.DT.voDTDate;
import dao.DT.daoDTDate;

import vo.BE.voBEEmployee;
import dao.BE.daoBEEmployee;

public class servBEEmployeeIns extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servBEEmployeeIns() {
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

		System.out.println("innnn");
		String test = request.getParameter("birthday").trim();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//
		try {
          //
            voBEEmployee voEmployee = new voBEEmployee();
            voEmployee.setEmployeeNo(request.getParameter("account").trim());
            voEmployee.setEmployeeName(request.getParameter("name").trim());
            voEmployee.setBirthday(new Date( sdf.parse(request.getParameter("birthday").trim()).getTime() ) );
            voEmployee.setHireDate(new Date( sdf.parse(request.getParameter("hiredate").trim()).getTime() ) );
            voEmployee.setDepartmentNo(request.getParameter("department").trim());
            voEmployee.setHeadship(request.getParameter("headship").trim());
            voEmployee.setSex(request.getParameter("sex").trim());
            voEmployee.setTelephone(request.getParameter("phone").trim());
            voEmployee.setSalary(Double.parseDouble(request.getParameter("salary").trim()));
    		String flag = new daoBEEmployee().insBEEmployee(voEmployee);
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
    			out.print("<script>location.href='../register.jsp';" +
    			"alert('insert error');</script>");
    		}
        }
        catch (NullPointerException e) {
            
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
