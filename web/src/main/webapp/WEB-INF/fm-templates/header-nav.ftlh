<header>
    <div class="top">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <ul class="top-right-info">


                        <label for="exampleInputHolidayName">Quick live search:</label>
                        <div class="form-group">
                            <input type="text" title="Please insert min 3 char." name="holiday-quick" class="form-control form-control-user" pattern=".{3,}"
                                   id="holiday-quick" placeholder="Please enter a minimum of 3 letters..." autocomplete="off">
                            <div id="result-div" class="list-group" style="margin-top:2px;position:absolute;margin-left:0;z-index: 1001 !important; ">
                            </div>
                        </div>
                    </ul></div></div>
        </div>
    </div>

</header><header>
    <div class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/"><img src="../../html/img/logo.png" alt="" width="199" height="52"/></a>
            </div>
            <div class="navbar-collapse collapse ">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Strona główna</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown"
                           data-delay="0" data-close-others="false">Biblioteka <i class="fa fa-angle-down"></i></a>
                        <ul class="dropdown-menu">
                              <li class="dropdown-submenu">
                                <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown">Katalog</a>
                                <ul class="dropdown-menu">
                                    <li><a href="/catalogue?bookNum=0">Książki</a></li>
                                    <li><a href="/soon">AudioBooki</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><a href="/soon">Zaloguj/Rejestracja</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>