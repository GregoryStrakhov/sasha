<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">


<jsp:include page="../fragments/header.jsp" />

<body>
<div class="container"><br>
    <c:choose>
        <c:when  test="${mode eq 'edit'}">
            <div class="well lead" align="center">Изменить информацию о пользователе</div>
        </c:when>

        <c:otherwise>
            <div class="well lead" align="center"><h1>Добавить пользователя</h1></div>
        </c:otherwise>
    </c:choose><br><br>


    <form:form method="POST" modelAttribute="userForm" class="form-horizontal" action="/user/save/">
        <form:input type="hidden" path="id" id="id"/>

        <spring:bind path="name">
            <div class="form-group row">
                <label class="col-xs-2 col-form-label">Имя и Фамилия</label>
                <div class="col-xs-3">
                    <form:input path="name" type="text" class="form-control " id="name" placeholder="Имя и Фамилия" required="required" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="age">
            <div class="form-group row">
                <label class="col-xs-2 col-form-label">Возраст</label>
                <div class="col-xs-3">
                    <form:input path="age" type="text" class="form-control " id="age" value = "" placeholder="Возраст" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-info">Сохранить</button>
            </div>
        </div>
    </form:form>
</div>

<jsp:include page="../fragments/footer.jsp" />
</body>

</html>