package utez.edu.mx.area.dao;
import utez.edu.mx.area.modelo.BeanArea;
import utez.edu.mx.general.servicios.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoArea {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Conexion c = new Conexion();

    //Querys de ejecucion:
    private final String SQLCONSULTAAREAS = "select * from areas;";
    private final String SQLCONSULTAAREASE = "select * from areas where idArea = ?;";
    private final String SQLREGISTRAAREAS = "INSERT INTO areas (idArea,Nombre,Status) VALUES (?,?,?);";
    private final String SQLREGISTRARCALL = "CALL idArea1(?,?);";
    private final String SQLELIMINARAREAS = "UPDATE areas SET Status = ? where idArea = ?;";
    private final String SQLMODIFICARAREAS = "UPDATE areas SET Nombre = ?, Status = ? where idArea = ?;";

    private final String SQLBUSQUEDA = ("select * from areas where Nombre like ?;");
    private final String SQLBUSQUEDA2 = ("select * from areas where idArea like ?;");

    //Metodos de conexion:
    //Consultar
    public List consultarAreas() {
        List listaAreas = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTAAREAS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanArea bean = new BeanArea();
                bean.setIdArea(rs.getString("idArea"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setStatus(rs.getInt("Status"));
                listaAreas.add(bean);
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
        return listaAreas;
    }

    public List busquedaNombre(String param) {
        List listaAreas = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanArea bean = new BeanArea();
                bean.setIdArea(rs.getString("idArea"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setStatus(rs.getInt("Status"));
                listaAreas.add(bean);
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
        return listaAreas;
    }

    public List busquedaIdArea(String param) {
        List listaAreas = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA2);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanArea bean = new BeanArea();
                bean.setIdArea(rs.getString("idArea"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setStatus(rs.getInt("Status"));
                listaAreas.add(bean);
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
        return listaAreas;
    }

    public BeanArea consultarAreasE(String idArea){
        BeanArea bean = new BeanArea();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTAAREASE);
            pstm.setString(1,idArea);
            rs = pstm.executeQuery();
            if (rs.next()){
                bean.setIdArea(rs.getString("idArea"));
                bean.setNombre(rs.getString("Nombre"));
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
    public boolean insertarAreas (BeanArea bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLREGISTRARCALL);
            pstm.setString (1, bean.getNombre());
            pstm.setInt (2, bean.getStatus());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo ingresar el area: "+ e.getMessage());
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

    public boolean eliminarAreas (BeanArea bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLELIMINARAREAS);
            pstm.setInt (1, bean.getStatus());
            pstm.setString(2,bean.getIdArea());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo eliminar el area: "+ e.getMessage());
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
    public boolean modificarAreas (BeanArea bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLMODIFICARAREAS);
            pstm.setString(1, bean.getNombre());
            pstm.setInt(2, bean.getStatus());
            pstm.setString(3, bean.getIdArea());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo modificar el area... "+ e.getMessage());
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
