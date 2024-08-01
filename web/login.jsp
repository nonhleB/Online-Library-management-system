<%-- 
    Document   : login.jsp
    Created on : 11 Jun 2024, 15:55:51
    Author     : nonhl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
    </head>
    <style>
        td{
            padding: 10px;
        }
        div{
            width:50%;
            border: 1px solid black;
            border-radius: 5px;
            background-color: magenta;
            
                
        }
        body{
            background-size: cover;
            background-image:URL('https://thumbs.dreamstime.com/z/flat-young-people-read-exchange-borrow-books-library-bookcrossing-book-concept-group-reading-women-men-bookshop-261416924.jpg')
        }
        
    </style>
    <body>
    <center> <h1>Login Here</h1></center>
    <center>
        <div>
            <img src="https://creazilla-store.fra1.digitaloceanspaces.com/icons/3499139/emblem-person-purple-icon-md.png" width="200" height="100" alt="alt"/>
            <table>
                <tr>
            
        <form action="login"method="post">
            
            <td >Username:</td>
            <td><input type="text"class="form-control" name="username" placeholder="username"> </td>
        </tr>
            <br>
            <tr>
            <td>Password:</td>
            <td> <input type="password"class="form-control" name="password" placeholder="password"> </td> <br>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input type="submit"class="btn btn-success" value="Login"></td>
                    </tr>
            </table>
                    </form>
        </div>
    </center>
    </body>
</html>
