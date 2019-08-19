package utez.edu.mx.reservaciones.dao;

import utez.edu.mx.general.servicios.Conexion;
import utez.edu.mx.reservaciones.modelo.BeanReservaciones;
import utez.edu.mx.reservaciones.modelo.BeanReservacionesM;

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

    private final String SQLCONSULTARESERVACIONESDETALLE = "select r.idReservaciones, r.FechaInicio,r.FechaFin, r.HorarioInicio,\n" +
            "r.HorarioFinal, r.DescripciondelEvento, r.espacios_idEspacios as IdEspacio,\n" +
            "e.Nombre as Espacio, e.areas_idArea as IdAreaEspacio, a.Nombre as AreaEspacio,\n" +
            "r.espacios_edificios_idEdificios as IdEdificio,\n" +
            "ed.Nombre as Edificio, est.idEstadoReservaciones as IdEstado, est.Nombre as Estado,\n" +
            "us.usuarios_idUsuarios as IdUsuarios, u.Nombre, u.Apellido_Paterno,\n" +
            "u.Apellido_Materno, u.Email, u.Contraseña, u.Telefono, u.Status,\n" +
            "u.Tipo_usuario_idTipoUsuario as Tipo,\n" +
            "tp.Nombre as TipoUsuario, ass.idArea as IdAreaUsuario, ass.Nombre as AreaUsuario from usuarios_has_reservaciones us\n" +
            "left join reservaciones r on us.reservaciones_idReservaciones = r.idReservaciones   \n" +
            "left join edificios ed on espacios_edificios_idEdificios = idEdificios\n" +
            "left join estadoreservaciones est on r.estadoReservaciones_idEstadoReservaciones = est.idEstadoReservaciones\n" +
            "left join usuarios u on us.usuarios_idUsuarios = u.idUsuarios\n" +
            "left join espacios e on r.espacios_idEspacios = e.idEspacios\n" +
            "left join areas a on e.areas_idArea = a.idArea\n" +
            "left join areas ass on u.Areas_idArea = ass.idArea\n" +
            "left join tipo_usuario tp on u.Tipo_usuario_idTipoUsuario = tp.idTipoUsuario;";

    private final String SQLREGISTRARESERVACIONES = "INSERT INTO `reservaciones` (`idReservaciones`, `FechaInicio`, `FechaFin`, `HorarioInicio`, `HorarioFinal`, `DescripciondelEvento`, `espacios_idEspacios`, `espacios_edificios_idEdificios`, `estadoReservaciones_idEstadoReservaciones`) VALUES (?,?,?,?,?,?,?,?,?);";
    private final String SQLMODIFICARRESERVACIONES = "UPDATE reservaciones SET FechaInicio = ?, FechaFin = ?, HorarioInicio = ?, HorarioFinal = ?, DescripciondelEvento = ?, espacios_idEspacios = ?, espacios_edificios_idEdificios = ?, estadoReservaciones_idEstadoReservaciones = ? where idReservaciones = ?;";
    //private final String SQLELIMINARRESERVACIONES = "DELETE FROM reservaciones WHERE idReservaciones = ?;";
    private final String SQLELIMINARRESERVACIONES = "UPDATE reservaciones SET estadoReservaciones_idEstadoReservaciones = ? WHERE idReservaciones = ?;";
    private final String SQLCONSULTARESERVACIONESE = "select r.idReservaciones, r.FechaInicio,r.FechaFin, r.HorarioInicio,\n" +
            "r.HorarioFinal, r.DescripciondelEvento, r.espacios_idEspacios as IdEspacio,\n" +
            "e.Nombre as Espacio, e.areas_idArea as IdAreaEspacio, a.Nombre as AreaEspacio,\n" +
            "r.espacios_edificios_idEdificios as IdEdificio,\n" +
            "ed.Nombre as Edificio, est.idEstadoReservaciones as IdEstado, est.Nombre as Estado,\n" +
            "us.usuarios_idUsuarios as IdUsuarios, u.Nombre, u.Apellido_Paterno,\n" +
            "u.Apellido_Materno, u.Email, u.Contraseña, u.Telefono, u.Status,\n" +
            "u.Tipo_usuario_idTipoUsuario as Tipo,\n" +
            "tp.Nombre as TipoUsuario, ass.idArea as IdAreaUsuario, ass.Nombre as AreaUsuario from usuarios_has_reservaciones us\n" +
            "left join reservaciones r on us.reservaciones_idReservaciones = r.idReservaciones   \n" +
            "left join edificios ed on espacios_edificios_idEdificios = idEdificios\n" +
            "left join estadoreservaciones est on r.estadoReservaciones_idEstadoReservaciones = est.idEstadoReservaciones\n" +
            "left join usuarios u on us.usuarios_idUsuarios = u.idUsuarios\n" +
            "left join espacios e on r.espacios_idEspacios = e.idEspacios\n" +
            "left join areas a on e.areas_idArea = a.idArea\n" +
            "left join areas ass on u.Areas_idArea = ass.idArea\n" +
            "left join tipo_usuario tp on u.Tipo_usuario_idTipoUsuario = tp.idTipoUsuario where us.usuarios_idUsuarios = ?;";

    private final String SQLCONSULTARESERVACIONESE2 = "select r.idReservaciones, r.FechaInicio,r.FechaFin, r.HorarioInicio,\n" +
            "r.HorarioFinal, r.DescripciondelEvento, r.espacios_idEspacios as IdEspacio,\n" +
            "e.Nombre as Espacio, e.areas_idArea as IdAreaEspacio, a.Nombre as AreaEspacio,\n" +
            "r.espacios_edificios_idEdificios as IdEdificio,\n" +
            "ed.Nombre as Edificio, est.idEstadoReservaciones as IdEstado, est.Nombre as Estado,\n" +
            "us.usuarios_idUsuarios as IdUsuarios, u.Nombre, u.Apellido_Paterno,\n" +
            "u.Apellido_Materno, u.Email, u.Contraseña, u.Telefono, u.Status,\n" +
            "u.Tipo_usuario_idTipoUsuario as Tipo,\n" +
            "tp.Nombre as TipoUsuario, ass.idArea as IdAreaUsuario, ass.Nombre as AreaUsuario from usuarios_has_reservaciones us\n" +
            "left join reservaciones r on us.reservaciones_idReservaciones = r.idReservaciones   \n" +
            "left join edificios ed on espacios_edificios_idEdificios = idEdificios\n" +
            "left join estadoreservaciones est on r.estadoReservaciones_idEstadoReservaciones = est.idEstadoReservaciones\n" +
            "left join usuarios u on us.usuarios_idUsuarios = u.idUsuarios\n" +
            "left join espacios e on r.espacios_idEspacios = e.idEspacios\n" +
            "left join areas a on e.areas_idArea = a.idArea\n" +
            "left join areas ass on u.Areas_idArea = ass.idArea\n" +
            "left join tipo_usuario tp on u.Tipo_usuario_idTipoUsuario = tp.idTipoUsuario where r.idReservaciones = ?;";
    //Metodos de conexion:
    private final String SQLINGRESARDOBLE = ("insert into usuarios_has_reservaciones (Usuarios_idUsuarios, Reservaciones_idReservaciones) VALUES (?,?);");

    private final String SQLBUSQUEDA = ("select * from reservaciones where idReservaciones like ?;");
    private final String SQLBUSQUEDA2 = ("select * from reservaciones where FechaInicio like ?;");

    private final String SQLBUSQUEDAMASIVA = ("select r.idReservaciones, r.FechaInicio,r.FechaFin, r.HorarioInicio,\n" +
            "r.HorarioFinal, r.DescripciondelEvento, r.espacios_idEspacios as IdEspacio,\n" +
            "e.Nombre as Espacio, e.areas_idArea as IdAreaEspacio, a.Nombre as AreaEspacio,\n" +
            "r.espacios_edificios_idEdificios as IdEdificio,\n" +
            "ed.Nombre as Edificio, est.idEstadoReservaciones as IdEstado, est.Nombre as Estado,\n" +
            "us.usuarios_idUsuarios as IdUsuarios, u.Nombre, u.Apellido_Paterno,\n" +
            "u.Apellido_Materno, u.Email, u.Contraseña, u.Telefono, u.Status,\n" +
            "u.Tipo_usuario_idTipoUsuario as Tipo,\n" +
            "tp.Nombre as TipoUsuario, ass.idArea as IdAreaUsuario, ass.Nombre as AreaUsuario from usuarios_has_reservaciones us\n" +
            "left join reservaciones r on us.reservaciones_idReservaciones = r.idReservaciones   \n" +
            "left join edificios ed on espacios_edificios_idEdificios = idEdificios\n" +
            "left join estadoreservaciones est on r.estadoReservaciones_idEstadoReservaciones = est.idEstadoReservaciones\n" +
            "left join usuarios u on us.usuarios_idUsuarios = u.idUsuarios\n" +
            "left join espacios e on r.espacios_idEspacios = e.idEspacios\n" +
            "left join areas a on e.areas_idArea = a.idArea\n" +
            "left join areas ass on u.Areas_idArea = ass.idArea\n" +
            "left join tipo_usuario tp on u.Tipo_usuario_idTipoUsuario = tp.idTipoUsuario where e.areas_idArea = ?;");

    private final String SQLREGISTRARCALL = ("call IdRev1(?,?,?,?,?,?,?,?,?)");

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
                bean.setEstadoReservaciones_idEstadoReservaciones(rs.getInt("estadoReservaciones_idEstadoReservaciones"));
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
                bean.setEstadoReservaciones_idEstadoReservaciones(rs.getInt("estadoReservaciones_idEstadoReservaciones"));
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
    public List consultarReservaciones(String idUsuario) {
        List listaReservaciones = new ArrayList();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTARESERVACIONESE);
            pstm.setString(1,idUsuario);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanReservaciones bean = new BeanReservaciones();

                bean.setIdReservaciones(rs.getString("idReservaciones"));
                bean.setFechaInicio(rs.getString("FechaInicio"));
                bean.setFechaFin(rs.getString("FechaFin"));
                bean.setHorarioInicio(rs.getString("HorarioInicio"));
                bean.setHorarioFinal(rs.getString("HorarioFinal"));
                bean.setDescripciondelEvento(rs.getString("DescripciondelEvento"));

                bean.setEspacios_idEspacios(rs.getString("idEspacio"));
                bean.setNombreidEspacios(rs.getString("Espacio"));

                bean.setIdArea(rs.getString("idAreaEspacio"));
                bean.setNombreArea(rs.getString("AreaEspacio"));

                bean.setEspacios_edificios_idEdificios(rs.getString("idEdificio"));
                bean.setNombreidEdificios(rs.getString("Edificio"));

                bean.setEstadoReservaciones_idEstadoReservaciones(rs.getInt("idEstado"));
                bean.setNombreEstadoReservaciones(rs.getString("Estado"));
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

    public List consultarRMasiva(String Areas_idArea) {
        List listaReservaciones = new ArrayList();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLBUSQUEDAMASIVA);
            pstm.setString(1,Areas_idArea);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanReservacionesM bean = new BeanReservacionesM();

                bean.setIdReservaciones(rs.getString("idReservaciones"));
                bean.setFechaInicio(rs.getString("FechaInicio"));
                bean.setFechaFin(rs.getString("FechaFin"));
                bean.setHorarioInicio(rs.getString("HorarioInicio"));
                bean.setHorarioFinal(rs.getString("HorarioFinal"));
                bean.setDescripciondelEvento(rs.getString("DescripciondelEvento"));

                bean.setIdEspacio(rs.getString("idEspacio"));
                bean.setNombreEspacio(rs.getString("Espacio"));

                bean.setIdAreaEspacio(rs.getString("idAreaEspacio"));
                bean.setNombreAreaEspacio(rs.getString("AreaEspacio"));

                bean.setIdEdificio(rs.getString("idEdificio"));
                bean.setNombreEdificio(rs.getString("Edificio"));

                bean.setIdEstadoReservacion(rs.getInt("idEstado"));
                bean.setNombreEstadoReservacion(rs.getString("Estado"));

                bean.setIdUsuarios(rs.getString("idUsuarios"));
                bean.setNombreUsuarios(rs.getString("Nombre"));
                bean.setApellidoPaterno(rs.getString("Apellido_Paterno"));
                bean.setApellidoMaterno(rs.getString("Apellido_Materno"));
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
            pstm = con.prepareStatement(SQLCONSULTARESERVACIONESE2);
            pstm.setString(1,idReservaciones);
            rs = pstm.executeQuery();
            if (rs.next()){
                bean.setIdReservaciones(rs.getString("idReservaciones"));
                bean.setFechaInicio(rs.getString("FechaInicio"));
                bean.setFechaFin(rs.getString("FechaFin"));
                bean.setHorarioInicio(rs.getString("HorarioInicio"));
                bean.setHorarioFinal(rs.getString("HorarioFinal"));
                bean.setDescripciondelEvento(rs.getString("DescripciondelEvento"));

                bean.setEspacios_idEspacios(rs.getString("idEspacio"));
                bean.setNombreidEspacios(rs.getString("Espacio"));

                bean.setIdArea(rs.getString("idAreaEspacio"));
                bean.setNombreArea(rs.getString("AreaEspacio"));

                bean.setEspacios_edificios_idEdificios(rs.getString("idEdificio"));
                bean.setNombreidEdificios(rs.getString("Edificio"));

                bean.setEstadoReservaciones_idEstadoReservaciones(rs.getInt("idEstado"));
                bean.setNombreEstadoReservaciones(rs.getString("Estado"));
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
            pstm.setInt(9, bean.getEstadoReservaciones_idEstadoReservaciones());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo ingresar la reservacion 1: "+ e.getMessage());
            System.out.println(bean.getIdReservaciones());
            System.out.println(bean.getFechaInicio());
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

    public boolean dobleinsercion (BeanReservaciones bean) {
        boolean resultado = false;
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLINGRESARDOBLE);
            pstm.setString(1, bean.getIdReservaciones());
            pstm.setString(2, bean.getIdUsuarios());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error, no se pudo ingresar la incersion doble: " + e.getMessage());
            System.out.println(bean.getIdReservaciones());
            System.out.println(bean.getIdUsuarios());
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error en las conexiones");
            }
        }
        return resultado;
    }

    //Eliminar
    public boolean eliminarReservaciones (BeanReservacionesM bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLELIMINARRESERVACIONES);
            pstm.setInt (1, bean.getIdEstadoReservacion());
            pstm.setString (2, bean.getIdReservaciones());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error, no se pudo modificar la reservacion... " + e.getMessage());
            System.out.println(bean.getIdEstadoReservacion());
            System.out.println(bean.getIdReservaciones());
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
            pstm.setInt(8, bean.getEstadoReservaciones_idEstadoReservaciones());
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

    public boolean insertarReservaciones2 (BeanReservacionesM bean){
        boolean resultado = false;
        try{
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLREGISTRARCALL);
            pstm.setString (1, bean.getFechaInicio());
            pstm.setString (2, bean.getFechaFin());
            pstm.setString (3, bean.getHorarioInicio());
            pstm.setString (4, bean.getHorarioFinal());
            pstm.setString (5, bean.getDescripciondelEvento());
            pstm.setString (6, bean.getIdEspacio());
            pstm.setString (7, bean.getIdEdificio());
            pstm.setInt (8, bean.getIdEstadoReservacion());
            pstm.setString (9, bean.getIdUsuarios());

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


}
