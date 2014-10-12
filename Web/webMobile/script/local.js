$(window).load(function() {
	getDatosLocal();
	$("#btnPresupuesto").click(function(){
		window.location = "pedido.html" + document.location.hash;
	});
});

function getDatosLocal(){
	var idLocal = document.location.hash.replace("#","");
	var local = getLocal(idLocal);
	
	$("#nombreLocal").html(local.nombre);
	$("#descripcionLocal").html(local.descripcion);
	$("#rubroLocal").html(local.rubro.nombre);
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