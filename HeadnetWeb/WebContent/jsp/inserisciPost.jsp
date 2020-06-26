<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="head.jsp"></jsp:include>
</head>
<body style="background-color:#F4F1DE;">
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container container-fluid">
		<jsp:include page="messaggi.jsp"></jsp:include>
		<h1>Inserisci nuovo post</h1>
		<form
			action="${pageContext.servletContext.contextPath}/insert"
			method="post" id="postForm">
			<div class="form-group">
				<label for="contenuto">Contenuto:</label> <input type="text"
					class="form-control" placeholder="Inserisci contenuto" id="contenuto"
					name="contenuto" required>
			</div>
			<button type="submit" class="btn btn-primary">Condividi</button>
			<!-- <button type="button" class="btn btn-primary" onclick="valida()">Entra</button> -->
		</form>
	</div>
</body>
</html>
