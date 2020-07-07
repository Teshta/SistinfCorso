<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="head.jsp"></jsp:include>
</head>
<body style="background-color: #F4F1DE;">
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container container-fluid">
		<jsp:include page="messaggi.jsp"></jsp:include>
		<h1>Registrati</h1>
		<form
			action="${pageContext.servletContext.contextPath}/registra2.do"
			method="post" id="regForm">
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text"
					class="form-control" placeholder="Inserisci nome" id="nome"
					name="nome" value="${INSERENDO.nome}">
			</div>
			<div class="form-group">
				<label for="cognome">Cognome:</label> <input type="text"
					class="form-control" placeholder="Inserisci cognome" id="cognome"
					name="cognome" value="${INSERENDO.cognome}">
			</div>
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" placeholder="Inserisci username" id="username"
					name="username" value="${INSERENDO.username}">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" placeholder="Inserisci email"
					id="email" name="email" value="${INSERENDO.email}">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input
					type="password" class="form-control"
					placeholder="Inserisci password" id="password"
					name="password" value="${INSERENDO.password}">
			</div>
			<div class="form-group">
				<label for="dataDiNascita">Data di Nascita:</label> <input
					type="date" class="form-control"
					placeholder="Inserisci data di nascita" id="dataDiNascita"
					name="dataDiNascita" value="${INSERENDO.dataDiNascita}">
			</div>
			<!--  <button type="submit" class="btn btn-primary">Submit</button> bottone senza JS -->
			<button type="button" class="btn btn-primary" onclick="valida()">Registrati</button> <!-- bottone con JS -->
		</form>
	</div>
</body>
</html>
