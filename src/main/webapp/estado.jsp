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
            <li class="breadcrumb-item active">Estado</li>
        </ol>

        <c:if test="${param.action eq 'noe'}">
            <form action="estado?action=save" method="post">
                <div class="form-group">
                    <label for="pais">Pais</label>
                    <input type="hidden" name="pais" value="<c:out value="${pais.codigo}"/>">
                    <input type="text" class="form-control" id="pais" placeholder="Sigla" value="<c:out value="${pais.sigla} - ${pais.nome}"/>" disabled="disabled">
                </div>
                <input type="hidden" name="codigo" value="<c:out value="${estado.codigo}"/>">
                <div class="form-group">
                    <label for="uf">UF</label>
                    <input type="text" class="form-control" id="uf" name="uf" placeholder="Sigla" value="<c:out value="${estado.uf}"/>">
                </div>
                <div class="form-group">
                    <label for="nome">Título</label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Título" value="<c:out value="${estado.nome}"/>">
                </div>
                <div class="form-group">
                    <label class="custom-control custom-checkbox" for="status">
                        <input type="checkbox" class="custom-control-input" id="status" name="status" <c:if test="${estado.status}">checked="checked"</c:if>>
                            <span class="custom-control-indicator"></span>
                            <span class="custom-control-description">Status está ativo</span>
                        </label>
                    </div>
                    <button type="submit" class="btn btn-success">Salvar</button>
                </form>
        </c:if>
        <c:if test="${empty param.action}">
            <a class="btn btn-secondary" href="estado?action=new&codigo=${pais}">Novo</a><br><br>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead class="thead-default">
                        <tr>
                            <th>#</th>
                            <th>Sigla</th>
                            <th>Título</th>
                            <th>Status</th>
                            <th class="acao"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="estado" items="${estados}">
                            <tr>
                                <td>${estado.codigo}</td>
                                <td>${estado.uf}</td>
                                <td>${estado.nome}</td>
                                <td><a href="#">${estado.status}</a></td>
                                <td><a href="cidade?codigo=${estado.codigo}" title="Cidades"><i class="fa fa-list" aria-hidden="true"></i></a>
                                    <a href="estado?action=edit&codigo=${estado.codigo}" title="Editar"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                    <a href="estado?action=delete&codigo=${estado.codigo}" title="Remover"><i class="fa fa-trash" aria-hidden="true"></i></a>
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