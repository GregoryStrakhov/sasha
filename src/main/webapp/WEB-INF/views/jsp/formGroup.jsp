<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<body>
<jsp:include page="../fragments/header.jsp" />

<div class="container">
    <div class="well lead" align="center">Добавить студента</div>

    <form:form method="POST" modelAttribute="groupForm" class="form-horizontal" action="/group/">
        <form:input type="hidden" path="id" id="id"/>

        <spring:bind path="numberGroup">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Ф.И.О.</label>
                <div class="col-sm-3">
                    <form:input path="numberGroup" type="text" class="form-control " id="numberGroup" placeholder="Номер группы" required="required" />
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