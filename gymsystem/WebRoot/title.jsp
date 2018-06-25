<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
${initParam.caption}
<c:if test="${emp==0}">
	<span id="tip">管理员：${role.mName}</span>
</c:if>
<c:if test="${emp==1}">
	<span id="tip">教练：${role.cName}</span>
</c:if>
<c:if test="${emp==2}">
	<span id="tip">前台人员：${role.fName}</span>
</c:if>

