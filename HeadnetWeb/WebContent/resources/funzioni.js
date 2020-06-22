//validazione JS
function valida() {

	if ($('#username').val() == '') {
		alert("devi inserire l'username");
	} else if ($('#password').val() == '') {
		alert("devi inserire la password");
	} else {
		$('#miaForm').submit();
	}

}
