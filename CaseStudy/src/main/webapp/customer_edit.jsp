<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 10/11/2023
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <link type="text/css"
          href="cssui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .parent {

            width: 100vw;
            height: 100vh;

            display: flex;
            justify-content: center;
            align-items: center;
        }

        .child {
            width: 750px;
            height: 750px;
        }

    </style>
</head>
<body>
<form action="/furama?action=update" method="post">
    <div class="parent">
        <div class="child">
            <h1>Thêm Employee</h1>
            <div class="form-group">
                <label >Mã Khách Hàng</label>
                <input type="text" class="form-control is-invalid" id="validationServer222" placeholder="State"
                       readonly  name="maKh" value="${customer.getMaKH()}"></div>
            <div class="form-group">

                <label for="exampleFormControlSelect1">Loại khách hàng</label>
                <select class="form-control" id="exampleFormControlSelect1" name="tenLkh">
                    <c:forEach items="${tenLkh}" varStatus="loop" var="tenLkh">
                        <option value="${tenLkh}"><c:out value="${tenLkh}"/></option>
                    </c:forEach>
                </select>
        </div>
            <div class="form-group">
                <label >Ngày Sinh</label>
                <input type="date" class="form-control is-valid"id="validationServer012" placeholder="State"
                       placeholder="Last name"   name="date">
            </div>
            <div class="form-group">
                <label for="validationServer02">Họ và tên</label>
                <input type="text" class="form-control is-valid" id="validationServer02"
                       placeholder="Last name"  name="name" required value="${customer.getName()}">
            </div>
            <div class="form-group">
                <label >Giới Tính</label>
                <input type="radio"
                        name="gender" value="0">Nam
                <input type="radio"
                        name="gender" value="1">Nữ
            </div>
            <div class="form-group">
                <label for="validationServer02">Cmnd</label>
                <input type="text" class="form-control is-valid" id="validationServer2"
                       placeholder="Last name"name="cmnd" required value="${customer.getCmnd()}">
            </div>
            <div class="form-group">
                <label for="validationServer02">Số điện thoại</label>
                <input type="text" class="form-control is-valid" id="validationServer"
                       placeholder="Last name"name="sdt" required value="${customer.getSdt()}">
            </div>
            <div class="form-group">
                <label for="validationServer02">Địa chỉ</label>
                <input type="text" class="form-control is-valid" id="validationServer0"
                       placeholder="Last name"name="address" required value="${customer.getAddress()}">
            </div>
            <div class="form-group">
                <label for="validationServer02">Email</label>
                <input type="text" class="form-control is-valid" id="validationServer0111"
                       placeholder="Last name"name="email" required value="${customer.getEmail()}">

            </div>

            <div class="center">
                <button type="submit" class="btn btn-primary">ADD</button>
            </div>
        </div>
    </div>
    </div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous">
</script>
</body>
</html>
</html>


