<%@page import="dominio.SeguroDao"%>
<%@page import="dominio.Seguro"%>
<%@page import="servlet.servletSeguro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Seguro</title>
</head>
<body>
	<a href="servletSeguro?Param=0">Inicio</a><br>
	<a href="servletSeguro?Param=1">Agregar seguro</a><br>
	<a href="servletSeguro?Param=2">Listar seguros</a>
	<br/>
	
	<% int proximo=0; 
		SeguroDao seguroDao = new SeguroDao();
		proximo=seguroDao.obtenerProximoId();	
	%>
	
	<h1>Agregar seguros</h1>
	<form action="servletSeguro" method="get">
		Id Seguro <input type="text" name="proxId" readonly="readonly" value=<%=proximo%> style="width: 52px; background-color: lightgrey; "> <br>	
		Descripcion	<input type="text" name="txtDescripcion"> <br>
		Tipo de seguro			
		<select name="tipoSeguro">
			<option value="1">Seguro de casas</option>
			<option value="2">Seguro de vida</option>
			<option value="3">Seguro de motos</option>
		</select><br>
		Costo contratacion	<input type="text" name="txtCostoContratacion"> <br>
		Costo máximo asegurado	<input type="text" name="txtCostoMaximoAsegurado"> <br>
	<input type="submit" value="Aceptar" name="btnAceptar">
</form>

<%
	int filas= 0;
	if(request.getAttribute("cantFilas")!=null){	
		filas=Integer.parseInt(request.getAttribute("cantFilas").toString());
	}
%>

 <%if(filas==1)
 	{  %>
 		Se agregó exitosamente.
 <%	} %>

</body>
</html>