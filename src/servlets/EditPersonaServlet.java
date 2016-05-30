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
import business.Persona;

/**
 * Servlet implementation class EditPersonaServlet
 */
@WebServlet("/EditPersonaServlet")
public class EditPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rs = request.getRequestDispatcher("/Login.jsp");
		request.setAttribute("LoginStatus",	" Error, No se aceptan peticiones GET");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idP = request.getParameter("idP");
		String run = request.getParameter("run");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String fono = request.getParameter("fono");
		String direccion = request.getParameter("direccion");
		String genero = request.getParameter("genero");
		String foto_b64 = request.getParameter("textArea");
		int empresaId = Integer.parseInt(request.getParameter("empresaIde"));
		
		RequestDispatcher rs = request.getRequestDispatcher("/FormEditPersona.jsp");
		
		Persona persona = new Persona();
		Empresa empresa = new Empresa();
		
		persona.setIdP(Integer.parseInt(idP));
		persona.setRun(run);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEmail(email);
		persona.setFono(fono);
		persona.setDireccion(direccion);
		persona.setGenero(genero);
		persona.setFoto_b64(foto_b64);
		
		empresa.setIdE(empresaId);
		
		persona.setEmpresa(empresa);
		
		try {
			String msj = persona.editPersonaBusiness(persona);
			request.setAttribute("EditPersonaStatus", msj);
			rs.forward(request, response);			
		} catch (PersistentException e) {
			request.setAttribute("EditPersonaStatus", "Error al editar la data");
			rs.forward(request, response);
		}
	}
}
