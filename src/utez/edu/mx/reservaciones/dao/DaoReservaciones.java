package utez.edu.mx.reservaciones.dao;

import utez.edu.mx.general.servicios.Conexion;
import utez.edu.mx.reservaciones.modelo.BeanReservaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoReservaciones {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Conexion c = new Conexion();

    //Querys de ejecucion:
    private final String SQLCONSULTARESERVACIONES = "select * from reservaciones;";
    private final String SQLREGISTRARESERVACIONES = "insert into reservaciones (idReservaciones,FechaInicio,FechaFin,HorarioInicio,HorarioFinal,DescripciondelEvento,espacios_idEspacios,espacios_edificios_idEdificios,estadoReservaciones_idEstadoReservaciones) VALUES (?,?,?,?,?,?,?,?,?);";
    private final String SQLMODIFICARRESERVACIONES = "UPDATE reservaciones SET FechaInicio = ?, FechaFin = ?, HorarioInicio = ?, HorarioFinal = ?, DescripciondelEvento = ?, espacios_idEspacios = ?, espacios_edificios_idEdificios = ?, estadoReservaciones_idEstadoReservaciones = ? where idReservaciones = ?;";
    private final String SQLELIMINARRESERVACIONES = "DELETE FROM reservaciones WHERE idReservaciones = ?;";

    private final String SQLCONSULTARESERVACIONESE = "select * from reservaciones where idReservaciones = ?;";
    //Metodos de conexion:


    private final String SQLBUSQUEDA = ("select * from reservaciones where idReservaciones like ?;");
    private final String SQLBUSQUEDA2 = ("select * from reservaciones where FechaInicio like ?;");

    public List busquedaIdEspacio(String param) {
        List listaReservacion = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanReservaciones bean = new BeanReservaciones();
                bean.setIdReservaciones(rs.getString("idReservaciones"));
                bean.setFechaInicio(rs.getString("FechaInicio"));
                bean.setFechaFin(rs.getString("FechaFin"));
                bean.setHorarioInicio(rs.getString("HorarioInicio"));
                bean.setHorarioFinal(rs.getString("HorarioFinal"));
                bean.setDescripciondelEvento(rs.getString("DescripciondelEvento"));
                bean.setEspacios_idEspacios(rs.getString("espacios_idEspacios"));
                bean.setEspacios_edificios_idEdificios(rs.getString("espacios_edificos_idEdificios"));
                bean.setEstadoReservaciones_idEstadoReservaciones(rs.getString("estadoReservaciones_idEstadoReservaciones"));
                listaReservacion.add(bean);
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
        return listaReservacion;
    }

    public List busquedaFechaInicio(String param) {
        List listaReservacion = new ArrayList();

        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDA2);
            pstm.setString(1,"%" + param + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanReservaciones bean = new BeanReservaciones();
                bean.setIdReservaciones(rs.getString("idReservaciones"));
                bean.setFechaInicio(rs.getString("FechaInicio"));
                bean.setFechaFin(rs.getString("FechaFin"));
                bean.setHorarioInicio(rs.getString("HorarioInicio"));
                bean.setHorarioFinal(rs.getString("HorarioFinal"));
                bean.setDescripciondelEvento(rs.getString("DescripciondelEvento"));
                bean.setEspacios_idEspacios(rs.getString("espacios_idEspacios"));
                bean.setEspacios_edificios_idEdificios(rs.getString("espacios_edificos_idEdificios"));
                bean.setEstadoReservaciones_idEstadoReservaciones(rs.getString("estadoReservaciones_idEstadoReservaciones"));
                listaReservacion.add(bean);
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
        return listaReservacion;
    }


    //Consultar
    public List consultarReservaciones() {
        List listaReservaciones = new ArrayList();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTARESERVACIONES);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanReservaciones bean = new BeanReservaciones();
                bean.setIdReservaciones(rs.getString("idReservaciones"));
                bean.setFechaInicio(rs.getString("FechaInicio"));
                bean.setFechaFin(rs.getString("FechaFin"));
                bean.setHorarioInicio(rs.getString("HorarioInicio"));
                bean.setHorarioFinal(rs.getString("HorarioInicio"));
                bean.setDescripciondelEvento(rs.getString("DescripciondelEvento"));
                bean.setEspacios_idEspacios(rs.getString("espacios_idEspacios"));
                bean.setEspacios_edificios_idEdificios(rs.getString("espacios_edificios_idEdificios"));
                bean.setEstadoReservaciones_idEstadoReservaciones(rs.getString("estadoReservaciones_idEstadoReservaciones"));
                listaReservaciones.add(bean);
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
        return listaReservaciones;
    }

    public BeanReservaciones consultarReservacionesE(String idReservaciones){
        BeanReservaciones bean = new BeanReservaciones();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTARESERVACIONESE);
            pstm.setString(1,idReservaciones);
            rs = pstm.executeQuery();
            if (rs.next()){
                bean.setIdReservaciones(rs.getString("idReservaciones"));
                bean.setFechaInicio(rs.getString("FechaInicio"));
                bean.setFechaFin(rs.getString("FechaFin"));
                bean.setHorarioInicio(rs.getString("HorarioInicio"));
                bean.setHorarioFinal(rs.getString("HorarioInicio"));
                bean.setDescripciondelEvento(rs.getString("DescripciondelEvento"));
                bean.setEspacios_idEspacios(rs.getString("espacios_idEspacios"));
                bean.setEspacios_edificios_idEdificios(rs.getString("espacios_edificios_idEdificios"));
                bean.setEstadoReservaciones_idEstadoReservaciones(rs.getString("estadoReservaciones_idEstadoReservaciones"));
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
    public boolean insertarReservaciones (BeanReservaciones bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLREGISTRARESERVACIONES);
            pstm.setString (1, bean.getIdReservaciones());
            pstm.setString (2, bean.getFechaInicio());
            pstm.setString (3, bean.getFechaFin());
            pstm.setString (4, bean.getHorarioInicio());
            pstm.setString (5, bean.getHorarioFinal());
            pstm.setString (6, bean.getDescripciondelEvento());
            pstm.setString(7, bean.getEspacios_idEspacios());
            pstm.setString(8, bean.getEspacios_edificios_idEdificios());
            pstm.setString(9, bean.getEstadoReservaciones_idEstadoReservaciones());
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
    public boolean eliminarReservaciones (BeanReservaciones bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLELIMINARRESERVACIONES);
            pstm.setString (1, bean.getIdReservaciones());
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
    public boolean modificiarReservaciones (BeanReservaciones bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLMODIFICARRESERVACIONES);
            pstm.setString (1, bean.getFechaInicio());
            pstm.setString (2, bean.getFechaFin());
            pstm.setString (3, bean.getHorarioInicio());
            pstm.setString (4, bean.getHorarioFinal());
            pstm.setString (5, bean.getDescripciondelEvento());
            pstm.setString(6, bean.getEspacios_idEspacios());
            pstm.setString(7, bean.getEspacios_edificios_idEdificios());
            pstm.setString(8, bean.getEstadoReservaciones_idEstadoReservaciones());
            pstm.setString(9, bean.getIdReservaciones());
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
