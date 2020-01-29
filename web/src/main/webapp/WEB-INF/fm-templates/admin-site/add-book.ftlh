<script>function adder() {
    jQuery.ajax({
        url: '/api/admin/add',
        async: true,
        dataType: 'json',
        type: 'POST',
        data: jQuery("form").serialize(),
    }).done(function () {
// Handle Success
        $('.modal-body').text("Książka została dodana");
        $('#myModal').show();

    }).fail(function (xhr, status, error) {
            // Handle Failure
        $('.modal-body').text("Coś poszło nie tak spróbuj jeszcze raz. ")
    });}</script>
<div class="container">
    <div class="formadd">
        <form class="border p-5 " enctype="multipart/form-data">

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
                <option value="" disabled="" selected="">Wybierz rodzaj literacki</option>
                <option value="Epika">Epika</option>
                <option value="Liryka">Liryka</option>
                <option value="Dramat">Dramat</option>
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

            <div class="form-group">
                <div class="input-group input-file" name="file">
                    <input type="file" class="form-control" placeholder='Wybierz plik okładki z dysku...'/>
                    <span class="input-group-btn">
       			 <button class="btn btn-warning btn-reset" type="button">Zresetuj</button>
    		</span>
                </div>
            </div>
            <button class="btn btn-success my-4 btn-block" type="button" onclick="adder()">Dodaj książkę</button>
        </form>
    </div>
</div>