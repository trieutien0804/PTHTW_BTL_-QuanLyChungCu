<%-- 
    Document   : resident
    Created on : May 31, 2024, 2:45:16 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<section class="container pt-3">
    <div class="bg-white w-100 border-bottom ">
        <div class="d-flex justify-content-between p-3">
            <form class="d-flex ">
                <input class="form-control me-2 rounded-pill" type="search" placeholder="Nhập số căn hộ" aria-label="Search">
                <div class="rounded-pill btn-yellow">
                    <img src="<c:url value="/images/search.png"/>" alt="Avatar" class="">   
                </div>
            </form>
            <a href="<c:url value="/admin/addApartment"/>" type="button" class= "btn btn-navy rounded-pill">Thêm khảo sát</a>
        </div>
    </div>
    <div class="bg-white">
        <table class="table table-hover">
            <thead class="">
                <tr>
                    <th scope="col" class="text-center border-end" >Mã khảo sát</th>   
                    <th scope="col" class="text-center border-end">Tiêu đề</th>
                    <th scope="col" class="text-center border-end">Mô tả</th>
                    <th scope="col" class="text-center border-end">Thời gian</th>
                    <th scope="col" class="text-center ">Chức năng</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${surveys}" var="s">
                    <tr class="border-bottom">
                        <td class="border-end align-content-center">${s.id}</td>
                        <td class="border-end align-content-center">${s.title}</td>
                        <td class="border-end align-content-center">${s.description}</td>
                        <td class="border-end align-content-center">${s.createdAt}</td>
                        <td class="text-center">
                            <a href="#" class="btn btn-navy rounded-pill">Cập nhật</a>
                            <button type="button" class="btn btn-danger rounded-pill">Xóa</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="updateModalLabel" aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content rounded">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateModalLabel">Cập nhật khảo sát</h5>
                    <button type="button" class="btn-close " data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="updateForm">
                        <c:url value="/admin/addSurvey" var="action" />
                        <form:form method="post" action="${action}" modelAttribute="newSurvey">
                        <input type="hidden" id="surveyId" name="surveyId">
                        <div class="mb-3">
                            <label for="surveyTitle" class="form-label">Tiêu đề</label>
                            <form:input id="surveyTitle" path="title" class="form-control" />
                            
                        </div>
                        <div class="mb-3">
                            <label for="surveyDesc" class="form-label">Mô tả</label>
                            <form:input id="surveyDesc" path="description" class="form-control" />
                            
                        </div>
                        
                        <button type="submit" class="btn btn-navy rounded-pill float-end">Lưu thay đổi</button>
                        </form:form>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--<section class="container">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Mã khảo sát</th>
                <th scope="col">Tiêu đề</th>
                <th scope="col">Mô tả</th>
                <th scope="col">Thời gian tạo</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:url value="/admin/addSurvey" var="action" />
            <form:form method="post" action="${action}" modelAttribute="newSurvey">
            <tr>
                <td>...</td>
                <td><form:input id="surveyTitle" path="title" class="form-control" /></td>
                <td><form:input id="surveyDesc" path="description" class="form-control" /></td>
                <td>...</td>
                <td>
                    <button type="submit" class="btn btn-primary">Thêm</button>
                </td>
            </tr>
            </form:form>

            <c:forEach items="${surveys}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.title}</td>
                    <td>${s.description}</td>
                    <td>${s.createdAt}</td>
                    <td>
                        <a type="button" href="<c:url value="/admin/surveyQuestion/${s.id}"/>" class="btn btn-primary">Chi tiết</a>
                        <a type="button" class="btn btn-danger" href="<c:url value='/admin/deleteSurvey/${s.id}'/>">Xoa</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>-->
<script>
    document.addEventListener('DOMContentLoaded', () => {
        const updateButtons = document.querySelectorAll('.btn-navy'); // Lấy tất cả các nút "Cập nhật"
        const updateModal = new bootstrap.Modal(document.getElementById('updateModal'));
        const updateForm = document.getElementById('updateForm');

        updateButtons.forEach(button => {
            button.addEventListener('click', (event) => {
                event.preventDefault(); // Ngăn chặn hành vi mặc định của liên kết

                const row = button.closest('tr');
                const surveyId = row.cells[0].textContent; 
                const surveyTitle = row.cells[1].textContent;
                const surveyDesc = row.cells[2].textContent;

                updateForm.surveyId.value = surveyId;
                updateForm.surveyTitle.value = surveyTitle;
                updateForm.surveyDesc.value = surveyDesc;

                updateModal.show(); 
            });
        });

        updateForm.addEventListener('submit', (event) => {
            event.preventDefault();
            updateModal.hide();
        });
    });
</script>