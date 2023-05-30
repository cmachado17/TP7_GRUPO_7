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
	<br/>
	<h1>Soy la página inicio</h1>
	
	<br>
	<br>
	
	<%
	int filas= 0;
	if(request.getAttribute("cantFilas")!=null){	
		filas=Integer.parseInt(request.getAttribute("cantFilas").toString());
	}
%>

 <%if(filas==1)
 	{  %>
 		<b> Se agregó exitosamente <b>
 <%	} %>
</body>
</html>