<%-- 
    Document   : index
    Created on : Mar 13, 2022, 7:29:22 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">DANH MUC SAN PHAM</h1>
<!-- Nap danh sach san pham (6 san pham) -->
<div class="row">
    <c:forEach items="${products}" var="p">
    <div class="col-md-4 col-sm-12">
      <div class="card">
        <img class="card-img-top" src="${p.image}" alt="${p.name}">
        <div class="card-body">
          <h4 class="card-title">${p.name}</h4>
          <p class="card-text">${p.price} VND</p>
          <a href="<c:url value="/products/${p.id}" />" class="btn btn-primary">Xem chi tiet</a>
          <a href="#" class="btn btn-danger">Them vao gio</a>
        </div>
      </div>
    </div>
    </c:forEach>
</div>

<!-- Nap danh sach san pham ban chay nhat -->
<div class="alert alert-success">
    <strong>DANH SACH SAN PHAM BAN CHAY</strong>
</div>
<div class="row">
    <c:forEach items="${topProducts}" var="p">
    <div class="col-md-4 col-sm-12">
        
        <div class="card">
          <img class="card-img-top" src="${p[3]}" alt="${p[1]}">
          <div class="card-body">
            <h4 class="card-title">${p[1]}</h4>
            <p class="card-text">${p[2]} VND</p>
            <p class="text-danger"><strong>Tong san pham ban: ${p[4]}</strong></p>
            <a href="#" class="btn btn-primary">Xem chi tiet</a>
            <a href="#" class="btn btn-danger">Them vao gio</a>
          </div>
        </div>

    </div>
    </c:forEach>
</div>
