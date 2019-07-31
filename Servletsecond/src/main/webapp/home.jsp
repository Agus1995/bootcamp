<%--
  Created by IntelliJ IDEA.
  User: STI
  Date: 03/04/2019
  Time: 20.42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Cookie[] cks = request.getCookies();
        if (cks != null){
            for (int i = 0; i<cks.length; i++){
                String name = cks[i].getName();
                String value = cks[i].getValue();
                if (name.equals("auth")){
                    break;
                }
                if (i == (cks.length - 1)){
                    response.sendRedirect("sesexp.jsp");
                    return;
                }
                i++;
            }
        }else {
            response.sendRedirect("sesexp.jsp");
            return;
        }
    %>
    <h3>You had successfully logged in.</h3>
    <br> your session is set to expire in 10min
    <br> try reloading after 10 min
    <br>
    <form action="Logout" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
