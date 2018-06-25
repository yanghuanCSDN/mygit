<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'Login.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/Login.css">
  </head>
   <body class="mainbody">
    <div class="top"></div>
    <div class="middle">
	    <div>
    		<form action="servlet/LoginServlet?act=1" method="post">
	    		<p>
	    			登录名：<input  name="loginName" class="txt" type="text">
	    		</p>
	    		<p>
	    			密码：
	    			<input name="password" class="txt" type="text">
	    		</p>
	    		<p><select name="select" id="select">
	    				<option selected="selected">管理员</option>
	    				<option>教练</option>
    					<option>前台人员</option>
    					<option style=" display:none" id="checked" name="hide"></option>
    				</select>
    			</p>
	    		<p>
	    			<input class="btn" type="submit" value="登录">
	    			<input class="btn" type="reset" value="取消">
	    		</p>
    		</form>
	    </div>
    </div>
    <div class="bottom"></div>
  </body>
  <c:if test="${not empty judge }">
  	<script>
  		alert("${judge}");
  	</script>
  </c:if>
</html>
