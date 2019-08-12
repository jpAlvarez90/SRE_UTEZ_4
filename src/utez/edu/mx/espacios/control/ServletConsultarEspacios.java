package utez.edu.mx.espacios.control;

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

@WebServlet(name = "ServletConsultarEspacios")
public class ServletConsultarEspacios extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoEspacios dao = new DaoEspacios();
        List<BeanEspacios> esp = new ArrayList();
        esp = dao.consultarEspacios();
        request.setAttribute("esp", esp);
        request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/ConsultarEspacios.jsp").forward(request,response);
    }
}
