<%-- 
    Document   : addBill
    Created on : Jun 14, 2024, 10:58:38 AM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container pt-3">
    <div class="bg-white w-100 border-bottom ">
        <div class="content-center p-3">
            <h1 class="modal-title fw-bold">Thêm hóa đơn</h1>
        </div>
        <div class=" p-3">
            <c:url value="/admin/addBill" var="action" />
            <form:form method="post" action="${action}" modelAttribute="bill">
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="residentId"  placeholder="Mã cư dân" path="residentId" />
                    <label for="name">Mã cư dân</label>
                </div>
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="type"  placeholder="Loại hóa đơn" path="type" />
                    <label for="name">Loại hóa đơn</label>
                    <form:errors path="type" cssClass="text-danger" element="div"/>
                </div>
                    <div class="form-floating mb-3">
                    <form:input class="form-control"  id="amount"  placeholder="Số tiền" path="amount" />
                    <label for="name">Số tiền</label>
                </div>
                <div>
                    <div class="form-floating mb-3">
                    <form:input class="form-control"  id="dueDate"  placeholder="Ngày đáo hạn" path="dueDate" />
                    <label for="name">Ngày đáo hạn</label>
                </div>
                <div>
                    <div class="form-floating mb-3">
                    <form:input class="form-control"  id="paymentMethod"  placeholder="Phương thức thanh toán" path="paymentMethod" />
                    <label for="name">Phương thức thanh toán</label>
                </div>
                <div>
                    <div class="form-floating mb-3">
                    <form:input class="form-control"  id="paymentStatus"  placeholder="Tình trạng" path="paymentStatus" />
                    <label for="name">Tình trạng</label>
                </div>
                <div>
                    <div class="form-floating mb-3">
                    <form:input class="form-control"  id="createdAt"  placeholder="Ngày tạo háo đơn" path="createdAt" />
                    <label for="name">Ngày tạo hoá đơn</label>
                </div>              
                <div class="form-floating">
                    <button class="btn btn-navy mt-1 rounded-pill" type="submit">
                        <c:choose>
                            <c:when test="${bill.id > 0}"> Cập nhật</c:when>
                            <c:otherwise> Thêm hóa đơn</c:otherwise>
                        </c:choose>
                    </button>
                    <form:hidden path="id" />
                    <a type="button" class="btn btn-light mt-1 rounded-pill" href="<c:url value="/admin/bill" />">Quay về</a>
                </div>
            </form:form>
        </div>
    </div>
</section>

