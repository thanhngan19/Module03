<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 10/4/2023
  Time: 1:12 PM
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

            /* additional style */
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
    <div class="parent">
        <div class="child">
            <h1>Xem chi tiết sản phẩm</h1>
            <div class="form-group">
                <label for="validationServer04"></label>
                <input type="hidden" class="form-control is-valid"id="validationServer99" placeholder="State"
                       placeholder="Last name" value="${pro.getId()}${id}"  name="id" readonly>
                <div class="invalid-feedback">
                </div>
            </div>
            <div class="form-group">
                <label for="validationServer04">Product Name </label>
                <input type="text" class="form-control is-invalid" id="validationServer04" placeholder="State"
                       required value="${pro.getName_pro()}${name_pro}" name="name_pro" readonly>
                <div class="invalid-feedback">
                </div>
            </div>
            <div class="form-group">
                <label for="validationServer04">Price</label>
                <input type="text" class="form-control is-valid"id="validationServer012" placeholder="State"
                       placeholder="Last name" value="${pro.getPrice()}${price}"  name="price" readonly>
                <div class="invalid-feedback">
                </div>
            </div>
            <div class="form-group">
                <label for="validationServer02">Quantity</label>
                <input type="text" class="form-control is-valid" id="validationServer02"
                       placeholder="Last name" value="${pro.getQuantity()}${quantity}" name="quantity" readonly>
                <div class="valid-feedback">
                </div>
            </div>

            <div class="form-group">
                <label for="validationServer04">Color</label>
                <input type="text" class="form-control is-valid" id="validationServer10"
                       placeholder="Last name"name="color" value="${pro.getColor()}${color}" readonly>
                <div class="invalid-feedback">

                </div>
            </div>
            <div class="form-group">
                <label for="validationServer04">Category</label>
                <input type="text" class="form-control is-valid" id="validationServer11"
                       placeholder="Last name"name="color" value="${pro.getCategory()}" readonly>
                <div class="invalid-feedback">

                </div>
            </div>

        </div>
    </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous">
</script>
</body>
</html>
</html>

