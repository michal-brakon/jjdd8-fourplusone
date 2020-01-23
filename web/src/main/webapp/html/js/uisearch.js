$(function() {
	$("#result-div").hide();
});
function getModal(id){
	$.ajax({
		type: "GET",
		url: "/api/search/" + id,
		enctype: 'application/json; charset=UTF-8',
		dataType: 'json',
		//data: $('#holiday-name').val(),
		contentType: 'application/json; charset=UTF-8'
	})
		.done(
			function (resp) {
				$('#modal-info-body').html("Holiday name: "+resp.name +" on day "+ resp.date +"<br />"+resp.description);
				$('#infoModal').modal('show');
			})
		.fail(
			function () {
				$('#modal-info-body').html("Ups... Operation failed!!!");
				$('#infoModal').modal('show');
			});
}
$('#holiday-quick').keyup(function (e) {
	e.preventDefault(); // Prevent the form from submitting via the browser
	$("#result-div").html("");
	if($('#holiday-quick').val().length >=3) {
		$.ajax({
			type: "GET",
			url: "/api/search/" + $('#holiday-quick').val(),
			enctype: 'application/json; charset=UTF-8',
			dataType: 'json',
			contentType: 'application/json; charset=UTF-8'
		})
			.
			done(
				function (data) {
					$("#result-div").show();
					if (data.length==0){
						$("#result-div").append('<a href="#" class="list-group-item list-group-item-action list-group-item-warning">No results found!</a>');
						return;
					}
					$("#modalh1id").text("Quick Holiday info");
					$.each(data, function (i, item) {
						$("#result-div").append('<a href="#" onclick="getModal('+item.id+')" class="list-group-item list-group-item-action list-group-item-primary">'+item.title+'</a>');
					});
				})
			.fail(
				function () {
					$("#result-div").show();
					$("#result-div").html("Fatal error!");
				});
	}
});