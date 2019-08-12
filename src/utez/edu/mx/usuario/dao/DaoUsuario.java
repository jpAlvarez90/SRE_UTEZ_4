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
    private final String SQLCONSULTAUSUARIOSE = "select * from usuarios where idUsuarios = ?;";
    private final String SQLREGISTRAUSUARIOS = "insert into usuarios (idUsuarios, Nombre, Apellido_Paterno, Apellido_Materno, Email, Contraseña, Telefono, Status, Tipo_usuario_idTipoUsuario, Areas_idArea) VALUES (?,?,?,?,?,?,?,?,?,?);";
    private final String SQLMODIFICARUSUARIOS = "UPDATE usuarios SET Nombre = ?, Apellido_Paterno = ?, Apellido_Materno = ?, Email = ?, Contraseña = ?, Telefono = ?, Tipo_usuario_idTipoUsuario = ?, Areas_idArea = ? where idUsuarios = ?;";
    private final String SQLELIMINARRUSUARIOS = "UPDATE usuarios SET Status = ? where idUsuarios = ?;";
    private final String SQLMODIFICARUSUARIOSP = "UPDATE usuarios SET Nombre = ?, Apellido_Paterno = ?, Apellido_Materno = ?, Telefono = ? where idUsuarios = ?;";
    private final String SQLINICIOUSUARIOS = "select idUsuarios, Nombre, Apellido_Paterno, Apellido_Materno, Email, Telefono, Status, Tipo_usuario_idTipoUsuario, Areas_idArea from usuarios where Email = ? and Contraseña = ?;";
    //Metodos de conexion:

    private final String SQLBUSQUEDA = ("select * from usuarios where idUsuarios like ?;");
    private final String SQLBUSQUEDA2 = ("select * from usuarios where Nombre like ?;");
    private final String SQLBUSQUEDA3 = ("select * from usuarios where Apellido_Paterno like ?;");
    private final String SQLBUSQUEDA4 = ("select * from usuarios where Apellido_Materno like ?;");


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
                bean.setIdUsuarios(rs.getString("idUsuario"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contraseña"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("Tipo_usuario_idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idAreas"));
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
                bean.setIdUsuarios(rs.getString("idUsuario"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contraseña"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("Tipo_usuario_idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idAreas"));
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
                bean.setIdUsuarios(rs.getString("idUsuario"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contraseña"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("Tipo_usuario_idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idAreas"));
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
                bean.setIdUsuarios(rs.getString("idUsuario"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setContra(rs.getString("Contraseña"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("Tipo_usuario_idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idAreas"));
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
            pstm = con.prepareStatement(SQLCONSULTAUSUARIOS);
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
                bean.setTipo_usuario_idTipoUsuario(rs.getString("Tipo_Usuario_idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idArea"));
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
                bean.setIdUsuarios(rs.getString("idUsuario"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setApellido_Paterno(rs.getString("Apellido_Paterno"));
                bean.setApellido_Materno(rs.getString("Apellido_Materno"));
                bean.setEmail(rs.getString("Email"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setTipo_usuario_idTipoUsuario(rs.getString("Tipo_usuario_idTipoUsuario"));
                bean.setAreas_idAreas(rs.getString("Areas_idAreas"));
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
            pstm = con.prepareStatement(SQLREGISTRAUSUARIOS);
            pstm.setString (1, bean.getIdUsuarios());
            pstm.setString (2, bean.getNombre());
            pstm.setString (3, bean.getApellido_Paterno());
            pstm.setString (4, bean.getApellido_Materno());
            pstm.setString(5, bean.getEmail());
            pstm.setString(6, bean.getContra());
            pstm.setString(7, bean.getTelefono());
            pstm.setString(9, bean.getTipo_usuario_idTipoUsuario());
            pstm.setString(10, bean.getAreas_idAreas());

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
            pstm = con.prepareStatement(SQLMODIFICARUSUARIOS);
            pstm.setString (1, bean.getNombre());
            pstm.setString (2, bean.getApellido_Paterno());
            pstm.setString (3, bean.getApellido_Materno());
            pstm.setString(4, bean.getEmail());
            pstm.setString(5, bean.getContra());
            pstm.setString(6, bean.getTelefono());
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

