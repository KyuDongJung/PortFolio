<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>오늘의 할 일</title>
    <link rel="stylesheet" href="resources/css/TodoList.css">
    <script src="https://kit.fontawesome.com/aadd271e4b.js" crossorigin="anonymous"></script>
</head>
<body>
<main>
    <section>
        <header>TOD<i class="fa-regular fa-face-smile"></i></header>
    </section>
    <section class="clock">
        <div id="watch"></div>
    </section> <!-- 시계 -->

    <section class="wrapper">
        <div class=todo-box>
            <div class="todo-input-box">
                <button class="complete-all-btn" id="complete-all-btn"><i class="fa-sharp fa-solid fa-check"></i></button>
                <input type="text" class="todo-input" id="input" placeholder="오늘의 할일을 입력해주세요" >
                <button type="button" class="inputBtn" id="inputBtn">Add</button>
            </div>
            <ul class="todo-list" id="todolist">
                <!-- 리스트 -->
            </ul>
            <div class="todo-bottom">
                <div class="left-items" id="left-items">남은 할일 0</div>
                <div class="button-group">
                    <button class="show-all-btn" id="all">All</button>
                    <button class="show-active-btn" id="active">Active</button>
                    <button class="show-completed-btn" id="complete">Complete</button>
                </div>
            <button class="clear-completed-btn" id="clear-completed-btn" type="clear">Clear Completed</button>
        </div>
    </div>
    </section>
</main>



    <script src="${contextPath}/resources/js/TodoList.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</body>
</html>