package serv.OD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.OD.voNoDesc;
import dao.OD.daoQryNoDesc;
import java.util.*;

public class servNoDesc extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public servNoDesc() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		int nFlag;
	    try {
	      nFlag = Integer.parseInt(request.getParameter("flag"));
	    }
	    catch(NumberFormatException e) {
	      nFlag = -1;
	    }	    
	    try
	    {
	      //µ˜”√±‡∫≈√Ë ˆ¿‡
	      ArrayList noDescList=new ArrayList();		
		  daoQryNoDesc daoDesc = new daoQryNoDesc();			
		  noDescList = daoDesc.qryNoDesc(nFlag);	    	
	      String sID = null;
	      String sName = null;
	      String sString = "";
	      int i=0;      
	      while(i<noDescList.size())  
	        { voNoDesc voNoDesc=(voNoDesc)noDescList.get(i);
	          i++;
	          sID = voNoDesc.getVoNo();
	          sName = voNoDesc.getVoDesc().trim();
	          if (i==1)
	              sString += "<option value=\""+sID+"\" selected>"+sName+"</option>";
	          else
	              sString += "<option value=\""+sID+"\">"+sName+"</option>";
	        }
	      request.setAttribute("sString",sString) ;
	    }
	    catch (Exception ex)
	    {
	      ex.printStackTrace() ;
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
