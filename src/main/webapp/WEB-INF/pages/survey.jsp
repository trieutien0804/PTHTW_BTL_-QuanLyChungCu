<%-- 
    Document   : resident
    Created on : May 31, 2024, 2:45:16 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<section class="m-3 w-100">
    <div class="bg-white w-100 border-bottom ">
        <div class="d-flex justify-content-between p-3">
            <c:url value="/admin/survey" var="action"/>
            <form class="d-flex" action="${action}">
                <input class="form-control me-2 rounded-pill" type="text" name="kw" value="${keyword}" placeholder="Nhập mô tả" aria-label="Search">
                <button type="submit" class="rounded-pill btn-yellow">
                    <img src="<c:url value="/images/search.png"/>" alt="Avatar" class="">   
                </button>
            </form>
            <a href="<c:url value="/admin/addSurvey"/>" type="button" class= "btn btn-navy rounded-pill">Thêm khảo sát</a>
        </div>          
    </div>
    <div class="bg-white p-4">
        <table class="table table-hover">
            <thead class="border">
                <tr>
                    <th scope="col" class="text-center border-end" >Mã khảo sát</th>   
                    <th scope="col" class="text-center border-end">Tiêu đề</th>
                    <th scope="col" class="text-center border-end">Mô tả</th>
                    <th scope="col" class="text-center border-end">Thời gian</th>
                    <th scope="col" class="text-center ">Chức năng</th>
                </tr>
            </thead>
            <tbody class="border">
                <c:forEach items="${surveys}" var="s">
                    <tr class="border-bottom">
                        <td class="border-end align-content-center">${s.id}</td>
                        <td class="border-end align-content-center">${s.title}</td>
                        <td class="border-end align-content-center">${s.description}</td>
                        <td class="border-end align-content-center">${s.createdAt}</td>
                        <td class="text-center">
                            <a href="#" class="btn btn-navy rounded-pill">Cập nhật</a>
                            <a href="<c:url value="/admin/surveyQuestion/${s.id}"/>" class="btn btn-navy rounded-pill">Xem</a>
                            <button type="button" class="btn btn-danger rounded-pill">Xóa</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>        
</section>
