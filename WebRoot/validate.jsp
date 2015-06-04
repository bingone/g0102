<%@ page language="java" 
import="java.util.*" 
import = "java.awt.image.BufferedImage"
import = "javax.imageio.ImageIO"
import = "java.awt.*"
pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'validate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%
  response.setHeader("Cache-Control", "no-cache");
  //在内存中创建图像
  int width = 60,height = 20;
  BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
  //获取画笔
  Graphics g = image.getGraphics();
  //设定背景色
  g.setColor(new Color(200,200,200));
  g.fillRect(0,0,width,height);
  //取随机产生的验证码（四位数字）
  Random rnd = new Random();
  int randNum = rnd.nextInt(8999)+1000;
  String randStr = String.valueOf(randNum);
  //将验证码存入session
  session.setAttribute("randStr",randStr);
  //将验证码显示在图像中
  g.setColor(Color.black);
  g.setFont(new Font("",Font.PLAIN,20));
  g.drawString(randStr,10,17);
  //随机产生100个干扰点，使图像中的验证码不易被其他程序探测到
  for(int i = 0;i < 100;i++){
  	int x = rnd.nextInt(width);
  	int y = rnd.nextInt(height);
  	g.drawOval(x,y,1,1);
  }
  //输出图像到页面
  ImageIO.write(image,"JPEG",response.getOutputStream());
  out.clear();
  out = pageContext.pushBody();
  %>
</html>
