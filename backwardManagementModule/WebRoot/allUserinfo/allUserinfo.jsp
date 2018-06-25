<!-- 显示全部用户信息 -->
<%@page import="com.yanghuan.model.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="/${pageContext.request.contextPath}">
    <title>账号列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
	  <body>
	  <div class="content">
	  	<h1 style="text-align: center"><font style="font-size:26px">账号列表</font></h1>
		<table bgcolor="#FFFF00" cellpadding="3px" cellspacing="3px"	 border="1" width="90%">
			<tr>
				<th>用户Id</th>
				<th>QQ号码</th>
				<th>真实姓名</th>
				<th>身份证号码</th>
				<th>手机号码</th>
				<th>个性签名</th>
				<th>是否已开通公众空间</th>
				<th>提交时间</th>
			</tr>
			<c:forEach var="userinfos" items="${userinfos}">
				<tr>
					<td>${userinfos.personId}</td> 
					<td>${userinfos.QQNumber}</td>
					<td>${userinfos.realName}</td>
					<td>${userinfos.idCard}</td>
					<td>${userinfos.cellPhoneNumber}</td>
					<td>${userinfos.personSignature}</td>
					<td>${userinfos.judgeOpened==0?"是":"否"}</td>
					<td>${userinfos.submissionTime}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	  </body>
</html>
