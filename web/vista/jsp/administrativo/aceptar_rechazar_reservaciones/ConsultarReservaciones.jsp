<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 11/08/2019
  Time: 06:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
    <title>SRE_UTEZ</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/csstablas.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/cssTooltip.css">
    <link rel="stylesheet" href="<%=path%>/vista/css/fonts.css">
    <script src="<%=path%>/vista/js/jquery.js"></script>
    <script src="<%=path%>/vista/js/main.js"></script>

</head>
<body>
<header>
    <div class="menu_bar">
        <a href="#" class="bt-menu"><img id="iconos" src="<%=path%>/vista/fotos/menu.PNG"/>Menú</a>
    </div>


    <nav>
        <ul>
            <center>
                <li><a href="<%=path%>/vista/jsp/administrativo/usuario/ConsultarDatos.jsp"><img src="<%=path%>/vista/fotos/user.png"/><br>${sessionScope.usuario.nombre} ${sessionScope.usuario.apellido_Paterno} ${sessionScope.usuario.apellido_Materno}</a></li>

                <li class="submenu">
                    <a><img src="<%=path%>/vista/fotos/siono.png"/><br>Reservaciones</a>
                    <ul class="children">
                        <li><a href="<%=path%>/ServletConsultarReservaciones?idUsuarios=${sessionScope.usuario.idUsuarios}" ><span class="icon-smile2"></span>Mis Reservaciones</a></li>
                        <li><a href="<%=path%>/ServletConsultarReservacionesGAR?Areas_idArea=${sessionScope.usuario.areas_idAreas}"><span class="icon-list"></span>Aceptar / Rechazar</a></li>
                    </ul>
                </li>
                <li>
                    <a href="<%=path%>/ServletConsultarUsuario"><img src="<%=path%>/vista/fotos/gestion.png"/><br>Gestión De Usuarios</a>
                </li>
                <li>
                    <a href="<%=path%>/ServletConsultarArea"><img src="<%=path%>/vista/fotos/area.PNG"/><br>Áreas</a>
                </li>
                <li>
                    <a href="<%=path%>/ServletConsultarEdificios"><img src="<%=path%>/vista/fotos/edificios.PNG"/><br>Edificios</a>
                </li>
                <li>
                    <a href="<%=path%>/ServletConsultarEspacios"><img src="<%=path%>/vista/fotos/espacio.PNG"/><br>Espacios</a>
                </li>
            </center>
        </ul>
    </nav>
</header>

<div>
    <nav>
        <ul>
            <li><a href="<%=path%>/ServletSalir"><span class="icon-exit"></span>Salir</a></li>
        </ul>
        <ul>
            <li><label>Sistema de Reservación de Espacios (SRE_UTEZ)</label></li>
        </ul>

    </nav>
</div>
<br>

<article>
    <fieldset>
        <legend><b>Mis Reservaciones</b></legend>
        <form action="<%=path%>/ServletRegistrarReservaciones" method="get" >
            <button class="registrar" type="submit">
                <span class="icon-pencil"></span>Registrar Reservaciones
            </button>
        </form>
        <!--<form action="">
            <button class="buscar" type="submit"><span class="icon-search"></span>Buscar</button>
            <input class="buscador" type="text" name="" placeholder="Buscar por ID">
        </form>-->
        <br><br><br>
        <center>
            <table border="5px">
                <thead>
                <tr >
                    <td>ID</td>
                    <td>Fecha/Hora Inicio</td>
                    <td>Edificio</td>
                    <td>Espacio</td>
                    <td>Area Perteneciente</td>
                    <td>Estado</td>
                    <td>Opción</td>
                </tr>

                </thead>

                <tbody>
                    <c:forEach var="res" items="${res}">
                        <tr class="fila" >
                            <td>${res.idReservaciones}</td>
                            <td>${res.fechaInicio} ${res.horarioInicio}</td>
                            <td>${res.nombreidEdificios}</td>
                            <td>${res.nombreidEspacios}</td>
                            <td>${res.nombreArea}</td>
                            <td>${res.nombreEstadoReservaciones}</td>
                            <td>
                                <center>
                                    <form action="<%=path%>/ServletReservaciones" method="post">

                                        <input type="hidden" value="conEspModificar" name="accion">
                                        <input type="hidden" value="${res.idReservaciones}" name="idReservaciones">

                                        <button type="submit" class="opcionEspacio1">
                                            <span class="icon-list"></span><span class="tooltiptext">Modificar</span>
                                        </button>

                                    </form>
                                    <form action="<%=path%>/ServletReservaciones" method="post">

                                        <input type="hidden" name="idUsuariosR" value="${sessionScope.usuario.idUsuarios}">
                                        <input type="hidden" value="eliminar" name="accion">
                                        <input type="hidden" value="${res.idReservaciones}" name="idReservaciones">

                                        <button type="submit" class="opcionEspacio2" >
                                            <span class="icon-cross"></span><span class="tooltiptext">Eliminar</span>
                                        </button>
                                    </form>
                                </center>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>

        </center>
        <br><br><br>
    </fieldset>
</article>
</body>
</html>
