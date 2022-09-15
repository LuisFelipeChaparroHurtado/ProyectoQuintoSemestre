<%-- 
    Document   : login
    Created on : 23/11/2021, 08:15:55 PM
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/stylesLogin.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Estonia&display=swap" rel="stylesheet">
        <title>JSP Page</title>
    </head>

    <body>
        <div class="lines">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <strong><label style="color: #ffffff; margin-top: 23%; margin-left: 48%; font-size: 2.5rem">WELCOME SUPERMARKET WEB</label></strong>
        </div>
        <div class="container col-lg-3" style="width: 30%; height: 78%">

            <form action="faces/index.xhtml">
                <div class="form-group text-center">
                    <br>
                    <img src="user.png" height="80" width="80"/>
                    <br>
                    <br>
                    <label style="font-size: 25px"><strong>SIGN IN</strong></label>
                    
                </div>
                <div class="form-group">
                    <strong><label>NAME:</label></strong>
                    <input itemtype="104668.png" class="form-control" type="text" name="txtnom" placeholder="Enter your Name">
                </div>
                <div class="form-group">
                    <strong><label>PASSWORD:</label></strong>
                    <input type="password" name="txtPass" placeholder="Enter your password" class="form-control">
                </div>
                <br>
                <input style="background-color: #388fd6; border-color: #388fd6"class="btn btn-danger btn-block" type="submit" name="accion" value="LOGIN">

            </form>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
