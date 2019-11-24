<%@page import="com.example.app.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <%User u =(User) application.getAttribute("oneUser"); %>
<title><%=u.getUsername() %></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/orange.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.1/semantic.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.semanticui.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/dataTables.semanticui.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.1/semantic.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" style="background-color: #fff !important; box-shadow: #bbb 5px 0px 5px;">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="/TP_JEE/home"><img class="ovg-logo" src="../img/logo.png" width="100px"></a>
            <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
                <li class="nav-item">
                    <form action="/TP_JEE/logout" method="POST">
                        <input type="submit" class="btn btn-gradient" alt="log out" value =<%= session.getAttribute("login")%>>
                    </form>
                </li>
            </ul>
        </div>
    </nav>
    <div class="content-sm">
    <img class="profile-avatar" src="<%=u.getPhoto() %>"/>
        <div class="form-group">
            <label class="oleo-label" for="username">Username</label>
            <input class="form-control rounded-input" type="text" name="username" placeholder="Username" value="<%=u.getUsername() %>" disabled>
        </div>
        <div class="form-group">
            <label class="oleo-label" for="username">Firstname</label>
            <input class="form-control rounded-input" type="text" name="firstname" placeholder="firstname" value="<%=u.getFirstname() %>" disabled>
        </div>
        <div class="form-group">
            <label class="oleo-label" for="username">Lastname</label>
            <input class="form-control rounded-input" type="text" name="lastname" placeholder="lastname" value="<%=u.getLastname() %>" disabled>
        </div>
        <div class="form-group">
            <label class="oleo-label" for="username">Address</label>
            <input class="form-control rounded-input" type="text" name="address" placeholder="address" value="<%=u.getAddress() %>" disabled>
        </div>
        <div class="form-group">
            <label class="oleo-label" for="username">Phone</label>
            <input class="form-control rounded-input" type="text" name="phone" placeholder="phone" value="<%=u.getPhone() %>" disabled>
        </div>
        <div class="form-group">
            <label class="oleo-label" for="username">Mail</label>
            <input class="form-control rounded-input" type="text" name="mail" placeholder="mail" value="<%=u.getEmail() %>" disabled>
        </div>
        <form action=/TP_JEE/update/<%=u.getId()%> method="POST">
            <input type="hidden" name="id" value=<%=u.getId()%>>
            <input type="submit" class="btn btn-gradient full-width" alt="update" value="Edit">
         </form>
    </div>

</body>
</html>
