function $jQuery(document) {

}

$jQuery(document).ready(function($) {
    $('#keyword').on('input', function() {
        var searchKeyword = $(this).val();
        if (searchKeyword.length >= 3) {
            $.post('search.php', { keywords: searchKeyword }, function(data) {
                $('ul#content').empty().addClass('active');
                $.each(data, function() {
                    $('ul#content').append('<li><a href="example.php?id=' + this.id + '">' + this.title + '</a></li>');
                });
            }, "json");
        } else {
            $('ul#content').empty().removeClass('active');
        }
    });
})
