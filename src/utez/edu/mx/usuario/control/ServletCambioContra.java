package utez.edu.mx.usuario.control;

import utez.edu.mx.usuario.dao.DaoUsuario;
import utez.edu.mx.usuario.modelo.BeanUsuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletCambioContra")
public class ServletCambioContra extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoUsuario dao = new DaoUsuario();
        String accion = request.getParameter("accion");
        String mensaje = "";

        if (accion.equals("contra")) {
            BeanUsuario bean = new BeanUsuario();

            String idUsuario = request.getParameter("idUsuario");
            String passwd = request.getParameter("passwd");

            String actualContra = request.getParameter("actualContra");

            String primerContra = request.getParameter("primerContra");
            String segundaContra = request.getParameter("segundaContra");

            System.out.println(idUsuario);
            System.out.println(passwd);
            System.out.println(actualContra);
            System.out.println(primerContra);
            System.out.println(segundaContra);

            if (primerContra.equals(segundaContra)){
                if (passwd.equals(actualContra)){
                    System.out.println("aqui si llega");
                    bean.setIdUsuarios(idUsuario);
                    bean.setContra(primerContra);
                    boolean resultado = dao.cambiarContraseña(bean);
                    System.out.println(resultado);
                    if (resultado) {
                        mensaje = "La contraseña se modifico correctamente";
                    } else {
                        mensaje = "La contraseña no se modifico correctamente";
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("/vista/jsp/administrativo/usuario/ConsultarDatos.jsp").forward(request, response);
                }else{
                    System.out.println("aqui no");
                    mensaje = "La contraseña no coincide con la contraseña actual";
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("/vista/jsp/administrativo/usuario/ConsultarDatos.jsp").forward(request, response);
                }
            } else {
                System.out.println("ya te pasaste");
                mensaje = "Las contraseñas no coinciden";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("/vista/jsp/administrativo/usuario/ConsultarDatos.jsp").forward(request, response);
            }

        } else if (accion.equals("contraDOC")) {
            BeanUsuario bean = new BeanUsuario();

            String idUsuario = request.getParameter("idUsuario");
            String passwd = request.getParameter("passwd");

            String actualContra = request.getParameter("actualContra");

            String primerContra = request.getParameter("primerContra");
            String segundaContra = request.getParameter("segundaContra");

            System.out.println(idUsuario);
            System.out.println(passwd);
            System.out.println(actualContra);
            System.out.println(primerContra);
            System.out.println(segundaContra);

            if (primerContra.equals(segundaContra)){
                if (passwd.equals(actualContra)){
                    System.out.println("aqui si llega");
                    bean.setIdUsuarios(idUsuario);
                    bean.setContra(primerContra);
                    boolean resultado = dao.cambiarContraseña(bean);
                    System.out.println(resultado);
                    if (resultado) {
                        mensaje = "La contraseña se modifico correctamente";
                    } else {
                        mensaje = "La contraseña no se modifico correctamente";
                    }
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("/vista/jsp/docentes/usuario/ConsultarDatos.jsp").forward(request, response);
                }else{
                    System.out.println("aqui no");
                    mensaje = "La contraseña no coincide con la contraseña actual";
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher("/vista/jsp/docentes/usuario/ConsultarDatos.jsp").forward(request, response);
                }
            } else {
                System.out.println("ya te pasaste");
                mensaje = "Las contraseñas no coinciden";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("/vista/jsp/docentes/usuario/ConsultarDatos.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
