
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="/WEB-INF/tld/jsp-decorator.tld" prefix="decorator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/css/shop-homepage.css" rel="stylesheet" type="text/css">
</head>
<body>

<a href="#modal" role="button" class="btn" data-toggle="modal">Click Me</a>
<div id="modal" class="modal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h2>Lorem Ipsum</h2>
	</div>
	<div class="modal-body">
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
		Donec placerat sem ipsum, ut faucibus nulla. Nullam mattis volutpat
		dolor, eu porta magna facilisis ut. In ultricies, purus sed pellentesque
		mollis, nibh tortor semper elit, eget rutrum purus nulla id quam.</p>
	</div>
</div>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

</body>
</html>