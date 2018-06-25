<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${pageContext.request.contextPath }/">
    <title>${initParam.caption}</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css">
  </head>
  <body class="mainBody">
  		<div class="main">
  			<div class="title">
  				<%@ include file="../../title.jsp" %>
  			</div>
  			<div>
  				<div class="nav">
  					<%@ include file="../../nav.jsp" %>
  				</div>
  				<div class="content">
  					<h1>前台人员信息列表</h1>
  					<form action="servlet/ForegroundPeopleServlet?act=2" method="post">
  					<p> 
  					<input type="text" name="name" id="name" value="请输入所查询人姓名"/>
  					<input type="submit" name="check" id="check" value="搜索" />
  					</p><br>
	  					<table>
	  						<tr>
	  							<th>编号</th>
	  							<th>姓名</th>
	  							<th>密码</th>
	  							<th>电话号码</th>
	  							<th>性别</th>
	  							<th>工资</th>
	  							<th>入职时间</th>
	  							<th>到期时间</th>
	  							<th>照片</th>
	  							<th>状态</th>
	  						</tr>
	  						<c:forEach var="foreground" items="${foreground}">
		  						<tr>
		  							<td>${foreground.fId}</td>
		  							<td>${foreground.fName}</td>
		  							<td>${foreground.fPassword}</td>
		  							<td>${foreground.fPhone}</td>
		  							<td>${foreground.fSex}</td>
		  							<td>${foreground.fPay}</td>
		  							<td>${foreground.enterTime}</td> 
		  							<td>${foreground.endTime}</td>
		  							<td>
		  								<img alt="${foreground.fName}" src="${initParam.saveDir}/${foreground.fPage}">
		  							</td>
		  							<td>${foreground.state==1?'就职':'已离职'}</td>
		  						</tr>
	  						</c:forEach>
	  						</form>
	  						<tr>
		  						<td colspan="25" class="center">
		  							<c:if test="${page==1 }">
			  							<span>首页</span>
			  							<span>上一页</span>
		  							</c:if>
		  							<c:if test="${page>1 }">
			  							<a href="servlet/ForegroundPeopleServlet?act=1&page=1">首页</a>
			  							<a href="servlet/ForegroundPeopleServlet?act=1&page=${page-1}">上一页</a>
		  							</c:if>
		  							第${page}页
		  							<c:if test="${page<endPage }">
			  							<a href="servlet/ForegroundPeopleServlet?act=1&page=${page+1}">下一页</a>
			  							<a href="servlet/ForegroundPeopleServlet?act=1&page=${endPage}">末页</a>
		  							</c:if>
		  							<c:if test="${page==endPage }">
			  							<span>下一页</span>
			  							<span>末页</span>
		  							</c:if>
		  							<form style="display: inline;" action="servlet/ForegroundPeopleServlet?act=1" method="post">
			  							<input name="page" size="1" >
			  							<input type="submit" value="go">
		  							</form>
		  						</td>
	  						</tr>
	  					</table>
  				</div>
  			</div>
  		</div>
  </body>
  <c:if test="${not empty m }">
		<script>
			alert("${m}");
		</script>
</c:if>
</html>