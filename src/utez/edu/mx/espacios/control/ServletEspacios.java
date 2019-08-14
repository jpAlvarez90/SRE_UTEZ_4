package utez.edu.mx.espacios.control;

import utez.edu.mx.area.dao.DaoArea;
import utez.edu.mx.area.modelo.BeanArea;
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

@WebServlet(name = "ServletEspacios")
public class ServletEspacios extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoEspacios dao = new DaoEspacios();
        String accion = request.getParameter("accion");
        String mensaje = "";
        if (accion.equals("registro")) {

            BeanEspacios bean = new BeanEspacios();
            bean.setIdEspacios(request.getParameter("idEspacios"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setStatus(1);
            bean.setEdificios_idEdificios(request.getParameter("edificios_idEdificios"));
            bean.setAreas_idArea(request.getParameter("areas_idArea"));

            boolean resultado = dao.insertarEspacios(bean);

            if (resultado) {
                mensaje = "Area registrada exitosamente";
            } else {
                mensaje = "No se registro correctamente el area";
            }
            List<BeanEspacios> esp = new ArrayList();
            esp = dao.consultarEspacios();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("esp", esp);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/ConsultarEspacios.jsp").forward(request, response);

        }else if(accion.equals("eliminar")) {

            BeanEspacios bean = new BeanEspacios();

            bean.setIdEspacios(request.getParameter("idEspacios"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setStatus(0);
            bean.setEdificios_idEdificios(request.getParameter("edificios_idEdificios"));

            boolean resultado = dao.eliminarEspacios(bean);

            System.out.println(resultado);
            List<BeanEspacios> esp = new ArrayList();
            esp = dao.consultarEspacios();
            request.setAttribute("esp", esp);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/ConsultarEspacios.jsp").forward(request, response);

        }else if(accion.equals("conEspModificar")) {

            String idEspacios = request.getParameter("idEspacios");

            DaoEdificios dao2 = new DaoEdificios();
            List<BeanEdificios> edif = new ArrayList();
            edif = dao2.consultarEdificios();

            DaoArea dao3 = new DaoArea();
            List<BeanArea> areas = new ArrayList();
            areas = dao3.consultarAreas();

            BeanEspacios bean = new BeanEspacios();
            bean = dao.consultarEspaciosE(idEspacios);

            request.setAttribute("esp", bean);

            request.setAttribute("edif", edif);

            request.setAttribute("areas", areas);

            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/ModificarEspacios.jsp").forward(request, response);

        }else if (accion.equals("modificar")) {

            BeanEspacios bean = new BeanEspacios();

            bean.setIdEspacios(request.getParameter("idEspacios"));
            bean.setNombre(request.getParameter("Nombre"));
            String Status = request.getParameter("Status");
            bean.setStatus(Integer.parseInt(Status));
            bean.setEdificios_idEdificios(request.getParameter("edificios_idEdificios"));
            bean.setAreas_idArea(request.getParameter("areas_idArea"));

            System.out.println(Status);
            System.out.println(request.getParameter("edificios_idEdificios"));
            System.out.println(request.getParameter("areas_idArea"));

            boolean resultado = dao.modificarEspacios(bean);

            System.out.println(resultado);
            if (resultado) {
                mensaje = "El estado se modifico correctamente";
            } else {
                mensaje = "El estado no se modifico";
            }
            List<BeanEspacios> esp = new ArrayList();
            esp = dao.consultarEspacios();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("esp", esp);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/ConsultarEspacios.jsp").forward(request, response);

        }else if (accion.equals("busqueda")){

            String busc = request.getParameter("buscar");
            System.out.println(busc);

            DaoEdificios dao2 = new DaoEdificios();
            List<BeanEdificios> edif = new ArrayList();
            edif = dao2.consultarEdificios();

            DaoArea dao3 = new DaoArea();
            List<BeanArea> areas = new ArrayList();
            areas = dao3.consultarAreas();

            List<BeanEspacios> esp = new ArrayList();
            List<BeanEspacios> esp2 = new ArrayList();
            List<BeanEspacios> esp3 = new ArrayList();
            List<BeanEspacios> esp4 = new ArrayList();
            List<BeanEspacios> espN = new ArrayList();

            List<BeanEspacios> espT = new ArrayList<BeanEspacios>();

            espN = dao.consultarEspacios();
            esp = dao.busquedaNombreEspacio(busc);
            esp2 = dao.busquedaIdEspacio(busc);
            esp3 = dao.busquedaNombreEdificioEspacio(busc);
            esp4 = dao.busquedaNombreAreaEspacio(busc);

            espT.addAll(esp);
            espT.addAll(esp2);
            espT.addAll(esp3);
            espT.addAll(esp4);



            if (request.getParameter("buscar").equals("")){
                request.setAttribute("esp", espN);
                request.setAttribute("edif", edif);
                request.setAttribute("areas", areas);
                request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/ConsultarEspacios.jsp").forward(request,response);
            }else{
                request.setAttribute("esp", espT);
                request.setAttribute("edif", edif);
                request.setAttribute("areas", areas);
                request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/ConsultarEspacios.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("mensaje","Accion no valida...");
            request.getRequestDispatcher("/vista/jsp/administrativo/menu.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
