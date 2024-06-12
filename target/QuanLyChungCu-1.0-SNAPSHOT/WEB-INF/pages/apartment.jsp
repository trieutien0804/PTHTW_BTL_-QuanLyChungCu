<%-- 
    Document   : apartment
    Created on : May 30, 2024, 1:05:18 PM
    Author     : tien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <a href="<c:url value="/admin/addApartment"/>" type="button" class= "btn btn-navy rounded-pill">Thêm căn hộ</a>
        </div>
    </div>
    <div class="bg-white">
        <table class="table table-hover">
            <thead class="">
                <tr>
                    <th scope="col" class="text-center border-end" >Mã căn hộ</th>   
                    <th scope="col" class="text-center border-end">Số căn hộ</th>
                    <th scope="col" class="text-center border-end">Trạng thái</th>
                    <th scope="col" class="text-center ">Chức năng</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${apartments}" var="a">
                    <tr class="border-bottom">
                        <td class="border-end align-content-center">${a.id}</td>
                        <td class="border-end align-content-center">${a.apartmentNumber}</td>
                        <td class="border-end align-content-center">${a.status}</td>
                        <td class="text-center">
                            <button href="#" class="btn btn-navy up rounded-pill">Cập nhật</button>
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
                    <h5 class="modal-title fw-bold" id="updateModalLabel">Cập nhật căn hộ</h5>
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
                        <button type="submit" class="btn btn-primary rounded-pill float-end">Lưu thay đổi</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="addApartmentModal" tabindex="-1" aria-labelledby="addApartmentModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
            </div>
        </div>
    </div>


<!--    <div class="modal fade" id="addApartmentModal" tabindex="-1" aria-labelledby="addApartmentModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-center fw-bold" id="addApartmentModalLabel">Thêm căn hộ</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="addApartmentForm">
                        <div class="mb-3">
                            <label for="newApartmentNumber" class="form-label">Số căn hộ</label>
                            <input type="text" class="form-control" id="newApartmentNumber" name="newApartmentNumber" required>
                        </div>
                        <button type="submit" class="btn btn-primary rounded-pill float-end">Thêm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>-->
</section>

<script>
    document.addEventListener('DOMContentLoaded', () => {
        const updateButtons = document.querySelectorAll('.btn-navy.up'); // Lấy tất cả các nút "Cập nhật"
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

//        updateForm.addEventListener('submit', (event) => {
//            event.preventDefault();
//            // Gửi dữ liệu form đến server để cập nhật (bạn cần xử lý phần này)
//            // ... Sau khi cập nhật thành công, bạn có thể ẩn modal:
//            updateModal.hide();
//            // Cập nhật lại dữ liệu trong bảng
//        });
//        const addApartmentButton = document.querySelector('.btn-navy'); // Lấy nút "Thêm căn hộ"
//        const addApartmentModal = new bootstrap.Modal(document.getElementById('addApartmentModal'));
//        const addApartmentForm = document.getElementById('addApartmentForm');
//
//        addApartmentButton.addEventListener('click', () => {
//            addApartmentModal.show(); // Hiển thị popup khi click nút
//        });
//
//        addApartmentForm.addEventListener('submit', (event) => {
//            event.preventDefault();
//            const newApartmentNumber = addApartmentForm.newApartmentNumber.value;
//            // Gửi dữ liệu newApartmentNumber đến server để xử lý (bạn cần viết phần này ở backend)
//            // ...
//            // Sau khi thêm thành công, bạn có thể ẩn modal và cập nhật bảng:
//            // addApartmentModal.hide();
//            // // Cập nhật bảng (ví dụ: thêm một dòng mới vào bảng với số căn hộ vừa thêm)
//        });
    });
</script>