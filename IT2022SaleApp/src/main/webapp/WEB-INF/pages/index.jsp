<%-- 
    Document   : index
    Created on : Mar 13, 2022, 7:29:22 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chu</title>
    </head>
    <body>
        <h1>Hello ${message}!</h1>
        <ul>
            <c:forEach items="${categories}" var="c">
                <li>${c.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>
