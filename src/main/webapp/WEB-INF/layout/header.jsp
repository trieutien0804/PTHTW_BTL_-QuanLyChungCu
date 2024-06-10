<%-- 
    Document   : header
    Created on : May 23, 2024, 3:57:59 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/header.css" />" rel="stylesheet"/>
<nav class="navbar navbar-expand-sm custom-navbar " >

    <div class="d-flex justify-content-between p-2 w-100">
        <div class="rounded content-center">
            <img src="<c:url value="/images/menu.png"/>" alt="Avatar" class="ms-2">   
        </div>
        <div class="navbar-header content-center me-auto">
            <a class="word-main"  href="">T&D Building Admin</a>
        </div>

        <ul class="nav navbar-nav navbar-right me-3">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="content-center">
                    <a href="<c:url value="/login" />" class="btn btn-warning text-white">Đăng nhập</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="content-center me-auto">
                    <a class="navbar-brand text-warning" href="#">Xin chào ${pageContext.request.userPrincipal.name}</a>

                </li>
                <li class="content-center me-auto">
                    <a href="<c:url value="/logout" />" class="btn btn-outline-light">Đăng xuất</a>
                </li>
            </c:if>
        </ul>    
    </div>

</nav>


