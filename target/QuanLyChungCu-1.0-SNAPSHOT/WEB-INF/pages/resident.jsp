<%-- 
    Document   : resident
    Created on : May 31, 2024, 2:45:16 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<section class="container pt-3">
    <div class="bg-white w-100 border-bottom ">
        <div class="d-flex justify-content-between p-3">

            <form class="d-flex ">
                <input class="form-control me-2 rounded-pill" type="search" placeholder="Nhập tên cư dân" aria-label="Search">
                <div class="rounded-pill btn-yellow">
                    <img src="<c:url value="/images/search.png"/>" alt="Avatar" class="">   
                </div>
            </form>
            <a href="<c:url value="/admin/addResident"/>" type="button" class= "btn btn-navy rounded-pill">Thêm cư dân</a>

        </div>
    </div>
    <div class="bg-white">
        <table class="table table-hover">
            <thead class="">
                <tr>
                    <th scope="col" class="text-center border-end">ID</th>
                    <th scope="col" class="text-center border-end">Name</th>   
                    <th scope="col" class="text-center border-end">Username</th>
                    <th scope="col" class="text-center border-end">Phone Number</th>
                    <th scope="col" class="text-center border-end">Email</th>
                    <th scope="col" class="text-center border-end">Căn hộ</th>
                    <th scope="col" class="text-center border-end">Tủ đồ</th>
                    <th scope="col" class="text-center ">Chức năng</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${residentDetails}" var="row">
                    <tr class="border-bottom">
                        <td class="border-end align-content-center">${row[0]}</td> 
                        <td class="border-end align-content-center">${row[1]}</td>
                        <td class="border-end align-content-center">${row[2]}</td>
                        <td class="border-end align-content-center">${row[3]}</td>
                        <td class="border-end align-content-center">${row[4]}</td>
                        <td class="border-end align-content-center">${row[5]}</td>
                        <td class="border-end align-content-center">${row[6]}</td>
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
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="updateModalLabel">Cập nhật căn hộ</h5>
                    <button type="button" class="btn-close " data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="updateForm">
                        <input type="hidden" id="apartmentId" name="apartmentId">
                        <div class="mb-3">
                            <label for="apartmentNumber" class="form-label">Số căn hộ</label>
                            <input type="text" class="form-control" id="apartmentNumber" name="apartmentNumber">
                        </div>
                        <div class="mb-3">
                            <label for="status" class="form-label">Trạng thái</label>
                            <input type="text" class="form-control" id="status" name="status">
                        </div>
                        <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--<script>
    document.addEventListener('DOMContentLoaded', () => {
        const updateButtons = document.querySelectorAll('.btn-primary'); // Lấy tất cả các nút "Cập nhật"
        const updateModal = new bootstrap.Modal(document.getElementById('updateModal'));
        const updateForm = document.getElementById('updateForm');

        updateButtons.forEach(button => {
            button.addEventListener('click', (event) => {
                event.preventDefault(); // Ngăn chặn hành vi mặc định của liên kết

                const row = button.closest('tr');
                const apartmentId = row.cells[0].textContent; // Lấy mã căn hộ từ ô đầu tiên
                const apartmentNumber = row.cells[1].textContent;
                const status = row.cells[2].textContent;

                updateForm.apartmentId.value = apartmentId;
                updateForm.apartmentNumber.value = apartmentNumber;
                updateForm.status.value = status;

                updateModal.show(); // Hiển thị modal
            });
        });

        updateForm.addEventListener('submit', (event) => {
            event.preventDefault();
            // Gửi dữ liệu form đến server để cập nhật (bạn cần xử lý phần này)
            // ... Sau khi cập nhật thành công, bạn có thể ẩn modal:
            updateModal.hide();
            // Cập nhật lại dữ liệu trong bảng
        });
    });
</script>-->

