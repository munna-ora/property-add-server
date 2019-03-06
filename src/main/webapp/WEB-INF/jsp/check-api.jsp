<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check API</title>
<style type="text/css">
input[type=text], textarea {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	align: center;
}
</style>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
</head>
<!-- jQuery -->
<script src="<%=basePath%>resources/js/jquery.min.js"></script>
<body>
	<div>
		<form action="#" method="post" id="formSubmit">

			<label for="To">Link</label> <input type="text" name="link"
				required="required" id="link"> <label for="To">SALT</label>
			<input type="text" name="salt" required="required"
				value="[B@6a9764f4"> <label for="To">ENC Data</label> <input
				type="text" name="encData" required="required"> <input
				type="submit" value="Check API" id="submit">

		</form>
		<br> <br> <br>
		<div align="center">${result}</div>
	</div>
</body>
<script type="text/javascript">

$(document).ready(function(){
 $("#submit").click(function(){
    	$("#formSubmit").attr("action","api/"+$("#link").val());
    });
});
</script>
</html>
