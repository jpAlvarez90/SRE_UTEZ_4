<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 22/08/2019
  Time: 04:05 AM
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
            $( "#txtfecha" ).datepicker({ minDate: '+2d' });
        });

        $(function(){
            $( "#txtfecha2" ).datepicker({ minDate: '+2d' });
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

    <script>
        function ddlIdEdificios() {
            var l1 = document.getElementsByName("idEdificios");
            var l2 = l1.options(l1.selectedIndex);
            document.getElementsByName("idEdificiosV").value = l2;
        }
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
                    <a href="<%=path%>/ServletConsultarReservacionesDOC?idUsuariosR=${sessionScope.usuario.idUsuarios}"><img src="<%=path%>/vista/fotos/siono.png"/><br>Mis Reservaciones</a>
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
        <form action="<%=path%>/ServletReservaciones" method="post">
            <input type="hidden" name="accion" value="registroDOC">
            <input type="hidden" name="idUsuariosR" value="${sessionScope.usuario.idUsuarios}">
            <div class="izq">
                <center>
                    <label><b>Edificio:</b></label><br/>
                    <select name="idEdificios" required onchange="ddlIdEdificios();">
                        <c:forEach items="${edif}" var="edif">
                            <option value="${edif.idEdificios}">${edif.nombre}</option>
                        </c:forEach>

                    </select>
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Espacios:</b></label><br/>
                    <input type="hidden" name="idEdificiosV" value="" >
                    <select name="idEspacios" required>
                        <c:forEach items="${esp}" var="esp" >
                            <option value="${esp.idEspacios}">${esp.nombre} - ${esp.nombreEdificio}</option>
                        </c:forEach>
                    </select>
                </center>
            </div>

            <br><br><br><br>

            <div class="izq">
                <center>
                    <label><b>Fecha inicio:</b></label><br/>
                    <input class="cuadros" type="text" name="FechaInicio"  id="txtfecha" required/>
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Fecha final:</b></label><br/>
                    <input class="cuadros" type="text" name="FechaFin"  id="txtfecha2" required/>
                </center>
            </div>

            <br><br><br><br>

            <div class="izq">
                <center>
                    <label><b>Hora de Inicio:</b></label><br/>
                    <input class="cuadros" type="text" name="HorarioInicio" value="" required>
                </center>
            </div>
            <div class="der">
                <center>
                    <label><b>Hora de Finalización:</b></label><br/>
                    <input class="cuadros" type="text" name="HorarioFinal" value="" required>
                </center>
            </div>
            <br><br/><br/><br/><br/>
            <div>
                <center>
                    <label><b>Descripción:</b></label><br/>
                    <textarea name="DescripciondelEvento" required></textarea>
                </center>
            </div>

            <br><br>
            <button class="botones" type="submit">

                <span class="icon-checkmark"></span>Registrar
            </button>
        </form>
        <form action="<%=path%>/ServletConsultarReservacionesDOC" method="get">
            <input type="hidden" name="idUsuariosR" value="${sessionScope.usuario.idUsuarios}">
            <button class="botones">
                <span class="icon-cross"></span>Cancelar
            </button>
        </form>
        <br><br><br>
    </fieldset>
</article>
</body>
</html>

