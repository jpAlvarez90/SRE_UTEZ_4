<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 11/08/2019
  Time: 06:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html>
<head>
    <title>SRE_UTEZ</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/css_registrar.css">
    <link rel="stylesheet" href="<%=path%>/vista/css/fonts.css">
    <link rel="stylesheet" href="<%=path%>/vista/css/jquery-ui.min.css"/>
    <script src="<%=path%>/vista/js/jquery-3.2.1.min.js"></script>
    <script src="<%=path%>/vista/js/jquery-ui.js"></script>
    <script src="<%=path%>/vista/js/main.js"></script>
    <script>
        $(function(){
            $("input").datepicker({minDate:'+0d'});
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

                <li>
                    <a href="<%=path%>/ServletConsultarReservaciones"><img src="<%=path%>/vista/fotos/siono.png"/><br>Aceptar / Rechazar Reservaciones</a>
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
            <li class="cabezera4"><a href="" class="cabezera5"><span class="icon-exit"></span>Salir</a></li>
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
        <form>
            <div class="izq">
                <center>
                    <label><b>ID</b></label><br/>
                    <input class="cuadros" type="text" name="">
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Número de Folio:</b></label><br/>
                    <input class="cuadros" type="text" name="">
                </center>
            </div>

            <br><br><br><br>

            <div class="izq">
                <center>
                    <label><b>Edificio</b></label><br/>
                    <input class="cuadros" type="text" name="">
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Aula:</b></label><br/>
                    <input class="cuadros"type="text" name="">
                </center>
            </div>

            <br><br><br><br>

            <div class="izq">
                <center>
                    <label><b>Fecha inicio:</b></label><br/>
                    <input class="cuadros" type="text" name="txtfecha" id="txtfecha"/>
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Fecha final:</b></label><br/>
                    <input class="cuadros" type="text" name="txtfecha" id="txtfecha2"/>
                </center>
            </div>

            <br><br><br><br>

            <div class="izq">
                <center>
                    <label><b>Hora de Inicio:</b></label><br/>
                    <input class="cuadros" type="text" name="">
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Hora de Finalización:</b></label><br/>
                    <input class="cuadros" type="text" name="">
                </center>
            </div>
            <br><br/><br/><br/><br/>
            <div>
                <center>
                    <label><b>Descripción</b></label><br/>
                    <textarea></textarea>
                </center>
            </div>

            <br><br>
            <button class="botones" type="submit">
                <span class="icon-checkmark"></span>Registrar</a>
            </button>
            <button class="botones">
                <a href="consultar_reservaciones.html"><span class="icon-cross"></span>Cancelar</a>
            </button>
        </form>
        <br><br><br>
    </fieldset>
</article>
</body>
</html>
