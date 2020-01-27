<script>
    function deletebook(id) {
        $.ajax({
            url: '/api/management/delete/' + id,
            type: 'DELETE',
            data: id
        })
            .done(
                function (data) {
                    $('#modal-info-body').html("Book: " + data.title + " " + data.author + " removed!");
                    $('#infoModal').modal('show');
                })
    }
</script>
<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Book list</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Autor</th>
                        <th>Tytuł</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Autor</th>
                        <th>Tytuł</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <#list books as book>
                        <tr>

                            <td>${book.author!}</td>
                            <td>${book.title!}</td>
                            <td>
                                <a href="#" class="btn btn-danger btn-circle btn-sm" onclick="deletebook(${book.id!})">
                                    <i class="fas fa-trash"></i></a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</div>
<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalh1id">Operation Info!</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div id="modal-info-body" class="modal-body"><img src="/img/ajax-loader.gif" alt="loading spinner"/></div>
            <div class="modal-footer">
                <button class="btn btn-secondary" id="modal-button" type="button" data-dismiss="modal">Ok</button>
                <#--                    <a class="btn btn-primary" href="/login.html">Logout</a>-->
            </div>
        </div>
    </div>
</div>