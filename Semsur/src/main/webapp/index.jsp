<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Semsur</title>
</head>
<body>
<h1>Login</h1>
<form action="ServletLogin" method="post">

<input name="login" type="text"> <br>
<input name="senha" type="password"> <br>

<input type="submit" value="Enviar">

</form>
<h4>${msg}</h4>
</body>
</html>