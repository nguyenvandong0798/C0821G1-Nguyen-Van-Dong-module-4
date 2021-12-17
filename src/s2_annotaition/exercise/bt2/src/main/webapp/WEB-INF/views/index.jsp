<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form method="post" action="/calculator">
    <h2> controller.CalculatorController</h2>
    <input type="number" name="number1" width="40px">
    <input type="number" name="number2" width="40px">

    <button type="submit" name="calculated" value="+">Addition(+)</button>
    <button type="submit" name="calculated" value="-">Subtraction(-)</button>
    <button type="submit" name="calculated" value="*">Multiplication(*)</button>
    <button type="submit" name="calculated" value="/">Division(/)</button>

</form>
</body>
</html>
