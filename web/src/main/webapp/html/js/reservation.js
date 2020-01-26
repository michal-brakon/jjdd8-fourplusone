$(".reserve").click(function(){
    $.ajax({
        type : 'GET',
        url : '/api/reserve/' + $(this).attr('data-id'),
            success: function(result)
            {
                alert("Dokonałeś rezerwacji! Potwierdź linkiem wysłanym na email");
        }});   });