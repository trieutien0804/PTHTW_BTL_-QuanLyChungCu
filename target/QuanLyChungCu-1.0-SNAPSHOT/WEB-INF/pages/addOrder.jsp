<%-- 
    Document   : addOrder
    Created on : Jun 19, 2024, 3:08:27 PM
    Author     : ptdzu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<c:forEach items="${locker.order1Set}" var="order">
    <p class="card-text">${order.id}</p>
</c:forEach>
<!--<section class="container pt-3">
    <div class="bg-white w-100 border-bottom ">
        <div class="content-center p-3">
            <h1 class="modal-title fw-bold">Thêm đơn hàng</h1>
        </div>
        <div class=" p-3">
            
            <c:url value="/admin/addOrder" var="action"/> 
            <form:form method="post" action="${action}" modelAttribute="order"> 
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="lockerId"  placeholder="Mã cư dân" path="lockerId" />
                    <label for="name">Mã tủ đồ</label>
                    <form:errors path="lockerId" cssClass="text-danger" element="div"/>
                </div>
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="description"  placeholder="Mo ta" path="description" />
                    <label for="name">Mô tả</label>
                    <form:errors path="description" cssClass="text-danger" element="div"/>
                </div>
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="status"  placeholder="Tình trạng" path="status" />
                    <label for="name">Tinh trang</label>
                </div>

                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="createdAt"  placeholder="Thời gian thêm đơn hàng" path="createdAt" />
                    <label for="name">Thời gian thêm đơn hàng</label>
                </div>

                <div class="form-floating">
                    <button class="btn btn-navy mt-1 rounded-pill" type="submit">
                        Thêm
                    </button>
                    <a type="button" class="btn btn-light mt-1 rounded-pill" href="<c:url value="/admin/locker" />">Quay về</a>
                </div>
            </form:form>
        </div>
    </div>
</div>
</section>-->


