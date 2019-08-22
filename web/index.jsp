<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 11/08/2019
  Time: 04:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
  <title>Iniciar Sesión</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
  <link rel="icon" type="image/png" href="<%=path%>/vista/fotos/logo.png" />
  <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/iniciocss.css">
</head>
<script type="text/javascript">
  <c:if test="${mensaje != null}">
  alert("${mensaje}");
  </c:if>
</script>
<body>
<section>
  <form action="<%=path%>/ServletLogin" method="post">
      <br><br>
      <center>
        <label><b>Correo:</b></label><br/>
        <input class="campos" type="text" name="usuario" placeholder="Ingrese su correo" />
      </center>

    <br/>

      <center>
        <label><b>Contraseña:</b></label><br/>
        <input class="campos" type="password" name="passwd" placeholder="Ingrese su contraseña">

      </center>

    <br/>

      <center>
        <input class="boton" type="submit" value="Iniciar Sesión" name="ingresar"/>
        <br><br>
        <a href="<%=path%>/vista/jsp/administrativo/usuario/RecuperarContraseña.jsp" class="olvido"><b>¿Olvido su contraseña?</b></a>
      </center>
    <br><br>
  </form>
</section>
</body>
</html>