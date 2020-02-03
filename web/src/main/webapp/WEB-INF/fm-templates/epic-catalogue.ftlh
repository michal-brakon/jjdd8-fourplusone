<#setting number_format="#####.#####">

<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="utf-8">
    <title>Four+One Library</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content="Bootstrap 3 template for corporate business"/>
    <link href="../../html/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../../html/plugins/flexslider/flexslider.css" rel="stylesheet" media="screen"/>
    <link href="../../html/css/cubeportfolio.min.css" rel="stylesheet"/>
    <link href="../../html/css/style.css" rel="stylesheet"/>
    <link id="t-colors" href="../../html/skins/default.css" rel="stylesheet"/>
    <link id="bodybg" href="../../html/bodybg/bg1.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


</head>
<body>
<div id="wrapper">
   <#include "header-nav.ftlh">
    <div class="container">
        <div class="col-sm-12 col-lg-12 row">
            <nav aria-label="Pagination">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="/epicCatalogue?bookNum=0">Pierwsza strona</a></li>
                    <#if (previous > -1)>
                        <li class="page-item"><a class="page-link" href="/epicCatalogue?bookNum=${previous}"><<</a>
                        </li>

                    <#else>
                        <li style="display: none " class="page-item"><a class="page-link"
                                                                        href="/epicCatalogue?bookNum=${previous}"><<</a>
                        </li>
                    </#if>

                    <#if (next < 1580)>
                        <li class="page-item"><a class="page-link" href="/epicCatalogue?bookNum=${next}">>></a></li>

                    <#else>
                        <li style="display: none " class="page-item"><a class="page-link"
                                                                        href="/epicCatalogue?bookNum=${next}">>></a>
                        </li>
                    </#if>
                    <li class="page-item"><a class="page-link" href="/epicCatalogue?bookNum=${lastPageView}">Ostatnia
                            strona</a></li>
                </ul>
            </nav>
        </div>
    </div>

    <section>
        <div class="container">
            <#list catalogue>
                <#items as cat>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th></th>
                            <td class="col-lg-2"><a href="/single?id=${cat.id}"><img
                                            src="${cat.coverThumb!}"
                                            alt="Okładka" height="193" width="139"></a></td>
                            <td class="col-lg-10">
                                <div class="text-center">
                                    <h3 class="text-danger"><a href="/single?id=${cat.id}">${cat.title} </a></h3>
                                    <h3>Autor: ${cat.author} </h3>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </#items>
            </#list>
        </div>
    </section>
</div>
</div>

<div class="container">
    <div class="col-sm-12 col-lg-12 row">
        <nav aria-label="Pagination">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/epicCatalogue?bookNum=0">Pierwsza strona</a></li>
                <#if (previous > -1)>
                    <li class="page-item"><a class="page-link" href="/epicCatalogue?bookNum=${previous}""><<</a>
                    </li>

                <#else>
                    <li style="display: none " class="page-item"><a class="page-link"
                                                                    href="/epicCatalogue?bookNum=${previous}"><<</a>
                    </li>
                </#if>

                <#if (next < 1580)>
                    <li class="page-item"><a class="page-link" href="/epicCatalogue?bookNum=${next}">>></a></li>

                <#else>
                    <li style="display: none " class="page-item"><a class="page-link" href="/epicCatalogue?bookNum=${next}">>></a>
                    </li>
                </#if>
                <li class="page-item"><a class="page-link" href="/epicCatalogue?bookNum=${lastPageView}">Ostatnia strona</a>
                </li>
            </ul>
        </nav>
    </div>
</div>

<footer>
    <div class="container">
        <div class="col-sm-12 col-lg-12 row">
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
    <div id="sub-footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <p>&copy; Sailor Theme - All Right Reserved</p>
                    <div class="credits">
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>


<script src="../../html/js/modernizr.custom.js"></script>
<script src="../../html/js/jquery.easing.1.3.js"></script>
<script src="../../html/plugins/flexslider/jquery.flexslider-min.js"></script>
<script src="../../html/plugins/flexslider/flexslider.config.js"></script>
<script src="../../html/js/jquery.appear.js"></script>
<script src="../../html/js/stellar.js"></script>
<script src="../../html/js/classie.js"></script>
<script src="../../html/js/uisearch.js"></script>
<script src="../../html/js/jquery.cubeportfolio.min.js"></script>
<script src="../../html/js/google-code-prettify/prettify.js"></script>
<script src="../../html/js/animate.js"></script>
<script src="../../html/js/custom.js"></script>
<script src="../../html/js/pagination.js"></script>
</body>

</html>
