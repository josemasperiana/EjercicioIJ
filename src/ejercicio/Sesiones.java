package ejercicio;

import java.util.Date;
import java.util.Hashtable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sesiones {

	public static Sesiones instancia=new Sesiones();
	private static IdGenerator generadorId=new IdGenerator();
	private static final int LONGITUD_SESION=16;
	private static final int MILISEGUNDOS_SESION=300000;
	public static String NOMBRE_COOKIE="CookieEjercicio";
	
	Hashtable<String, DatosSesion> datos=new Hashtable<String, DatosSesion>();
	
	public void nuevaSesion(HttpServletResponse res, String login, String[] roles){
		DatosSesion d=new DatosSesion();
		String id;
		
		id=generadorId.generateId(LONGITUD_SESION);
		d.setLogin(login);
		d.setRoles(roles);
		d.setUltimoAcceso(new Date());
		datos.put(id, d);
		res.addCookie(new Cookie(NOMBRE_COOKIE, id));
	}
	
	public DatosSesion accesoDatos(HttpServletRequest req){
		DatosSesion resultado=null;
		String id=null;
		for(Cookie cookie:req.getCookies()){
			if(cookie.getName().equals(NOMBRE_COOKIE)){
				id=cookie.getValue();
				resultado=datos.get(id);
				//System.out.println("Encontrada sesion");
				if(resultado!=null){
					// Si ha pasado más tiempo del estipulado sin usarse, eliminamos esta sesión
					if( (new Date()).getTime()-MILISEGUNDOS_SESION>resultado.getUltimoAcceso().getTime()){
						System.out.println("Tiempo excedido, eliminada sesion");
						resultado=null;
						datos.remove(id);			
					}else{
						resultado.setUltimoAcceso(new Date());
					}
				}
			}
		}
		return resultado;
	}

	public void eliminaSesion(HttpServletRequest req){
		DatosSesion resultado=null;
		String id=null;
		for(Cookie cookie:req.getCookies()){
			if(cookie.getName().equals(NOMBRE_COOKIE)){
				id=cookie.getValue();
				resultado=datos.get(id);
				if(resultado!=null){
					datos.remove(id);			
				}
			}
		}
	}
}
