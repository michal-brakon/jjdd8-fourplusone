

<div id="editModal">
    <div class="dialog">
        <div class="content">

            <#if Error??>
                    <h3>Nie można znaleźć książki</h3>
                <#else>
                    <form method="POST" action="/admin/edit">
                        <input type="hidden" name="id" value="${book.id}" readonly >
                        Tytuł: <input type="text" class="form-control mb-4" name="title" required="required"
                                      value="${book.title !""}"/><br/>
                        Autor: <input type="text" class="form-control mb-4" name="author" required="required"
                                      value="${book.author !""}"/><br/>
                        Rodzaj: <input type="text" class="form-control mb-4" name="kind" required="required"
                                       value="${book.kind !""}"/><br/>
                        Typ : <input type="text" class="form-control mb-4" name="genre" required="required"
                                     value="${book.genre !""}"/><br/>
                        Epoka : <input type="text" class="form-control mb-4" name="epoch" required="required"
                                       value="${book.epoch !""}"/><br/>
                        Audiobook : <input type="text" class="form-control mb-4" name="audio" required="required"
                                           value=${book.audio?then('Dostępna','Brak') !""}/><br/>
                       <input type="submit" > <br/><br/>
                    </form>
            </#if>
           </div>
       </div>
    </div>
</div>