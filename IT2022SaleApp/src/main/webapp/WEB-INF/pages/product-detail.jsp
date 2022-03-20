<%-- 
    Document   : product-detail
    Created on : Mar 20, 2022, 9:34:28 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">CHI TIET SAN PHAM</h1>
<div class="row">
    <div class="col-md-4 col-xs-6">
        <img src="${p.image}" class="img-fluid" />
    </div>
    <div class="col-md-8 col-xs-6">
        <h1>${p.name}</h1>
        <p>${p.description}</p>
        <h3>${p.price} VND</h3>
        <div>
            <input type="button" value="Them vao gio" class="btn btn-danger" />
        </div>
    </div>
</div>

<div>
    <div class="form-group">
        <textarea class="form-control" id="content" 
                  placeholder="Nhap noi dung binh luan"></textarea>
    </div>
    <div>
        <input type="button" 
               onclick="addComment(${p.id})"
               value="Them binh luan" 
               class="btn btn-info" />
    </div>

</div>

<script>
    <c:url value="/api/comments" var="url" />

    function addComment(productId) {
        fetch("${url}", {
            method: "post",
            body: JSON.stringify({
                "content": document.getElementById("content").value,
                "productId": productId
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
//            if (res.status == 201)
                return res.json();
//            else
//                alert("Something wrong!!!");
        }).then(data => {
            console.info(data)
            //moment(1647747535380).locale('vi').fromNow()
        })

    }
</script>

