<%-- 
    Document   : surveyQuestion
    Created on : Jun 7, 2024, 12:29:30 AM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<section class="m-3 w-100">
    <div class="bg-white p-4">
        <a href="<c:url value="/admin/addQuestion/${surveyId}"/>" type="button" class= "btn btn-navy rounded-pill">Thêm câu hỏi</a>
        <table class="table">
            
            <thead class="border">
                <tr>
                    <th scope="col" class="text-center border-end">Mã câu hỏi</th>
                    <th scope="col" class="text-center border-end">Nội dung</th>
                    <th scope="col" class="text-center ">Chức năng</th>
                    <th></th>
                </tr>
            </thead>
            <tbody class="border">
                <c:forEach items="${questions}" var="q">
                    <tr>
                        <td class="border-end align-content-center">${q.id}</td>
                        <td class="border-end align-content-center">${q.content}</td>
                        <td class="text-center">
                            <a href="#" class="btn btn-primary">Cập nhật</a>
                            <button type="button" class="btn btn-danger">Xóa</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>      
</section>
