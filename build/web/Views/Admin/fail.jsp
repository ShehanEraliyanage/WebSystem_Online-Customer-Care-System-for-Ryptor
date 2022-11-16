<%--
  Created by IntelliJ IDEA.
  User: Hirusha
  Date: 9/20/2021
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <%if (request.getAttribute("error") != null) {%>
        <h3>${error}</h3>
        <%} else {%>
        <h3>fail</h3>
        <%}%>
    </body>
</html>
