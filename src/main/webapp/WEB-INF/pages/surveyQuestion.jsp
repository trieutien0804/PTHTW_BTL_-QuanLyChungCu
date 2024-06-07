<%-- 
    Document   : surveyQuestion
    Created on : Jun 7, 2024, 12:29:30 AM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Mã câu hỏi</th>
                <th scope="col">Nội dung</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${questions}" var="q">
                <tr>
                    <td>${q.id}</td>
                    <td>${q.content}</td>
                    <td>
                        <a href="#" class="btn btn-primary">Cập nhật</a>
                        <button type="button" class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
