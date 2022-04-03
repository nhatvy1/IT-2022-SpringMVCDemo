<%-- 
    Document   : register
    Created on : Mar 27, 2022, 7:36:36 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">DANG KY</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action" />

<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="user">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-group">
        <label for="firstname">First Name</label>
        <form:input type="text" id="firstname" path="firstName" class="form-control" />
        <form:errors path="firstName" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="lastname">Last Name</label>
        <form:input type="text" id="lastname" path="lastName" class="form-control" />
        <form:errors path="lastName" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class="form-control" />
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <form:input type="text" id="username" path="username" class="form-control" />
        <form:errors path="username" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:input type="password" id="password" path="password" class="form-control" />
        <form:errors path="password" cssClass="text-danger" />
    </div>
    <div class="form-group">
        <label for="confirm-password">Confirm Password</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control" />
    </div>
    <div class="form-group">
        <label for="avatar">Avatar</label>
        <form:input type="file" id="avatar" path="file" class="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" value="DANG KY" class="btn btn-danger" />
    </div>
</form:form>
