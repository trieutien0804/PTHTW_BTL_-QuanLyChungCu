<%-- 
    Document   : sidebar
    Created on : Jun 8, 2024, 10:55:40 PM
    Author     : ptdzu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="<c:url value="/css/sidebar.css" />" rel="stylesheet"/>

<div class="header-box px-2 pt-3 pb-3 d-flex justify-content-between  border-bot">
    <div class="d-flex align-items-center fs-4">
        <div class="rounded me-2">
            <img src="<c:url value="/images/user.png"/>" alt="Avatar" class="rounded-circle me-2 ms-2">   
            <span class="text-black me-2">${pageContext.request.userPrincipal.name}</span>
        </div>
    </div>

</div>

<ul class="list-unstyled  text-dark " style="margin-bottom: 0">

    <li class="border-bot">
        <a href="<c:url value="/admin/apartment"/>" class="text-decoration-none px-3 py-2 d-block">
            <i class="fal fa-home"></i> Căn hộ
        </a>
    </li>   
    <li class="border-bot">
        <a href="<c:url value="/admin/resident"/>" class="text-decoration-none px-3 py-2 d-block">
            <i class="fal fa-list"></i>Cư dân
        </a>
    </li>

    <li class="border-bot">
        <a href="<c:url value="/admin/bill"/>" class="text-decoration-none px-3 py-2 d-block d-flex justify-content-between">
            <span><i class="fal fa-comment"></i> Hoá đơn</span>
            <!--            <span class="bg-dark rounded-pill text-white py-0 px-2">02</span>-->
        </a>
    </li>

    <li class="border-bot">
        <a href="<c:url value="/admin/survey"/>" class="text-decoration-none px-3 py-2 d-block">
            <i class="fal fa-envelope-open-text"></i> Khảo sát
        </a>
    </li>
    <li class="border-bot">
        <a href="<c:url value="/admin/locker"/>" class="text-decoration-none px-3 py-2 d-block">
            <i class="fal fa-users"></i>Tủ đồ
        </a>
    </li>

    <li class="border-bot">
        <a href="<c:url value="/admin/feedback"/>" class="text-decoration-none px-3 py-2 d-block">
            <i class="fal fa-users"></i>Đánh giá
        </a>
</ul>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        $(".sidebar ul li").on('click', function () {
            $(".sidebar ul li.active").removeClass('active');
            $(this).addClass('active');
        });

        $('.open-btn').on('click', function () {
            $('.sidebar').addClass('active');

        });


        $('.close-btn').on('click', function () {
            $('.sidebar').removeClass('active');

        });
    });
</script>