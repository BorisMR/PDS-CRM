package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter(); // devuelve PrinWriter para obtener encode y establecer el retorno
		
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
		
		if( run.trim().equals("") || run.trim().length() == 0 ){
			 out.println("Error en el campo Run");
			 validado = false;
		}
		
		if( nombre.trim().equals("") || nombre.trim().length() == 0 ){
			 out.println("Error en el campo Nombre");
			 validado = false;
		}

		if( apellido.trim().equals("") || apellido.trim().length() == 0 ){
			 out.println("Error en el campo Apellido");
			 validado = false;
		}

		if( email.trim().equals("") || email.trim().length() == 0 ){
			 out.println("Error en el campo Mail");
			 validado = false;
		}

		if( telefono.trim().equals("") || telefono.trim().length() == 0 ){
			 out.println("Error en el campo Telefono");
			 validado = false;
		}

		if( direccion.trim().equals("") || direccion.trim().length() == 0 ){
			 out.println("Error en el campo Direccion");
			 validado = false;
		}

		if( genero.trim().equals("") || genero.trim().length() == 0 ){
			 out.println("Error en el campo Genero");
			 validado = false;
		}
		
		persona.setRun(run);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEmail(email);
		persona.setFono(telefono);
		persona.setDireccion(direccion);
		persona.setGenero(genero);
		
		if(validado){
			try {
				out.println(persona.addPersonaBusiness(persona));
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			out.println("Error en la validacion de los datos");
		}				
	}

}
