package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
PrintWriter out = response.getWriter(); // devuelve PrinWriter para obtener encode y establecer el retorno
		
		Empresa empresa = new Empresa();
		
		String rut;
		String nombre;
		String email;
		String telefono;
		String direccion;
		
		boolean validado = true;
		
		rut = request.getParameter("rut");
		nombre = request.getParameter("nombre");
		email = request.getParameter("email");
		telefono = request.getParameter("telefono");
		direccion = request.getParameter("direccion");
		
		if( rut.trim().equals("") || rut.trim().length() == 0 ){
			 out.println("Error en el campo Run");
			 validado = false;
		}
		
		if( nombre.trim().equals("") || nombre.trim().length() == 0 ){
			 out.println("Error en el campo Nombre");
			 validado = false;
		}

		if( email.trim().equals("") || email.trim().length() == 0 ){
			 out.println("Error en el campo Email");
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
		
		empresa.setRut(rut);
		empresa.setNombre(nombre);
		empresa.setEmail(email);
		empresa.setFono(telefono);
		empresa.setDireccion(direccion);
		
		if(validado){
			try {
				out.println(empresa.addEmpresaBusiness(empresa));
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			out.println("Error en la validacion de los datos");
		}		
	}

}
