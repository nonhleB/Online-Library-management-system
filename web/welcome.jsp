<%-- 
    Document   : welcome.jsp
    Created on : 11 Jun 2024, 15:56:03
    Author     : nonhl
--%>

<%@page session="true"%>
<%
    String username =(String) session.getAttribute("username");
if(username == null){
response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome,<%=username%>!</h1>
        <a href="logout.jsp" >Logout</a>
    </body>
</html>