package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;
import dominio.TipoSeguro;
import dominio.TipoSeguroDao;


@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletSeguro() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null) {
			String dispatcher="";
			
			switch(request.getParameter("Param")) {
			case "1":
				
				//le enviamos al jsp el id
				SeguroDao seguroDao = new SeguroDao();
				int proximo = seguroDao.obtenerProximoId();
				request.setAttribute("id", proximo);
				
				TipoSeguroDao tipoSeguroDao = new TipoSeguroDao();
				ArrayList <TipoSeguro> listaTipoSeguros = tipoSeguroDao.obtenerTiposSeguros();
				//le enviamos al jsp la lista de los seguros de la bd
				request.setAttribute("listaTS", listaTipoSeguros);
				
				dispatcher = "/AgregarSeguro.jsp";
				
				break;
			case "2":
			
				TipoSeguroDao tipoSeguroDaos = new TipoSeguroDao();
				TipoSeguro todos = new TipoSeguro();
				todos.setDescripcion("Todos");
				todos.setIdTipo(0);
				
				ArrayList <TipoSeguro> listaTs= tipoSeguroDaos.obtenerTiposSeguros();
				listaTs.add(todos);
				
				request.setAttribute("listaTSS", listaTs);
				
				SeguroDao sdao = new SeguroDao();
				ArrayList <Seguro> listaS= sdao.obtenerSeguros();
				request.setAttribute("listaSeguros", listaS);
				
				RequestDispatcher rd= request.getRequestDispatcher("/ListarSeguros.jsp");
				rd.forward(request, response);
				
				
				//dispatcher = "/ListarSeguros.jsp";
				break;
			default:
				dispatcher = "/Inicio.jsp";
				break;
			}
			
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
	        rd.forward(request, response);  
		}
		
		//BOTÓN AGREGAR
		if(request.getParameter("btnAceptar")!=null) {
			
			boolean camposCompletos=true;
			
			TipoSeguroDao tsdao = new TipoSeguroDao();
			
			Seguro s = new Seguro();
			
			try {				
				if(request.getParameter("txtDescripcion")!="") {
					s.setDescripcion(request.getParameter("txtDescripcion"));				
				}
				else {
					camposCompletos=false;
				}
				
				if(request.getParameter("tipoSeguro").toString()!=""){
					s.setTipoSeguro(tsdao.obtenerTipoSeguro(request.getParameter("tipoSeguro").toString()));				
				}
				else {
					camposCompletos=false;
				}
				
				if(request.getParameter("txtCostoContratacion").toString()!="") {
					s.setCostoContratacion(Float.parseFloat(request.getParameter("txtCostoContratacion").toString()));
				}
				else {
					camposCompletos=false;
				}
				
				if(request.getParameter("txtCostoMaximoAsegurado").toString()!="") {
					
					s.setCostoAsegurado(Float.parseFloat(request.getParameter("txtCostoMaximoAsegurado").toString()));
				}
				else {
					camposCompletos=false;
				}			
			} 
			
			catch (NumberFormatException e) {
				e.printStackTrace();
			}			
			catch (NullPointerException e) {
				e.printStackTrace();
			}
			
			SeguroDao sdao = new SeguroDao();
			int filas=0;		
			
			if(camposCompletos) {
				filas = sdao.agregarSeguro(s);	
				request.setAttribute("cantFilas", filas);
				RequestDispatcher rd=request.getRequestDispatcher("/Inicio.jsp");  
				rd.forward(request, response);  				
			}
			else {
				request.setAttribute("cantFilas", filas);		
				RequestDispatcher rd=request.getRequestDispatcher("servletSeguro?Param=1");
				rd.forward(request, response);  		
			}
		}
		
		
		//BOTÓN FILTRAR
		if(request.getParameter("btnFiltrar")!=null) {		
			SeguroDao sdao = new SeguroDao();
			TipoSeguro todos = new TipoSeguro();
			todos.setDescripcion("Todos");
			todos.setIdTipo(0);
			
			ArrayList <Seguro> listaSeguros = sdao.obtenerSeguros();
			int idTipoSeguro = Integer.parseInt(request.getParameter("tipoSeguro").toString());
			
			if(idTipoSeguro!=0) {
				listaSeguros = (ArrayList<Seguro>) listaSeguros
					.stream()
					.filter(x-> x.getTipoSeguro().getIdTipo() == idTipoSeguro)
					.collect(Collectors.toList());
			}
			request.setAttribute("listaSeguros", listaSeguros);
			
			TipoSeguroDao tipoSeguroDaos = new TipoSeguroDao();
			ArrayList <TipoSeguro> listaTs= tipoSeguroDaos.obtenerTiposSeguros();
			listaTs.add(todos);
			
			request.setAttribute("listaTSS", listaTs);		
			
			RequestDispatcher rd= request.getRequestDispatcher("/ListarSeguros.jsp");
			rd.forward(request, response);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
