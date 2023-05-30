package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;


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
				SeguroDao seguroDao = new SeguroDao();
				int proximo = seguroDao.obtenerProximoId();
				request.setAttribute("id", proximo);
				dispatcher = "/AgregarSeguro.jsp";
				
				break;
			case "2":
				dispatcher = "/ListarSeguros.jsp";
				break;
			default:
				dispatcher = "/Inicio.jsp";
				break;
			}
			
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
	        rd.forward(request, response);  
		}
		
		if(request.getParameter("btnAceptar")!=null) {
	
			Seguro s = new Seguro();
			s.setDescripcion(request.getParameter("txtDescripcion"));
			s.setIdTipo(Integer.parseInt(request.getParameter("tipoSeguro").toString()));
			s.setCostoContratacion(Float.parseFloat(request.getParameter("txtCostoContratacion").toString()));
			s.setCostoAsegurado(Float.parseFloat(request.getParameter("txtCostoMaximoAsegurado").toString()));
			
			SeguroDao sdao = new SeguroDao();
			int filas = sdao.agregarSeguro(s);
			
			request.setAttribute("cantFilas", filas);
			RequestDispatcher rd=request.getRequestDispatcher("/Inicio.jsp");  
	        rd.forward(request, response);  
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
