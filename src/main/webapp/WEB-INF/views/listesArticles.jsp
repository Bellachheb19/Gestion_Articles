<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Liste des articles</title>
</head>

<body>

<h1>Liste des articles</h1>

<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>

<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>

<a href="${pageContext.request.contextPath}/app/new">
    Ajouter un article
</a>

<br><br>

<table border="1">

    <thead>
    <tr>
        <th>Code</th>
        <th>Désignation</th>
        <th>Prix</th>
        <th>Actions</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach var="article" items="${articles}">
        <tr>
            <td>${article.code}</td>
            <td>${article.designation}</td>
            <td>${article.prix}</td>

            <td>
                <a href="${pageContext.request.contextPath}/app/edit?code=${article.code}">
                    Modifier
                </a>

                <a href="${pageContext.request.contextPath}/app/delete?code=${article.code}">
                    Supprimer
                </a>
            </td>
        </tr>
    </c:forEach>

    </tbody>

</table>

</body>
</html>