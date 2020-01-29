

<div id="editModal">
    <div class="dialog">
        <div class="content">

                   <#if Error??>
                    <h3>Nie można znaleźć książki</h3>
                <#else>
                    <form method="PUT" action="/">
                       Tytuł: <input type="text" name="title" required="required" value="${book.title !""}"/><br/>
                        Autor: <input type="text" name="author" required="required" value="${book.author !""}"/><br/>
                        Rodzaj: <input type="text" name="kind" required="required" value="${book.kind !""}"/><br/>
                        Typ : <input type="text" name="genre" required="required" value="${book.genre !""}"/><br/>
                        Cover : <input type="text" name="cover" required="required" value="${book.cover !""}"/><br/>
                       Audiobook : <input type="text" name="hasAudio" required="required" value="${book.audio !""}"/><br/>
                        <input type="button" name="reset" value="Reset">
                        <input type="button" value="" onclick="editUser()"/><br/><br/>
                    </form>
                </#if>
           </div>
       </div>
    </div>
</div>
