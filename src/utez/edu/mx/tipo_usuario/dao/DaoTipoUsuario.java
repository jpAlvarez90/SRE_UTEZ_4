package utez.edu.mx.tipo_usuario.dao;

import utez.edu.mx.general.servicios.Conexion;
import utez.edu.mx.tipo_usuario.modelo.BeanTipoUsuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTipoUsuario {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Conexion c = new Conexion();

    private final String SQLCONSULTARTIPOUSUARIOS = "select * from tipo_usuario;";

    public List consultarTipoUsuario() {
        List listaTipoUsuario = new ArrayList();
        try {
            //con = Conexion.getConexion();
            con = c.getConexion();
            pstm = con.prepareStatement(SQLCONSULTARTIPOUSUARIOS);
            rs = pstm.executeQuery();
            while(rs.next()){
                BeanTipoUsuario bean = new BeanTipoUsuario();
                bean.setIdTipoUsuario(rs.getString("idTipoUsuario"));
                bean.setNombre(rs.getString("Nombre"));
                bean.setStatus(rs.getInt("Status"));
                listaTipoUsuario.add(bean);
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
        return listaTipoUsuario;
    }


}
