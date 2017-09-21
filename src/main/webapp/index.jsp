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

        <h1>Dashbord</h1>
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/iipweb/">Home</a></li>
        </ol>
        <h2>Section title</h2>
    </jsp:body>
</t:layout>