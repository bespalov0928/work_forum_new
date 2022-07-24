<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Создание темы</title>
</head>
<body>
<div>
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
                        <a class="nav-link" href="/logout">| Выйти</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div>
        <div>
            <form action="<c:url value="/save"/> " method="post">
                <c:if test="${not empty post}">
                    <input type="hidden" name="id" value="${post.id}">
                </c:if>
                <div class="card-header">
                    <div class="card-body">
                        <p><input type="text" class="form-control" name="name" value="${post.name}"></p>
                        <p><textarea class="form-control" name="description" rows="5">${post.description}</textarea></p>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="px-4 pt-3 text-right">
                        <button type="submit" class="btn btn-primary">
                            <i class="ion ion-md-create"></i>
                            Сохранить
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
