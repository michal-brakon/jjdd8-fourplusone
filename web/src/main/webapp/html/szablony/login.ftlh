<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="utf-8">
    <title>Four+One Library</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content="Bootstrap 3 template for corporate business"/>
    <!-- css -->
    <link href="../css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../css/cubeportfolio.min.css" rel="stylesheet"/>
    <link href="../css/style.css" rel="stylesheet"/>


    <!-- Theme skin -->
    <link id="t-colors" href="../skins/default.css" rel="stylesheet"/>

    <!-- boxed bg -->
    <link id="bodybg" href="../bodybg/bg1.css" rel="stylesheet" type="text/css"/>


</head>

<body>


<div id="wrapper">
    <!-- start header -->
    <header>
        <div class="top">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <ul class="topleft-info">
                        </ul>
                    </div>
                    <div class="col-md-6">
                        <div id="sb-search" class="sb-search">
                            <form>
                                <input class="sb-search-input" placeholder="Czego szukasz?" type="text" value=""
                                       name="search" id="search">
                                <input class="sb-search-submit" type="submit" value="">
                                <span class="sb-icon-search" title="Click to start searching"></span>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="../../WEB-INF/fm-templates/index.ftlh"><img src="../img/logo.png" alt="" width="199"
                                                                                              height="52"/></a>
                </div>
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="../../WEB-INF/fm-templates/index.ftlh">Strona główna</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown"
                               data-delay="0" data-close-others="false">Biblioteka <i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="../../WEB-INF/fm-templates/comingsoon.ftlh">Wyszukaj</a></li>
                                <li class="dropdown-submenu">
                                    <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown">Katalog</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="../../WEB-INF/fm-templates/comingsoon.ftlh">Książki</a></li>
                                        <li><a href="../../WEB-INF/fm-templates/comingsoon.ftlh">AudioBooki</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="login.ftlh">Zaloguj/Rejestracja</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </header>
    <!-- end header -->
    <section id="inner-headline">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <ul class="breadcrumb">
                        <li><a href="../../WEB-INF/fm-templates/index.ftlh"><i class="fa fa-home"></i></a><i class="icon-angle-right"></i></li>
                        <li class="active">Login</li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <section id="content">
        <div class="container">

            <div class="row">
                <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                    <form role="form" class="register-form">
                        <h2>Zaloguj się <small>do swojego konta</small></h2>
                        <hr class="colorgraph">

                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-lg"
                                   placeholder="Adres email" tabindex="4">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control input-lg" id="exampleInputPassword1"
                                   placeholder="Hasło">
                        </div>

                        <div class="row">
                            <div class="col-xs-4 col-sm-3 col-md-3">
									<span class="button-checkbox">
						<button type="button" class="btn" data-color="info" tabindex="7">Zapamiętaj</button>
                        <input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1">
					</span>
                            </div>
                        </div>

                        <hr class="colorgraph">
                        <div class="row">
                            <div class="col-xs-12 col-md-6"><input type="submit" value="Zaloguj"
                                                                   class="btn btn-primary btn-block btn-lg"
                                                                   tabindex="7"></div>
                            <div class="col-xs-12 col-md-6">Nie masz konta? <a href="register.ftlh">Zarejestruj</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </section>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-lg-12">
                    <div class="widget">
                        <h4>Kontakt</h4>
                        <address>
                            <strong>Four+One Library</strong><br>Olivia Busines Centre<br>Gdańsk
                        </address>
                        <p>
                            <i class="icon-phone"></i> (0048) 123-456-789 <br>
                            <i class="icon-envelope-alt"></i> fourplusone@library.com
                        </p>
                    </div>
                </div>


            </div>
        </div>
        <div id="sub-footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="copyright">
                            <p>&copy; Sailor Theme - All Right Reserved</p>
                            <div class="credits">
                                <!--
                All the links in the footer should remain intact.
                You can delete the links only if you purchased the pro version.
                Licensing information: https://bootstrapmade.com/license/
                Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Sailor
              -->
                                Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>

</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<!-- javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../js/jquery.min.js"></script>
<script src="../js/modernizr.custom.js"></script>
<script src="../js/jquery.easing.1.3.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.appear.js"></script>
<script src="../js/stellar.js"></script>
<script src="../js/classie.js"></script>
<script src="../js/uisearch.js"></script>
<script src="../js/jquery.cubeportfolio.min.js"></script>
<script src="../js/google-code-prettify/prettify.js"></script>
<script src="../js/animate.js"></script>
<script src="../js/jquery.countdown.min.js"></script>
<script src="../js/custom.js"></script>


</body>

</html>
