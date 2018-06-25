<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<c:if test="${empty emp}">
	<script>
		alert("您还没有登录，请重新登录");
		location.href="login.jsp";
	</script>
</c:if>
