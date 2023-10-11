<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 10/11/2023
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.27/dist/sweetalert2.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <style>
        .center{
            text-align: center;

        }
        body {
            font-family: "Open Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Helvetica, Arial, sans-serif;
        }
    </style>
</head>
<body>
<%--thanh navbarr--%>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <a class="navbar-brand" href="#">Customer</a>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <form class="d-flex" action="/furama?action=search" method="post">
                        <input class="form-control me-2" type="search" placeholder="Search"
                               aria-label="Search" id="searchByName" name="searchByName">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav>
            <%--            table hiện ra màn hình--%>

            <table id="tableHouseHold" class="table table-striped table-hover table table-striped table-bordered">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã Dịch Vụ</th>
                    <th>tên dịch vụ</th>
                    <th>Diện tích</th>
                    <th>Chi phí thuê</th>
                    <th>Số người tối đa</th>
                    <th>Tên kiểu thuê</th>
                    <th>Tên loại dịch vụ</th>
                    <th>Tiêu chuẩn phòng</th>
                    <th>Các tiện nghi khác</th>
                    <th>Diện tích hồ bới</th>
                    <th>Số tâng
                    </th>

                </tr>
                </thead>
                <c:forEach items="${employees}" var="employee" varStatus="loop">
                    <tbody>
                    <tr>
                        <td><c:out value="${loop.count}"/></td>
                        <td><c:out value="${employee.getMaNhanVien()}"/></td>
                        <td><c:out value="${employee.getName()}"/></td>
                        <td><c:out value="${employee.getDate()}"/></td>
                        <td><c:out value="${employee.getCMND() }" /></td>
                        <td><c:out value="${employee.getSDT()}"/></td>
                        <td><c:out value="${employee.getEmail()}"/></td>
                        <td><c:out value="${employee.getAddress()}"/></td>
                        <td><c:out value="${employee.getSalary()}"/></td>
                        <td><c:out value="${employee.getMa_vi_tri()}"/></td>
                        <td><c:out value="${employee. getMa_trinh_do()}"/></td>
                        <td><c:out value="${employee.getMa_bo_phan()}"/></td>

                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
    </form>
</div>
</div>
</div>
</div>

<script>
    function getIdName(id,name){
        document.getElementById('idModal').value=id;
        document.getElementById('nameModal').innerText=name;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous">
</script>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<link rel="stylesheet" type="text/css" href="dist/sweetalert.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
    const params = new URLSearchParams(window.location.search);
    let number=params.get('number');
    if(number==1){
        Swal.fire(
            'Good job!',
            'success'
        )}
    else if(number==2){
        swal(text);
    }
</script>
<script>
    $(document).ready(function() {
        $('#tableHouseHold').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 6
        } );
    } );
</script>
</body>
</html>

