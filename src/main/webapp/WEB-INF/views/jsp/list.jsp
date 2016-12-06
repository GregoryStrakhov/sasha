<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <jsp:include page="../fragments/header.jsp"/>
</head>

<body>
<div class="container"><br><br><br>
    <form:form method="get" action="user/search">
        <div class="col-lg-6">
            <div class="input-group">
                <input type="text" name="searchText" class="form-control" placeholder="Поиск по имени">
                <span class="input-group-btn">
        <button class="btn btn-secondary" type="submit">Поиск</button>
      </span>
            </div>
        </div>
    </form:form>

    <br><br><br><br><br><br>
    <h1 align="center">Cписок пользователей</h1>

    <table class="table ">
        <tr>
            <th>№</th>
            <th>Фамилия и Имя</th>
            <th>Возраст</th>
            <th>Администратор</th>
            <th>Дата и Время</th>
            <th></th>
        </tr>

        <c:set var="counter" value="0"/>
        <c:forEach var="users" items="${users}">
            <c:set var="counter" value="${counter+1}"/>
            <tr>
                <td>${counter}</td>
                <td>${users.name}</td>
                <td>${users.age}</td>
                <td>${users.admin}</td>
                <td>${users.createdDate}</td>
                <spring:url value="/user/${users.id}/delete" var="deleteUser"/>
                <spring:url value="/user/${users.id}" var="editUser"/>
                <td>
                    <button class="btn btn-primary" onclick="location.href='${editUser}'">Изменить</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteUser}'">Удалить</button>
                </td>
            </tr>

        </c:forEach>

    </table>

    <spring:url value="/user/form" var="AddUser"/>
    <button class="btn btn-info" onclick="location.href='${AddUser}'">Добавить</button>
    <%--<nav aria-label="Page navigation" style="float: right;">--%>
        <%--<ul class="pagination">--%>
            <%--<li class="page-item">--%>
                <%--<a class="page-link" href="#" aria-label="Previous">--%>
                    <%--<span aria-hidden="true">&laquo;</span>--%>
                    <%--<span class="sr-only">Previous</span>--%>
                <%--</a>--%>
            <%--</li>--%>
            <%--<li class="page-item"><a class="page-link" href="">1</a></li>--%>
            <%--<li class="page-item"><a class="page-link" href="">2</a></li>--%>
            <%--<li class="page-item"><a class="page-link" href="#">3</a></li>--%>
            <%--<li class="page-item"><a class="page-link" href="#">4</a></li>--%>
            <%--<li class="page-item"><a class="page-link" href="#">5</a></li>--%>
            <%--<li class="page-item">--%>
                <%--<a class="page-link" href="#" aria-label="Next">--%>
                    <%--<span aria-hidden="true">&raquo;</span>--%>
                    <%--<span class="sr-only">Next</span>--%>
                <%--</a>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</nav>--%>
    <div id="content">Dynamic Content goes here</div>
    <div id="page-selection">Pagination goes here</div>
    <script>
        // init bootpag
        $('#page-selection').bootpag({
            total: 10,
            page: 1,
            maxVisible: 10
        }).on("page", function(event, /* page number here */ num){
            $.ajax({
                type: "GET",
                url: "user/getNum/" + num,
                dataType: "json"
            });
            $("#content").html("Insert content"); // some ajax content loading...
        });
    </script>
</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>