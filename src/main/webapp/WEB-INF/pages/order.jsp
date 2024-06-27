<%-- 
    Document   : addOrder
    Created on : Jun 19, 2024, 3:08:27 PM
    Author     : ptdzu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<div class="section">
    <h1>TỦ ĐỒ: ${locker.lockerNumber}</h1>
    <a href="<c:url value="/admin/addOrder/${locker.id}"/>" type="button" class= "btn btn-navy rounded-pill">Thêm đơn hàng mới</a>
    <div class="row">
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
                        <a type="button" href="<c:url value="/admin/confirmTakeOrder/${order1.id}" />" class="btn btn-primary">Xác nhận nhận hàng</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>