jQuery(document).ready(function($) {
	"use strict";
	function log(message) {
		$("<div>").text(message).prependTo("#log");
		$("#log").scrollTop(0);
	}
	$("#sb-search").keyup({
		source: function (request, response) {
			$.ajax({
				type: "GET",
				url: "/api/search/"+request.term,
				done: function (data) {
					if(data.length===0){
						response( log("brak resultatów"))
					}   else {

						response(data.map(b => b.title))
						;}
				}
			});
		},
		minLength: 3,
		select: function (event, ui) {
			log("Selected: " + ui.item.value + " aka " + ui.item.label);
		}
	});
});