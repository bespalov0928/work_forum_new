<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <title>Форум</title>
</head>

<body>
<div class="container mt-3">
    <nav class="navbar navbar-expand-lg navbar-light bg-light rounded" aria-label="Twelfth navbar example">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample10"
                    aria-controls="navbarsExample10" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample10">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/">Все темы</a>
                    </li>
                    <li lass="nav-item">
                        <a class="nav-link" href="/create">Открыть новую тему</a>
                    </li>
                    <li class="nav-item">
<%--                        <form action="/auth/logout" method="POST">--%>
<%--                            <button type="submit">Logout</button>--%>
<%--                        </form>--%>
                        <a class="nav-link" href="/auth/logout">${user.username} | Выйти</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема</th>
                <th scope="col">Обновлено</th>
                <th scope="col">Автор</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>
                        <a href="<c:url value='/read?id=${post.id}'/>">
                            <c:out value="${post.name}"/>
                        </a>
                    </td>
                    <td>
                        <fmt:formatDate value="${post.updated}" type="both" pattern='dd MMMM, EEEE, yyyy г.'/>
                    </td>
                    <td>
                        <a>${post.user.username}</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
