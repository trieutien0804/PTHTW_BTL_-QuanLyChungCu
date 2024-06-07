<%-- 
    Document   : header
    Created on : May 23, 2024, 3:57:59 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/header.css" />" rel="stylesheet"/>
<nav class="navbar navbar-expand-sm">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Chung cư ABC</a>
        </div>
        <ul class="navbar-nav me-auto">
            <li class="active nav-item"><a href="<c:url value="/admin/apartment"/>" class="nav-link">Căn hộ</a></li>
            <li><a class="nav-link" href="<c:url value="/admin/resident"/>">Cư dân</a></li>
            <li><a class="nav-link" href="#">Hóa đơn</a></li>
            <li><a class="nav-link" href="<c:url value="/admin/survey"/>">Khảo sát</a></li>
            <li><a class="nav-link" href="#">Tủ đồ</a></li>
            <li><a class="nav-link" href="#">Đánh giá</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li>
                    <a href="<c:url value="/login" />" class="btn btn-primary">Đăng nhập</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li>
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Xin chào ${pageContext.request.userPrincipal.name}</a>
                    </div>
                </li>
                <li>
                    <a href="<c:url value="/logout" />" class="btn btn-outline-light">Đăng xuất</a>
                </li>
            </c:if>
        </ul>    
    </div>
</nav>
