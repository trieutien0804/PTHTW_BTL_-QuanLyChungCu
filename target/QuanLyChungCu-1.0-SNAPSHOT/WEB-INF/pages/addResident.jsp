<%-- 
    Document   : addResident
    Created on : May 31, 2024, 3:29:25 PM
    Author     : tien
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/addResident" var="action" />
<form:form method="post" action="${action}" modelAttribute="addResident">
    <h1 class="text-center text-info mt-1">Thêm cư dân</h1>
    <div class="form-floating mb-3 mt-3">
        <form:input path="user.username" class="form-control" id="username" placeholder="Username" />
        <label for="username">Username</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input path="user.password" class="form-control" id="password" placeholder="Password" />
        <label for="password">Password</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input path="resident.name" class="form-control" id="name" placeholder="Name" />
        <label for="name">Name</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input path="resident.phoneNumber" class="form-control" id="phoneNumber" placeholder="Phone Number" />
        <label for="phoneNumber">Phone Number</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input path="resident.email" class="form-control" id="email" placeholder="Email" />
        <label for="email">Email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select id="apartmentId" name="apartment" path="resident.apartmentId" class="form-select">
            <c:forEach items="${availableApartments}" var="a">
                <option value="${a.id}">${a.apartmentNumber}</option>
            </c:forEach>
        </form:select>
        <label for="email">Select list (Select one):</label>
    </div>
    <div class="form-floating mb-3 mt-3"> 
        <form:input path="locker.lockerNumber" class="form-control" id="lockerNumber" placeholder="Locker Number" />
        <label for="lockerNumber">Locker Number</label>
    </div>
    <button type="submit">Thêm cư dân</button>
</form:form>