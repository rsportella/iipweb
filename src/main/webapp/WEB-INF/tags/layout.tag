<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="titulo" fragment="true" %>
<%-- 
    Document   : Layout
    Created on : 17/09/2017, 15:04:41
    Author     : Portella, Rodolfo <rodolfosportella@gmail.com>
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IIP</title>
        <link href="webjars/bootstrap/4.0.0-alpha.6/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="webjars/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="webjars/jquery.tablesorter/2.28.5/dist/css/theme.bootstrap_3.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#">
                <i class="fa fa-hand-spock-o" aria-hidden="true"></i>
                I²P - Inteligence in Production
            </a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </ul>
                <ul class="navbar-nav navbar-toggler-right">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Menu
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <a class="dropdown-item" href="acao_usuario?parametro=logout">Sair</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container-fluid">   
            <div class="row">   
                <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#"><i class="fa fa-home" aria-hidden="true"></i> Dashbord <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"><i class="fa fa-car" aria-hidden="true"></i> Apoio</a>
                            <ul class="nav nav-pills flex-column">
                                <li class="nav-item">
                                    <a class="nav-link" href="tipoendereco.jsp">Tipo endereço</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="tipocontato.jsp">Tipo contato</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="logradouro.jsp">Logradouro</a>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="nav-link" href="#"><i class="fa fa-cogs" aria-hidden="true"></i> Configurações</a>
                            <ul class="nav nav-pills flex-column">
                                <li class="nav-item"><a class="nav-link" href="pais.jsp">Pais/Estado/Cidade</a></li>
                                <li class="nav-item"><a class="nav-link" href="usuario">Usuarios</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
                <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
                    <div id="pageheader">
                        <jsp:invoke fragment="header"/>
                    </div>
                    <div id="body">
                        <jsp:doBody/>
                    </div>
                    <div id="pagefooter">
                        <jsp:invoke fragment="footer"/>
                    </div>
                </main>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
        <script src="webjars/bootstrap/4.0.0-alpha.6/dist/js/bootstrap.min.js"></script>

        <script src="webjars/jquery.tablesorter/2.28.5/dist/js/jquery.tablesorter.min.js"></script>
        <script src="webjars/jquery.tablesorter/2.28.5/dist/js/jquery.tablesorter.widgets.min.js"></script>
        <script src="webjars/jquery.tablesorter/2.28.5/dist/js/extras/jquery.tablesorter.pager.min.js"></script>
        <script>
            $.tablesorter.themes.bootstrap = {
                table: 'table table-bordered table-striped',
                caption: 'caption',
                header: 'bootstrap-header',
                iconSortNone: 'fa fa-sort', // class name added to icon when column is not sorted
                iconSortAsc: 'fa fa-sort-amount-asc', // class name added to icon when column has ascending sort
                iconSortDesc: 'fa fa-sort-amount-desc', // class name added to icon when column has descending sort
            };
            $("table").tablesorter({
                theme: "bootstrap",
                widthFixed: true,
                headerTemplate: '{content} {icon}', // new in v2.7. Needed to add the bootstrap icon!
                widgets: ["uitheme", "filter", "pager"],
                headers: {'.acao': {sorter: false,
                        filter: false}},
                widgetOptions: {
                    filter_hideFilters: false,
                    filter_childRows: false,
                    filter_reset: ".reset",
                    filter_cssFilter: "form-control",
                }
            })
                    .tablesorterPager({
                        container: $(".ts-pager"),
                        cssGoto: ".pagenum",
                        removeRows: false,
                        output: '{startRow} - {endRow} / {filteredRows} ({totalRows})'
                    });
        </script>
    </body>
</html>
