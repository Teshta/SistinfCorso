<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="profilo.jsp">Profilo Utente</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.servletContext.contextPath}/index.jsp">Home</a></li>
      <li><a href="#">Notifiche</a></li>
      <li><a href="#">Richieste di amicizia</a></li>
    </ul>
    <!-- <form class="navbar-form navbar-left" action="/${pageContext.servletContext.contextPath}/search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
     
     <form class="form-inline" action="/action_page.php">  -->
  <form class="navbar-form navbar-left" action="${pageContext.servletContext.contextPath}/search" method="post">
  	<input type="nome" class="form-control" placeholder="Nome" id="nome" name="nome"/>
    <input type="cognome" class="form-control" placeholder="Cognome" id="cognome" name="cognome" />
  	<button type="submit" class="btn btn-primary">Cerca</button>
  </form>
      
      <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
    </form>
  </div>
</nav>
<jsp:include page="messaggi.jsp"></jsp:include>
<div class="container">
</div>