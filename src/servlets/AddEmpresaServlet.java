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
		String email;
		String fono;
		String direccion;
		
		boolean validado = true;
		
		rut = request.getParameter("rut");
		nombre = request.getParameter("nombre");
		email = request.getParameter("email");
		fono = request.getParameter("fono");
		direccion = request.getParameter("direccion");
		
		if( rut.trim().equals("") || rut.trim().length() == 0 ){
			AddStatus += "Rut ";
			validado = false;
		}
		
		if( nombre.trim().equals("") || nombre.trim().length() == 0 ){
			AddStatus += "Nombre ";
			validado = false;
		}

		if( email.trim().equals("") || email.trim().length() == 0 ){
			AddStatus += "Email ";
			validado = false;
		}

		if( fono.trim().equals("") || fono.trim().length() == 0 ){
			AddStatus += "Fono ";
			validado = false;
		}

		if( direccion.trim().equals("") || direccion.trim().length() == 0 ){
			AddStatus += "Direccion ";
			validado = false;
		}
		
		empresa.setRut(rut);
		empresa.setNombre(nombre);
		empresa.setEmail(email);
		empresa.setFono(fono);
		empresa.setDireccion(direccion);
		
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
