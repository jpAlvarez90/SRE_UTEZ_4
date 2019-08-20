package utez.edu.mx.area.control;

import utez.edu.mx.area.dao.DaoArea;
import utez.edu.mx.area.modelo.BeanArea;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletArea")
public class ServletArea extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoArea dao = new DaoArea();
        String accion = request.getParameter("accion");
        String mensaje = "";
        PrintWriter out = response.getWriter();

        if (accion.equals("registro")) {
            BeanArea bean = new BeanArea();
            bean.setIdArea(request.getParameter("idArea"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setStatus(1);
            boolean resultado = dao.insertarAreas(bean);

            if (resultado) {
                mensaje = "Area registrada exitosamente";
            } else {
                mensaje = "No se registro correctamente el area";
            }

            List<BeanArea> areas = new ArrayList();
            areas = dao.consultarAreas();

            request.setAttribute("mensaje", mensaje);
            request.setAttribute("areas", areas);

            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_areas/ConsultarArea.jsp").forward(request, response);

        }else if(accion.equals("eliminar")) {
            BeanArea bean = new BeanArea();
            bean.setIdArea(request.getParameter("idArea"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setStatus(0);
            boolean resultado = dao.eliminarAreas(bean);

            if (resultado) {
                mensaje = "Area deshabilitada exitosamente";
            } else {
                mensaje = "No se deshabilito correctamente el area";
            }

            System.out.println(resultado);
            List<BeanArea> areas = new ArrayList();
            areas = dao.consultarAreas();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("areas", areas);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_areas/ConsultarArea.jsp").forward(request, response);

        }else if(accion.equals("conEspModificar")) {
            BeanArea bean = new BeanArea();
            String idArea = request.getParameter("idArea");
            bean = dao.consultarAreasE(idArea);
            request.setAttribute("areas", bean);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_areas/ModificarArea.jsp").forward(request, response);

        }else if (accion.equals("modificar")) {
            BeanArea bean = new BeanArea();
            bean.setIdArea(request.getParameter("idArea"));
            bean.setNombre(request.getParameter("Nombre"));
            String Status = request.getParameter("Status");
            bean.setStatus(Integer.parseInt(Status));
            System.out.println(Status);
            boolean resultado = dao.modificarAreas(bean);
            System.out.println(resultado);

            if (resultado) {
                mensaje = "El estado se modifico correctamente";
            } else {
                mensaje = "El estado no se modifico correctamente";
            }

            List<BeanArea> areas = new ArrayList();
            areas = dao.consultarAreas();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("areas", areas);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_areas/ConsultarArea.jsp").forward(request, response);

        }else if (accion.equals("busqueda")){

            String busc = request.getParameter("buscar");
            System.out.println(busc);

            List<BeanArea> areas = new ArrayList();
            List<BeanArea> areas2 = new ArrayList();
            List<BeanArea> areasN = new ArrayList();

            List<BeanArea> areasT = new ArrayList<BeanArea>();

            areasN = dao.consultarAreas();
            areas = dao.busquedaNombre(busc);
            areas2 = dao.busquedaIdArea(busc);
            areasT.addAll(areas);
            areasT.addAll(areas2);

            if (request.getParameter("buscar").equals("")){
                request.setAttribute("areas", areasN);
                request.getRequestDispatcher("/vista/jsp/administrativo/gestion_areas/ConsultarArea.jsp").forward(request,response);
            }else{
                request.setAttribute("areas", areasT);
                request.getRequestDispatcher("/vista/jsp/administrativo/gestion_areas/ConsultarArea.jsp").forward(request,response);
            }

        }else {
            request.setAttribute("mensaje","Accion no valida...");
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_areas/RegistroArea.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
