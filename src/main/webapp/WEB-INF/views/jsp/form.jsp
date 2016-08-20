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
<div class="container">
    <div class="well lead" align="center">Добавить студента</div>

    <form:form method="POST" modelAttribute="studentForm" class="form-horizontal" action="/student/">
        <form:input type="hidden" path="id" id="id"/>

        <spring:bind path="fullName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Ф.И.О.</label>
                <div class="col-sm-3">
                    <form:input path="fullName" type="text" class="form-control " id="fullName" placeholder="Ф.И.О." required="required" />
                </div>
            </div>
        </spring:bind>

        <c:choose>
            <c:when  test="${mode eq 'edit'}">
                <spring:bind path="idGroup">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Номер группы</label>
                        <div class="col-sm-3">
                            <form:select path="idGroup" class="form-control">
                                <form:option  label="--Select--"  value=""/>
                                <form:options items="${list}" itemValue="id" itemLabel="numberGroup" />
                            </form:select>
                        </div>
                        <div class="col-sm-4"></div>
                    </div>
                </spring:bind>
            </c:when>

            <c:otherwise>
                <spring:bind path="idGroup">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Номер группы</label>
                        <div class="col-sm-3">
                            <form:select path="idGroup" class="form-control">
                                <form:option  label="--Select--"  value=""/>
                                <form:options items="${list}" itemValue="id" itemLabel="numberGroup" />
                            </form:select>
                        </div>
                        <div class="col-sm-4"></div>
                    </div>
                </spring:bind>
            </c:otherwise>
        </c:choose>


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