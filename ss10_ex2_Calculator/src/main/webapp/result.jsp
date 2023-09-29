<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 9/29/2023
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Result Calculator</h1>
<p>
    Operand1: <%=request.getAttribute("operand1")%><br/>
    Operator: <%=request.getAttribute("operator")%><br/>
    Operand2: <%=request.getAttribute("operand2")%><br/>
    Result: <%=request.getAttribute("result")%><br/>
    <a href="index.jsp">Back to Calculator</a>
</p>
</body>
</html>
