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
        <section class="vh-100 bg-theme-color">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-9 col-lg-6 col-xl-5">
                        <img src="<c:url value="/images/logo-name.png"/>"
                             class="img-fluid" alt="Sample image">
                    </div>
                            <div class="col-md-8 col-lg-6 col-xl-4 bg-white p-4 rounded-9 shadow">
                        <c:url value="/login" var="action" />
                        <form method="post" action="${action}"> 

                            <h1 class="text-gold text-center fw-bold">ĐĂNG NHẬP</h1>

                            <div data-mdb-input-init class="form-outline mb-4 mt-3">
                                <label class="form-label a text-navy" for="username">Tài khoản</label>
                                <input id="username" name="username" class="form-control form-control-lg rounded-9"
                                       placeholder="Nhập tên đăng nhập" />                                
                            </div>

                            <div data-mdb-input-init class="form-outline mb-3">
                                <label class="form-label text-navy fs-6" for="password">Mật khẩu</label>
                                <input type="password" name="password" id="password" class="rounded-9 form-control form-control-lg"
                                       placeholder="Mật khẩu của bạn" />
                            </div>
                            <c:if test="${param.error != null}">
                                <div class="text-danger">
                                    Vui lòng nhập thông tin chính xác!
                                </div>
                            </c:if>
                            <div class="d-flex justify-content-end">
                                <div class="text-lg-start mt-4 pt-2">
                                    <button  type="submit" data-mdb-button-init data-mdb-ripple-init class="rounded-9 btn btn-gold btn-lg"
                                             style="padding-left: 2.5rem; padding-right: 2.5rem;">Đăng nhập</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>

