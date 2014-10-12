$(window).load(function() {
	$( '#contextMenu' ).simpleSidebar({
		settings: {
			opener: '.btnContextMenu',
			wrapper: '#contentPage',
		},
		sidebar: {
			align: 'left',
			width: 250,
			closingLinks: 'a',
			style: {
				zIndex: 100
			}
		},
		mask: {
			style: {
				backgroundColor: 'grey',
				opacity: 0.9,
				filter: 'Alpha(opacity=90)'
			}
		}
	});
	
	$(".btnAlert").click(function(){
		$(".btnAlert").unbind("click");
		$('#openAlert').click();
	});
	
	$(".btnVolver").click(function(){
		window.location = "perfil.html";
	});
	
	$(".itemEvento, .itemEventoA").click(function(){
		window.location = "evento.html";
	});
	
	$(".btnContextMenu").click(function(){
		$('#openMenu').click();
	});
	
	var urlPage =  window.location.pathname;
	var page = urlPage.substring(urlPage.lastIndexOf('/') + 1);
	
	$(".contentPage").swipe({
		swipeLeft:function(event, direction, distance, duration, fingerCount) {
			//$(".btnAlert").click();
        },
		swipeRight:function(event, direction, distance, duration, fingerCount) {
			//$('#openMenu').click();
        },
        threshold:0
	});
});