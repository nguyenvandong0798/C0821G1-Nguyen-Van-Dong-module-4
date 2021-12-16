<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form method="post" action="/save">
    <input type="checkbox" name="name" value="Lettuce">
    <label>Lettuce</label>
    <input type="checkbox" name="name" value="Tomato">
    <label>tomato</label>
    <input type="checkbox" name="name" value="mustard">
    <label>mustard</label>
    <input type="checkbox" name="name" value="sprouts">
    <label>sprouts</label>
    <button type="submit">search</button>
</form>
</body>
</html>
