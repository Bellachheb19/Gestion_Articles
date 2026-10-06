<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Ajouter un article</title>
</head>

<body>

<h1>Ajouter un article</h1>

<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>

<form method="post"
      action="${pageContext.request.contextPath}/app/create">

    <label>Code :</label>
    <input type="text" name="code" required>

    <br><br>

    <label>Désignation :</label>
    <input type="text" name="designation" required>

    <br><br>

    <label>Prix :</label>
    <input type="number"
           name="prix"
           step="0.01"
           required>

    <br><br>

    <button type="submit">Ajouter</button>

</form>

<br>

<a href="${pageContext.request.contextPath}/app/list">
    Retour à la liste
</a>

</body>
</html>