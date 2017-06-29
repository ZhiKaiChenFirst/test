<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><struts:text name="login.jsp.title" /></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
</style>
</head>
<body>
	<center>
		<div id="" style="width: 400px;height: 200px;">
		<form action="/user/login.action" method="post">
			<input  style=" width: 90%; height: 35px; margin-left: 5%;margin-top: 18px;"     class="text" type="text" id="uid"  name="uid"   placeholder="   账号"  required/>
			<input  style=" width: 90%; height: 35px; margin-left: 5%; margin-top: 12px;" type="password" name="password" id="password" placeholder="   密码"  required>
			<input  style=" width: 90%; height: 45px; margin-left: 5% ; margin-top: 12px; background-color:#920D0D; font-size: 20px; color: white;" type="submit" value="登陆">
		</form>
		</div>
	</center>
</body>
</html>
