<%-- 
    Document   : index
    Created on : May 21, 2024, 9:03:10 AM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <h1>Hello World!</h1>
    <ul>
        <c:forEach items="${apartments}" var="p">
            <li>${p.id} - ${p.apartmentNumber} - ${p.status}</li>
            </c:forEach>
    </ul>
</body>
