$(window).load(function() {
	getDatosLocal();
	$("#btnEnviarPedido").click(function(){
		enviarPedido();
	});
});

function getDatosLocal(){
	var idLocal = document.location.hash.replace("#","");
	var local = getLocal(idLocal);
	
	$("#rubroLocal").html(local.nombre);
}

function getLocal(idLocal){
	var url = "http://localhost:8080/SLD2014HackMlServices/webresources/clases.local/" + idLocal;
	var local = {};
	$.ajax({
        type: 'GET',
        url: url,
		contentType: "application/json",
		async: false,
        beforeSend: function (data) {
        },
        success: function (data) {
			local = data;
        },
		error: function (data, i) {
			console.log(JSON.stringify(data));
		}
    });
	
	return local;
}

function enviarPedido(){
	
}