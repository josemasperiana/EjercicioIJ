<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="POST">
		<input type="hidden" name="recurso" value="<%=request.getAttribute("recurso")%>"/>
		<table>
			<tr>
				<td>Usuario: </td>
				<td><input type="text" name="usuario" /></td>
			</tr>
			<tr>
				<td>Contrase&ntilde;a: </td>
				<td><input type="password" name="clave" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="enviar" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>