<div id="book-form-container" class="container">
    <div class="col-md-8 col-md-offset-2">
        <div class="form-group">
            <form class="border p-5 " method="POST" action="#" enctype="multipart/form-data">

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
                        <input type="text" class="form-control" placeholder='Wybierz plik okładki z dysku...'/>
                        <span class="input-group-btn">
       			 <button class="btn btn-warning btn-reset" type="button">Zresetuj</button>
    		</span>
                    </div>
                </div>
                <button class="btn btn-success my-4 btn-block" type="submit">Dodaj książkę</button>
            </form>
        </div>
    </div>
</div>