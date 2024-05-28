<%-- 
    Document   : header
    Created on : May 23, 2024, 3:57:59 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Chung cư ABC</a>
        </div>
        <ul class="navbar-nav me-auto">
            <li class="active nav-item"><a href="#" class="nav-link">Trang Chủ</a></li>
            <li><a class="nav-link" href="#">Cư dân</a></li>
            <li><a class="nav-link" href="#">Căn hộ</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li>
                    <a href="<c:url value="/login" />" class="btn btn-outline-light">Đăng nhập</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li>
                    <a href="#" class="btn btn-outline-light">${pageContext.request.userPrincipal.name}</a>
                </li>
                <li>
                    <a href="<c:url value="/logout" />" class="btn btn-outline-light">Đăng xuất</a>
                </li>
            </c:if>
        </ul>    
    </div>
</nav>
