<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 15/08/2019
  Time: 05:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesión</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/iniciocss.css">
</head>
<body>
<section>
    <form action="<%=path%>/ServletLogin" method="post">
        <h4 align="center" style="background: #59cec9;"><br>Se enviará un correo electrónico para realizar el cambio de contraseña <br><br></h4>
        <br><br>
        <form action="<%=path%>/ServletEnviarCorreo" method="post">
            <center>
                <label><b>Correo:</b></label><br/>
                <input class="campos" type="email" name="Correo" placeholder="Ingrese su correo">
            </center>
        </form>
        <br/>
        <form>
            <center>
                <input class="boton" type="submit" value="Enviar" name="ingresar"/><br><br>
            </center>
        </form>
    </form>
</section>
</body>
</html>
