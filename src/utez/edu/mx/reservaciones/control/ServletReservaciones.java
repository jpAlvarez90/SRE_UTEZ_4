package utez.edu.mx.reservaciones.control;

import utez.edu.mx.edificios.dao.DaoEdificios;
import utez.edu.mx.edificios.modelo.BeanEdificios;
import utez.edu.mx.espacios.dao.DaoEspacios;
import utez.edu.mx.espacios.modelo.BeanEspacios;
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

@WebServlet(name = "ServletReservaciones")
public class ServletReservaciones extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoReservaciones dao = new DaoReservaciones();
        String accion = request.getParameter("accion");
        String mensaje = "";

        if (accion.equals("registro")) {

            BeanReservacionesM beanM = new BeanReservacionesM();

            String idUsuariosR = request.getParameter("idUsuariosR");

            System.out.println(idUsuariosR);

            //bean.setIdUsuarios(request.getParameter(idUsuariosR));

            beanM.setFechaInicio(request.getParameter("FechaInicio"));
            beanM.setFechaFin(request.getParameter("FechaFin"));
            beanM.setHorarioInicio(request.getParameter("HorarioInicio"));
            beanM.setHorarioFinal(request.getParameter("HorarioFinal"));
            beanM.setDescripciondelEvento(request.getParameter("DescripciondelEvento"));
            beanM.setIdEspacio(request.getParameter("idEspacios"));
            beanM.setIdEdificio(request.getParameter("idEdificios"));
            beanM.setIdEstadoReservacion(3);
            beanM.setIdUsuarios(idUsuariosR);

            boolean resultado = dao.insertarReservaciones2(beanM);

            System.out.println(resultado);

            if (resultado) {
                mensaje = "No se registro la reservacion";
            } else {

                mensaje = "Reservacion registrada exitosamente";
            }

            List<BeanReservaciones> res = new ArrayList();
            res = dao.consultarReservaciones(idUsuariosR);
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("res", res);
            request.getRequestDispatcher("/vista/jsp/administrativo/aceptar_rechazar_reservaciones/ConsultarReservaciones.jsp").forward(request, response);

        } else if (accion.equals("registroDOC")) {

            BeanReservacionesM beanM = new BeanReservacionesM();

            String idUsuariosR = request.getParameter("idUsuariosR");

            System.out.println(idUsuariosR);

            //bean.setIdUsuarios(request.getParameter(idUsuariosR));

            beanM.setFechaInicio(request.getParameter("FechaInicio"));
            beanM.setFechaFin(request.getParameter("FechaFin"));
            beanM.setHorarioInicio(request.getParameter("HorarioInicio"));
            beanM.setHorarioFinal(request.getParameter("HorarioFinal"));
            beanM.setDescripciondelEvento(request.getParameter("DescripciondelEvento"));
            beanM.setIdEspacio(request.getParameter("idEspacios"));
            beanM.setIdEdificio(request.getParameter("idEdificios"));
            beanM.setIdEstadoReservacion(3);
            beanM.setIdUsuarios(idUsuariosR);

            boolean resultado = dao.insertarReservaciones2(beanM);

            System.out.println(resultado);

            if (resultado) {
                mensaje = "No se registro la reservacion";
            } else {

                mensaje = "Reservacion registrada exitosamente";
            }

            List<BeanReservaciones> res = new ArrayList();
            res = dao.consultarReservaciones(idUsuariosR);
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("res", res);
            request.getRequestDispatcher("/vista/jsp/docentes/aceptar_rechazar_reservaciones/ConsultarReservaciones.jsp").forward(request, response);


        }else if(accion.equals("eliminar")) {

            String idUsuariosR = request.getParameter("idUsuariosR");

            BeanReservacionesM bean = new BeanReservacionesM();

            bean.setIdReservaciones(request.getParameter("idReservaciones"));
            bean.setIdEstadoReservacion(4);

            boolean resultado = dao.eliminarReservaciones(bean);
            if (resultado) {
                mensaje = "Reservacion inhabilitada exitosamente";
            } else {
                mensaje = "No se inhabilito la reservacion";
            }

            List<BeanReservaciones> res = new ArrayList();
            res = dao.consultarReservaciones(idUsuariosR);
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("res", res);
            request.getRequestDispatcher("/vista/jsp/administrativo/aceptar_rechazar_reservaciones/ConsultarReservaciones.jsp").forward(request, response);

        }else if(accion.equals("eliminarDOC")) {

            String idUsuariosR = request.getParameter("idUsuariosR");

            BeanReservacionesM bean = new BeanReservacionesM();

            bean.setIdReservaciones(request.getParameter("idReservaciones"));
            bean.setIdEstadoReservacion(4);

            boolean resultado = dao.eliminarReservaciones(bean);
            if (resultado) {
                mensaje = "Reservacion inhabilitada exitosamente";
            } else {
                mensaje = "No se inhabilito la reservacion";
            }

            List<BeanReservaciones> res = new ArrayList();
            res = dao.consultarReservaciones(idUsuariosR);
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("res", res);
            request.getRequestDispatcher("/vista/jsp/docentes/aceptar_rechazar_reservaciones/ConsultarReservaciones.jsp").forward(request, response);

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

        }else if(accion.equals("conEspModificarDOC")) {

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

            request.getRequestDispatcher("/vista/jsp/docentes/aceptar_rechazar_reservaciones/ModificarReservaciones.jsp").forward(request, response);


        }else if (accion.equals("modificar")) {

            String idUsuariosR = request.getParameter("idUsuariosR");

            BeanReservaciones bean = new BeanReservaciones();

            bean.setIdReservaciones(request.getParameter("idReservaciones"));
            bean.setFechaInicio(request.getParameter("FechaInicio"));

            System.out.println(request.getParameter("FechaInicio"));

            bean.setFechaFin(request.getParameter("FechaFin"));
            bean.setHorarioInicio(request.getParameter("HorarioInicio"));
            bean.setHorarioFinal(request.getParameter("HorarioFinal"));
            bean.setDescripciondelEvento(request.getParameter("DescripciondelEvento"));

            bean.setEspacios_idEspacios(request.getParameter("idEspacios"));
            bean.setEspacios_edificios_idEdificios(request.getParameter("idEdificios"));
            bean.setEstadoReservaciones_idEstadoReservaciones(3);

            boolean resultado = dao.modificiarReservaciones(bean);

            System.out.println(resultado);
            if (resultado) {
                mensaje = "La reservacion se modifico correctamente";
            } else {
                mensaje = "La reservacion no se modifico";
            }
            List<BeanReservaciones> res = new ArrayList();
            res = dao.consultarReservaciones(idUsuariosR);
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("res", res);
            request.getRequestDispatcher("/vista/jsp/administrativo/aceptar_rechazar_reservaciones/ConsultarReservaciones.jsp").forward(request, response);

        }else if (accion.equals("modificarDOC")) {

            String idUsuariosR = request.getParameter("idUsuariosR");

            BeanReservaciones bean = new BeanReservaciones();

            bean.setIdReservaciones(request.getParameter("idReservaciones"));
            bean.setFechaInicio(request.getParameter("FechaInicio"));

            System.out.println(request.getParameter("FechaInicio"));

            bean.setFechaFin(request.getParameter("FechaFin"));
            bean.setHorarioInicio(request.getParameter("HorarioInicio"));
            bean.setHorarioFinal(request.getParameter("HorarioFinal"));
            bean.setDescripciondelEvento(request.getParameter("DescripciondelEvento"));

            bean.setEspacios_idEspacios(request.getParameter("idEspacios"));
            bean.setEspacios_edificios_idEdificios(request.getParameter("idEdificios"));
            bean.setEstadoReservaciones_idEstadoReservaciones(3);

            boolean resultado = dao.modificiarReservaciones(bean);

            System.out.println(resultado);
            if (resultado) {
                mensaje = "La reservacion se modifico correctamente";
            } else {
                mensaje = "La reservacion no se modifico";
            }
            List<BeanReservaciones> res = new ArrayList();
            res = dao.consultarReservaciones(idUsuariosR);
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("res", res);
            request.getRequestDispatcher("/vista/jsp/docentes/aceptar_rechazar_reservaciones/ConsultarReservaciones.jsp").forward(request, response);

        }else if(accion.equals("AcepRech")) {

            String Areas_idArea = request.getParameter("Areas_idArea");
            String AcepRechV = request.getParameter("AcepRechV");

            System.out.println(Areas_idArea);
            System.out.println(AcepRechV);

            BeanReservacionesM bean = new BeanReservacionesM();

            if (AcepRechV.equals("Aceptar")) {

                bean.setIdReservaciones(request.getParameter("idReservaciones"));
                bean.setIdEstadoReservacion(1);
                boolean resultado = dao.eliminarReservaciones(bean);
                System.out.println(resultado);

            }else if (AcepRechV.equals("Rechazar")){

                bean.setIdReservaciones(request.getParameter("idReservaciones"));
                bean.setIdEstadoReservacion(2);
                boolean resultado = dao.eliminarReservaciones(bean);
                System.out.println(resultado);

            }


            List<DaoReservaciones> resG = new ArrayList();
            resG = dao.consultarRMasiva(Areas_idArea);
            request.setAttribute("resG", resG);
            request.getRequestDispatcher("/vista/jsp/administrativo/aceptar_rechazar_reservaciones/AceptarRechazar.jsp").forward(request, response);

        }else {
            request.setAttribute("mensaje","Accion no valida...");
            request.getRequestDispatcher("/vista/jsp/administrativo/menu.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
