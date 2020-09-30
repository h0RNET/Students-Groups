<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Groups list</title>

</head>
<body>
<h2>Группы университета ScaleApps</h2>

<table id="groupsList" border="1">
    <tr>
        <th>Номер</th>
        <th>Количество студентов</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${groupsList}" var="group">
        <tr>
            <td>${group.number}</td>
            <td>${group.count}</td>
            <td ><a href="/students/studentsList/${group.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>

<form:form action="/groups/saveGroup/" method="POST" modelAttribute="group">
    <form:input path="number" placeholder="Номер группы"/>
    <input type="submit" value="Добавить новую группу">
</form:form>

</body>
</html>