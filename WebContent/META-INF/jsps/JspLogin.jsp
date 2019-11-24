<%@ page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/orange.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="home">
        <div class="right-side">
            <div class="brand">
                <img class="brand-logo" src="img/logo.png">
            </div>
            <form class="sign-in" action="/TP_JEE/login" method="POST">
                <div class="form-group">
                    <label class="oleo-label" for="username">Username</label>
                    <input class="form-control rounded-input" type="text" name="username" placeholder="Username">
                </div>
                <div class="form-group">
                    <label class="oleo-label" for="password">Password</label>
                    <input type="password" class="form-control rounded-input" name="password" placeholder="Password">
                </div>
                <input class="btn btn-gradient btn-sub" type="submit" value="Login"/>
            </form>
        </div>
    </div>
</body>
</html>
