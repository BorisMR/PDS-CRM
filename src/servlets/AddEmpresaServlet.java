package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import business.Empresa;

/**
 * Servlet implementation class AddEmpresaServlet
 */
@WebServlet("/AddEmpresaServlet")
public class AddEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
		request.setAttribute("LoginStatus",	" Error, No se aceptan peticiones GET");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa = new Empresa();
		String AddStatus = "";
		
		String rut;
		String nombre;
		
		boolean validado = true;
		
		rut = request.getParameter("rut");
		nombre = request.getParameter("nombre");
		
		if( rut.trim().equals("") || rut.trim().length() == 0 ){
			AddStatus += "Rut ";
			validado = false;
		}
		
		if( nombre.trim().equals("") || nombre.trim().length() == 0 ){
			AddStatus += "Nombre ";
			validado = false;
		}
		
		empresa.setRut(rut);
		empresa.setNombre(nombre);
		
		if(validado){
			try {
				AddStatus = empresa.addEmpresaBusiness(empresa);
				RequestDispatcher rs = request.getRequestDispatcher("/FormAddEmpresa.jsp");
				request.setAttribute("AddEmpresaStatus", AddStatus);
				rs.forward(request, response);
								
			} catch (PersistentException e) {
				AddStatus = "PersistentException: "+e.getMessage();
				RequestDispatcher rs = request.getRequestDispatcher("/FormAddEmpresa.jsp");
				request.setAttribute("AddEmpresaStatus", AddStatus);
				rs.forward(request, response);
			}
		}else{
			AddStatus += "Error en la validacion de los datos";
			RequestDispatcher rs = request.getRequestDispatcher("/FormAddEmpresa.jsp");
			request.setAttribute("AddEmpresaStatus", AddStatus);
			rs.forward(request, response);
		}	
	}

}
