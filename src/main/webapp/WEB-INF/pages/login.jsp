<%-- 
    Document   : login
    Created on : May 24, 2024, 6:49:50 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chung cư ABC - Đăng nhập</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>   
        <div class="container">
            <h1 style="padding: 10px 0">FORM ĐĂNG NHẬP</h1>
            <c:if test="${param.error != null}">
                <div class="alert alert-danger">
                    Đã có lỗi xảy ra! Vui lòng quay lại sau.
                </div>
            </c:if>

            <c:url value="/login" var="action" />

            <form method="post" action="${action}">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="type" id="username" name="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="type" id="password" name="password" class="form-control"/>
                </div>
                <div style="padding-top: 15px" class="form-group">
                    <input type="submit" value="Đăng nhập"/>
                </div>
            </form>
        </div>
    </body>
</html>