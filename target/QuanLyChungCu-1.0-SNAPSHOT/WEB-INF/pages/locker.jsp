<%-- 
    Document   : locker
    Created on : Jun 3, 2024, 11:46:18 AM
    Author     : tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <div>
        <a href="<c:url value="/admin/addApartment"/>" type="button" class= "btn btn-primary mt-1">Thêm sản phẩm</a>
    </div>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Mã căn hộ</th>
                <th scope="col">Số căn hộ</th>
                <th scope="col">Trạng thái</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${apartments}" var="a">
                <tr>
                    <td>${a.id}</td>
                    <td>${a.apartmentNumber}</td>
                    <td>${a.status}</td>
                    <td>
                        <a href="#" class="btn btn-primary">Cập nhật</a>
                        <button type="button" class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
