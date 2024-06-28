<%-- 
    Document   : addOrder
    Created on : Jun 27, 2024, 10:54:10 AM
    Author     : tien
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>

<section class="m-3 w-100">
    <div class="bg-white w-100 border-bottom ">
        <div class="content-center p-3">
            <h1 class="modal-title fw-bold">Thêm đơn hàng</h1>
        </div>
        <div class=" p-3">
            <c:url value="/admin/addOrder" var="action" />
            <form:form method="post" action="${action}" modelAttribute="order">
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="description"  placeholder="Mô tả đơn hàng" path="description" />
                    <label for="name">Mô tả đơn hàng</label>
                </div>
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="lockerId"  placeholder="Mã cư dân" path="lockerId" value="${lockerId}" readonly="true"/>
                    <label for="name">Mã tủ đồ</label>
                </div>
                <div class="form-floating">
                    <button class="btn btn-navy mt-1 rounded-pill" type="submit">Thêm</button>
                    <a type="button" class="btn btn-light mt-1 rounded-pill" href="<c:url value="/admin/order/${lockerId}"/>">Quay về</a>
                </div>
            </form:form> 
        </div>
    </div>
</section>
