<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>

<section class="m-3 w-100">
    <div class="bg-white w-100 border-bottom ">
        <div class="content-center p-3">
            <h1 class="modal-title fw-bold">Thêm câu hỏi</h1>
        </div>
        <div class=" p-3">
            <c:url value="/admin/addQuestion" var="action" />
            <form:form method="post" action="${action}" modelAttribute="question">
                <div class="form-floating mb-3">
                    <form:input class="form-control"  id="content"  placeholder="Câu hỏi" path="content" />
                    <label for="name">Nội dung câu hỏi</label>
                    <form:errors path="content" cssClass="text-danger" element="div"/>
                </div>
                <div class="form-floating mb-3">
                    <label for="name">Ma khao sat</label>
                    <form:input class="form-control"  id="surveyId"  placeholder="Mã khao sat" path="surveyId" value="${surveyId}" readonly="true"/>
                </div>
                
                <div class="form-floating">
                    <button class="btn btn-navy mt-1 rounded-pill" type="submit">Thêm
                    </button>
                    <a type="button" class="btn btn-light mt-1 rounded-pill" href="<c:url value="/admin/surveyQuestion/${surveyId}"/>" >Quay về</a>
                </div>
            </form:form>
        </div>
    </div>  
</section>