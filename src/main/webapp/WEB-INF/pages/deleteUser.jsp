<%-- 
    Document   : deleteUser
    Created on : Jun 27, 2024, 11:30:56 PM
    Author     : tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/deleteUser" var="action" />
<section class="container p-3 d-flex justify-content-center ">
    <div class="card">
        <h5 class="card-header">
            Bạn có muốn xóa cư dân này không?
        </h5>
        <div class="p-3 d-flex justify-content-end g-5 align-items-end">
            <form:form method="post" action="${action}" modelAttribute="user">
                <button type="submit" class="btn btn-danger me-3 rounded-pill">Xóa</button>
                <form:hidden path = "id" value = "${user.id}"/>
            </form:form>
            <a type="button" class="btn btn-light  rounded-pill" href="<c:url value="/admin/resident" />">Quay về</a>
        </div>
    </div>
</section>
