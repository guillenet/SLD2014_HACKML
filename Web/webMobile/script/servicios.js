$(window).load(function() {
	cargarServicios();
});


function cargarServicios(){
	var list = getServicios();
	var listString = "";
	$.each(list, function (index, item) {
		listString += "<li id='itemLista" + item.idLocal + "' class='itemLista'>";
		listString += "<label>" + item.nombre + "</label>";
		listString += "</li>";
	});
	
	$("#listComercios").html(listString);
	$(".itemLista").click(function(){
		var idItem = $(this)[0].id.replace("itemLista","");
		window.location = "local.html#" + idItem;
	});
}


function getServicios(){
	var url = "http://localhost:8080/SLD2014HackMlServices/webresources/clases.local";
	var listServicios = [];
	$.ajax({
        type: 'GET',
        url: url,
		contentType: "application/json",
		async: false,
        beforeSend: function (data) {
        },
        success: function (data) {
			$.each(data, function (index, item) {
				if(item.esServicio){
					listServicios.push(item);
				}
			});
        },
		error: function (data, i) {
			console.log(JSON.stringify(data));
		}
    });
	
	return listServicios;
}