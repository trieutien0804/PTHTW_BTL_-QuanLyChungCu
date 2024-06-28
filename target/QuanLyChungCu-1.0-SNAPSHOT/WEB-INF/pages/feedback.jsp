<%-- 
    Document   : feedback
    Created on : Jun 12, 2024, 9:38:17 PM
    Author     : tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>

<section class="m-3 w-100">
    <div class="bg-white w-100 border-bottom ">
        <div class="d-flex justify-content-between p-3">
            <c:url value="/admin/feedback" var="action"/>
            <form class="d-flex" action="${action}">
                <input class="form-control me-2 rounded-pill" type="text" name="kw" value="${keyword}" placeholder="Nhập số căn hộ" aria-label="Search">
                <button type="submit" class="rounded-pill btn-yellow">
                    <img src="<c:url value="/images/search.png"/>" alt="Avatar" class="">   
                </button>
            </form>
        </div>
    </div>
    <div class="bg-white p-4">
        <table class="table table-hover">
            <thead class="border">
                <tr>
                    <th scope="col" class="text-center border-end" >Mã đánh giá</th>   
                    <th scope="col" class="text-center border-end">Người đánh giá</th>
                    <th scope="col" class="text-center border-end">Nôi dung</th>
                    <th scope="col" class="text-center border-end">Trạng thái</th>
                    <th scope="col" class="text-center border-end">Ngày đánh giá</th>
                    <th scope="col" class="text-center ">Chức năng</th>
                </tr>
            </thead>
            <tbody class="border" >
                <c:forEach items="${feedback}" var="f">
                    <tr class="border-bottom">
                        <td class="border-end align-content-center">${f.id}</td>
                        <td class="border-end align-content-center">${f.residentId.name}</td>
                        <td class="border-end align-content-center">${f.content}</td>
                        <td class="border-end align-content-center">${f.status}</td>
                        <td class="border-end align-content-center">${f.createdAt}</td>
                        
                        <td class="text-center">   
                            <a href="<c:url value="/admin/addFeeback/${f.id}" />" class="btn btn-navy rounded-pill">Cập nhật</a>
                            <a type="button" class="btn btn-danger rounded-pill" href="<c:url value='/admin/deleteFeedback/${f.id}'/>">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <ul class="pagination ms-auto justify-content-end">
            <c:forEach begin="1" end="${counter}" var="i">
                <c:url value="${currentUrl}" var="pageAction">
                    <c:param name="kw" value="${param.kw}" /> 
                    <c:param name="page" value="${i}" />
                </c:url>
                <li class="page-item">
                    <a class="page-link" href="${pageAction}">${i}</a>
                </li>
            </c:forEach>
        </ul>
    </div>

</section>