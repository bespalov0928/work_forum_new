[![Build Status](https://app.travis-ci.com/bespalov0928/work_forum_new.svg?branch=main)](https://app.travis-ci.com/bespalov0928/work_forum_new)

## Описание

### О проекте
Приложение представляет классический форум.
Есть возможность авторизации, аутентификации, добавить новую тему, обсудить выбранную тему.
Данные хранятся в базе Postgres


### Стек технологий
* Java 17
* Spring Boot 2
* Spring Security
* PostgreSQL
* Liquibase
* jacoco
* travic


### Сборка и запуск
Сборка
```
mvn install
```
запуск
```
java -jar target/forum-1.0.jar
```

### Как использовать
Регистрация нового пользователя
![ScreenShot](images/reg.png)

Аторизация
![ScreenShot](images/login.png)

Главная страница
![ScreenShot](images/index.png)

Создание новой темы форума
![ScreenShot](images/newPost.png)

Страница обсуждения
![ScreenShot](images/response.png)



### Контакты
Skype: bespalov0928