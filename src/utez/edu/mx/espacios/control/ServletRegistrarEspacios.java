package utez.edu.mx.espacios.control;

import utez.edu.mx.area.dao.DaoArea;
import utez.edu.mx.area.modelo.BeanArea;
import utez.edu.mx.edificios.dao.DaoEdificios;
import utez.edu.mx.edificios.modelo.BeanEdificios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletRegistrarEspacios")
public class ServletRegistrarEspacios extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoEdificios dao2 = new DaoEdificios();
        List<BeanEdificios> edif = new ArrayList();
        edif = dao2.consultarEdificios();

        DaoArea dao3 = new DaoArea();
        List<BeanArea> areas = new ArrayList();
        areas = dao3.consultarAreas();

        request.setAttribute("edif", edif);
        request.setAttribute("areas", areas);
        request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/RegistrarEspacios.jsp").forward(request,response);
    }
}
