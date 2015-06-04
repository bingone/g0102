package serv.BE;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BE.voBECustomer;
import dao.BE.daoBECustomer;

public class servBECustomerQry extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servBECustomerQry() {
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
		if(request.getParameter("CustomerName").trim().equals("")==false)
			mp.put("CustomerName", "'"+request.getParameter("CustomerName").trim()+"'");
		if(request.getParameter("CustomerNo").trim().equals("")==false)
			mp.put("CustomerNo", "'"+request.getParameter("CustomerNo").trim()+"'");
		try {
          //调用供应商类
            List<voBECustomer> flag = new daoBECustomer().qryBECustomer(mp);
    		if (flag.size() >0){
    			for(voBECustomer e:flag){
    				/*RequestDispatcher rd = request.getRequestDispatcher("qryemployee.jsp");
    		        String no = e.getEmployeeNo();
    		        request.setAttribute("employee",collection);//存值
    		        rd.forward(request,response);*/
    			out.println("<table width='400' border='1'>");
    			out.println("<tr><td>供应商编号</td><td>"+e.getCustomerNo()+"</td></tr>");
    			out.println("<tr><td>供应商名称</td><td>"+e.getCustomerName()+"</td></tr>");
    			out.println("<tr><td>地址</td><td>"+e.getAddress()+"</td></tr>");
    			out.println("<tr><td>电话</td><td>"+e.getTelephone()+"</td></tr>");
    			out.println("<tr><td>邮编</td><td>"+e.getZip()+"</td></tr>");
    			out.println("</table>");
    			}
    		}else{
    			out.print("<script>location.href='../qrycustomer.jsp';" +
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
