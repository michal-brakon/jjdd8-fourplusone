$("#fld_pozkoszt").keyup(function(){
    if ($(this).val().lenght>=3){
        $.ajax({
            type: "POST",
            url: "../manager/readPozkoszt.php",
            data:'keyword='+$(this).val(),
        beforeSend: function(){
            $("#fld_pozkoszt").css("background","#FFF url(LoaderIcon.gif) no-repeat 165px");
            $("#elementy").multiselect({
                remoteUrl: "wn-ajax.php"
            });
        },
        success: function(data){
            $("#suggesstion-box2").show();
            $("#suggesstion-box2").html(data);
            $("#fld_pozkoszt").css("background","#FFF");
            $("#elementy").multiselect( 'search', query );
        }
    });}})
