package ejercicio;

import java.util.Date;

public class DatosSesion {

	public static final String ROL_PAGINA_1="PAG_1";
	public static final String ROL_PAGINA_2="PAG_2";
	public static final String ROL_PAGINA_3="PAG_3";	
	
	String login;
	Date ultimoAcceso;
	String[] roles;	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}
	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public boolean tieneRolPagina1(){
		return buscaRol(ROL_PAGINA_1);
	}
	
	public boolean tieneRolPagina2(){
		return buscaRol(ROL_PAGINA_2);
	}
	
	public boolean tieneRolPagina3(){
		return buscaRol(ROL_PAGINA_3);
	}
	
	private boolean buscaRol(String rol){
		boolean resultado=false;
		for(int i=0; i<roles.length && !resultado; i++){
			resultado=roles[i].equals(rol);
		}
		return resultado;
	}
}
