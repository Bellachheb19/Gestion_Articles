<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Modifier un article</title>
</head>

<body>

<h1>Modifier un article</h1>

<form method="post"
      action="${pageContext.request.contextPath}/app/update">

    <label>Code :</label>
    <input type="text"
           name="code"
           value="${article.code}"
           readonly>

    <br><br>

    <label>Désignation :</label>
    <input type="text"
           name="designation"
           value="${article.designation}"
           required>

    <br><br>

    <label>Prix :</label>
    <input type="number"
           name="prix"
           step="0.01"
           value="${article.prix}"
           required>

    <br><br>

    <button type="submit">Modifier</button>

</form>

<br>

<a href="${pageContext.request.contextPath}/app/list">
    Retour à la liste
</a>

</body>
</html>