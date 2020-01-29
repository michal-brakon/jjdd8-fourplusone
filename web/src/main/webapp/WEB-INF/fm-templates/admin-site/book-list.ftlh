<script src="/../../../html/js/datatables/jquery.dataTables.min.js"></script>
<script src="/../../../html/js/datatables/dataTables.bootstrap4.min.js"></script>
<script src="/../../../html/js/demo/datatables-demo.js"></script>
<script>
    function deletebook(id) {
        $.ajax({
            url: '/api/admin/delete/' + id,
            type: 'DELETE',
            data: id
        })
            .done(
                function (data) {
                   $('.modal-body').html( "Książka została usunięta");
                            $('#myModel').show();
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
                        <th>edytuj</th>
                        <th>usuń</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Autor</th>
                        <th>Tytuł</th>
                        <th>edytuj</th>
                        <th>usuń</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <#list books as book>
                        <tr>
                            <td>${book.author!}</td>
                            <td>${book.title!}</td>
                            <td><a href="/admin/edit?id=${book.id}" class="btn btn-warning btn-circle btn-sm">
                                </a></td>
                            <td>
                                <button href="#" class="btn btn-danger btn-circle btn-sm"
                                        onclick="deletebook(${book.id!})" data-toggle="modal" data-target="#myModal">
                                    </button>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
<!-- The Modal -->
