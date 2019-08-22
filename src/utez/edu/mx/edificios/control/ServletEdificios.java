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
            bean.setDireccion(request.getParameter("Direccion"));
            bean.setStatus(1);
            boolean resultado = dao.insertarEdificios(bean);
            if (resultado) {
                mensaje = "No se registro correctamente el edificio";
            } else {
                mensaje = "Edificio registrado exitosamente";
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
            if (resultado) {
                mensaje = "Edificio inhabilitado exitosamente";
            } else {
                mensaje = "No se inhabilito el edificio";
            }
            System.out.println(resultado);
            List<BeanEdificios> edif = new ArrayList();
            edif = dao.consultarEdificios();
            request.setAttribute("mensaje", mensaje);
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
                mensaje = "El edificio se modifico correctamente";
            }else {
                mensaje = "El edificio no se modifico";
            }
            List<BeanEdificios> edif = new ArrayList();
            edif = dao.consultarEdificios();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("edif", edif);
            request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ConsultarEdificios.jsp").forward(request, response);

        }else if (accion.equals("busqueda")){

            String busc = request.getParameter("buscar");
            System.out.println(busc);

            List<BeanEdificios> edif = new ArrayList();
            List<BeanEdificios> edif2 = new ArrayList();
            List<BeanEdificios> edif3 = new ArrayList();
            List<BeanEdificios> edifN = new ArrayList();

            List<BeanEdificios> edifT = new ArrayList<BeanEdificios>();

            edifN = dao.consultarEdificios();
            edif = dao.busquedaNombreEdificio(busc);
            edif2 = dao.busquedaIdEdificio(busc);
            edif3 = dao.busquedaDireccionEdificio(busc);

            edifT.addAll(edif);
            edifT.addAll(edif2);
            edifT.addAll(edif3);

            if (request.getParameter("buscar").equals("")){
                request.setAttribute("edif", edifN);
                request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ConsultarEdificios.jsp").forward(request,response);
            }else{
                request.setAttribute("edif", edifT);
                request.getRequestDispatcher("/vista/jsp/administrativo/gestion_edificios/ConsultarEdificios.jsp").forward(request,response);
            }

        }else {
            request.setAttribute("mensaje","Accion no valida...");
            request.getRequestDispatcher("/vista/jsp/administrativo/menu.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
