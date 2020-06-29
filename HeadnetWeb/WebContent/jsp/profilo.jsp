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
<script type="text/javascript">
	$(document).ready(function() {
		$('#myTable').DataTable();
	});
</script>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50"
	style="background-color: #F4F1DE;">
	<jsp:include page="menu.jsp"></jsp:include>
	<jsp:include page="messaggi.jsp"></jsp:include>
	<table class="table table-blue table-striped" id="myTable">
		<thead>
			<tr>
				<th><h1>Lista Post ${USER.username}</h1></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${posts}" var="post">
				<tr>
					<td>
						<div class="container-fluid">
							<h1>${post.user.username}</h1> 
							<p>${post.contenuto}</p>
							<p>Pubblicato il: ${post.dataPubblicazione}</p>
							<a class="btn btn-primary btn-sm"
									href="${pageContext.servletContext.contextPath}/like?idPost=${post.id}&proprietario=${post.user.id}">
									<i class="fa fa-glass  pull-left"></i> Like
								</a> <a class="btn btn-default btn-sm"> <i class="fa fa-heart"></i>
									Numero di like:${post.like}
								</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>