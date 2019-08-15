package utez.edu.mx.reservaciones.control;

import utez.edu.mx.reservaciones.dao.DaoReservaciones;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletConsultarReservaciones")
public class ServletConsultarReservaciones extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idUsuariosR = request.getParameter("idUsuarios");

        System.out.println(idUsuariosR);

        DaoReservaciones dao = new DaoReservaciones();
        List<DaoReservaciones> res = new ArrayList();
        res = dao.consultarReservaciones(idUsuariosR);

        request.setAttribute("res", res);

        request.getRequestDispatcher("/vista/jsp/administrativo/aceptar_rechazar_reservaciones/ConsultarReservaciones.jsp").forward(request,response);
    }
}
