<%-- 
    Document   : deleteApartment
    Created on : Jun 11, 2024, 9:13:46 PM
    Author     : tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/deleteApartment" var="action" />
<form:form method="post" action="${action}" modelAttribute="apartment">
    <button type="submit">Delete</button>
    <form:hidden path = "id" value = "${apartment.id}"/>
</form:form>
