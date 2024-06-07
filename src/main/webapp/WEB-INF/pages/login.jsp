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
        <link href="<c:url value="/css/login.css" />" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>  
        <section class="vh-100">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-9 col-lg-6 col-xl-5">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
                             class="img-fluid" alt="Sample image">
                    </div>
                    <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                        <c:url value="/login" var="action" />
                        <form method="post" action="${action}">
                            <!-- Email input -->
                            <h1>Đăng nhập</h1>

                            <div data-mdb-input-init class="form-outline mb-4 mt-3">
                                <label class="form-label a" for="username">Tài khoản</label>
                                <input id="username" name="username" class="form-control form-control-lg"
                                       placeholder="Nhập tên đăng nhập" />                                
                            </div>

                            <!-- Password input -->
                            <div data-mdb-input-init class="form-outline mb-3">
                                <label class="form-label" for="password">Mật khẩu</label>
                                <input type="password" name="password" id="password" class="form-control form-control-lg"
                                       placeholder="Mật khẩu của bạn" />
                            </div>
                            <c:if test="${param.error != null}">
                                <div class="text-danger">
                                    Vui lòng nhập thông tin chính xác!
                                </div>
                            </c:if>

                            <div class="text-center text-lg-start mt-4 pt-2">
                                <button  type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg"
                                         style="padding-left: 2.5rem; padding-right: 2.5rem;">Đăng nhập</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>

