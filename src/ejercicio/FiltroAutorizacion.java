package ejercicio;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FiltroAutorizacion implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain cadena) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		RequestDispatcher despachador;
		DatosSesion datos=null;
				
		datos=Sesiones.instancia.accesoDatos(req);
		if(datos==null){
			req.setAttribute("recurso", req.getServletPath());
			despachador=req.getRequestDispatcher("login.jsp");
			despachador.forward(req, res);
		}else{
			req.setAttribute("datos", datos);
			cadena.doFilter(req, res);
		}
		//res.sendRedirect("login.jsp");
		//cadena.doFilter(request, response);		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
