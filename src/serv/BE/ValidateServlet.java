package serv.BE;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,
	IOException{
	//得到提交的验证码
		String code = request.getParameter("code");
		//获取session中的验证码		
		HttpSession session = request.getSession();
		String randStr = (String)session.getAttribute("randStr");
		response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();
		if(!code.equals(randStr)){
			out.println("验证码错误！");
		}
		else{
			request.getRequestDispatcher(request.getParameter("path")).forward(request, response);
			out.println("验证码正确！跳转到loginservlet……");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
