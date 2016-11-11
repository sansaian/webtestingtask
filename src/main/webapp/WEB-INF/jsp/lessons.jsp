<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Lessons</title>
</head>
<body>
<h2>List of Lessons</h2>
<br>
<form action="/search" method="GET">
    <input name="search" placeholder="search" >
    <input type="submit" value="search">
    <br>
</form>
<table>
    <thead>
    <td>Id</td>
    <td>Title</td>
    <td>Controls</td>
    </thead>
    <tbody>
    <a href="admin/add/">Add new Lesson</a>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.title}</td>
            <td>
                <a href="/lesson/view/${item.id}">view/edit</a>
                <a href="/lesson/del/${item.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/"><---STUDENTS </a>
</body>
</html>