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
<title>Insert title here</title>
</head>
<body>
	<a href="servletSeguro?Param=0">Inicio</a>
	<a href="servletSeguro?Param=1" style="margin-left: 5px">Agregar seguro</a>
	<a href="servletSeguro?Param=2" style="margin-left: 5px">Listar seguros</a>
</body>

<h1><b>"Tipos de seguros de la base de datos"<b></b></h1><br>
Busqueda por tipo de seguros: <%

ArrayList <TipoSeguro> listaTipoSeguros = null;
if(request.getAttribute("listaTSS") != null){
listaTipoSeguros = (ArrayList <TipoSeguro>) request.getAttribute("listaTSS");
}

%>
<select  name="tipoSeguro" style="margin-left: 77px"> 

<%  
if(listaTipoSeguros != null)
for(TipoSeguro tipo : listaTipoSeguros) { %>

<option value="<%=tipo.getIdTipo()%>"><%=tipo.getDescripcion()%></option>



<%} //cierro el for%>
</select> 
<input type="submit" name="txtFiltrar" value="Filtrar">

<br><br>			
		
		<table border="1">
		<tr> 	<th>ID SEGURO</th>   <th>descripcion</th> <th>idTipo</th>   <th>costoContratacion</th> <th>costoAsegurado</th> </tr>
		<tr>     <td></td>                  <td></td>           <td></td>           <td></td>                        <td></td>  </tr>
		
		</table>
		
		
</html>