package utez.edu.mx.espacios.dao;

import utez.edu.mx.edificios.modelo.BeanEdificios;
import utez.edu.mx.espacios.modelo.BeanEspacios;
import utez.edu.mx.general.servicios.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoEspacios {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Conexion c = new Conexion();

    //Querys de ejecucion:
    private final String SQLCONSULTARESPACIOS = "select * from espacios;";
    private final String SQLREGISTRARESPACIOS = "INSERT INTO espacios (idEspacios,Nombre,Extension,Telefono,Status,edificios_idEdificios) VALUES (?,?,?,?,?,?,?);";
    private final String SQLELIMINARESPACIOS = "UPDATE espacios SET Status = ? where idEspacios = ?;";
    private final String SQLMODIFICARESPACIOS = "UPDATE espacios SET Nombre = ?,Extension = ?,Telefono = ?,edificios_idEdificios = ? where idEspacios = ?;";

    private final String SQLCONSULTAESPACIOSE = "select * from espacios where idEspacios = ?;";

    private final String SQLLISTAEDIFICIOS = "select idEdificios, Nombre from edificios;";


    private final String SQLBUSQUEDA = ("select * from espacios where idEspacios like ?;");
    private final String SQLBUSQUEDA2 = ("select * from espacios where Nombre like ?;");


    public List busquedaIdEspacio(String param) {
        List listaEspacios = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanEspacios bean = new BeanEspacios();
                bean.setIdEspacios(rs.getString("idEspacio"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setStatus(rs.getInt("Status"));
                bean.setEdificios_idEdificios(rs.getString("edificios_idEdificios"));
                listaEspacios.add(bean);
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
        return listaEspacios;
    }


    public List busquedaNombreEspacio(String param) {
        List listaEspacios = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA2);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanEspacios bean = new BeanEspacios();
                bean.setIdEspacios(rs.getString("idEspacio"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setStatus(rs.getInt("Status"));
                bean.setEdificios_idEdificios(rs.getString("edificios_idEdificios"));
                listaEspacios.add(bean);
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
        return listaEspacios;
    }

    //Metodos de conexion:
    //Consultar
    public List consultarEspacios() {
        List listaEspacios = new ArrayList();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTARESPACIOS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanEspacios bean = new BeanEspacios();
                bean.setIdEspacios(rs.getString("idEspacios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setExtension(rs.getString("Extension"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(rs.getInt("Status"));
                bean.setEdificios_idEdificios(rs.getString("edificios_idEdificios"));
                listaEspacios.add(bean);
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
        return listaEspacios;
    }

    public BeanEspacios consultarEspaciosE(String idEspacios){
        BeanEspacios bean = new BeanEspacios();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTAESPACIOSE);
            pstm.setString(1,idEspacios);
            rs = pstm.executeQuery();
            if (rs.next()){
                bean.setIdEspacios(rs.getString("idEspacios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setExtension(rs.getString("Extension"));
                bean.setTelefono(rs.getString("Telefono"));
                bean.setStatus(Integer.parseInt(rs.getString("Status")));
                bean.setEdificios_idEdificios(rs.getString("edificios_idEdificios"));
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
    public boolean insertarEspacios (BeanEspacios bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLREGISTRARESPACIOS);
            pstm.setString (1, bean.getIdEspacios());
            pstm.setString (2, bean.getNombre());
            pstm.setString (3, bean.getExtension());
            pstm.setString (4, bean.getTelefono());
            pstm.setInt (5, bean.getStatus());
            pstm.setString (6, bean.getEdificios_idEdificios());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo ingresar el Espacio: "+ e.getMessage());
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

    public boolean eliminarEspacios (BeanEspacios bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLELIMINARESPACIOS);
            pstm.setInt (1, bean.getStatus());
            pstm.setString (2, bean.getIdEspacios());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo eliminar el espacio: "+ e.getMessage());
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


    //Modificar
    public boolean modificarEspacios (BeanEspacios bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLMODIFICARESPACIOS);
            pstm.setString(1, bean.getNombre());
            pstm.setString(2, bean.getExtension());
            pstm.setString(3, bean.getTelefono());
            pstm.setString(4, bean.getEdificios_idEdificios());
            pstm.setString(5, bean.getIdEspacios());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo modificar el espacio... "+ e.getMessage());
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

    public List listaEdificios() {
        List listaEdif = new ArrayList();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLLISTAEDIFICIOS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanEdificios bean = new BeanEdificios();
                bean.setIdEdificios(rs.getString("idEdificios"));
                bean.setNombre(rs.getString("Nombre"));
                listaEdif.add(bean);
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
        return listaEdif;
    }

}
