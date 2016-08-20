<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Test</title>
    <jsp:include page="../fragments/header.jsp" />
</head>


<body>
<div class="container">

    <h1 align="center">Cписок групп</h1>

    <table class="table ">

        <tr>
            <th>№</th>
            <th>Номер группы</th>
            <th></th>
        </tr>

        <c:set var="counter" value="0" />
        <c:forEach var="groups" items="${groups}">
            <c:set var="counter" value="${counter+1}" />
            <tr>
                <td>${counter}</td>
                <td>${groups.numberGroup}</td>
                <spring:url value="/group/${groups.id}/delete" var="deleteGroup" />
                <td><button class="btn btn-danger" onclick="location.href='${deleteGroup}'">Удалить</button></td>
            </tr>

        </c:forEach>

    </table>
    <spring:url value="/group/form" var="AddGroup" />
    <button class="btn btn-info" onclick="location.href='${AddGroup}'">Добавить</button>
</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>