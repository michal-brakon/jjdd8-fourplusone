



$(document).ready(function () {
    $("#input").keypress(function () {
    if ($(this).val().length >= 3) {
        $.ajax({
            url: '/api/search'+$(this).val(),
            type: 'GET',
            success: function (result) {

                for (var i = 0; i < result.length; i++) {
                    $("#out").append(
                        "<div value='" + result[i].id + "'>" + result[i].title + "</div>");
                }

                console.log(result);

            }
        });
    }})
});
