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
            <li class="breadcrumb-item"><a href="#">Apoio</a></li>
            <li class="breadcrumb-item active">Tipo Endereço</li>
        </ol>
        <c:if test="${param.action eq 'noe'}">
            <form action="tipoendereco?action=save" method="post">
                <input type="hidden" name="codigo" value="<c:out value="${tipoendereco.codigo}"/>">
                <div class="form-group">
                    <label for="sigla">Sigla *</label>
                    <input type="text" class="form-control" id="sigla" name="sigla" placeholder="Sigla" value="<c:out value="${tipocontato.sigla}"/>"  maxlength="2" minlength="2" required>
                </div>
                <div class="form-group">
                    <label for="nome">Título *</label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Título" value="<c:out value="${tipoendereco.nome}"/>">
                </div>
                <div class="form-group">
                    <label for="descricao">Descrição</label>
                    <textarea class="form-control" id="descricao" name="descricao" placeholder="Descrição"><c:out value="${tipoendereco.descricao}"/></textarea>
                </div>
                <div class="form-group">
                    <label class="custom-control custom-checkbox" for="status">
                        <input type="checkbox" class="custom-control-input" id="status" name="status" <c:if test="${logradouro.status || empty(logradouro.status)}">checked</c:if>>
                            <span class="custom-control-indicator"></span>
                            <span class="custom-control-description">Status está ativo</span>
                        </label>
                    </div>
                    <button type="submit" class="btn btn-success">Salvar</button>
                </form>
        </c:if>
        <c:if test="${empty param.action}">
            <a class="btn btn-secondary" href="tipoendereco.jsp?action=noe">Novo</a><br><br>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead class="thead-default">
                        <tr>
                            <th>#</th>
                            <th>Sigla</th>
                            <th>Título</th>
                            <th>Situação</th>
                            <th class="acao"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <jsp:useBean id="controller" class="br.com.is.Address.Controller.TipoenderecoController"/>
                        <c:forEach var="tipoendereco" items="${controller.list()}">
                            <tr>
                                <td>${tipoendereco.codigo}</td>
                                <td>${tipoendereco.sigla}</td>
                                <td>${tipoendereco.nome}</td>
                                <td>${tipoendereco.status}</td>
                                <td><a href="tipoendereco?action=edit&codigo=${tipoendereco.codigo}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                    <a href="tipoendereco?action=delete&codigo=${tipoendereco.codigo}"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
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