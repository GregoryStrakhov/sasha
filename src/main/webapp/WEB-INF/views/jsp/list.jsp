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
    <jsp:include page="../fragments/header.jsp" />
</head>


<body>
<div class="container">
            <div class="row">
                <div class="col-md-6">
                    <form:form method="get" action="search">
                        <div id="custom-search-input">
                            <div class="input-group col-xs-1">
                                <input type="text" name="searchText" class="form-control input-sm" placeholder="Поиск" />
                                    <span class="input-group-btn">
                                        <button class="btn btn-info btn-sm" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                                    </span>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>

            <h1 align="center">Cписок студентов</h1>

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
                        <td><button class="btn btn-primary" onclick="location.href='${editStudent}'">Изменить</button>
                            <button class="btn btn-danger" onclick="location.href='${deleteStudent}'">Удалить</button></td>
                    </tr>

                </c:forEach>

            </table>
            <spring:url value="/student/form" var="AddStudent" />
            <button class="btn btn-info" onclick="location.href='${AddStudent}'">Добавить</button>
        </div>
    <%--</sec:authorize>--%>



<jsp:include page="../fragments/footer.jsp" />

</body>
</html>