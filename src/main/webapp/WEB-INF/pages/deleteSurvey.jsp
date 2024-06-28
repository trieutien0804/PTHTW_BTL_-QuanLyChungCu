<%-- 
    Document   : deleteSurvey
    Created on : Jun 6, 2024, 2:06:10 PM
    Author     : tien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/deleteSurvey" var="action" />
${survey.id}
<form:form method="post" action="${action}" modelAttribute="survey">
    <button type="submit">Delete</button>
    <form:hidden path = "id" value = "${survey.id}"/>
</form:form>    
