
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/css/pages.css"/>" rel="stylesheet"/>
<section class="m-3 w-100">
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
                    
    <div class="bg-white d-flex flex-wrap custom-row custom-col justify-content-center p-3">
        <table class="table table-hover">
            <thead class="">
                
            </thead>
            <tbody >        
                    <c:forEach items="${lockers}" var="locker">
                        <tr class="border-bottom">
                            <div class="card" style="width: 10rem;">
                                <img src="<c:url value="/images/lockernew.png"/>" class="card-img-top" alt="...">
                                <div class="bg-gray card-body d-flex align-items-center justify-content-between">
                                    <div class="d-inline-block">
                                        <h5 class="card-text fw-bold">${locker.lockerNumber}</h5>
                                    </div>      
                                    <div class="d-inline-block">
                                        <a href="<c:url value="/admin/order/${locker.id}"/>" class="btn btn-gold rounded-circle">...</a>
                                    </div>
                                </div>
                            </div>          
                        </tr>
                    </c:forEach>
            </tbody>
        </table>
        <ul class="pagination ms-auto">
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