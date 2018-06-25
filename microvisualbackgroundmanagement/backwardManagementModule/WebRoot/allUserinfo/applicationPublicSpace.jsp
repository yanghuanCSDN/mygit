<%@page language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.yanghuan.model.User"%>
<!--功能1：显示所有用户
	功能2：根据检索查出数据，进行修改  -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${pageContext.request.contextPath}/">
    <title>申请公众空间</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script src="${pageContext.request.contextPath}/WdatePicker.js"></script>
	<script type="text/javascript">
   		function updateByTime(){
    		var form=document.getElementById('form');
			form.action="servlet/AllUserinfoServlet?act=6";
			form.submit();
		}
    	function updateByQQNumber(){
	    	var form=document.getElementById('form');
			form.action="servlet/AllUserinfoServlet?act=5";
			form.submit();
		}
    	function dredge(id){
    		location.href="${pageContext.request.contextPath}/servlet/AllUserinfoServlet?act=7&personId="+id;
		}
    	function refuse(id){
	    	location.href="${pageContext.request.contextPath}/servlet/AllUserinfoServlet?act=8&personId="+id;
		}
    </script>
  </head>
  <body>
	 <form id="form"  method="post">
	  	<h1>
	  		<input type="text" value="检索："  style="  height:45px;font-weight:50;width:60px;text-align:center;font-size:25px;border:none; background-color:#66CCFF;"/></font>
	   		<input onchange="updateByTime()" id="time" name="time" readonly type="text" size="20">
	   		<img onclick="WdatePicker({el:'time'})" src="skin/datePicker.gif" 
	   			width="24" height="30" align="absmiddle" >
	   		<input size="20" name="QQNumber" type="text">
		 	<input onclick="updateByQQNumber()"	type="submit" value="QQ号码">
		</h1>
	</form>
		<h2>${msg}</h2>
	    <table bgcolor="#FFFF00"  cellpadding="3px" cellspacing="3px"	border="1" width="100%">
			<tr>
				<th>用户Id</th>
				<th>QQ号码</th>
				<th>真实姓名</th>
				<th>身份证号码</th>
				<th>手机号码</th>
				<th>申请列表</th>
				<th>个性签名</th>
				<th>提交时间</th>
				<th>是否已开通公众空间</th>
				<th>操作</th>
			</tr>
			</tr>
			<c:forEach var="userinfo" items="${userinfos}">
				<tr>
					<td>${userinfo.personId}</td> 
					<td>${userinfo.QQNumber}</td>
					<td>${userinfo.realName}</td>
					<td>${userinfo.idCard}</td>
					<td>${userinfo.cellPhoneNumber}</td>
					<td>${userinfo.judgeOpened==0?"开通":"待开通"}</td>
					<td>${userinfo.personSignature}</td>
					<td>${userinfo.submissionTime}</td>
					<td>${userinfo.judgeOpened==0?"是":"否"}</td>
					<td>
						<c:if test="${userinfo.judgeOpened==0}">
							<span>开通</span>
					    	<input onclick="refuse(${userinfo.personId})"	type="reset" name="reset" value="拒绝">
						</c:if>
						<c:if test="${userinfo.judgeOpened==1}">
					    	<input ${userinfo.judgeOpened==0?"disabled":""}  onclick="dredge(${userinfo.personId})"	type="submit"  name="submit" value="开通">
							<span>拒绝</span>
						</c:if>
	    			</td>
				</tr>
			</c:forEach>
			</table>
  </body>
</html>