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
            bean.setExtension(request.getParameter("Extension"));
            bean.setTelefono(request.getParameter("Telefono"));
            String Status = request.getParameter("Status");
            bean.setStatus(Integer.parseInt(Status));
            bean.setEdificios_idEdificios(request.getParameter("edificios_idEdificios"));
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
            bean.setExtension(request.getParameter("Extension"));
            bean.setTelefono(request.getParameter("Telefono"));
            bean.setStatus(0);
            bean.setEdificios_idEdificios(request.getParameter("edificios_idEdificios"));

            boolean resultado = dao.eliminarEspacios(bean);

            System.out.println(resultado);
            List<BeanEspacios> esp = new ArrayList();
            esp = dao.consultarEspacios();
            request.setAttribute("esp", esp);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/ConsultarEspacios.jsp").forward(request, response);

        }else if(accion.equals("conEspModificar")) {
            BeanEspacios bean = new BeanEspacios();
            String idEspacios = request.getParameter("idEspacios");
            bean = dao.consultarEspaciosE(idEspacios);
            request.setAttribute("esp", bean);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/ModificarEspacios.jsp").forward(request, response);

        }else if (accion.equals("modificar")){

            BeanEspacios bean = new BeanEspacios();

            bean.setIdEspacios(request.getParameter("idEspacios"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setExtension(request.getParameter("Extension"));
            bean.setTelefono(request.getParameter("Telefono"));
            String Status = request.getParameter("Status");
            bean.setStatus(Integer.parseInt(Status));
            bean.setEdificios_idEdificios(request.getParameter("edificios_idEdificios"));

            System.out.println(Status);
            boolean resultado = dao.modificarEspacios(bean);
            System.out.println(resultado);
            if (resultado){
                mensaje = "El estado se modifico correctamente";
            }else {
                mensaje = "El estado no se modifico";
            }
            List<BeanEspacios> esp = new ArrayList();
            esp = dao.consultarEspacios();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("esp", esp);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_espacios/ConsultarEspacios.jsp").forward(request, response);

        }else {
            request.setAttribute("mensaje","Accion no valida...");
            request.getRequestDispatcher("/vista/jsp/administrativo/menu.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
