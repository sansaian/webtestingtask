<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student form for Teacher!</title>
</head>
<body>
<style type="text/css">
    .msg {
        color: #9429f9;
        font-size: 11pt;
    }
</style>
<c:if test="${not empty msg}">
    <div class="msg"><h1 >${msg} </h1></div>
</c:if>
<form action="/student/${student.id}" method="GET">
    <label>First name</label>
    <input name="firstName" placeholder="${student.firstName}" >
    <br>
    <label>Last name</label>
    <input name="lastName" placeholder="${student.lastName}">
    <br>
    <label>Sex</label>
    <select name="sex">
        <option value="m" <c:if test="${student.sex == 'm'}">selected="selected"</c:if> >male</option>
        <option value="f" <c:if test="${student.sex == 'f'}">selected="selected"</c:if> >female</option>
    </select>
    <br>
    <input type="submit" value="Update">
    <br><a href="/">Back to list</a><br>
</form>
</body>
</html>
