<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 11/08/2019
  Time: 06:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link rel="stylesheet" href="<%=path%>/vista/css/fonts.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/css.css">
    <link rel="icon" type="image/png" href="<%=path%>/vista/fotos/logo.png" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/cssTooltip.css">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <script src="<%=path%>/vista/js/jquery.js"></script>
    <script src="<%=path%>/vista/js/main.js"></script>
    <link rel="icon" type="image/png" href="<%=path%>/vista/fotos/logo.png" />
    <script src="<%=path%>/vista/js/jquery-3.2.1.min.js"></script>
    <script src="<%=path%>/vista/js/alertifyjs/alertify.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/js/alertifyjs/css/alertify.css" />
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/js/alertifyjs/css/themes/default.css" />

</head>
<script type="text/javascript">
    <c:if test="${mensaje != null}">
    alert("${mensaje}");
    </c:if>
</script>
<body>
<input type="hidden" name="idUsuariosR" value="${sessionScope.usuario.idUsuarios}">
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
<br/>
<br/>

<article>
    <fieldset>
        <legend><b>Información Personal</b></legend>
        <center>
            <table>
                <tr>
                    <td align="center">
                        <label><b>ID del Usuario:</b></label><br/>
                        <input type="text" name="idUsuario" value="${sessionScope.usuario.idUsuarios}" disabled>
                    </td>
                    <td align="center">
                        <label><b>Nombre(s):</b></label><br/>
                        <input type="text" name="Nombre" value="${sessionScope.usuario.nombre}" disabled>
                    </td>
                </tr>
                <br/>
                <tr>
                    <td align="center">
                        <label><b>Primer Apellido:</b></label><br/>
                        <input type="text" name="Apellido_Paterno" value="${sessionScope.usuario.apellido_Paterno}" disabled>
                    </td>
                    <td align="center">
                        <label><b>Segundo Apellido:</b></label><br/>
                        <input type="text" name="Apellido_Materno" value="${sessionScope.usuario.apellido_Materno}" disabled>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <label><b>Teléfono:</b></label><br/>
                        <input type="text" name="Telefono" value="${sessionScope.usuario.telefono}" disabled>
                    </td>
                    <td align="center">
                        <label><b>Correo Electrónico:</b></label><br/>
                        <input type="text" name="Email" value="${sessionScope.usuario.email}" disabled>
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <label><b>Tipo de Usuario:</b></label><br/>
                        <input type="text" name="tipo_usuario_idTipoUsuario" value="${sessionScope.usuario.tipo_usuario_idTipoUsuario}" disabled>
                    </td>

                    <td align="center">
                        <label><b>Área de Usuario:</b></label><br/>
                        <input type="text" name="Areas_idAreas" value="${sessionScope.usuario.areas_idAreas}" disabled>
                    </td>
                </tr>
            </table>
            <br/><br><br>
            <button type="submit" class="botones" type="button" name="" onclick="location.href='<%=path%>/vista/jsp/administrativo/usuario/ModificarDatos.jsp' ">
                <span class="icon-pencil" ></span>Modificar Información
            </button>
        </center>
        <br><br><br>
    </fieldset>
</article>
<br>
<br>
<article>
    <fieldset>
        <legend><b>Cambiar Contraseña</b></legend>
        <center>
            <form action="<%=path%>/ServletCambioContra" method="post">
                <input type="hidden" name="accion" value="contra">
                <input type="hidden" name="idUsuario" value="${sessionScope.usuario.idUsuarios}">
                <input type="hidden" name="passwd" value="${sessionScope.usuario.contra}">
                <table>
                    <tr>
                        <td align="center">
                            <label><b>Contraseña Actual:</b></label><br/>
                            <input type="password" name="actualContra" placeholder="Ingrese su actual contraseña">
                        </td>
                    </tr>
                    <br/>
                    <tr>
                        <td align="center">
                            <label><b>Nueva Contraseña:</b></label><br/>
                            <input type="password" name="primerContra" placeholder="Ingrese su nueva contraseña">
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <label><b>Repetir Contraseña:</b></label><br/>
                            <input type="password" name="segundaContra" placeholder="Repita su nueva contraseña">
                        </td>
                    </tr>
                </table>
                <br/><br><br>
                <button type="submit" class="botones" type="button" onclick="return CambioPass()">
                    <span class="icon-pencil" ></span>Modificar
                </button>
            </form>
        </center>
        <br><br><br>
    </fieldset>
</article>
<br><br>
<script type="text/javascript">
    function CambioPass() {
        var respuesta = confirm("¿Esta seguro que desea cambiar su contraseña?\n(La contraseña solo se puede cambiar una vez por sesión)");
        if (respuesta == true){
            return true;
        } else {
            return false;
        }
    }
</script>
</body>
</html>
