<%-- 
    Document   : deleteUser
    Created on : Jun 27, 2024, 11:30:56 PM
    Author     : tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/deleteUser" var="action" />
<section class="container pt-3">
    <div class="card">
        <h5 class="card-header">
            Bạn có muốn xóa cư dân này không?
        </h5>
            <form:form method="post" action="${action}" modelAttribute="user">
                <button type="submit" class="btn btn-danger">Xóa</button>
                <form:hidden path = "id" value = "${user.id}"/>
            </form:form>
            <a type="button" class="btn btn-light" href="<c:url value="/admin/resident" />">Quay về</a>
        </div>
    </div>
</section>
