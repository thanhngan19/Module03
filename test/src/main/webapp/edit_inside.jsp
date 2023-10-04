<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.27/dist/sweetalert2.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        .center {
            text-align: center;

        }

        body {
            font-family: "Open Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Helvetica, Arial, sans-serif;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Product</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <form class="d-flex" action="/product?action=search" method="post">
                        <input class="form-control me-2" type="search" placeholder="Search"
                               aria-label="Search" id="searchByName" name="searchByName">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav>
            <%--            table hiện ra màn hình--%>
            <form action="/product?action=update&id=${seHouse.getId()}" method="post">
                <table id="tableHouseHold" class="table table-striped table-hover table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Pro Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Color</th>
                        <th>Category</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <c:forEach items="${findAll}" var="household" varStatus="loop">
                        <c:if test="${household.getId()==seHouse.getId()}">
                            <tbody>
                            <tr>
                                <td><c:out value="${loop.count}"/></td>
                                <td><input type="text" class="form-control is-invalid" id="validationServer04"
                                           placeholder="State"
                                           required value="${seHouse.getName_pro()}${name_pro}" name="name_pro"></td>
                                <td><input type="text" class="form-control is-valid" id="validationServer012"
                                           placeholder="State"
                                           placeholder="Last name" value="${seHouse.getPrice()}${price}" name="price">
                                </td>
                                <td><input type="text" class="form-control is-valid" id="validationServer02"
                                           placeholder="Last name" value="${seHouse.getQuantity()}${quantity}"
                                           name="quantity" required></td>
                                <td><input type="text" class="form-control is-valid" id="validationServer10"
                                           placeholder="Last name" name="color" value="${seHouse.getColor()}${color}">
                                </td>
                                <td><select class="form-control" name="category" id="category">
                                    <c:forEach items="${ret}" var="ret">
                                        <option value="${ret}">${ret}</option>
                                    </c:forEach>
                                </select></td>
                                <td>
                                    <button type="submit" class="btn btn-primary">EDIT</button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#exampleModal"
                                            onclick="getIdName('${household.getId()}','${household.getName_pro()}')">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                            </tbody>
                        </c:if>
                        <tbody>
                        <tr>
                            <td><c:out value="${loop.count}"/></td>
                            <td><c:out value="${household.getName_pro()}"/></td>
                            <td><c:out value="${household.getPrice()}"/></td>
                            <td><c:out value="${household.getQuantity()}"/></td>
                            <td><c:out value="${household.getColor() }"/></td>
                            <td><c:out value="${household.getCategory()}"/></td>
                            <td>
                                <button type="submit" class="btn btn-primary">EDIT</button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#exampleModal"
                                        onclick="getIdName('${household.getId()}','${household.getName_pro()}')">Delete
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </form>
        </div>
        <div class="center">
            <a href="/product?action=showFormCreate" role="button" class="btn btn-primary ">Add new Pro</a>
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">

                    <form action="/product?action=delete" method="post">

                        <div class="modal-header">
                            <h5 class="modal-title">Xóa học viên</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" id="idModal" name="id">
                            are you sure?
                            <span class="text-danger" id="nameModal"></span>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                            <button type="submit" class="btn btn-primary">delete</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
        function getIdName(id, name) {
            document.getElementById('idModal').value = id;
            document.getElementById('nameModal').innerText = name;
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
        let number = params.get('number');
        if (number == 1) {
            Swal.fire(
                'Good job!',
                'success'
            )
        } else if (number == 2) {
            swal(text);
        }
    </script>
    <script>
        $(document).ready(function () {
            $('#tableHouseHold').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 6
            });
        });
    </script>
</body>
</html>
