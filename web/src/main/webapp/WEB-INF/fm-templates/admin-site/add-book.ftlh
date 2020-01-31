<script>
    $(function () {

        $(document).ready(function () {

            $.ajax({
                url: '/api/admin/kind',
                type: 'GET',
                success: function (result) {

                    for (var i = 0; i < result.length; i++) {
                        $("#kind").append(
                            "<option value='" + result[i].name + "'>" + result[i].name + "</option>");
                    }

                    console.log(result);
                }
            });
        })
    })
</script>
<div class="container">
    <div class="formadd">
        <form class="border p-5 " method="post" action="/admin/add-book" enctype="multipart/form-data">

            <p class="h3 mb-4 text-center">Dodaj nową książkę</p>
            <hr>

            <label for="textInput">Tytuł</label>
            <input type="text" id="textInput" class="form-control mb-4" placeholder="Podaj tytuł"
                   name="title" required>

            <label for="textInput">Autor</label>
            <input type="text" id="textInput" class="form-control mb-4" placeholder="Podaj autora"
                   name="author" required>

            <label for="textInput">Rodzaj</label>
            <select class="browser-default custom-select mb-4" id="select" name="kind" required>

            </select>
            <label for="textInput">Epoka</label>
            <select class="browser-default custom-select mb-4" id="select" name="epoch" required>
                <option value="" disabled="" selected="">Wybierz rodzaj literacki</option>
                <option value="jakas">jakas</option>
                <option value="ptakas">srakas</option>
                <option value="sgfsdf">asdas</option>
            </select>

            <label for="textInput">Gatunek</label>
            <input type="text" id="textInput" class="form-control mb-4"
                   placeholder="Podaj gatunek literacki" name="genre" required>

            <label for="textInput">Audiobook</label>
            <select class="browser-default custom-select mb-4" id="select" name="audio" required>
                <option value="" disabled="" selected="">Czy wersja audio jest dostępna?</option>
                <option value="tak">Tak</option>
                <option value="nie">Nie</option>
            </select>
            <input type="file" name="file" placeholder='Wybierz plik okładki z dysku...'/>

            <button class="btn btn-warning btn-reset" type="button">Zresetuj</button>


            <button class="btn btn-success my-4 btn-block" type="submit">Dodaj książkę</button>
        </form>
    </div>
</div>