<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Submitted Email Information</h2>
<table>
    <tr>
        <td>Language:</td>
        <td>${language}</td>
    </tr>
    <tr>
        <td>Page size:</td>
        <td>${pageSize}</td>
    </tr>
    <tr>
        <td>Spam mail:</td>
        <td>${spamFiler}</td>
    </tr>
    <tr>
        <td>Sign mail:</td>
        <td>${signature}</td>
    </tr>
</table>
</body>
</html>
