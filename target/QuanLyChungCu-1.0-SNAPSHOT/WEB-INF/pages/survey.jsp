<%-- 
    Document   : resident
    Created on : May 31, 2024, 2:45:16 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="container">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Mã khảo sát</th>
                <th scope="col">Tiêu đề</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Thời gian tạo</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:url value="/admin/addSurvey" var="action" />
            <form:form method="post" action="${action}" modelAttribute="newSurvey">
            <tr>
                <td>...</td>
                <td><form:input id="surveyTitle" path="title" class="form-control" /></td>
                <td><form:input id="surveyDesc" path="description" class="form-control" /></td>
                <td>...</td>
                <td>
                    <button type="submit" class="btn btn-primary">Thêm</button>
                </td>
            </tr>
            </form:form>

            <c:forEach items="${surveys}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.title}</td>
                    <td>${s.description}</td>
                    <td>${s.createdAt}</td>
                    <td>
                        <a type="button" href="<c:url value="/admin/surveyQuestion/${s.id}"/>" class="btn btn-primary">Chi tiết</a>
                        <a type="button" class="btn btn-danger" href="<c:url value='/admin/deleteSurvey/${s.id}'/>">Xoa</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>