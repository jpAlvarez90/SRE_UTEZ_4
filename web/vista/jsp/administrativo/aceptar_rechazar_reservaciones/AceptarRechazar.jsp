<%--
  Created by IntelliJ IDEA.
  User: JP
  Date: 11/08/2019
  Time: 06:12 PM
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
    <link rel="stylesheet" href="<%=path%>/vista/css/fonts.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/vista/css/csstablas.css">
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
                <li><a href="../usuario/index.html"><img src="<%=path%>/vista/fotos/user.png"/><br>Jean Jairo Benitez Meza</a></li>

                <li>
                    <a href="../aceptar_rechazar reservaciones/aceptar_rechazar.html"><img src="<%=path%>/vista/fotos/siono.png"/><br>Aceptar / Rechazar Reservaciones</a>
                </li>
                <li>
                    <a href="../gestion_de_usuarios/consultar_usuarios.html"><img src="<%=path%>/vista/fotos/gestion.png"/><br>Gestión De Usuarios</a>
                </li>
                <li>
                    <a href="../gestion_areas/consultar_area.html"><img src="<%=path%>/vista/fotos/area.PNG"/><br>Áreas</a>
                </li>
                <li>
                    <a href="../gestion_edificios/consultar_edificio.html"><img src="<%=path%>/vista/fotos/edificios.PNG"/><br>Edificios</a>
                </li>
                <li>
                    <a href="../gestion_espacios/consultar_espacio.html"><img src="<%=path%>/vista/fotos/espacio.PNG"/><br>Espacios</a>
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
        <legend><b>Aceptar / Rechazar Reservaciones</b></legend>
        <br>
        <form action="" >
            <button class="registrar">
                <a href="consultar_reservaciones.html"><span class="icon-pencil"></span>Consultar Reservaciones</a>
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
                <tr>
                    <td>Nombre</td>
                    <td>Espacio</td>
                    <td>Fecha Inicio</td>
                    <td>Hora Inicio</td>
                    <td>Opción</td>
                </tr>

                </thead>

                <tbody>
                <tr class="fila" onclick="location.href='../usuario/modificar_datos.html' ">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <center>
                            <form>
                                <button type="submit" class="opcion1" value="" name="">
                                    <span class="icon-checkmark"></span>Aceptar
                                </button>
                                <br/><br/>
                                <button type="submit" class="opcion2">
                                    <span class="icon-cross"></span>Rechazar
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
