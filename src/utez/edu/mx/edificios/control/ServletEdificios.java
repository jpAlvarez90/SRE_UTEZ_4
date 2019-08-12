package utez.edu.mx.edificios.control;

import utez.edu.mx.edificios.dao.DaoEdificios;
import utez.edu.mx.edificios.modelo.BeanEdificios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletEdificios")
public class ServletEdificios extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoEdificios dao = new DaoEdificios();
        String accion = request.getParameter("accion");
        String mensaje = "";
        if (accion.equals("registro")) {
            BeanEdificios bean = new BeanEdificios();
            bean.setIdEdificios(request.getParameter("idEdificios"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setExtension(request.getParameter("Extension"));
            bean.setDireccion(request.getParameter("Direccion"));
            String Status = request.getParameter("Status");
            bean.setStatus(Integer.parseInt(Status));
            boolean resultado = dao.insertarEdificios(bean);
            if (resultado) {
                mensaje = "Area registrada exitosamente";
            } else {
                mensaje = "No se registro correctamente el area";
            }
            List<BeanEdificios> edif = new ArrayList();
            edif = dao.consultarEdificios();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("edif", edif);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ConsultarEdificios.jsp").forward(request, response);

        }else if(accion.equals("eliminar")) {
            BeanEdificios bean = new BeanEdificios();
            bean.setIdEdificios(request.getParameter("idEdificios"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setExtension(request.getParameter("Extension"));
            bean.setDireccion(request.getParameter("Direccion"));
            bean.setStatus(0);
            boolean resultado = dao.eliminarEdificios(bean);
            System.out.println(resultado);
            List<BeanEdificios> edif = new ArrayList();
            edif = dao.consultarEdificios();
            request.setAttribute("edif", edif);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ConsultarEdificios.jsp").forward(request, response);

        }else if(accion.equals("conEspModificar")) {
            BeanEdificios bean = new BeanEdificios();
            String idEdificios = request.getParameter("idEdificios");
            bean = dao.consultarEdificiosE(idEdificios);
            request.setAttribute("edif", bean);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ModificarEdificios.jsp").forward(request, response);

        }else if (accion.equals("modificar")){
            BeanEdificios bean = new BeanEdificios();
            bean.setIdEdificios(request.getParameter("idEdificios"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setExtension(request.getParameter("Extension"));
            bean.setDireccion(request.getParameter("Direccion"));
            String Status = request.getParameter("Status");
            bean.setStatus(Integer.parseInt(Status));
            System.out.println(Status);
            boolean resultado = dao.modificiarEdificios(bean);
            System.out.println(resultado);
            if (resultado){
                mensaje = "El estado se modifico correctamente";
            }else {
                mensaje = "El estado no se modifico";
            }
            List<BeanEdificios> edif = new ArrayList();
            edif = dao.consultarEdificios();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("edif", edif);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ConsultarEdificios.jsp").forward(request, response);

        }else {
            request.setAttribute("mensaje","Accion no valida...");
            request.getRequestDispatcher("/vista/jsp/administrativo/menu.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
