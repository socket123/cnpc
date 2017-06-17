<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%@include file="../common/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>${article.title}</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->	  <meta name="viewport"
			content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
	
  </head>
  
  <body>
    <h1>
${article.title}
    </h1>
    <div style="width:100%;overflow: hidden;">
    	<p style="width:100%;height:30px;line-height: 30px;font-size:14px;color:#3d3d3d;">${article.createusername}</p>
    	<p style="width:100%;height:25px;line-height: 25px;font-size: 12px;color:#808080;">${article.createtime }</p>
    </div>
    <div style="width:100%;overflow: hidden;">
<c:forEach var="image" items="${urlList}">
     <img src="${simage}"/>

</c:forEach>    
   
    	<p style="width:100%;line-height: 25px;text-indent: 2em;word-wrap:break-word; word-break:normal;font-size:14px;color:3d3d3d;">${article.content}</p>
    </div>
  </body>
</html>
