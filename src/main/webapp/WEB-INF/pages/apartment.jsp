<%-- 
    Document   : apartment
    Created on : May 30, 2024, 1:05:18 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>

<section class="container pt-3">
    <div class="bg-white w-100 border-bottom ">
        <div class="d-flex justify-content-between p-3">
            <c:url value="/admin/apartment" var="action"/>
            <form class="d-flex" action="${action}">
                <input class="form-control me-2 rounded-pill" type="text" name="kw" placeholder="Nhập số căn hộ" aria-label="Search">
                <button type="submit" class="rounded-pill btn-yellow">
                    <img src="<c:url value="/images/search.png"/>" alt="Avatar" class="">   
                </button>
            </form>
            <a href="<c:url value="/admin/addApartment"/>" type="button" class= "btn btn-navy up rounded-pill">Thêm căn hộ</a>
        </div>
    </div>
    <div class="bg-white">
        <table class="table table-hover">
            <thead class="">
                <tr>
                    <th scope="col" class="text-center border-end" >Mã căn hộ</th>   
                    <th scope="col" class="text-center border-end">Số căn hộ</th>
                    <th scope="col" class="text-center ">Chức năng</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${apartments}" var="a">
                    <tr class="border-bottom">
                        <td class="border-end align-content-center">${a.id}</td>
                        <td class="border-end align-content-center">${a.apartmentNumber}</td>
                        <td class="text-center">
                            <a href="#" class="btn btn-navy rounded-pill">Cập nhật</a>
                            <a type="button" class="btn btn-danger rounded-pill" href="<c:url value='/admin/deleteApartment/${a.id}'/>">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <ul class="pagination ms-2">
            <c:forEach begin="1" end="${counter}" var="i">
                <c:url value="/admin/apartment" var="pageAction">
                    <c:param name="page" value="${i}" />
                </c:url>
                <li class="page-item">
                    <a class="page-link" href="${pageAction}">${i}</a>
                </li>
            </c:forEach>


        </ul>
    </div>
</div>
</section>