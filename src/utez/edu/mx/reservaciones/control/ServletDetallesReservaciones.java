package utez.edu.mx.reservaciones.control;

import utez.edu.mx.reservaciones.dao.DaoReservaciones;
import utez.edu.mx.reservaciones.modelo.BeanReservaciones;
import utez.edu.mx.reservaciones.modelo.BeanReservacionesM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletDetallesReservaciones")
public class ServletDetallesReservaciones extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idReservaciones = request.getParameter("idReservaciones");

        System.out.println(idReservaciones);

        DaoReservaciones dao = new DaoReservaciones();
        BeanReservacionesM bean = new BeanReservacionesM();
        bean = dao.consultarReservacionesRD(idReservaciones);

        request.setAttribute("rd", bean);
        request.getRequestDispatcher("/vista/jsp/administrativo/aceptar_rechazar_reservaciones/DetallesReservacion.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
