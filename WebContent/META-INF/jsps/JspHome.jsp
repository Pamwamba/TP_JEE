<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.example.app.entities.User"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/orange.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.3.1/semantic.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.semanticui.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css" />
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
            <a class="navbar-brand" href="/TP_JEE/home"><img class="ovg-logo" src="img/logo.png" width="100px"></a>
            <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
                <li class="nav-item">
                    <form action="/TP_JEE/logout" method="POST">
                        <input type="submit" class="btn btn-gradient" alt="log out" value =<%= session.getAttribute("login")%>>
                    </form>
                </li>
            </ul>
        </div>
    </nav>
    <div class="content">

        <table id="myTable" class="ui celled table" style="width:100%">
        <thead>
            <tr>
                <th>Select</th>
                <th>Username</th>
                <th>Photo</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <%Map<Integer, User> userlist = new HashMap<Integer, User>();
        userlist.putAll((Map<Integer, User>) application.getAttribute("USERS"));
        %>
        <%
        for(Map.Entry<Integer, User> u : userlist.entrySet()) {

            %>
            <tr>
                <td>
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id=<%=u.getValue().getId()%>>
                    </div>
                </td>
                <td><%=u.getValue().getUsername()%></td>
                <td><%=u.getValue().getPhoto()%></td>
                <td><%=u.getValue().getFirstname()%></td>
                <td><%=u.getValue().getLastname()%></td>
                <td><%=u.getValue().getAddress()%></td>
                <td><%=u.getValue().getPhone()%></td>
                <td><%=u.getValue().getEmail()%></td>
                <td>
                    <form action=/TP_JEE/show/<%=u.getValue().getId()%> method="POST">
                        <input type="hidden" name="id" value=<%=u.getValue().getId()%>>
                        <input type="submit" class="btn btn-gradient" alt="Show" value="Show">
                     </form>
                </td>
            </tr>
            <%
        } %>
        </tbody>
        <tfoot>
            <tr>
                <th>Select</th>
                <th>Username</th>
                <th>Photo</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
        </tfoot>
        </table>

    </div>
    <div class="fixed-action-btn horizontal" style="bottom: 45px; right: 24px;">
    <a class="btn-floating btn-large red">
      <i class="large material-icons">add</i>
    </a>
  </div>
    <script type="text/javascript">
    $(document).ready( function () {
        $('#myTable').DataTable();
    } );
    </script>
</body>
</html>
