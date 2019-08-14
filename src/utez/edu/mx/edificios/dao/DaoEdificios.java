package utez.edu.mx.edificios.dao;

import utez.edu.mx.edificios.modelo.BeanEdificios;
import utez.edu.mx.general.servicios.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoEdificios {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Conexion c = new Conexion();

    //Querys de ejecucion:
    private final String SQLCONSULTAEDIFICIOS = "select * from edificios;";
    private final String SQLCONSULTAEDIFICIOSE = "select * from edificios where idEdificios = ?;";
    private final String SQLREGISTRAEDIFICIOS = "insert into edificios (idEdificios,Nombre,Direccion,Status) VALUES (?,?,?,?);";
    private final String SQLREGISTRARCALL = "CALL IdEdificios1(?,?,?)";
    private final String SQLELIMINAREDIFICIOS = "UPDATE edificios SET Status = ? where idEdificios = ?;";
    private final String SQLMODIFICAREDIFICIOS = "UPDATE edificios SET Nombre = ?, Direccion = ?, Status = ? where idEdificios = ?;";

    private final String SQLBUSQUEDA = ("select * from edificios where idEdificios like ?;");
    private final String SQLBUSQUEDA2 = ("select * from edificios where Nombre like ?;");
    private final String SQLBUSQUEDA3 = ("select * from edificios where Direccion like ?;");


    //Metodos de conexion:

    public List busquedaIdEdificio(String param) {
        List listaAreas = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanEdificios bean = new BeanEdificios();
                bean.setIdEdificios(rs.getString("idEdificios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setDireccion(rs.getString("Direccion"));
                bean.setStatus(rs.getInt("Status"));
                listaAreas.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... 1 "+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaAreas;
    }

    public List busquedaNombreEdificio(String param) {
        List listaEdificios = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA2);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanEdificios bean = new BeanEdificios();
                bean.setIdEdificios(rs.getString("idEdificios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setDireccion(rs.getString("Direccion"));
                bean.setStatus(rs.getInt("Status"));
                listaEdificios.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... 2"+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaEdificios;
    }

    public List busquedaDireccionEdificio(String param) {
        List listaEdificios = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA3);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanEdificios bean = new BeanEdificios();
                bean.setIdEdificios(rs.getString("idEdificios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setDireccion(rs.getString("Direccion"));
                bean.setStatus(rs.getInt("Status"));
                listaEdificios.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... 3"+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaEdificios;
    }


    //Consultar
    public List consultarEdificios() {
        List listaEdificios = new ArrayList();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTAEDIFICIOS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanEdificios bean = new BeanEdificios();
                bean.setIdEdificios(rs.getString("idEdificios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setDireccion(rs.getString("Direccion"));
                bean.setStatus(rs.getInt("Status"));
                listaEdificios.add(bean);
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro >:v... 4"+e.getMessage());
        } finally {
            try{
                rs.close();
                pstm.close();
                con.close();
            }catch (SQLException ex){
                System.out.println("Error en las conexiones");
            }
        }
        return listaEdificios;
    }

    public BeanEdificios consultarEdificiosE(String idEdificios){
        BeanEdificios bean = new BeanEdificios();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTAEDIFICIOSE);
            pstm.setString(1,idEdificios);
            rs = pstm.executeQuery();
            if (rs.next()){
                bean.setIdEdificios(rs.getString("idEdificios"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setDireccion(rs.getString("Direccion"));
                bean.setStatus(Integer.parseInt(rs.getString("Status")));
            }
            rs.close();
            pstm.close();
            con.close();
        } catch (Exception e){
            System.out.println("Hubo un error prro... 5"+e.getMessage());
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
    public boolean insertarEdificios (BeanEdificios bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLREGISTRARCALL);
            pstm.setString (1, bean.getNombre());
            pstm.setString (2, bean.getDireccion());
            pstm.setInt (3, bean.getStatus());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo ingresar el edificio: "+ e.getMessage());
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
    public boolean eliminarEdificios (BeanEdificios bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLELIMINAREDIFICIOS);
            pstm.setInt (1, bean.getStatus());
            pstm.setString (2, bean.getIdEdificios());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo eliminar el edificio: "+ e.getMessage());
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
    public boolean modificiarEdificios (BeanEdificios bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLMODIFICAREDIFICIOS);
            pstm.setString(1, bean.getNombre());
            pstm.setString(2, bean.getDireccion());
            pstm.setInt(3, bean.getStatus());
            pstm.setString(4, bean.getIdEdificios());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo modificar el edificio... " + e.getMessage());
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
