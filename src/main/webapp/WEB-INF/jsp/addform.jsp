<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student form!</title>
</head>
<body>
<style type="text/css">
    .msg {
        color: #9429f9; /* Цвет текста */
        font-size: 11pt;
    }
</style>
<c:if test="${not empty msg}">
    <div class="msg"><h1 >${msg} </h1></div>
</c:if>
<form action="addform" method="GET">
    <label>First name</label>
    <input name="firstName" placeholder="firstName" >
    <br>
    <label>Last name</label>
    <input name="lastName" placeholder="lastName">
    <br>
    <label>Sex</label>
    <select name="sex">
        <option value="m" <c:if test="${student.sex == 'm'}">selected="selected"</c:if> >male</option>
        <option value="f" <c:if test="${student.sex == 'f'}">selected="selected"</c:if> >female</option>
    </select>
    <br>
    <input name="birth" placeholder="dd-mm-yyyy"><br>
    <input type="submit" value="Add">
    <br><a href="/">Back to list</a><br>
</form>
</body>
</html>