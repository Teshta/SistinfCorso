<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Grey with black text -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav">
		<li class="nav-item active"><a class="nav-link"
			href="${pageContext.servletContext.contextPath}/index.jsp">Home</a></li>
		<li class="nav-item"><a class="nav-link"
			href="${pageContext.servletContext.contextPath}/jsp/cerca.jsp">Profilo</a></li>
		<li><li class="nav-item"><c:if test="${empty USER.nome}"><a class="nav-link" href="${pageContext.servletContext.contextPath}/jsp/login.jsp">Login</a></c:if></li>
		<li class="nav-item"><c:if test="${USER.nome}"><a class="nav-link" href="${pageContext.servletContext.contextPath}/logout">Log Out</a></c:if></li>
	</ul>
</nav>