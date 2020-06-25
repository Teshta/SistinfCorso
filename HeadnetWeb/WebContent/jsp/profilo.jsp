<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="/jsp/style.jsp"></jsp:include>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="messaggi.jsp"></jsp:include>
<div class="container-fluid"
		style="background-color: #F44336; color: #fff; height: 100px;">
		<h1>
			Lista Post
			</h1>
	</div>
<c:forEach items="${posts}" var="post">
	<div id="section1" class="container-fluid">
		<h1>${post.user.username}</h1>
		<p>${post.contenuto }</p>
		<p>Pubblicato il: ${post.dataPubblicazione}</p>
		<p>${post.like}</p>
		<a href="${pageContext.servletContext.contextPath}/like?idPost=${post.id}&proprietario=${post.user.id}" ><i class="fa fa-glass" aria-hidden="true"></i></a>
	</div>
</c:forEach>
</body>
</html>