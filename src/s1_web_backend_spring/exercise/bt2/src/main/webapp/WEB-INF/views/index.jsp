<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <form action="/dictionary" method="post">
   <input type="text" value="${search}" name="search">
   <input type="submit" value="submit">
 </form>
  </body>
</html>
