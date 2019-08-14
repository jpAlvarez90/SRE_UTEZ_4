package utez.edu.mx.usuario.control;

import utez.edu.mx.area.dao.DaoArea;
import utez.edu.mx.area.modelo.BeanArea;
import utez.edu.mx.tipo_usuario.dao.DaoTipoUsuario;
import utez.edu.mx.tipo_usuario.modelo.BeanTipoUsuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletRegistrarUsuario")
public class ServletRegistrarUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoTipoUsuario dao2 = new DaoTipoUsuario();
        List<BeanTipoUsuario> tpusr = new ArrayList();
        tpusr = dao2.consultarTipoUsuario();

        DaoArea dao3 = new DaoArea();
        List<BeanArea> areas = new ArrayList();
        areas = dao3.consultarAreas();

        request.setAttribute("tpusr", tpusr);
        request.setAttribute("areas", areas);
        request.getRequestDispatcher("/vista/jsp/administrativo/gestion_usuarios/RegistrarUsuarios.jsp").forward(request,response);
    }
}
