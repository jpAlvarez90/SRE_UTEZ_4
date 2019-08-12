package utez.edu.mx.general.servicios;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private String ip = "localhost";
    private String nombrebase = "mydb";
    private String usuario = "root";
    private String contraseña = "G1antchinchompas";

    public Connection getConexion() throws Exception{
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        con = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+nombrebase+"?user="+usuario+"&password="+contraseña+"&useSSL=false");
        return con;
    }

    //SET GLOBAL time_zone = '-3:00';

    public static void main(String[] args) {
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            System.out.println("Ya quedo prro");
            con.close();
        }catch (Exception e){
            System.out.println("No se pudo prro: ");
            System.out.println(e.getMessage());
        }
    }

}
