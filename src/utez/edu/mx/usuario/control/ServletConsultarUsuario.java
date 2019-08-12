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

@WebServlet(name = "ServletConsultarUsuario")
public class ServletConsultarUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoUsuario dao = new DaoUsuario();
        List<BeanUsuario> usr = new ArrayList();
        usr = dao.consultarUsuarios();

        request.setAttribute("usr", usr);

        request.getRequestDispatcher("/vista/jsp/administrativo/administrativo/gestion_usuarios/ConsultarDatos.jsp").forward(request,response);
    }
}
