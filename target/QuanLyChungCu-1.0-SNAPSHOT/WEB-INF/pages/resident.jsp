<%-- 
    Document   : resident
    Created on : May 31, 2024, 2:45:16 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<section class="m-3 w-100">
    <div class="bg-white w-100 border-bottom ">
        <div class="d-flex justify-content-between p-3">

            <form class="d-flex ">
                <input class="form-control me-2 rounded-pill" type="text" name="kw" value="${keyword}" placeholder="Nhập tên cư dân" aria-label="Search">
                <button type="submit" class="rounded-pill btn-yellow">
                    <img src="<c:url value="/images/search.png"/>" alt="Avatar" class="">   
                </button>
            </form>
            <a href="<c:url value="/admin/addResident"/>" type="button" class= "btn btn-navy rounded-pill">Thêm cư dân</a>

        </div>
    </div>
    <div class="bg-white p-4">
        <table class="table table-hover">
            <thead class="border">
                <tr>
                    <th scope="col" class="text-center border-end">ID</th>
                    <th scope="col" class="text-center border-end">Name</th>   
                    <th scope="col" class="text-center border-end">Username</th>
                    <th scope="col" class="text-center border-end">Phone Number</th>
                    <th scope="col" class="text-center border-end">Email</th>
                    <th scope="col" class="text-center border-end">Căn hộ</th>
                    <th scope="col" class="text-center border-end">Tủ đồ</th>
                    <th scope="col" class="text-center ">Chức năng</th>
                </tr>
            </thead>
            <tbody class="border" >
                <c:forEach items="${residentDetails}" var="row">
                    <tr class="border-bottom">
                        <td class="border-end align-content-center">${row[0]}</td> 
                        <td class="border-end align-content-center">${row[1]}</td>
                        <td class="border-end align-content-center">${row[2]}</td>
                        <td class="border-end align-content-center">${row[3]}</td>
                        <td class="border-end align-content-center">${row[4]}</td>
                        <td class="border-end align-content-center">${row[5]}</td>
                        <td class="border-end align-content-center">${row[6]}</td>
                        <td class="text-center">
                            <a href="<c:url value="/admin/deleteUser/${row[2]}"/>" type="button" class= "btn btn-danger rounded-pill">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>        
        <ul class="pagination ms-2 justify-content-end">
            <c:forEach begin="1" end="${counter}" var="i">
                <c:url value="/admin/resident" var="pageAction">
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

