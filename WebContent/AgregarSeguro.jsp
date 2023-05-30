<%@page import="dominio.SeguroDao"%>
<%@page import="dominio.Seguro"%>
<%@page import="dominio.TipoSeguro"%>
<%@page import="servlet.servletSeguro"%>
<%@ page import="java.util.ArrayList" %>
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
	
		Id Seguro  <b style="margin-left: 124px"> <%=proximo%>  </b> <br>	<br>
		
		<%}//cierro el if %>	
		
		Descripcion 	<input style="margin-left: 107px" type="text" name="txtDescripcion"> <br><br>	
		
		Tipo de seguro	
		
		
		<%
			ArrayList <TipoSeguro> listaTipoSeguros = null;
	if(request.getAttribute("listaTS") != null){
		listaTipoSeguros = (ArrayList <TipoSeguro>) request.getAttribute("listaTS");
	}

%>
	<select  name="tipoSeguro" style="margin-left: 89px; width:143px"> 
	
	<%  
		if(listaTipoSeguros != null)
			for(TipoSeguro tipo : listaTipoSeguros) { %>

 <option value="<%=tipo.getIdTipo()%>"><%=tipo.getDescripcion()%></option>

 <%} //cierro el for%>
	</select>
	<br><br>		
		
		
		
		Costo contratacion $	<input style="margin-left: 53px" type="text" name="txtCostoContratacion" onkeypress="if ( isNaN( String.fromCharCode(event.keyCode) )) return false;"> <br><br>	
		Costo máximo asegurado $	<input style="margin-left: 10px" type="text" name="txtCostoMaximoAsegurado" onkeypress="if ( isNaN( String.fromCharCode(event.keyCode) )) return false;"> <br><br>
	<input style="margin-left: 190px" type="submit" value="Aceptar" name="btnAceptar">
</form>

	<%
	int filas =-1;
	if(request.getAttribute("cantFilas")!=null){		
		filas=(int)request.getAttribute("cantFilas");
	}
	
	if (filas==0){  %>
			<br>
			<b> Para agregar un registro todos los campos deben estar completados! <b>
	<%	} %>

</body>
</html>