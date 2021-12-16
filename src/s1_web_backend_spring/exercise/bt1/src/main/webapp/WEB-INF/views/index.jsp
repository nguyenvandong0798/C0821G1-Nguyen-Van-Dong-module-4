<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/money" method="post">
    <input type="number" name="usd" value="${usd}"> USD
    <input  value="${result}"> Result
    <input type = "submit" value="submit">
  </form>
  </body>
</html>
