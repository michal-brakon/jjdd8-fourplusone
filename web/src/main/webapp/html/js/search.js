$("#sb-search").keyup(function(){
    if ($(this).val().lenght>=3){
        $.ajax({
            type: "POST",
            url: "../search",
            data:'keyword='+$(this).val(),
        success: function(data){
            $("#suggesstion-box2").show();
            $("#suggesstion-box2").html(data);
            $("#sb-search").css("background","#FFF");
            $("#elementy").multiselect( 'search', query );
        }
    });}})
