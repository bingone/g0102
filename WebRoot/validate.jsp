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
  //���ڴ��д���ͼ��
  int width = 60,height = 20;
  BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
  //��ȡ����
  Graphics g = image.getGraphics();
  //�趨����ɫ
  g.setColor(new Color(200,200,200));
  g.fillRect(0,0,width,height);
  //ȡ�����������֤�루��λ���֣�
  Random rnd = new Random();
  int randNum = rnd.nextInt(8999)+1000;
  String randStr = String.valueOf(randNum);
  //����֤�����session
  session.setAttribute("randStr",randStr);
  //����֤����ʾ��ͼ����
  g.setColor(Color.black);
  g.setFont(new Font("",Font.PLAIN,20));
  g.drawString(randStr,10,17);
  //�������100�����ŵ㣬ʹͼ���е���֤�벻�ױ���������̽�⵽
  for(int i = 0;i < 100;i++){
  	int x = rnd.nextInt(width);
  	int y = rnd.nextInt(height);
  	g.drawOval(x,y,1,1);
  }
  //���ͼ��ҳ��
  ImageIO.write(image,"JPEG",response.getOutputStream());
  out.clear();
  out = pageContext.pushBody();
  %>
</html>
