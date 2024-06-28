<%-- 
    Document   : confirmTakeOrder
    Created on : Jun 27, 2024, 12:06:29 PM
    Author     : tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>

<section class="m-3 w-100">
    <div class="bg-white w-100 border-bottom ">
        <div class="content-center p-3">
            <h1 class="modal-title fw-bold">Cập nhật trạng thái đơn hàng</h1>
        </div>
        <div class=" p-3">
            <c:url value="/admin/confirmTakeOrder/${order.id}" var="action" />
            <form:form method="post" action="${action}" modelAttribute="order">
                <div class="form-floating">
                    <button class="btn btn-navy mt-1 rounded-pill" type="submit">Xác nhận đã nhận hàng</button>
                </div>
            </form:form> 
        </div>
    </div>
</section>
