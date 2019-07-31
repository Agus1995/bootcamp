<%--
  Created by IntelliJ IDEA.
  User: STI
  Date: 02/04/2019
  Time: 13.35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>

    <form action="/customerlist" method="POST">
        <label> Nama : </label>
        <input type="text" name="nama" id="nama">
        <label>Alamat</label>
        <input type="text" name="alamat" id="alamat">
        <input type="submit">
    </form>
</body>
</html>
