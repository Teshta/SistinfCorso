<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand"
				href="${pageContext.servletContext.contextPath}/homepost">Home</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><c:if test="${!empty USER.username}"><a href="${pageContext.servletContext.contextPath}/mine">Profilo ${USER.username} </a></c:if></li>
			<li><c:if test="${!empty USER.username}"><a href="${pageContext.servletContext.contextPath}/jsp/inserisciPost.jsp">Inserisci Post</a></c:if></li>
			<li><c:if test="${!empty USER.username}"><a href="${pageContext.servletContext.contextPath}/friends">Amici</a></c:if></li>
			<li class="dropdown"><c:if test="${!empty USER.username}"><a class="dropdown-toggle" data-toggle="dropdown" href="${pageContext.servletContext.contextPath}/jsp/richiesteAmicizia.jsp">Richieste di amicizia</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.servletContext.contextPath}/out">Inviate</a></li>
						<li><a href="${pageContext.servletContext.contextPath}/in">Ricevute</a></li>
					</ul>
				</c:if></li>
		</ul>
		<!-- <form class="navbar-form navbar-left" action="/${pageContext.servletContext.contextPath}/search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
     
     <form class="form-inline" action="/action_page.php">  -->
		<c:if test="${!empty USER.username}">
			<form class="navbar-form navbar-left"
				action="${pageContext.servletContext.contextPath}/search"
				method="post">
				<input type="text" class="form-control" placeholder="Nome" id="nome"
					name="nome" /> <input type="text" class="form-control"
					placeholder="Cognome" id="cognome" name="cognome" />
				<button type="submit" class="btn btn-primary">Cerca</button>
			</form>
		</c:if>

		<ul class="nav navbar-nav navbar-right">
			<li><c:if test="${empty USER.username}">
					<a
						href="${pageContext.servletContext.contextPath}/jsp/registra.jsp"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a>
				</c:if></li>
			<li><c:if test="${empty USER.username}">
					<a href="${pageContext.servletContext.contextPath}/jsp/login.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Login</a>
				</c:if></li>
			<li><c:if test="${!empty USER.username}">
					<a href="${pageContext.servletContext.contextPath}/logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a>
				</c:if></li>
		</ul>
		</form>
	</div>
</nav>