package utez.edu.mx.usuario.dao;

import utez.edu.mx.general.servicios.Conexion;
import utez.edu.mx.usuario.modelo.BeanUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Conexion c = new Conexion();

    //Querys de ejecucion:
    private final String SQLCONSULTAUSUARIOS = "select * from usuarios;";
    private final String SQLCONSULTAUSUARIOS2 = "select u.idUsuarios,u.Nombre,u.Apellido_Paterno as PrimerApellido ,u.Apellido_Materno as SegundoApellido,u.Email,u.Contraseña as Contra,\n" +
            "u.Telefono,u.Status,u.Tipo_usuario_idTipoUsuario as idTipoUsuario , t.Nombre as Tipo_Usuario,u.Areas_idArea, a.Nombre as Area from usuarios u inner join \n" +
            "tipo_usuario t on Tipo_usuario_idTipoUsuario = idTipoUsuario \n" +
            "inner join areas a on Areas_idArea = idArea;";

    private final String SQLCONSULTAUSUARIOSE = "select u.idUsuarios,u.Nombre,u.Apellido_Paterno as PrimerApellido ,u.Apellido_Materno as SegundoApellido,u.Email,u.Contraseña as Contra, u.Telefono,u.Status,u.Tipo_usuario_idTipoUsuario as idTipoUsuario , t.Nombre as Tipo_Usuario,u.Areas_idArea, a.Nombre as Area from usuarios u inner join tipo_usuario t on Tipo_usuario_idTipoUsuario = idTipoUsuario inner join areas a on Areas_idArea = idArea where u.idUsuarios = ?;";

    private final String SQLREGISTRAUSUARIOS = "insert into usuarios (idUsuarios, Nombre, Apellido_Paterno, Apellido_Materno, Email, Contraseña, Telefono, Status, Tipo_usuario_idTipoUsuario, Areas_idArea) VALUES (?,?,?,?,?,?,?,?,?,?);";
    private final String SQLREGISTRARCALL = "Call IdUsuarios1(?,?,?,?,?,?,?,?,?)";
    private final String SQLMODIFICARUSUARIOS = "UPDATE usuarios SET Nombre = ?, Apellido_Paterno = ?, Apellido_Materno = ?, Email = ?, Contraseña = ?, Telefono = ?, Tipo_usuario_idTipoUsuario = ?, Areas_idArea = ? where idUsuarios = ?;";
    private final String SQLMODIFICARSINPASS = "UPDATE usuarios SET Nombre = ?, Apellido_Paterno = ?, Apellido_Materno = ?, Email = ?, Telefono = ?, Status = ?, Tipo_usuario_idTipoUsuario = ?, Areas_idArea = ? where idUsuarios = ?;";
    private final String SQLELIMINARRUSUARIOS = "UPDATE usuarios SET Status = ? where idUsuarios = ?;";
    private final String SQLMODIFICARUSUARIOSP = "UPDATE usuarios SET Nombre = ?, Apellido_Paterno = ?, Apellido_Materno = ?, Telefono = ? where idUsuarios = ?;";
    private final String SQLINICIOUSUARIOS = "select idUsuarios, Nombre, Apellido_Paterno, Apellido_Materno, Email, Telefono, Status, Tipo_usuario_idTipoUsuario, Areas_idArea from usuarios where Email = ? and Contraseña = ?;";
    //Metodos de conexion:

    private final String SQLBUSQUEDAN = ("select u.idUsuarios,u.Nombre,u.Apellido_Paterno ,u.Apellido_Materno ,u.Email,u.Contraseña as Contra, u.Telefono,u.Status,u.Tipo_usuario_idTipoUsuario as idTipoUsuario , t.Nombre as Tipo_Usuario,u.Areas_idArea, a.Nombre as Area from usuarios u inner join tipo_usuario t on Tipo_usuario_idTipoUsuario = idTipoUsuario inner join areas a on Areas_idArea = idArea;");
    private final String SQLBUSQUEDA = ("select u.idUsuarios,u.Nombre,u.Apellido_Paterno ,u.Apellido_Materno ,u.Email,u.Contraseña as Contra, u.Telefono,u.Status,u.Tipo_usuario_idTipoUsuario as idTipoUsuario , t.Nombre as Tipo_Usuario,u.Areas_idArea, a.Nombre as Area from usuarios u inner join tipo_usuario t on Tipo_usuario_idTipoUsuario = idTipoUsuario inner join areas a on Areas_idArea = idArea where u.idUsuarios like ?;");
    private final String SQLBUSQUEDA2 = ("select u.idUsuarios,u.Nombre,u.Apellido_Paterno ,u.Apellido_Materno ,u.Email,u.Contraseña as Contra, u.Telefono,u.Status,u.Tipo_usuario_idTipoUsuario as idTipoUsuario , t.Nombre as Tipo_Usuario,u.Areas_idArea, a.Nombre as Area from usuarios u inner join tipo_usuario t on Tipo_usuario_idTipoUsuario = idTipoUsuario inner join areas a on Areas_idArea = idArea where u.Nombre like ?;");
    private final String SQLBUSQUEDA3 = ("select u.idUsuarios,u.Nombre,u.Apellido_Paterno ,u.Apellido_Materno ,u.Email,u.Contraseña as Contra, u.Telefono,u.Status,u.Tipo_usuario_idTipoUsuario as idTipoUsuario , t.Nombre as Tipo_Usuario,u.Areas_idArea, a.Nombre as Area from usuarios u inner join tipo_usuario t on Tipo_usuario_idTipoUsuario = idTipoUsuario inner join areas a on Areas_idArea = idArea where u.Apellido_Paterno like ?;");
    private final String SQLBUSQUEDA4 = ("select u.idUsuarios,u.Nombre,u.Apellido_Paterno ,u.Apellido_Materno ,u.Email,u.Contraseña as Contra, u.Telefono,u.Status,u.Tipo_usuario_idTipoUsuario as idTipoUsuario , t.Nombre as Tipo_Usuario,u.Areas_idArea, a.Nombre as Area from usuarios u inner join tipo_usuario t on Tipo_usuario_idTipoUsuario = idTipoUsuario inner join areas a on Areas_idArea = idArea where u.Apellido_Materno like ?;");
    private final String SQLBUSQUEDA5 = ("select u.idUsuarios,u.Nombre,u.Apellido_Paterno ,u.Apellido_Materno ,u.Email,u.Contraseña as Contra, u.Telefono,u.Status,u.Tipo_usuario_idTipoUsuario as idTipoUsuario , t.Nombre as Tipo_Usuario,u.Areas_idArea, a.Nombre as Area from usuarios u inner join tipo_usuario t on Tipo_usuario_idTipoUsuario = idTipoUsuario inner join areas a on Areas_idArea = idArea where u.Email like ?;");
    private final String SQLBUSQUEDA6 = ("select u.idUsuarios,u.Nombre,u.Apellido_Paterno ,u.Apellido_Materno ,u.Email,u.Contraseña as Contra, u.Telefono,u.Status,u.Tipo_usuario_idTipoUsuario as idTipoUsuario , t.Nombre as Tipo_Usuario,u.Areas_idArea, a.Nombre as Area from usuarios u inner join tipo_usuario t on Tipo_usuario_idTipoUsuario = idTipoUsuario inner join areas a on Areas_idArea = idArea where u.Telefono like ?;");
    private final String SQLBUSQUEDA7 = ("select u.idUsuarios,u.Nombre,u.Apellido_Paterno ,u.Apellido_Materno ,u.Email,u.Contraseña as Contra,u.Telefono,u.Status,t.idTipoUsuario,t.Nombre as NombreTipo,a.idArea,a.Nombre as NombreArea from usuarios u \n" +
            "inner join tipo_usuario t on u.Tipo_usuario_idTipoUsuario = t.idTipoUsuario \n" +
            "inner join areas a on u.Areas_idArea = a.idArea where t.Nombre like ?;");
    private final String SQLBUSQUEDA8 = ("select u.idUsuarios,u.Nombre,u.Apellido_Paterno ,u.Apellido_Materno,u.Email,u.Contraseña as Contra ,u.Telefono,u.Status,t.idTipoUsuario,t.Nombre as NombreTipo,a.idArea,a.Nombre as NombreArea from usuarios u \n" +
            "inner join tipo_usuario t on u.Tipo_usuario_idTipoUsuario = t.idTipoUsuario\n" +
            "inner join areas a on u.Areas_idArea = a.idArea where a.Nombre like ?;");


    public List busquedaUsuarios() {
        List listaUsuario = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDAN);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanUsuario bean = new BeanUsuario();
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
                bean.setNombreTipoUsuario(rs.getString("Tipo_Usuario"));
                bean.setNombreAreas(rs.getString("Area"));
                listaUsuario.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaUsuario;
    }

    public List busquedaIdUsuarios(String param) {
        List listaUsuario = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanUsuario bean = new BeanUsuario();
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
                bean.setNombreTipoUsuario(rs.getString("Tipo_Usuario"));
                bean.setNombreAreas(rs.getString("Area"));
                listaUsuario.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaUsuario;
    }

    public List busquedaNombreUsuarios(String param) {
        List listaUsuario = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA2);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanUsuario bean = new BeanUsuario();
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
                bean.setNombreTipoUsuario(rs.getString("Tipo_Usuario"));
                bean.setNombreAreas(rs.getString("Area"));
                listaUsuario.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaUsuario;
    }

    public List busquedaApellidoPaternoUsuarios(String param) {
        List listaUsuario = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA3);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanUsuario bean = new BeanUsuario();
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
                bean.setNombreTipoUsuario(rs.getString("Tipo_Usuario"));
                bean.setNombreAreas(rs.getString("Area"));
                listaUsuario.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaUsuario;
    }


    public List busquedaApellidoMaternoUsuarios(String param) {
        List listaUsuario = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA4);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanUsuario bean = new BeanUsuario();
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
                bean.setNombreTipoUsuario(rs.getString("Tipo_Usuario"));
                bean.setNombreAreas(rs.getString("Area"));
                listaUsuario.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaUsuario;
    }

    public List busquedaEmailUsuarios(String param) {
        List listaUsuario = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA5);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanUsuario bean = new BeanUsuario();
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
                bean.setNombreTipoUsuario(rs.getString("Tipo_Usuario"));
                bean.setNombreAreas(rs.getString("Area"));
                listaUsuario.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaUsuario;
    }

    public List busquedaTelefonoUsuarios(String param) {
        List listaUsuario = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA6);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanUsuario bean = new BeanUsuario();
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
                bean.setNombreTipoUsuario(rs.getString("Tipo_Usuario"));
                bean.setNombreAreas(rs.getString("Area"));
                listaUsuario.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaUsuario;
    }

    public List busquedaTipoUsuarios(String param) {
        List listaUsuario = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA7);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanUsuario bean = new BeanUsuario();
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("idArea"));
                bean.setNombreTipoUsuario(rs.getString("NombreTipo"));
                bean.setNombreAreas(rs.getString("NombreArea"));
                listaUsuario.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaUsuario;
    }

    public List busquedaAreaUsuarios(String param) {
        List listaUsuario = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA8);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanUsuario bean = new BeanUsuario();
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("idArea"));
                bean.setNombreTipoUsuario(rs.getString("NombreTipo"));
                bean.setNombreAreas(rs.getString("NombreArea"));
                listaUsuario.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaUsuario;
    }


    //Consultar
    public List consultarUsuarios() {
        List listaUsuarios = new ArrayList();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTAUSUARIOS2);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanUsuario bean = new BeanUsuario();
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("PrimerApellido"));
                bean.setApellido_Materno(rs.getString("SegundoApellido"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
                bean.setNombreTipoUsuario(rs.getString("Tipo_Usuario"));
                bean.setNombreAreas(rs.getString("Area"));
                listaUsuarios.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaUsuarios;
    }

    public BeanUsuario consultarUsuariosE(String idUsuario){
        BeanUsuario bean = new BeanUsuario();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTAUSUARIOSE);
            pstm.setString(1,idUsuario);
            rs = pstm.executeQuery();
            if (rs.next()){
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("PrimerApellido"));
                bean.setApellido_Materno(rs.getString("SegundoApellido"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contra"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
                bean.setNombreTipoUsuario(rs.getString("Tipo_Usuario"));
                bean.setNombreAreas(rs.getString("Area"));
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return bean;
    }

    public BeanUsuario inicioSesion(String correo, String contra){
        BeanUsuario bean = new BeanUsuario();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLINICIOUSUARIOS);
            pstm.setString(1,correo);
            pstm.setString(2,contra);
            rs = pstm.executeQuery();
            if (rs.next()){
                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("Tipo_Usuario_idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return bean;
    }

    //Insertar
    public boolean insertarUsuarios(BeanUsuario bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLREGISTRARCALL);
            pstm.setString (1, bean.getNombre());
            pstm.setString (2, bean.getApellido_Paterno());
            pstm.setString (3, bean.getApellido_Materno());
            pstm.setString(4, bean.getEmail());
            pstm.setString(5, bean.getContra());
            pstm.setString(6, bean.getTelefono());
            pstm.setInt(7, bean.getStatus());
            pstm.setString(8, bean.getTipo_usuario_idTipoUsuario());
            pstm.setString(9, bean.getAreas_idAreas());

            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo ingresar la reservacion: "+ e.getMessage());
        }finally {
            try{
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return resultado;
    }

    //Eliminar
    public boolean eliminarUsuarios (BeanUsuario bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLELIMINARRUSUARIOS);
            pstm.setInt (1, bean.getStatus());
            pstm.setString (2, bean.getIdUsuarios());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo modificar la reservacion... " + e.getMessage());
        }finally{
            try{
                pstm.close();
                con.close();
            } catch (SQLException ex){
                System.out.println("Error en cierre de conexiones");
            }
        }
        return resultado;
    }

    //Modificar
    public boolean modificiarUsuarios (BeanUsuario bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLMODIFICARSINPASS);
            pstm.setString (1, bean.getNombre());
            pstm.setString (2, bean.getApellido_Paterno());
            pstm.setString (3, bean.getApellido_Materno());
            pstm.setString(4, bean.getEmail());
            pstm.setString(5, bean.getTelefono());
            pstm.setInt(6, bean.getStatus());
            pstm.setString(7, bean.getTipo_usuario_idTipoUsuario());
            pstm.setString(8, bean.getAreas_idAreas());
            pstm.setString(9, bean.getIdUsuarios());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo modificar la reservacion... " + e.getMessage());
        }finally{
            try{
                pstm.close();
                con.close();
            } catch (SQLException ex){
                System.out.println("Error en cierre de conexiones");
            }
        }
        return resultado;
    }

    public boolean modificiarUsuariosP (BeanUsuario bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLMODIFICARUSUARIOSP);
            pstm.setString (1, bean.getNombre());
            pstm.setString (2, bean.getApellido_Paterno());
            pstm.setString (3, bean.getApellido_Materno());
            pstm.setString(4, bean.getTelefono());
            pstm.setString(5, bean.getIdUsuarios());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo modificar la reservacion... " + e.getMessage());
        }finally{
            try{
                pstm.close();
                con.close();
            } catch (SQLException ex){
                System.out.println("Error en cierre de conexiones");
            }
        }
        return resultado;
    }


}

