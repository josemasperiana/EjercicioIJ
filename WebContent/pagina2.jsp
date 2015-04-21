<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>P&aacute;gina 2</title>
</head>
<body>
<%if(((ejercicio.DatosSesion) request.getAttribute("datos")).tieneRolPagina2()){ %>
<h1>P&aacute;gina 2</h1>
<p>Hola <%=((ejercicio.DatosSesion) request.getAttribute("datos")).getLogin()%></p>
<p><a href="logout">Salir</a></p>
<%}else{ %>
<h1>No tiene acceso a esta p&aacute;gina</h1>
<%}%>
</body>

</html>