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

function valida() {
	
	
	if ($('#nome').val() == '') {
		alert("devi inserire il nome");
	} else if ($('#cognome').val() == '') {
		alert("devi inserire il cognome");
	} else if ($('#username').val() == '') {
		alert("devi inserire la username");
	} else if ($('#mail').val() == '') {
		alert("devi inserire la mail");
	} else if ($('#password').val() == '') {
		alert("devi inserire la password");
	} else if ($('#dataDiNascita').val() == '') {
		alert("devi inserire la data di nascita");
	}else {
		$('#regForm').submit();
	}

}
