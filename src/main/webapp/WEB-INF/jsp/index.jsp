<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$List of Students</title>
</head>
<body>
<br>
<form action="/search" method="POST">
  <input name="search" placeholder="search" >
  <input type="submit" value="search">
  <br>
</form>
<table>
  <thead>
  <td>Id</td>
  <td>First name</td>
  <td>Last name</td>
  <td>Sex</td>
  <td>Birth date</td>
  <td>Controls</td>
  </thead>
  <tbody>
  <a href="/user/">Roleuser</a>
  <a href="/admin/">Roleuser</a>
  </tbody>
</table>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!--  Сортировка    -->

</body>
</html>

