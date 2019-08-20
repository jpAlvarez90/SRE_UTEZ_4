package utez.edu.mx.login.control;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FiltroSesion implements Filter {

    String usuario = "";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        usuario = (String) (session != null ? session.getAttribute("Tipo_usuario_idTipoUsuario"):"false");
        if (session == null || usuario == null){
            try{
                httpRequest.getRequestDispatcher("").forward(request, response);
                return;
            }catch (ServletException e){

            }catch (IOException e){

            }
        }

        try {
            chain.doFilter(request, response);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ServletException e){
            e.printStackTrace();
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        usuario = "";
    }

    @Override
    public void destroy() {

    }
}
