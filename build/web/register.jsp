<%-- 
    Document   : register.jsp
    Created on : 11 Jun 2024, 15:55:35
    Author     : nonhl
--%>


       <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
    </head>
    <style>
    
     td{
            padding: 10px;
        }
        div{
            width:50%;
            border: 1px solid black;
            border-radius: 5px;
            background-color: pink;
                
        }
        body{
            background-image: url('https://th.bing.com/th/id/OIP.D01G-sF4EsB-qTf-_u347gHaF-?w=1000&h=807&rs=1&pid=ImgDetMain')
        }
        </style>
    <body>
        
    <center> <h1>Register</h1></center>
    <center>
        <div>
            <table>
                <tr>
        <form action="register" method="post">
            <td>Username:</td>
            <td><input type="text"class="form-control"name="username"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" class="form-control"name="password"></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text"class="form-control"name="name"></td>
                     </tr>
                        <tr>
                            <td>Surname:</td>
                         <td><input type="text"class="form-control"name="surname"></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align:center"> <input type="Submit" class="btn btn-success" value="Register"></td>
                    </tr>
                    </table>
        </form>
        </div>
    </center>
    </body>
</html>
