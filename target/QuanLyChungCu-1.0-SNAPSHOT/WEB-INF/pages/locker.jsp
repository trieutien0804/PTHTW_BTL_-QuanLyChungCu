
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<section class="container pt-3">
    <div class="bg-white w-100 border-bottom ">
        <div class="d-flex justify-content-between p-3">
            <c:url value="/admin/locker" var="action"/>
            <form class="d-flex" action="${action}">
                <input class="form-control me-2 rounded-pill" type="text" name="kw" value="${keyword}" placeholder="Nhập số tủ đồ" aria-label="Search">
                <button type="submit" class="rounded-pill btn-yellow">
                    <img src="<c:url value="/images/search.png"/>" alt="Avatar" class="">   
                </button>
            </form>

        </div>
    </div>
                    
    <div class="bg-white">
        <table class="table table-hover">
            <thead class="">
                <tr>
                    <th scope="col" class="text-center border-end" >Mã tủ đồ</th>
                    <th scope="col" class="text-center border-end">Tên cư dân</th>
                    <th scope="col" class="text-center border-end" >Số tủ đồ</th>
                    <th scope="col" class="text-center ">Chức năng</th>
                </tr>
            </thead>
            <tbody >
                    <c:forEach items="${lockers}" var="locker">
                        <tr class="border-bottom">
                            <div class="card" style="width: 10rem;">
                                <img src="<c:url value="/images/google.png"/>" class="card-img-top" alt="...">
                                <div class="card-body">
                                  <h5 class="card-title">Card title</h5>
                                  <a href="#" class="btn btn-primary">Go somewhere</a>
                                </div>
                            </div>
                            <td class="border-end align-content-center">${locker.id}</td>
                            <td class="border-end align-content-center">${locker.residentId.name}</td>
                            <td class="border-end align-content-center">${locker.lockerNumber}</td>
                            <td class="text-center">   
                                
                                <a href="<c:url value="/admin/addOrder/${locker.id}"/> " type="button" class="btn btn-navy rounded-pill">...</a>

                            </td>
                        </tr>
                    </c:forEach>
            </tbody>
        </table>
        <ul class="pagination ms-2">
            <c:forEach begin="1" end="${counter}" var="i">
                <c:url value="${currentUrl}" var="pageAction">
                    <c:param name="kw" value="${param.kw}" /> 
                    <c:param name="page" value="${i}" />
                </c:url>
                <li class="page-item">
                    <a class="page-link" href="${pageAction}">${i}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</section>