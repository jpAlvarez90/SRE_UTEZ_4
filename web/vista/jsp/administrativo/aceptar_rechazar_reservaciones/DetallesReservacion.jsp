<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 11/08/2019
  Time: 06:20 PM
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
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/css_registrar.css">
    <link rel="stylesheet" href="<%=path%>/vista/css/fonts.css">
    <link rel="icon" type="image/png" href="<%=path%>/vista/fotos/logo.png" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/cssTooltip.css">
    <link rel="stylesheet" href="<%=path%>/vista/css/jquery-ui.min.css"/>
    <script src="<%=path%>/vista/js/jquery-3.2.1.min.js"></script>
    <script src="<%=path%>/vista/js/jquery.js"></script>
    <script src="<%=path%>/vista/js/jquery-ui.js"></script>
    <script src="<%=path%>/vista/js/main.js"></script>
    <script>
        $(function(){
            $( "#txtfecha" ).datepicker({ minDate: '-0d' });
        });

        $(function(){
            $( "#txtfecha2" ).datepicker({ minDate: '-0d' });
        });

        $(function () {
            $("#txtfecha").datepicker()({
                dateFormat: "yy-mm-dd"
            });
        });

        $(function () {
            $("#txtfecha2").datepicker()({
                dateFormat: "yy-mm-dd"
            });
        });
    </script>
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
<div id="cabezera">
    <nav id="cabezera2">
        <ul class="cabezera3">
            <li class="cabezera4"><a href="<%=path%>/ServletSalir" class="cabezera5"><span class="icon-exit"></span>Salir</a></li>
        </ul>
        <ul class="cabezera3">
            <li class="cabezera4"><label class="cabezera6">Sistema de Reservación de Espacios (SRE_UTEZ)</label></li>
        </ul>

    </nav>
</div>
<br>
<article>
    <fieldset>
        <legend><b>Reservaciones</b></legend><br>

        <form action="<%=path%>/ServletConsultarReservacionesGAR" method="get">
            <input type="hidden" name="Areas_idArea" value="${sessionScope.usuario.areas_idAreas}">

            <div class="izq">
                <center>
                    <label><b>ID de Reservación:</b></label><br/>
                    <input class="cuadros" type="text" value="${rd.idReservaciones}" disabled>
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Estado:</b></label><br/>
                    <input class="cuadros" type="text" value="${rd.nombreEstadoReservacion}" disabled>
                </center>
            </div>

            <br><br><br><br>

            <div class="izq">
                <center>
                    <label><b>Edificio:</b></label><br/>
                    <input class="cuadros" type="text" value="${rd.nombreEdificio}" disabled>
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Espacio:</b></label><br/>
                    <input class="cuadros" type="text" value="${rd.nombreEspacio}" disabled>
                </center>
            </div>

            <br><br><br><br>

            <div class="izq">
                <center>
                    <label><b>Nombre(s):</b></label><br/>
                    <input class="cuadros" type="text" value="${rd.nombreUsuarios}" disabled>
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Primer Apellido:</b></label><br/>
                    <input class="cuadros"type="text" value="${rd.apellidoPaterno}" disabled>
                </center>
            </div>

            <br><br><br><br>

            <div class="izq">
                <center>
                    <label><b>Segundo Apellido:</b></label><br/>
                    <input class="cuadros" type="text" value="${rd.apellidoMaterno}" disabled>
                </center>
            </div>

            <br><br><br><br>

            <div class="izq">
                <center>
                    <label><b>Fecha inicio:</b></label><br/>
                    <input class="cuadros" type="text" name="txtfecha" id="txtfecha" value="${rd.fechaInicio}" disabled>
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Fecha final:</b></label><br/>
                    <input class="cuadros" type="text" name="txtfecha" id="txtfecha2" value="${rd.fechaFin}" disabled>
                </center>
            </div>

            <br><br><br><br>

            <div class="izq">
                <center>
                    <label><b>Hora de Inicio:</b></label><br/>
                    <input class="cuadros" type="text" value="${rd.horarioInicio}" disabled>
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Hora de Finalización:</b></label><br/>
                    <input class="cuadros" type="text" value="${rd.horarioFinal}" disabled>
                </center>
            </div>
            <br><br/><br/><br/><br/>
            <div>
                <center>
                    <label><b>Descripción</b></label><br/>
                    <textarea disabled>${rd.descripciondelEvento}</textarea>
                </center>
            </div>
            <br>
            <button class="opcion1" type="submit">
                <span class="icon-checkmark"></span>Volver
            </button>
            <!--<button class="opcion2" type="button" onclick="location.href='aceptar_rechazar.html'">
                <span class="icon-cross"></span>Rechazar
            </button>
            <button class="botones" type="button" onclick="location.href='aceptar_rechazar.html'">
                <span class="icon-cross"></span>Cancelar
            </button>-->
        </form>
        <br><br><br>
    </fieldset>
</article>
</body>
</html>
