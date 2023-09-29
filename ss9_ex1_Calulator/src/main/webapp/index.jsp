<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Discount Caculator</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <style>
        input {
            padding: 5px;
            margin: 5px;
        }
    </style>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form method="post" action="/display-discount">
    <input type="text" name="description" placeholder="Product Discription"><br/>
    <input type="number" name="price" placeholder="List Price"><br/>
    <input type="number" name="discount" placeholder="Discount Percent"><br/>
    <input type="submit" value="Caculate Discount">
</form>
</body>
</html>