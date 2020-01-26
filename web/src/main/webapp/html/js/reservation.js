$(".reserve").click(function(){
    $.ajax({
        type : 'GET',
        url : '/api/reserve/' + $(this).attr('data-id'),
            success: function(result)
            {
                location.reload();
        }});   });