package utez.edu.mx.login.control;

import utez.edu.mx.usuario.dao.DaoUsuario;
import utez.edu.mx.usuario.modelo.BeanUsuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();

        DaoUsuario dao = new DaoUsuario();
        BeanUsuario beanu = new BeanUsuario();
        beanu = dao.inicioSesion(request.getParameter("usuario"),request.getParameter("passwd"));

        System.out.println(request.getParameter("usuario"));
        System.out.println(request.getParameter("passwd"));

        String tipoUsr = beanu.getTipo_usuario_idTipoUsuario();

        System.out.println(tipoUsr);

        if (tipoUsr.equals("Tpu_00") || tipoUsr.equals("Tpu_01")){

            sesion.setAttribute("usuario", beanu);
            //request.setAttribute("mensaje", "Bienvenido "+usuario);
            request.getRequestDispatcher("/vista/jsp/administrativo/usuario/ConsultarDatos.jsp").forward(request, response);

        }else if (tipoUsr.equals("Tpu_02") || tipoUsr.equals("Tpu_03")){

            sesion.setAttribute("usuario", beanu);
            //request.setAttribute("mensaje", "Bienvenido "+usuario);
            request.getRequestDispatcher("/vista/jsp/docente/menu.jsp").forward(request, response);

        }else{

            request.setAttribute("mensaje","Usuario o contraseña incorrectos...");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
