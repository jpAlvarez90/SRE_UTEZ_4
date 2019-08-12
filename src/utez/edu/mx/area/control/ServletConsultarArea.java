package utez.edu.mx.area.control;

import utez.edu.mx.area.dao.DaoArea;
import utez.edu.mx.area.modelo.BeanArea;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletConsultarArea")
public class ServletConsultarArea extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoArea dao = new DaoArea();
        List<BeanArea> areas = new ArrayList();
        areas = dao.consultarAreas();

        request.setAttribute("areas", areas);

        request.getRequestDispatcher("/vista/jsp/administrativo/gestion_areas/ConsultarAreas.jsp").forward(request,response);
    }
}
