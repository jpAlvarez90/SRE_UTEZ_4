package utez.edu.mx.reservaciones.control;

import utez.edu.mx.reservaciones.dao.DaoReservaciones;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletConsultarReservacionesGAR")
public class ServletConsultarReservacionesGAR extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Areas_idArea = request.getParameter("Areas_idArea");

        System.out.println(Areas_idArea);

        DaoReservaciones dao = new DaoReservaciones();
        List<DaoReservaciones> resG = new ArrayList();
        resG = dao.consultarRMasiva(Areas_idArea);

        request.setAttribute("resG", resG);
        request.getRequestDispatcher("/vista/jsp/administrativo/aceptar_rechazar_reservaciones/AceptarRechazar.jsp").forward(request, response);

    }
}
