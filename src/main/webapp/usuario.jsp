<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>

    <jsp:attribute name="header">
        <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
    <jsp:body>
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/iipweb/">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Configurações</a></li>
            <li class="breadcrumb-item active">Usuário</li>
        </ol>
        <c:if test="${param.action eq 'noe'}">
            <form action="" method="post">
                <div class="form-group">
                    <label for="nome">Sigla</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Sigla" maxlength="2">
                </div>
                <div class="form-group">
                    <label for="formGroupExampleInput">Nome</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Nome" value="<c:out value="${usuario.login}"/>">
                    </div>
                    <button type="reset" class="btn btn-primary">Limpar</button>
                    <button type="submit" class="btn btn-success">Salvar</button>
                </form>
        </c:if>
        <c:if test="${empty param.action}">
            <a class="btn btn-secondary" href="">Novo</a><br><br>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead class="thead-default">
                        <tr>
                            <th>#</th>
                            <th>Nome do usuário</th>
                            <th>Login</th>
                            <th>Situação</th>
                            <th class="acao">Edição</th>
                        </tr>
                    </thead>
                    <tbody>
                        <jsp:useBean id="controller" class="br.com.is.Person.Controller.UsuarioController"/>
                        <c:forEach var="usuario" items="${controller.list()}">
                            <tr>
                                <td>${usuario.codigo}</td>
                                <td>${usuario.pessoa.nome}</td>
                                <td>${usuario.login}</td>
                                <td><a href="#">${usuario.status}</a></td>
                                <td><a href="/iipweb/usuario?action=edit&codigo=${usuario.pessoa.codigo}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th colspan="5" class="ts-pager">
                                <div class="form-inline">
                                    <div class="btn-group btn-group-sm mx-1" role="group">
                                        <button type="button" class="btn btn-secondary first" title="first">⇤</button>
                                        <button type="button" class="btn btn-secondary prev" title="previous">←</button>
                                    </div>
                                    <span class="pagedisplay"></span>
                                    <div class="btn-group btn-group-sm mx-1" role="group">
                                        <button type="button" class="btn btn-secondary next" title="next">→</button>
                                        <button type="button" class="btn btn-secondary last" title="last">⇥</button>
                                    </div>
                                    <select class="form-control-sm custom-select px-1 pagesize" title="Select page size">
                                        <option selected="selected" value="10">10</option>
                                        <option value="20">20</option>
                                        <option value="30">30</option>
                                        <option value="all">All Rows</option>
                                    </select>
                                    <select class="form-control-sm custom-select px-4 mx-1 pagenum" title="Select page number"></select>
                                </div>
                            </th>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </c:if>
    </jsp:body>
</t:layout>