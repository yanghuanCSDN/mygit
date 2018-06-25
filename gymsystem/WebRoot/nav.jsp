<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
	<c:if test="${emp==0}">
		<li>教练信息管理
			<ul>
				<li><a href="servlet/CoachServlet?act=1">教练列表</a></li>
			</ul>
		</li>
		<li>前台人员信息管理
			<ul>
				<li><a href="servlet/ForegroundPeopleServlet?act=1">前台人员列表</a></li>
			</ul>
		</li>
		<li>用户信息管理
			<ul>
				<li><a href="servlet/ConsumerServlet?act=1">用户列表</a></li>
			</ul>
		</li>
		<li>器材信息管理
			<ul>
				<li><a href="servlet/EquipmentServlet?act=1">器材列表</a></li>
			</ul>
		</li>
	</c:if>
	<c:if test="${emp==1}">
		<li>用户信息管理
			<ul>
				<li><a href="servlet/ConsumerServlet?act=1">用户列表</a></li>
			</ul>
		</li>
	</c:if>
	<c:if test="${emp==2}">
		<li>用户信息管理
			<ul>
				<li><a href="servlet/ConsumerServlet?act=1">用户列表</a></li>
			</ul>
		</li>
		<li>教练信息管理
			<ul>
				<li><a href="servlet/CoachServlet?act=1">教练列表</a></li>
			</ul>
		</li>
	</c:if>
</ul>
