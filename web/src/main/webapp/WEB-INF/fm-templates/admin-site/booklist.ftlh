<div class="container-fluid">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Lista wszystkich Książek</h6>
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
                        <th>Autor </th>
                        <th>Tytuł</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <#list bookViews as book>
                        <tr>
                            <td>${book.author!}</td>
                            <td>${book.title!}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
<!-- Page level plugins -->
<script src="/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="/js/demo/datatables-demo.js"></script>