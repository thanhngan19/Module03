<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 10/6/2023
  Time: 8:46 PM
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
<form action="/furama?action=createEmployee" method="post">
    <div class="parent">
        <div class="child">
            <h1>Thêm Employee</h1>
            <div class="form-group">
                <label for="validationServer04">Họ và tên</label>
                <input type="text" class="form-control is-invalid" id="validationServer04" placeholder="State"
                       required  name="nameEmployee">
                <div class="form-group">
                    <label for="validationServer04">Ngày Sinh</label>
                    <input type="date" class="form-control is-valid"id="validationServer012" placeholder="State"
                           placeholder="Last name"   name="date">
                </div>
                <div class="form-group">
                    <label for="validationServer02">Số CMND</label>
                    <input type="text" class="form-control is-valid" id="validationServer02"
                           placeholder="Last name"  name="CMND" required>
                </div>
                <div class="form-group">
                    <label for="validationServer04">Salary</label>
                    <input type="text" class="form-control is-valid" id="validationServer10"
                           placeholder="Last name"name="salary"  >
                </div>
                <div class="form-group">
                    <label for="validationServer02">Số điên thoại</label>
                    <input type="text" class="form-control is-valid" id="validationServer2"
                           placeholder="Last name"name="SDT" required>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Email</label>
                    <input type="text" class="form-control is-valid" id="validationServer"
                           placeholder="Last name"name="email" required>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Địa chỉ</label>
                    <input type="text" class="form-control is-valid" id="validationServer0"
                           placeholder="Last name"name="address" required>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Vị trí</label>
                    <select class="form-control" id="exampleFormControlSelect1" name="vi_tri">
                        <c:forEach items="${viTri}" varStatus="loop" var="vt">
                            <option value="${vt}"><c:out value="${vt}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Trình độ</label>
                    <select class="form-control" id="exampleFormControlSelect11" name="trinh_do">
                        <c:forEach items="${trinhDo}" varStatus="loop" var="vt">
                            <option value="${vt}"><c:out value="${vt}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="validationServer02">Bộ phậni</label>
                    <select class="form-control" id="exampleFormControlSelect122" name="bo_phan">
                        <c:forEach items="${boPhan}" varStatus="loop" var="vt">
                            <option value="${vt}"><c:out value="${vt}"/></option>
                        </c:forEach>
                    </select>
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
