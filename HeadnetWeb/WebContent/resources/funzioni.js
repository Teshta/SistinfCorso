//validazione JS
function valida() {

	if ($('#email').val() == '') {
		alert("devi inserire l'email");
	} else if ($('#password').val() == '') {
		alert("devi inserire la password");
	} else {
		$('#miaForm').submit();
	}

}
