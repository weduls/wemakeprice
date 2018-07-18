<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<title>500 Error Page</title>
</head>
<body id="errorContent">
	<div id="errorCodeBox">
		<span id="errorCode">500</span> 
	</div>
	<div id="errorDetailBox">
		<span>Internal Server Error.</span>
	</div>
	<br>
	<span id="errorRefreshMsg"></span>
</body>
</html>