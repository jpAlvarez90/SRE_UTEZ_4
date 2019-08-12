package utez.edu.mx.usuario.control;

import utez.edu.mx.area.dao.DaoArea;
import utez.edu.mx.area.modelo.BeanArea;
import utez.edu.mx.usuario.dao.DaoUsuario;
import utez.edu.mx.usuario.modelo.BeanUsuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletUsuario")
public class ServletUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoUsuario dao = new DaoUsuario();
        String accion = request.getParameter("accion");
        String mensaje = "";
        PrintWriter out = response.getWriter();

        if (accion.equals("registro")) {
            BeanUsuario bean = new BeanUsuario();
            bean.setIdUsuarios(request.getParameter("idUsuario"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setApellido_Paterno(request.getParameter("Apellido_Paterno"));
            bean.setApellido_Materno(request.getParameter("Apellido_Materno"));
            bean.setEmail(request.getParameter("Email"));
            bean.setTelefono(request.getParameter("Telefono"));
            String Status = request.getParameter("Status");
            bean.setStatus(Integer.parseInt(Status));
            bean.setTipo_usuario_idTipoUsuario(request.getParameter("Tipo_usuario_idTipoUsuario"));
            bean.setAreas_idAreas(request.getParameter("Areas_idAreas"));

            boolean resultado = dao.insertarUsuarios(bean);

            if (resultado) {
                mensaje = "Area registrada exitosamente";
            } else {
                mensaje = "No se registro correctamente el area";
            }

            List<BeanUsuario> usr = new ArrayList();
            usr = dao.consultarUsuarios();

            request.setAttribute("mensaje", mensaje);
            request.setAttribute("usr", usr);

            request.getRequestDispatcher("/vista/jsp/administrativo/usuario/ConsultarUsuario.jsp").forward(request, response);

        }else if(accion.equals("eliminar")) {
            BeanUsuario bean = new BeanUsuario();
            bean.setIdUsuarios(request.getParameter("idUsuario"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setApellido_Paterno(request.getParameter("Apellido_Paterno"));
            bean.setApellido_Materno(request.getParameter("Apellido_Materno"));
            bean.setEmail(request.getParameter("Email"));
            bean.setTelefono(request.getParameter("Telefono"));
            bean.setStatus(0);
            bean.setTipo_usuario_idTipoUsuario(request.getParameter("Tipo_usuario_idTipoUsuario"));
            bean.setAreas_idAreas(request.getParameter("Areas_idAreas"));

            boolean resultado = dao.eliminarUsuarios(bean);

            System.out.println(resultado);

            List<BeanUsuario> usr = new ArrayList();
            usr = dao.consultarUsuarios();
            request.setAttribute("usr", usr);
            request.getRequestDispatcher("/vista/jsp/administrativo/usuario/ConsultarUsuario.jsp").forward(request, response);

        }else if(accion.equals("conEspModificar")) {
            BeanUsuario bean = new BeanUsuario();
            String idUsuario = request.getParameter("idUsuario");
            bean = dao.consultarUsuariosE(idUsuario);
            request.setAttribute("usr", bean);
            request.getRequestDispatcher("/vista/jsp/administrativo/usuario/ConsultarUsuario.jsp").forward(request, response);

        }else if (accion.equals("modificar")) {
            BeanUsuario bean = new BeanUsuario();

            //bean.setIdUsuarios(request.getParameter("idUsuario"));
            bean.setNombre(request.getParameter("Nombre"));
            bean.setApellido_Paterno(request.getParameter("Apellido_Paterno"));
            bean.setApellido_Materno(request.getParameter("Apellido_Materno"));
            bean.setEmail(request.getParameter("Email"));
            bean.setTelefono(request.getParameter("Telefono"));
            //String Status = request.getParameter("Status");
            //bean.setStatus(Integer.parseInt(Status));
            //bean.setTipo_usuario_idTipoUsuario(request.getParameter("Tipo_usuario_idTipoUsuario"));
            //bean.setAreas_idAreas(request.getParameter("Areas_idAreas"));

            boolean resultado = dao.modificiarUsuarios(bean);

            System.out.println(resultado);
            if (resultado) {
                mensaje = "El estado se modifico correctamente";
            } else {
                mensaje = "El estado no se modifico correctamente";
            }

            List<BeanUsuario> usr = new ArrayList();
            usr = dao.consultarUsuarios();
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("usr", usr);
            request.getRequestDispatcher("/vista/jsp/administrativo/usuario/ConsultarUsuario.jsp").forward(request, response);

        }else if (accion.equals("busqueda")){

            String busc = request.getParameter("buscar");
            System.out.println(busc);

            List<BeanUsuario> usuario = new ArrayList();
            List<BeanUsuario> usuario2 = new ArrayList();
            List<BeanUsuario> usuario3 = new ArrayList();
            List<BeanUsuario> usuario4 = new ArrayList();
            usuario = dao.busquedaNombreUsuarios(busc);
            usuario2 = dao.busquedaIdUsuarios(busc);
            usuario3 = dao.busquedaApellidoPaternoUsuarios(busc);
            usuario4 = dao.busquedaApellidoMaternoUsuarios(busc);

            List<BeanUsuario> usuarioT = new ArrayList<BeanUsuario>();

            usuarioT.addAll(usuario);
            usuarioT.addAll(usuario2);
            usuarioT.addAll(usuario3);
            usuarioT.addAll(usuario4);

            request.setAttribute("usr", usuarioT);
            request.getRequestDispatcher("/vista/jsp/administrativo/usuario/ConsultarUsuario.jsp").forward(request,response);

        }else{
            request.setAttribute("mensaje","Accion no valida...");
            request.getRequestDispatcher("/vista/jsp/administrativo/usuario/ConsultarUsuario.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
