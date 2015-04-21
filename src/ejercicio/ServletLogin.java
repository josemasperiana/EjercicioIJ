package ejercicio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static final String[] USUARIOS={"u1", "u2", "u3", "u4"};
	static final String[] CLAVES={"c1", "c2", "c3", "c4"};
	static final String[][] ROLES={
		{DatosSesion.ROL_PAGINA_1}, {DatosSesion.ROL_PAGINA_2}, {DatosSesion.ROL_PAGINA_3}, {DatosSesion.ROL_PAGINA_1, DatosSesion.ROL_PAGINA_3}
	};
	
	
    public ServletLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servicio(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servicio(request, response);
	}
	
	private void servicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario;
		String clave;
		int numeroUsuario=-1;
		String recurso;
		RequestDispatcher despachador;
		
		usuario=request.getParameter("usuario");
		clave=request.getParameter("clave");
		recurso=request.getParameter("recurso");
		for(int i=0;i<USUARIOS.length && numeroUsuario<0; i++){
			if(usuario.trim().equalsIgnoreCase(USUARIOS[i])){
				numeroUsuario=i;
			}
		}		
		if(numeroUsuario>=0 && clave.equals(CLAVES[numeroUsuario])){
			Sesiones.instancia.nuevaSesion(response, USUARIOS[numeroUsuario], ROLES[numeroUsuario]);
			response.sendRedirect("/ejercicio"+recurso);
		}else{
			request.setAttribute("recurso", recurso);
			despachador=request.getRequestDispatcher("login.jsp");
			despachador.forward(request, response);
		}
	}

}
