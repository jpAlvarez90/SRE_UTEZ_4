<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 11/08/2019
  Time: 05:59 PM
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
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/css.css">
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
        <legend><b>Usuario</b></legend>
        <center>
            <form action="<%=path%>/ServletUsuario" method="post">
                <input type="hidden" name="accion" value="modificar">
                <input type="hidden" name="idUsuarios" value="${usr.idUsuarios}">
                <table>
                    <tr >
                        <td align="center">
                            <label><b>ID:</b></label><br/>
                            <input type="text" name="idUsuarios" value="${usr.idUsuarios}" disabled>
                        </td>
                        <td align="center">
                            <label><b>Nombre(s):</b></label><br/>
                            <input type="text" name="Nombre" value="${usr.nombre}">
                        </td>
                    </tr>
                    <br/>
                    <tr>
                        <td align="center">
                            <label><b>Primer Apellido:</b></label><br/>
                            <input type="text" name="Apellido_Paterno" value="${usr.apellido_Paterno}">
                        </td>
                        <td align="center">
                            <label><b>Segundo Apellido:</b></label><br/>
                            <input type="text" name="Apellido_Materno" value="${usr.apellido_Materno}">
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <label><b>Teléfono:</b></label><br/>
                            <input type="text" name="Telefono" value="${usr.telefono}">
                        </td>
                        <td align="center">
                            <label><b>Correo Electrónico:</b></label><br/>
                            <input type="text" name="Email" value="${usr.email}">
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <label><b>Tipo de Usuario:</b></label><br/>
                            <select name="Tipo_usuario_idTipoUsuario">
                                <option value="${usr.tipo_usuario_idTipoUsuario}" disabled>${usr.nombreTipoUsuario}</option>
                                <c:forEach items="${tpusr}" var="tpusr">
                                    <option value="${tpusr.idTipoUsuario}">${tpusr.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>

                        <td align="center">
                            <label><b>División Académica:</b></label><br/>
                            <select name="Areas_idAreas">
                                <option value="${usr.areas_idAreas}" disabled>${usr.nombreAreas}</option>
                                <c:forEach items="${areas}" var="areas">
                                    <option value="${areas.idArea}">${areas.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <label><b>Estado:</b></label><br/>
                            <select name="Status">
                                <c:if test="${usr.status == 1}">
                                    <option value="1">Activo</option>
                                    <option value="0">Inactivo</option>
                                </c:if>
                                <c:if test="${usr.status == 0}">
                                    <option value="0">Inactivo</option>
                                    <option value="1">Activo</option>
                                </c:if>
                            </select>
                        </td>
                    </tr>
                </table>
                <br/>

                <button class="botones" type="submit" onclick="return ConfirmarMod()">
                    <span class="icon-checkmark"></span>Modificar
                </button>
            </form>
            <form action="<%=path%>/ServletConsultarUsuario" method="get">
                <button class="botones">
                    <span class="icon-cross"></span>Cancelar
                </button>
            </form>

        </center>
        <br><br><br>
    </fieldset>
</article>
<script type="text/javascript">
    function ConfirmarMod() {
        var respuesta = confirm("¿Esta seguro que desea modificiar el usuario?");
        if (respuesta == true){
            return true;
        } else {
            return false;
        }
    }
</script>
</body>
</html>
