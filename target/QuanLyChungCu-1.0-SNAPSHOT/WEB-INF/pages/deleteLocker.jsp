
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/deleteLocker" var="action" />
<section class="m-3 w-100">
    <div class="card">
        <h5 class="card-header">
            Bạn có muốn xóa tủ đồ này không?
        </h5>
        <div class="card-body">
            <form:form method="post" action="${action}" modelAttribute="locker">
                <button type="submit" class="btn btn-danger">Xóa</button>
                <form:hidden path = "id" value = "${locker.id}"/>
            </form:form>
            <a type="button" class="btn btn-light" href="<c:url value="/admin/locker" />">Quay về</a>
        </div>
    </div>
</section>