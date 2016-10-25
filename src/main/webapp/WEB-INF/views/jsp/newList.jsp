<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="">

    <jsp:include page="../fragments/header.jsp" />
</head>


<body>
<div class="container">
    <div class="row"><br>
        <div class="col-xs-4">
            <form:form method="get" action="search">
                <div class="input-group" style="float: left">
                    <input type="text" class="form-control" placeholder="Поиск по фамилии">
                          <span class="input-group-btn">
                            <button class="btn btn-info" type="button">Поиск</button>
                          </span>
                </div>
            </div>
        </div>
    </form:form>

    <h3 align="center">Cписок студентов</h3><br>

    <table class="table ">
        <tr>
            <th>№</th>
            <th>Ф.И.О.</th>
            <th>Номер группы</th>
            <th></th>
        </tr>

        <c:set var="counter" value="0" />
        <c:forEach var="students" items="${students}">
            <c:set var="counter" value="${counter+1}" />
            <tr>
                <td>${counter}</td>
                <td>${students.fullName}</td>
                <td>${students.group.numberGroup}</td>
                <spring:url value="/student/${students.id}/delete" var="deleteStudent" />
                <spring:url value="/student/${students.id}?mode=edit" var="editStudent" />
                <td><button class="btn btn-info" onclick="location.href='${editStudent}'">Изменить</button>
                    <button class="btn btn-danger" onclick="location.href='${deleteStudent}'">Удалить</button></td>
            </tr>
        </c:forEach>
    </table>
</div>

</div>
</body>
</html>

