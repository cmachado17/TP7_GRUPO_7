package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
				dispatcher = "/AgregarSeguro.jsp";
				break;
			case "2":
				dispatcher = "/ListarSeguros.jsp";
				break;
			default:
				dispatcher = "/Inicio.jsp";
			}
			
			RequestDispatcher rd=request.getRequestDispatcher(dispatcher);  
	        rd.forward(request, response);  
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
