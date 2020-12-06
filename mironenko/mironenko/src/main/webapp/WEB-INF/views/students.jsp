<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Students List</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
        function addStudent() {
            var student = JSON.stringify(
                {
                    fullName: $('#fullName').val(),
                    idGroup: ${idGroup}
                })
            $.ajax({
                type: "post",
                contentType: "application/json",
                url: "/students/saveStudent",
                data: student,
                dataType: "json"
            })
        }


        function deleteStudent(idStudent) {
            document.getElementById("tr-"+idStudent).remove();
            var urlForDelete = "/students/deleteStudent/" + idStudent;
            $.ajax({
                type: "post",
                url: urlForDelete,
            })
        }

    </script>
</head>
<body>
<h2>Группа номер № ${groupNumber}</h2>

<table id="groupsList" border="1">
    <tr>
        <th>Дата принятия</th>
        <th>ФИО студента</th>
        <th>Действия</th>
    </tr>
    <tr>
        <c:forEach items="${studentsList}" var="student">
    <tr id="tr-${student.id}">
        <td>${student.enrollmentDate}</td>
        <td>${student.fullName}</td>
        <td><a onclick="deleteStudent(${student.id})">Удалить</a></td>
    </tr>
    </c:forEach>
    </tr>
</table>
<form id="form" method="get">
    <input type="text" id="fullName" placeholder="ФИО"/><br>
    <button onclick="addStudent()">Принять нового студента</button><br>
</form>

<form action="/groups/groupList" method="get">
    <button>Вернуться к списку групп</button>
</form>
</body>
</html>