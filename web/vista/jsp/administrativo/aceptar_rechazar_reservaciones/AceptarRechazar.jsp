<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 11/08/2019
  Time: 06:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>

<c:if test="${sessionScope.usuario.tipo_usuario_idTipoUsuario == null} || ${sessionScope.usuario.tipo_usuario_idTipoUsuario != 'Tpu_00'} && ${sessionScope.usuario.tipo_usuario_idTipoUsuario != 'Tpu_01'}">
    <script>
        window.location.href = "<%=path%>/";
    </script>
</c:if>

<!DOCTYPE html>
<html>
<head>
    <title>SRE_UTEZ</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <link rel="stylesheet" href="<%=path%>/vista/css/fonts.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/csstablas.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/cssTooltip.css">
    <script type="text/javascript" src=" http://code.jquery.com/jquery-latest.js"></script>
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
                        <li><a href="<%=path%>/ServletConsultarReservaciones?idUsuariosR=${sessionScope.usuario.idUsuarios}" ><span class="icon-smile2"></span>Mis Reservaciones</a></li>
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
        <legend><b>Aceptar / Rechazar Reservaciones</b></legend>
        <br>
        <form action="" >
            <button class="registrar">
                <a href="consultar_reservaciones.html"><span class="icon-pencil"></span>Consultar Reservaciones</a>
            </button>
        </form>

        <!--<form action="">
            <button class="buscar" type="submit"><span class="icon-search"></span>Buscar</button>
            <input class="buscador" type="text" name="" placeholder="Buscar por ID">
        </form>-->

        <br><br>
        <center>

            <br/>
            <table border="5px">
                <thead>
                <tr>
                    <td>Nombre</td>
                    <td>Edificio</td>
                    <td>Espacio</td>
                    <td>Fecha/Hora Inicio</td>
                    <td>Estado</td>
                    <td>Opción</td>
                </tr>

                </thead>

                <tbody>
                    <c:forEach var="resG" items="${resG}">
                        <tr class="fila" >
                            <td>${resG.nombreUsuarios} ${resG.apellidoPaterno} ${resG.apellidoMaterno}</td>
                            <td>${resG.nombreEdificio}</td>
                            <td>${resG.nombreEspacio}</td>
                            <td>${resG.fechaInicio} ${resG.horarioInicio}</td>
                            <td>${resG.nombreEstadoReservacion}</td>
                            <td>
                                <center>
                                    <form>

                                        <button type="submit" class="opcion1">
                                            <span class="icon-checkmark"></span><span class="tooltiptext">Detalles</span>
                                        </button>

                                    </form>

                                    <c:if test="${resG.idEstadoReservacion == 3}">
                                        <form action="<%=path%>/ServletReservaciones" method="post">

                                            <input type="hidden" name="Areas_idArea" value="${sessionScope.usuario.areas_idAreas}">
                                            <input type="hidden" value="AcepRech" name="accion">
                                            <input type="hidden" value="${resG.idReservaciones}" name="idReservaciones">
                                            <input type="hidden" value="Aceptar" name="AcepRechV">

                                            <button type="submit" class="opcion1">
                                                <span class="icon-checkmark"></span><span class="tooltiptext">Aceptar</span>
                                            </button>

                                        </form>
                                        <form action="<%=path%>/ServletReservaciones" method="post">

                                            <input type="hidden" name="Areas_idArea" value="${sessionScope.usuario.areas_idAreas}">
                                            <input type="hidden" value="AcepRech" name="accion">
                                            <input type="hidden" value="${resG.idReservaciones}" name="idReservaciones">
                                            <input type="hidden" value="Rechazar" name="AcepRechV">

                                            <button class="opcion2">
                                                <span class="icon-cross"></span><span class="tooltiptext">Rechazar</span>
                                            </button>

                                        </form>
                                    </c:if>
                                    <c:if test="${resG.idEstadoReservacion != 3}">
                                        <form action="<%=path%>/ServletReservaciones" method="post">

                                            <input type="hidden" name="Areas_idArea" value="${sessionScope.usuario.areas_idAreas}">
                                            <input type="hidden" value="AcepRech" name="accion">
                                            <input type="hidden" value="${resG.idReservaciones}" name="idReservaciones">
                                            <input type="hidden" value="Aceptar" name="AcepRechV">

                                            <button type="submit" class="opcion1" disabled>
                                                <span class="icon-checkmark"></span><span class="tooltiptext">Aceptar</span>
                                            </button>

                                        </form>
                                        <form action="<%=path%>/ServletReservaciones" method="post">

                                            <input type="hidden" name="Areas_idArea" value="${sessionScope.usuario.areas_idAreas}">
                                            <input type="hidden" value="AcepRech" name="accion">
                                            <input type="hidden" value="${resG.idReservaciones}" name="idReservaciones">
                                            <input type="hidden" value="Rechazar" name="AcepRechV">

                                            <button class="opcion2" disabled>
                                                <span class="icon-cross"></span><span class="tooltiptext">Rechazar</span>
                                            </button>

                                        </form>
                                    </c:if>



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
