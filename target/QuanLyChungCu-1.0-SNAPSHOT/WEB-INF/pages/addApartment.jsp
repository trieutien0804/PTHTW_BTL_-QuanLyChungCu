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
            <h1 class="modal-title fw-bold">Thêm căn hộ</h1>
        </div>
        <div class=" p-3">
            <c:url value="/admin/addApartment" var="action" />
            <form:form method="post" action="${action}" modelAttribute="apartment">
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="apartmentNumber"  placeholder="Số căn hộ" path="apartmentNumber" />
                    <label for="name">Số căn hộ</label>
                    <form:errors path="apartmentNumber" cssClass="text-danger" element="div"/>
                </div>
                <div class="form-floating">
                    <button class="btn btn-navy mt-1 rounded-pill" type="submit">
                        <c:choose>
                            <c:when test="${apartment.id > 0}"> Cập nhật</c:when>
                            <c:otherwise> Thêm căn hộ</c:otherwise>
                        </c:choose>
                    </button>
                    <form:hidden path="id" />
                    <a type="button" class="btn btn-light mt-1 rounded-pill" href="<c:url value="/admin/apartment"/>" >Quay về</a>
                </div>
            </form:form>
        </div>
    </div>
</section>