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
	<a href="servletSeguro?Param=0">Inicio</a>
	<a href="servletSeguro?Param=1" style="margin-left: 5px">Agregar seguro</a>
	<a href="servletSeguro?Param=2" style="margin-left: 5px">Listar seguros</a>
	<br/>
	
	
	<h1>Agregar seguros</h1> <br>
	

	
		<% int proximo=0; 
		
		if(request.getAttribute("id") != null){
		proximo = (int) request.getAttribute("id");
		
	%>
	
		<form action="servletSeguro" method="get">
	
		Id Seguro <b style="margin-left: 112px"> <%=proximo%>  </b> <br>	<br>
		
		<%}//cierro el if %>	
		
		Descripcion	<input style="margin-left: 96px" type="text" name="txtDescripcion"> <br><br>	
		Tipo de seguro			
		<select name="tipoSeguro" style="margin-left: 77px">
			<option value="1">Seguro de casas</option>
			<option value="2">Seguro de vida</option>
			<option value="3">Seguro de motos</option>
		</select><br><br>	
		Costo contratacion	<input style="margin-left: 53px" type="text" name="txtCostoContratacion"> <br><br>	
		Costo máximo asegurado	<input style="margin-left: 10px" type="text" name="txtCostoMaximoAsegurado"> <br><br>
	<input style="margin-left: 177px" type="submit" value="Aceptar" name="btnAceptar">
</form>



</body>
</html>