<%-- 
    Document   : bill
    Created on : Jun 12, 2024, 9:16:14 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<section class="m-3 w-100">
    <div class="bg-white w-100 border-bottom ">
        <div class="d-flex justify-content-between p-3">
            <c:url value="/admin/bill" var="action"/>
            <form class="d-flex" action="${action}">
                <input class="form-control me-2 rounded-pill" type="text" name="kw" value="${keyword}" placeholder="Nhập số loại hoá đơn" aria-label="Search">
                <button type="submit" class="rounded-pill btn-yellow">
                    <img src="<c:url value="/images/search.png"/>" alt="Avatar" class="">   
                </button>
            </form>
            <a href="<c:url value="/admin/addBill"/>" type="button" class= "btn btn-navy rounded-pill">Thêm hóa đơn</a>
        </div>
    </div>
    <div class="bg-white p-4">
        <table class="table table-hover">
            <thead class="border">
                <tr>
                    <th scope="col" class="text-center border-end" >Mã hoá đơn</th>
                    <th scope="col" class="text-center border-end">Tên cư dân</th>
                    <th scope="col" class="text-center border-end" >loại hoá đơn</th>
                    <th scope="col" class="text-center border-end" >Số tiền</th>
                    <th scope="col" class="text-center border-end">Tình trạng</th>
                    <th scope="col" class="text-center border-end">Ngày tạo HĐ</th>
                    <th scope="col" class="text-center ">Chức năng</th>
                </tr>
            </thead>
            <tbody class="border">
                <c:forEach items="${bills}" var="bill">
                    <tr class="border-bottom">
                        <td class="border-end align-content-center">${bill.id}</td>
                        <td class="border-end align-content-center">${bill.residentId.name}</td>
                        <td class="border-end align-content-center">${bill.type}</td>
                        <td class="border-end align-content-center">${bill.amount}</td>
                        <td class="border-end align-content-center">${bill.paymentStatus}</td>
                        <td class="border-end align-content-center">${bill.createdAt}</td>
                        <td class="text-center">   
<!--                            <a href="<c:url value="/admin/addBill/${bill.id}" />" class="btn btn-navy rounded-pill">Cập nhật</a>-->
                            <a type="button" class="btn btn-danger rounded-pill" href="<c:url value='/admin/deleteBill/${bill.id}'/>">Xóa</a>
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