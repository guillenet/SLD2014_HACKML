$(window).load(function() {
	cargarComercios();
});


function cargarComercios(){
	var list = getComercios();
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


function getComercios(){
	var url = "http://localhost:8080/SLD2014HackMlServices/webresources/clases.local";
	var listComercios = [];
	$.ajax({
        type: 'GET',
        url: url,
		contentType: "application/json",
		async: false,
        beforeSend: function (data) {
        },
        success: function (data) {
			$.each(data, function (index, item) {
				if(!item.esServicio){
					listComercios.push(item);
				}
			});
        },
		error: function (data, i) {
			console.log(JSON.stringify(data));
		}
    });
	
	return listComercios;
}