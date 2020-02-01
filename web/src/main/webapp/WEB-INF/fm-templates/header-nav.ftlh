<header>
    <div class="top">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <ul class="top-right-info">


                        <label for="exampleInputHolidayName">Wyszukiwanie :</label>
                        <div class="form-group">
                            <input type="text" title="Wyszukiwanie powyżej 3 znaków." name="bookSearch"
                                   class="form-control form-control-user" pattern=".{3,}"
                                   id="bookSearch" placeholder="Wyszukiwanie powyżej 3 znaków." autocomplete="off">
                            <div id="result-div" class="list-group"
                                 style="margin-top:2px;position:absolute;margin-left:0;z-index: 1001 !important; ">
                            </div>
                        </div>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</header>
<header>
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
                                <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown">Książki</a>
                                <ul class="dropdown-menu">
                                    <li><a href="/catalogue?bookNum=0">Wszystkie pozycje</a></li>
                                    <li><a href="/lyricCatalogue?bookNum=0">Liryka</a></li>
                                    <li><a href="/epicCatalogue?bookNum=0">Epika</a></li>
                                    <li><a href="/dramaCatalogue?bookNum=0">Dramat</a></li>
                                </ul>
                            </li>
                            <li><a href="/audioCatalogue?bookNum=0">AudioBooki</a></li>
                        </ul>
                    </li>

                    <li>
                        <#if logged == "yes" >
                        <a href="/logout">Wyloguj się </a>
                        <#else>
                        <a href="https://accounts.google.com/o/oauth2/auth?client_id=273754675187-9rlbmfmo4b4u15h887kkaj9nljgpuajv.apps.googleusercontent.com&redirect_uri=http://localhost:8080/oauth2callback&response_type=code&scope=https://www.googleapis.com/auth/userinfo.profile%20https://www.googleapis.com/auth/userinfo.email&state=google;-2106811103">Zaloguj</a>
                        </#if>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>