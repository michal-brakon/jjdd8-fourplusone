
<div id="table-container" class="container">
    <div class="custom-control custom-switch">

    </div>
    <div class="table-responsive-md">
        <table
                class="table table-bordered table-striped shadow-lg p-3 mb-5 bg-white rounded">
            <thead class="thead-dark">
            <tr>
                <th scope="col" class="text-center">#</th>
                <th scope="col" class="text-center">Użytkownik</th>
                <th scope="col" class="text-center">Typ</th>
                <th scope="col" class="text-center">Uprawnienia</th>

            </tr>
            </thead>
            <tbody>
            <#assign i=1>
            <#list users>
                <#items as user>
                    <tr>
                        <th scope="row" class="text-center">${i}</th>
                        <td>${user.username}</td>
                        <td>${user.userType}</td>
                        <td>
                            <div class="btn-group" role="group" aria-label="Basic example">
                                <button type="button" data-id="${user.userId}" class="btn btn-success give">Nadaj uprawnienia Admina</button>
                                <button type="button" data-id="${user.userId}" class="btn btn-danger revoke">Odbierz uprawnienia Admina</button>
                            </div>
                        </td>
                    </tr>
                    <#assign i=i+1>
                </#items>
            </#list>
            </tbody>
        </table>
    </div>
</div>