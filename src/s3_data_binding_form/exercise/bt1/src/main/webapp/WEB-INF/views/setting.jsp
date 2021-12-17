<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Settings</h3>
<%--@elvariable id="email" type="com"--%>
<form:form method="post" action="addEmail" modelAttribute="email">
    <table>
        <tr>
            <td><form:select path="language">
                <form:options items="${languages}" ></form:options>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><form:select path="pageSize">
                <form:options items="${pageSizes}" ></form:options>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><form:select path="spamFiler">
                <form:options items="${spamFilers}" ></form:options>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>