<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty MSG_KO }">
	<br>
	<div class="alert alert-danger">
		<strong>Attenzione!</strong> ${MSG_KO}
	</div>
</c:if>
<c:if test="${not empty MSG_CORRECT }">
	<br>
	<div class="alert alert-success">
		<strong>Successo!</strong> ${MSG_CORRECT}
	</div>
</c:if>

<div id="areaMsgJS"></div> <!-- per configurare i msg con JS -->