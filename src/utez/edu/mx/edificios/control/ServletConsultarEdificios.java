package utez.edu.mx.edificios.control;

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

@WebServlet(name = "ServletConsultarEdificios")
public class ServletConsultarEdificios extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoEdificios dao = new DaoEdificios();
        List<BeanEdificios> edif = new ArrayList();
        edif = dao.consultarEdificios();

        request.setAttribute("edif", edif);

        request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ConsultarEdificios.jsp").forward(request,response);
    }
}
