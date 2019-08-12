<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 11/08/2019
  Time: 05:52 PM
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
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/csstablas.css">
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

        <form action="" >
            <button class="registrar">
                <a href="registrar_espacio.html"><span class="icon-pencil"></span>Registrar Nuevo</a>
            </button>
        </form>
        <form action="">
            <button class="buscar" type="submit"><span class="icon-search"></span>Buscar</button>
            <input class="buscador" type="text" name="" placeholder="Buscar por ID">
        </form>
        <br><br>
        <center>
            <br/>
            <table border="5px">
                <thead>
                <tr >
                    <td>Matrícula</td>
                    <td>Nombre</td>
                    <td>Edificio Perteneciente</td>
                    <td>Extensión</td>
                    <td>Teléfono</td>
                    <td>Estado</td>
                    <td>Opción</td>

                </tr>

                </thead>

                <tbody>
                <tr>
                    <td>USER_001</td>
                    <td>Jean Jairo</td>
                    <td>DOC1</td>
                    <td>123</td>
                    <td>777-51-32-885</td>
                    <td>Activo</td>
                    <td>
                        <center>
                            <form>
                                <button type="submit" class="opcion1" value="" name="">
                                    <a href="modificar_espacio.html"><span class="icon-list"></span>Modificar</a>
                                </button>
                                <br/><br/>
                                <button type="submit" class="opcion2">
                                    <span class="icon-cross"></span>Eliminar
                                </button>
                            </form>
                        </center>
                    </td>
                </tr>
                </tbody>
            </table>
            <br/>

        </center>
        <br><br><br>
    </fieldset>
</article>
</body>
</html>
