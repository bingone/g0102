package serv.BE;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.DT.voDTDate;
import dao.DT.daoDTDate;

import vo.BE.voBEEmployee;
import dao.BE.daoBEEmployee;

public class servBEEmployeeQry extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servBEEmployeeQry() {
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
		response.setCharacterEncoding("gb2312");
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html; charset=gb2312");
		PrintWriter out = response.getWriter();
		Map<String,String> mp = new HashMap<String,String>();
		if(request.getParameter("EmployeeName").trim().equals("")==false)
			mp.put("EmployeeName", "'"+request.getParameter("EmployeeName").trim()+"'");
		if(request.getParameter("EmployeeNo").trim().equals("")==false)
			mp.put("EmployeeNo", "'"+request.getParameter("EmployeeNo").trim()+"'");
		try {
          //调用员工类
            List<voBEEmployee> flag = new daoBEEmployee().qryBEEmployee(mp);
    		if (flag.size() >0){
    			for(voBEEmployee e:flag){
    				/*RequestDispatcher rd = request.getRequestDispatcher("qryemployee.jsp");
    		        String no = e.getEmployeeNo();
    		        request.setAttribute("employee",collection);//存值
    		        rd.forward(request,response);*/
    			out.println("<table width='400' border='1'>");
    			out.println("<tr><td>员工编号</td><td>"+e.getEmployeeNo()+"</td></tr>");
    			out.println("<tr><td>员工姓名</td><td>"+e.getEmployeeName()+"</td></tr>");
    			out.println("<tr><td>性别</td><td>"+e.getSex()+"</td></tr>");
    			out.println("<tr><td>出生日期</td><td>"+e.getBirthday()+"</td></tr>");
    			out.println("<tr><td>电话</td><td>"+e.getTelephone()+"</td></tr>");
    			out.println("<tr><td>职务</td><td>"+e.getHeadship()+"</td></tr>");
    			out.println("<tr><td>薪水</td><td>"+e.getSalary()+"</td></tr>");
    			out.println("<tr><td>所属部门</td><td>"+e.getDepartmentNo()+"</td></tr>");
    			out.println("<tr><td>雇用日期</td><td>"+e.getHireDate()+"</td></tr>");
    			out.println("</table>");
    			}
    		}else{
    			out.print("<script>location.href='../qryemployee.jsp';" +
    			"alert('search error！');</script>");
    		}
        }
        catch (NullPointerException e) {
            
        }
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
