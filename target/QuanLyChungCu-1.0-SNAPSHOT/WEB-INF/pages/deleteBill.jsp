<%-- 
    Document   : deleteApartment
    Created on : Jun 11, 2024, 9:13:46 PM
    Author     : tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/deleteBill" var="action" />
<section class="container p-3 d-flex justify-content-center">
    <div class="card w-50">
        <h5 class="card-header">
            Bạn có muốn xóa hoá đơn này không?
        </h5>
        <div class="p-3 d-flex justify-content-end g-5">
            <form:form method="post" action="${action}" modelAttribute="bill">
                <button type="submit" class="btn btn-danger me-3 rounded-pill">Xóa</button>
                <form:hidden path = "id" value = "${bill.id}"/>
            </form:form>
            <a type="button" class="btn btn-light rounded-pill" href="<c:url value="/admin/bill" />">Quay về</a>
        </div>
    </div>
</section>
