<%-- 
    Document   : stats
    Created on : Apr 3, 2022, 8:04:00 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">THONG KE DOANH THU</h1>

<div class="row">
    <div class="col-md-6">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>So luong san pham</th>
            </tr>
            <c:forEach items="${catesStats}" var="c">
            <tr>
                <td>${c[0]}</td>
                <td>${c[1]}</td>
                <td>${c[2]}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6">
        <canvas id="cateChart"></canvas>
    </div>
</div>

<div class="row">
    <div class="col-md-6">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Ten san pham</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${revenueProducts}" var="p">
            <tr>
                <td>${p[0]}</td>
                <td>${p[1]}</td>
                <td>${p[2]}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6">
        <form>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Nhap tu khoa..." name="kw" />
            </div>
            <div class="form-group">
                <input type="date" class="form-control" name="fromDate" />
            </div>
            <div class="form-group">
                <input type="date" class="form-control" name="toDate" />
            </div>
            <input type="submit" value="Loc du lieu" class="btn btn-info" />
        </form>
        <canvas id="productChart"></canvas>
    </div>
</div>

<div class="row">
    <div class="col-md-6">
        <table class="table">
            <tr>
                <th>Thang</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${revenueMonth}" var="p">
            <tr>
                <td>${p[0]}</td>
                <td>${p[1]}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6">
        <form>
            <div class="form-group">
                <input type="number" min="2000" 
                       class="form-control" 
                       placeholder="Nhap name..." name="year" />
            </div>
            <input type="submit" value="Loc du lieu" class="btn btn-info" />
        </form>
        <canvas id="revenueMonthChart"></canvas>
    </div>
</div>

<div class="row">
    <div class="col-md-6">
        <table class="table">
            <tr>
                <th>Quy</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${revenueQuarter}" var="p">
            <tr>
                <td>${p[0]}</td>
                <td>${p[1]}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6">
        <form>
            <div class="form-group">
                <input type="number" min="2000" 
                       class="form-control" 
                       placeholder="Nhap name..." name="year" />
            </div>
            <input type="submit" value="Loc du lieu" class="btn btn-info" />
        </form>
        <canvas id="revenueQuarterChart"></canvas>
    </div>
</div>

<script>
    let data1=[], label1=[]
    <c:forEach items="${catesStats}" var="c">
        data1.push(${c[2]})
        label1.push('${c[1]}')
    </c:forEach>
    
    let data2=[], label2=[]
    <c:forEach items="${revenueProducts}" var="p">
        data2.push(${p[2]})
        label2.push('${p[1]}')
    </c:forEach>
        
    let data3=[], label3=[]
    <c:forEach items="${revenueMonth}" var="p">
        data3.push(${p[1]})
        label3.push(${p[0]})
    </c:forEach>
        
    let data4=[], label4=[]
    <c:forEach items="${revenueQuarter}" var="p">
        data4.push(${p[1]})
        label4.push(${p[0]})
    </c:forEach>
    
    window.onload = function() {
        let ctx1 = document.getElementById("cateChart").getContext("2d");
        let ctx2 = document.getElementById("productChart").getContext("2d");
        let ctx3 = document.getElementById("revenueMonthChart").getContext("2d");
        let ctx4 = document.getElementById("revenueQuarterChart").getContext("2d");
        drawChart(ctx1, data1, label1, "pie")
        drawChart(ctx2, data2, label2, "bar")
        drawChart(ctx3, data3, label3, "line")
        drawChart(ctx4, data4, label4, "line")
    }
</script>
