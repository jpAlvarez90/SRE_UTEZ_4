package utez.edu.mx.reservaciones.control;

import utez.edu.mx.edificios.dao.DaoEdificios;
import utez.edu.mx.edificios.modelo.BeanEdificios;
import utez.edu.mx.espacios.dao.DaoEspacios;
import utez.edu.mx.espacios.modelo.BeanEspacios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletRegistrarReservacionesDOC")
public class ServletRegistrarReservacionesDOC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoEdificios dao2 = new DaoEdificios();
        List<BeanEdificios> edif = new ArrayList();
        edif = dao2.consultarEdificios();

        DaoEspacios dao3 = new DaoEspacios();
        List<BeanEspacios> esp = new ArrayList();
        esp = dao3.consultarEspacios();

        request.setAttribute("edif", edif);
        request.setAttribute("esp", esp);

        request.getRequestDispatcher("/vista/jsp/docentes/aceptar_rechazar_reservaciones/RealizarReservaciones.jsp").forward(request, response);
    }
}
