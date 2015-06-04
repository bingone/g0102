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

import vo.BE.voBEProduct;
import dao.BE.daoBEProduct;

public class servBEProductQry extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servBEProductQry() {
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
		if(request.getParameter("ProductName").trim().equals("")==false)
			mp.put("ProductName", "'"+request.getParameter("ProductName").trim()+"'");
		if(request.getParameter("ProductNo").trim().equals("")==false)
			mp.put("ProductNo", "'"+request.getParameter("ProductNo").trim()+"'");
		try {
          //调用商品类
            List<voBEProduct> flag = new daoBEProduct().qryBEProduct(mp);
    		if (flag.size() >0){
    			for(voBEProduct e:flag){
    				/*RequestDispatcher rd = request.getRequestDispatcher("qryemployee.jsp");
    		        String no = e.getEmployeeNo();
    		        request.setAttribute("employee",collection);//存值
    		        rd.forward(request,response);*/
    			out.println("<table width='400' border='1'>");
    			out.println("<tr><td>商品编号</td><td>"+e.getProductNo()+"</td></tr>");
    			out.println("<tr><td>商品名称</td><td>"+e.getProductName()+"</td></tr>");
    			out.println("<tr><td>包装</td><td>"+e.getPackaging()+"</td></tr>");
    			out.println("<tr><td>商品类型</td><td>"+e.getProductclass()+"</td></tr>");
    			out.println("<tr><td>规格</td><td>"+e.getSpecifiction()+"</td></tr>");
    			out.println("<tr><td>质量要求</td><td>"+e.getRequality()+"</td></tr>");
    			out.println("</table>");
    			}
    		}else{
    			out.print("<script>location.href='../qrybranch.jsp';" +
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
