package utez.edu.mx.reservaciones.control;

import utez.edu.mx.edificios.dao.DaoEdificios;
import utez.edu.mx.edificios.modelo.BeanEdificios;
import utez.edu.mx.espacios.dao.DaoEspacios;
import utez.edu.mx.espacios.modelo.BeanEspacios;
import utez.edu.mx.reservaciones.dao.DaoReservaciones;
import utez.edu.mx.reservaciones.modelo.BeanReservaciones;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletReservaciones")
public class ServletReservaciones extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoReservaciones dao = new DaoReservaciones();
        String accion = request.getParameter("accion");
        String mensaje = "";
        if (accion.equals("registro")) {

            BeanReservaciones bean = new BeanReservaciones();
            bean.setIdReservaciones(request.getParameter("idReservaciones"));
            bean.setFechaInicio(request.getParameter("FechaInicio"));
            bean.setFechaFin(request.getParameter("FechaFin"));
            bean.setHorarioInicio(request.getParameter("HorarioInicio"));
            bean.setHorarioFinal(request.getParameter("HorarioFinal"));
            bean.setDescripciondelEvento(request.getParameter("DescripciondelEvento"));
            bean.setEspacios_idEspacios(request.getParameter("espacios_idEspacios"));
            bean.setEspacios_edificios_idEdificios(request.getParameter("espacios_espacios_idEdificios"));
            bean.setEstadoReservaciones_idEstadoReservaciones(request.getParameter("estadoReservaciones_idEstadoReservaciones"));

            boolean resultado = dao.insertarReservaciones(bean);
            if (resultado) {
                mensaje = "Area registrada exitosamente";
            } else {
                mensaje = "No se registro correctamente el area";
            }
            List<BeanReservaciones> res = new ArrayList();
            //res = dao.consultarReservaciones();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("res", res);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ConsultarReservaciones.jsp").forward(request, response);

        }else if(accion.equals("eliminar")) {

            BeanReservaciones bean = new BeanReservaciones();

            bean.setIdReservaciones(request.getParameter("idReservaciones"));
            bean.setFechaInicio(request.getParameter("FechaInicio"));
            bean.setFechaFin(request.getParameter("FechaFin"));
            bean.setHorarioInicio(request.getParameter("HorarioInicio"));
            bean.setHorarioFinal(request.getParameter("HorarioFinal"));
            bean.setDescripciondelEvento(request.getParameter("DescripciondelEvento"));
            bean.setEspacios_idEspacios(request.getParameter("espacios_idEspacios"));
            bean.setEspacios_edificios_idEdificios(request.getParameter("espacios_edificios_idEdificios"));
            bean.setEstadoReservaciones_idEstadoReservaciones(request.getParameter("estadoReservaciones_idEstadoReservaciones"));

            boolean resultado = dao.eliminarReservaciones(bean);
            System.out.println(resultado);
            List<BeanReservaciones> res = new ArrayList();
            //res = dao.consultarReservaciones();
            request.setAttribute("res", res);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ConsultarEspacios.jsp").forward(request, response);

        }else if(accion.equals("conEspModificar")) {

            String idReservaciones = request.getParameter("idReservaciones");

            BeanReservaciones bean = new BeanReservaciones();
            bean = dao.consultarReservacionesE(idReservaciones);

            DaoEdificios dao2 = new DaoEdificios();
            List<BeanEdificios> edif = new ArrayList();
            edif = dao2.consultarEdificios();

            DaoEspacios dao3 = new DaoEspacios();
            List<BeanEspacios> esp = new ArrayList();
            esp = dao3.consultarEspacios();

            request.setAttribute("res", bean);
            request.setAttribute("edif", edif);
            request.setAttribute("esp", esp);

            request.getRequestDispatcher("/vista/jsp/administrativo/aceptar_rechazar_reservaciones/ModificarReservaciones.jsp").forward(request, response);

        }else if (accion.equals("modificar")){

            BeanReservaciones bean = new BeanReservaciones();

            bean.setIdReservaciones(request.getParameter("idReservaciones"));
            bean.setFechaInicio(request.getParameter("FechaInicio"));
            bean.setFechaFin(request.getParameter("FechaFin"));
            bean.setHorarioInicio(request.getParameter("HorarioInicio"));
            bean.setHorarioFinal(request.getParameter("HorarioFinal"));
            bean.setDescripciondelEvento(request.getParameter("DescripciondelEvento"));
            bean.setEspacios_idEspacios(request.getParameter("espacios_idEspacios"));
            bean.setEspacios_edificios_idEdificios(request.getParameter("espacios_edificios_idEdificios"));
            bean.setEstadoReservaciones_idEstadoReservaciones(request.getParameter("estadoReservaciones_idEstadoReservaciones"));

            boolean resultado = dao.modificiarReservaciones(bean);
            System.out.println(resultado);
            if (resultado){
                mensaje = "El estado se modifico correctamente";
            }else {
                mensaje = "El estado no se modifico";
            }
            List<BeanReservaciones> res = new ArrayList();
            //res = dao.consultarReservaciones();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("res", res);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ConsultarEspacios.jsp").forward(request, response);

        }else {
            request.setAttribute("mensaje","Accion no valida...");
            request.getRequestDispatcher("/vista/jsp/administrativo/menu.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
