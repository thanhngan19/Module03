<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <style>
        table {
            border-collapse: separate;
            border-spacing: 0;
        }
        th, td {
            border-bottom: 1px solid darkgray;
            width: 100px;
            font-size: 10px;
            text-align: center;
        }
        img {
            width: auto;
            height: 50px;
            object-fit: contain;
        }
    </style>
</head>
<body>
<c:out></c:out>
<h1>Danh sách khách hàng</h1>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <tr>
        <td>Mai Văn Hoàn</td>
        <td>1983-08-20</td>
        <td>Hà Nội</td>
        <td>
            <img src="https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxjb2xsZWN0aW9uLXBhZ2V8MXw3NjA4Mjc3NHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=900&q=60">
        </td>
    </tr>
    <tr>
        <td>Mai Văn Hoàn</td>
        <td>1983-08-20</td>
        <td>Hà Nội</td>
        <td>
            <img src="https://images.unsplash.com/photo-1581824043583-6904b080a19c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxjb2xsZWN0aW9uLXBhZ2V8Mnw3NjA4Mjc3NHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=900&q=60">
        </td>
    </tr>

</table>
</body>
</html>