<%-- 
    Document   : index
    Created on : 17/09/2017, 00:04:41
    Author     : Portella, Rodolfo <rodolfosportella@gmail.com>
--%>

<%@page import="br.com.is.Person.Entity.Usuario"%>
<%@page import="br.com.is.Util.DAO.Generico"%>
<%@page import="br.com.is.Address.Entity.Pais"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="webjars/bootstrap/4.0.0-alpha.6/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="webjars/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
                Bootstrap
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
                            <a class="dropdown-item" href="#">Sair</a>
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
                            <a class="nav-link" href="#">Reports</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Analytics</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"><i class="fa fa-cogs" aria-hidden="true"></i> Configurações</a>
                        </li>
                    </ul>
                </nav>
                <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
                    <h1>Dashboard</h1>
                    <h2>Section title</h2>
                    <div class="table-responsive">
                        <table class="table table-condensed table-hover">
                            <thead class="thead-default">
                                <tr>
                                    <th>Id</th>
                                    <th>Nome</th>
                                    <th>E-mail</th>
                                    <th>Situação</th>
                                    <th>Edição</th>
                                </tr>
                            </thead>
                            <%
                                List<Pais> pais = new Generico<Pais>(new Pais()).Listar(null);
                                for (int i = 0; i < pais.size(); i++) {
                            %>

                            <tr>
                                <td><%= pais.get(i).getCodigo()%></td>
                                <td><%= pais.get(i).getNome()%></td>
                                <td><%= pais.get(i).getSigla()%></td>
                                <td><a href="/ProspexaoQ/acao?parametro=edUsuario&id=<%= pais.get(i).getCodigo()%>"><span class="pull-left glyphicon glyphicon-pencil"></span></a></td>
                                <td><a href="/ProspexaoQ/acao?parametro=exUsuario&id=<%= pais.get(i).getCodigo()%>"><span class="pull-left glyphicon glyphicon-trash"></span></a></td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                </main>
            </div>
        </div>



        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
        <script src="webjars/bootstrap/4.0.0-alpha.6/dist/js/bootstrap.min.js"></script>
    </body>
</html>
