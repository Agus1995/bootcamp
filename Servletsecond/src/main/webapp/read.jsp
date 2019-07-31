<%@ page import="com.bootcamp.Customer" %><%--
  Created by IntelliJ IDEA.
  User: STI
  Date: 02/04/2019
  Time: 13.57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
/*
        Customer customer = (Customer)request.getAttribute("customer");
        out.print(customer.getNama());
        out.print(customer.getAlamat());
*/

        out.print(request.getAttribute("data"));
    %>
</body>
</html>
