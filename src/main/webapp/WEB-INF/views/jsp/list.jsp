<%--suppress ALL --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<SetEnv downgrade-1.0></SetEnv>
<html lang="ru">
<head>
    <jsp:include page="../fragments/header.jsp"/>
</head>

<body>
<div class="container"><br><br><br>
    <div class="col-lg-6">
        <div class="input-group">
            <input type="text" id="searchName" name="searchText" class="form-control" placeholder="Поиск по имени"
                   required="required">
            <span class="input-group-btn">
        <button class="btn btn-secondary" type="submit" onclick="getData(1, $('#searchName').val())">Поиск</button>
      </span>
        </div>
    </div>
    <script>
    </script>


    <br><br><br><br><br><br>
    <h1 align="center">Cписок пользователей</h1>

    <table class="table" id="mytab">
        <tr>
            <th>Фамилия и Имя</th>
            <th>Возраст</th>
            <th>Администратор</th>
            <th>Дата и Время</th>
            <th></th>
        </tr>
        <tbody id="mybody">

        </tbody>
    </table>
    <ul id="pagination-demo" class="pagination-sm"></ul>
    <br><br>
    <script>
        var paramPage = 1;
        var countAll = ${counts};
        var pages = Math.ceil(countAll / 10);
        $('#pagination-demo').twbsPagination({
            totalPages: pages,
            visiblePages: 5,
            loop: true,
            onPageClick: function (event, page) {
                paramPage = page;
                getData(page, $('#searchName').val());
            }
        });

        function getData(page, name) {
            paramPage = page;
            console.log(name)
            if (name != null) {
                $.ajax({
                    type: "POST",
                    url: "/user/page/" + page,
                    dataType: "text",
                    success: function (data) {
                        var obj = JSON.parse(data);
                        console.log(page)
                        $('#mybody').html('');
                        for (var i = 0; i < obj.length; i++) {
                            newrow = document.all.mybody.insertRow()
                            newcell = newrow.insertCell(0)
                            newcell.innerText = obj[i].name
                            newcell = newrow.insertCell(1)
                            newcell.innerText = obj[i].age
                            if (obj[i].admin == false) {
                                newcell = newrow.insertCell(2)
                                newcell.innerText = "Нет"
                            } else {
                                newcell = newrow.insertCell(2)
                                newcell.innerText = "Да"
                            }
                            newcell = newrow.insertCell(3)
                            newcell.innerText = obj[i].createdDateString
                            newcell = newrow.insertCell(4)
                            newcell.innerHTML = newcell.innerHTML + " <button type='button' class='btn btn-primary' onclick = location.href='/user/" + obj[i].id + "' >Изменить</button><br>";
                            newcell = newrow.insertCell(5)
                            newcell.innerHTML = newcell.innerHTML + " <button type='button' class='btn btn-danger' onclick = location.href='/user/" + obj[i].id + "/delete' >Удалить</button><br>";
                        }
                    }
                });
            }
            else {
                $.ajax({
                    type: "POST",
                    url: "/user/page/1/" + name,
                    dataType: "text",
                    success: function (data) {
                        console.log(name)
                        var obj = JSON.parse(data);
                        $('#mybody').html('');
                        for (var i = 0; i < obj.length; i++) {
                            newrow = document.all.mybody.insertRow()
                            newcell = newrow.insertCell(0)
                            newcell.innerText = obj[i].name
                            newcell = newrow.insertCell(1)
                            newcell.innerText = obj[i].age
                            if (obj[i].admin == false) {
                                newcell = newrow.insertCell(2)
                                newcell.innerText = "Нет"
                            } else {
                                newcell = newrow.insertCell(2)
                                newcell.innerText = "Да"
                            }
                            newcell = newrow.insertCell(3)
                            newcell.innerText = obj[i].createdDateString
                            newcell = newrow.insertCell(4)
                            newcell.innerHTML = newcell.innerHTML + " <button type='button' class='btn btn-primary' onclick = location.href='/user/" + obj[i].id + "' >Изменить</button><br>";
                            newcell = newrow.insertCell(5)
                            newcell.innerHTML = newcell.innerHTML + " <button type='button' class='btn btn-danger' onclick = location.href='/user/" + obj[i].id + "/delete' >Удалить</button><br>";
                        }
                    }
                });
            }

        }


    </script>


    <spring:url value="/user/form" var="AddUser"/>
    <button class="btn btn-info" onclick="location.href='${AddUser}'">Добавить</button>
    <br>


</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>