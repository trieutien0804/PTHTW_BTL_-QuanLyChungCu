<%-- 
    Document   : deleteApartment
    Created on : Jun 11, 2024, 9:13:46 PM
    Author     : tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/deleteApartment" var="action" />

<div class="card">
    <h5 class="card-header">
        Bạn có muốn xóa căn hộ này không?
    </h5>
    <div class="card-body">
        <p class="card-title">Những dữ liệu liên quan dưới đây cũng sẽ bị xóa</p>
        <c:forEach items="${apartment.residentSet}" var="residents">
            <p class="card-text">${residents.name}</p>
        </c:forEach>
   
        <form:form method="post" action="${action}" modelAttribute="apartment">
            <button type="submit" class="btn btn-danger">Xóa</button>
            <form:hidden path = "id" value = "${apartment.id}"/>
        </form:form>
        <a type="button" class="btn btn-light" href="<c:url value="/admin/apartment" />">Quay về</a>
    </div>
</div>
