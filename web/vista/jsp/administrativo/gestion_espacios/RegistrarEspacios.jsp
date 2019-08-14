<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 11/08/2019
  Time: 05:52 PM
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
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/css.css">
    <link rel="stylesheet" href="<%=path%>/vista/css/fonts.css">
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
<div>
    <nav>
        <ul>
            <li><a href=""><span class="icon-exit"></span>Salir</a></li>
        </ul>
        <ul>
            <li><label>Sistema de Reservación de Espacios (SRE_UTEZ)</label></li>
        </ul>

    </nav>
</div>
<br>

<article>
    <fieldset>
        <legend><b>Espacios</b></legend>
        <center>
            <form action="<%=path%>/ServletEspacios" method="post">
                <input type="hidden" name="accion" value="registro">
                <table>
                    <tr>
                        <td align="center">
                            <label><b>Nombre:</b></label><br/>
                            <input type="text" name="Nombre">
                        </td>
                        <td align="center">
                            <label><b>Edificio Perteneciente:</b></label><br/>
                            <select name="edificios_idEdificios">
                                <option value="#" >Seleccione...</option>
                                <c:forEach items="${edif}" var="edif">
                                    <option value="${edif.idEdificios}">${edif.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <br/>
                    <tr>
                        <td align="center">
                            <label><b>Area Perteneciente:</b></label><br/>
                            <select name="areas_idArea">
                                <option value="#" >Seleccione...</option>
                                <c:forEach items="${areas}" var="areas">
                                    <option value="${areas.idArea}">${areas.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
                <br/>
                <button class="botones" type="submit">
                    <span class="icon-checkmark"></span>Registrar
                </button>
            </form>

            <form action="<%=path%>/ServletConsultarEspacios" method="get">
                <button class="botones">
                    <span class="icon-cross"></span>Cancelar
                </button>
            </form>

        </center>
        <br><br><br>
    </fieldset>
</article>
</body>
</html>
