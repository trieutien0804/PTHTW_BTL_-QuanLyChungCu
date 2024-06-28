<%-- 
    Document   : addOrder
    Created on : Jun 19, 2024, 3:08:27 PM
    Author     : ptdzu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<section class="m-3 w-100">
    <div class="bg-white w-100 border-bottom ">
        <div class="bg-white w-100 border-bottom ">
            <div class="d-flex justify-content-between p-3">
                <lable class="fs-3">TỦ ĐỒ: ${locker.lockerNumber}</lable>
                <a href="<c:url value="/admin/addOrder/${locker.id}"/>" type="button" class= "btn btn-navy rounded-pill">Thêm đơn hàng mới</a>
            </div>
        </div>
    </div>
    <div class="bg-white p-5 d-flex flex-wrap custom-row justify-content-between">
        <c:forEach items="${locker.order1Set}" var="order1">
            <div class="col-12 col-md-4">
                <div class="card" style="width: 20rem;">
                    <div class="card-body">
                        <p class="card-text">Mã đơn hàng: ${order1.id}</p>
                        <p class="card-text">Mô tả: ${order1.description   }</p>
                        <p class="card-text">Tình trạng:
                            <c:choose>
                                <c:when test="${order1.status == 'Chưa nhận hàng'}">
                                    <span class="text-danger">${order1.status}</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="text-success">${order1.status}</span>
                                </c:otherwise>
                            </c:choose>
                        </p>
                        <p class="card-text">Tạo lúc: ${order1.createdAt}</p>
                        <c:choose>
                            <c:when test="${order1.status == 'Chưa nhận hàng'}">
                                <a type="button" href="<c:url value="/admin/confirmTakeOrder/${order1.id}" />" class="btn btn-gold">Xác nhận nhận hàng</a>
                            </c:when>
                        </c:choose>
                        
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</section>