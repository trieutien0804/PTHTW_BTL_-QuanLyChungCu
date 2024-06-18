<%-- 
   Document   : addApartment
   Created on : May 30, 2024, 2:57:17 PM
   Author     : tien
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>

<section class="container pt-3">
    <div class="bg-white w-100 border-bottom ">
        <div class="content-center p-3">
            <h1 class="modal-title fw-bold">Thêm tủ đồ</h1>
        </div>
        <div class=" p-3">
            <c:url value="/admin/addLocker" var="action" />
            <form:form method="post" action="${action}" modelAttribute="locker">
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="lockerNumber"  placeholder="Số tủ đồ" path="lockerNumber" />
                    <label for="name">Số tủ đồ</label>
                    <form:errors path="lockerNumber" cssClass="text-danger" element="div"/>
                </div>
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="residentId"  placeholder="Mã cư dân" path="residentId" />
                    <label for="name">Mã cư dân</label>
                    <form:errors path="residentId" cssClass="text-danger" element="div"/>
                </div>
                <div class="form-floating">
                    <button class="btn btn-navy mt-1 rounded-pill" type="submit">
                        <c:choose>
                            <c:when test="${locker.id > 0}"> Cập nhật</c:when>
                            <c:otherwise> Thêm tủ đồ</c:otherwise>
                        </c:choose>
                    </button>
                    <form:hidden path="id" />
                    <a type="button" class="btn btn-light mt-1 rounded-pill" href="<c:url value="/admin/locker" />">Quay về</a>
                </div>
            </form:form>
        </div>
    </div>
</section>