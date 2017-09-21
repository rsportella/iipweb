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
            <li class="breadcrumb-item"><a href="">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Configurações</a></li>
            <li class="breadcrumb-item active">Cidades</li>
        </ol>
        <c:if test="${param.action eq 'noe'}">
            <form action="cidade?action=save" method="post">
                <input type="hidden" name="codigo" value="<c:out value="${estado.codigo}"/>">
                <div class="form-group">
                    <label for="nome"></label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Título" value="<c:out value="${cidade.nome}"/>">
                </div>
                <div class="form-group">
                    <label class="custom-control custom-checkbox" for="status">
                        <input type="checkbox" class="custom-control-input" id="status" name="status" <c:if test="${cidade.status}">checked="checked"</c:if>>
                            <span class="custom-control-indicator"></span>
                            <span class="custom-control-description">Status está ativo</span>
                        </label>
                    </div>
                    <button type="submit" class="btn btn-success">Salvar</button>
                </form>
        </c:if>
        <c:if test="${empty param.action}">
            <a class="btn btn-secondary" href="cidade.jsp?action=noe">Novo</a><br><br>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead class="thead-default">
                        <tr>
                            <th>#</th>
                            <th>Título</th>
                            <th>Status</th>
                            <th class="acao"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cidade" items="${cidades}">
                            <tr>
                                <td>${cidade.codigo}</td>
                                <td>${cidade.nome}</td>
                                <td><a href="#">${cidade.status}</a></td>
                                <td><a href="estado?codigo=${cidade.codigo}" title="Estados"><i class="fa fa-list" aria-hidden="true"></i></a>
                                    <a href="cidade?action=edit&codigo=${cidade.codigo}" title="Editar"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                    <a href="cidade?action=delete&codigo=${cidade.codigo}" title="Remover"><i class="fa fa-trash" aria-hidden="true"></i></a>
                                </td>
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