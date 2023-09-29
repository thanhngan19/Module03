<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="post">
    <table>
        <tr>
            <td>First operand: </td>
            <td>
                <input type="text" name="operand1" placeholder="First operand">
            </td>
        </tr>
        <tr>
            <td>Operator: </td>
            <td>
                <select name="operator">
                    <option value="+">Addition</option>
                    <option value="-">Subtraction</option>
                    <option value="*">Multiplication</option>
                    <option value="/">Division</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Second operand:</td>
            <td>
                <input type="text" name="operand2" placeholder="Second operand">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" id="submit" value="Calculate">
            </td>
        </tr>
    </table>
</form>
</body>
</html>