<%-- 
    Document   : bill
    Created on : Jun 12, 2024, 9:16:14 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="<c:url value="/admin/addBill"/>" type="button" class= "btn btn-navy rounded-pill">Thêm hóa đơn</a>
<c:forEach items="${bills}" var="bill">
    ${bill.type}
</c:forEach>