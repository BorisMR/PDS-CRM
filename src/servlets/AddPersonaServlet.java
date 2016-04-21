package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import business.Persona;

/**
 * Servlet implementation class AddPersonaServlet
 */
@WebServlet("/AddPersonaServlet")
public class AddPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		String LoginStatus = "";
		RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
		request.setAttribute("LoginStatus",	" Error, No se aceptan peticiones GET");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String AddStatus = "";
		Persona persona = new Persona();
		
		String run;
		String nombre;
		String apellido;
		String email;
		String telefono;
		String direccion;
		String genero;
		
		boolean validado = true;
		
		run = request.getParameter("run");
		nombre = request.getParameter("nombre");
		apellido = request.getParameter("apellido");
		email = request.getParameter("mail");
		telefono = request.getParameter("telefono");
		direccion = request.getParameter("direccion");
		genero = request.getParameter("genero");
		
		//--verifica campos vacios
		if( run.trim().equals("") || run.trim().length() == 0 ){
			AddStatus += "Run ";
			validado = false;
		}		
		if( nombre.trim().equals("") || nombre.trim().length() == 0 ){
			AddStatus += "Nombre ";
			validado = false;
		}
		if( apellido.trim().equals("") || apellido.trim().length() == 0 ){
			AddStatus += "Apellido";
			validado = false;
		}
		if( email.trim().equals("") || email.trim().length() == 0 ){
			AddStatus += "Email ";
			validado = false;
		}
		if( telefono.trim().equals("") || telefono.trim().length() == 0 ){
			AddStatus += "Telefono ";
			validado = false;
		}
		if( direccion.trim().equals("") || direccion.trim().length() == 0 ){
			AddStatus += "Direccion ";
			validado = false;
		}
		if( genero.trim().equals("") || genero.trim().length() == 0 ){
			AddStatus += "Error en el campo Genero";
			validado = false;
		}
		//-FIN-verifica campos vacios
		
		persona.setRun(run);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEmail(email);
		persona.setFono(telefono);
		persona.setDireccion(direccion);
		persona.setGenero(genero);
		
		if(validado){
			try {
				AddStatus = persona.addPersonaBusiness(persona);
				RequestDispatcher rs = request.getRequestDispatcher("FormAddPersona.jsp");
				request.setAttribute("AddStatus", AddStatus);
				rs.forward(request, response);
								
			} catch (PersistentException e) {
				e.printStackTrace();
			}
		}else{
			AddStatus = "Error en la validacion de los datos";
			RequestDispatcher rs = request.getRequestDispatcher("FormAddPersona.jsp");
			request.setAttribute("AddStatus", AddStatus);
			rs.forward(request, response);
		}				
	}

}
