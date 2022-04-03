<%-- 
    Document   : header
    Created on : Mar 20, 2022, 7:27:38 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">SaleApp</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
          <a class="nav-link" href="<c:url value="/" />">Trang chu</a>
      </li>
      <c:forEach items="${categories}" var="c">
        <li class="nav-item">
            <c:url value="/" var="cateUrl" >
                <c:param name="cateId" value="${c.id}" />
            </c:url>
          <a class="nav-link" href="${cateUrl}">${c.name}</a>
        </li>
      </c:forEach>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/register" />">Dang ky</a>
      </li>
    </ul>
  </div>
  <form class="form-inline" action="">
    <input class="form-control mr-sm-2" type="text" placeholder="Nhap tu khoa...">
    <button class="btn btn-success" type="submit">Tim kiem</button>
  </form>
</nav>