package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class SearchAdvanceServlet
 */
@WebServlet("/SearchAdvanceServlet")
public class SearchAdvanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAdvanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		Persona persona = new Persona();
		List<Persona> listaBusqueda = new ArrayList<Persona>();
		
		String run = request.getParameter("run");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String fono = request.getParameter("fono");
		String direccion = request.getParameter("direccion");
		String genero = request.getParameter("genero");
		
		//verificar campos nulos y efectuar asignaciones vacias en caso de.
		if(run != null){
			persona.setRun(run);
		}			
		else{
			persona.setRun("");
		}
		
		if(nombre != null){
			persona.setNombre(nombre);
		}else{
			persona.setNombre("");
		}
		
		if(apellido != null){
			persona.setApellido(apellido);
		}else{
			persona.setApellido("");
		}
		
		if(email != null){
			persona.setEmail(email);
		}else{
			persona.setEmail("");
		}
		
		if(fono != null){
			persona.setFono(fono);
		}else{
			persona.setFono("");
		}
		
		if(direccion != null){
			persona.setDireccion(direccion);
		}else{
			persona.setDireccion("");
		}
		
		if(genero != null){
			persona.setGenero(genero);
		}else{
			persona.setGenero("");
		}
		

		try {
			listaBusqueda = persona.busquedaAvanzada(persona);
			
			if(listaBusqueda.isEmpty()){
				RequestDispatcher rs = request.getRequestDispatcher("/FormSearchAdvance.jsp");
				request.setAttribute("SearchAdvanceStatus",	"No se encontraron datos asociados a la busqueda");
				rs.forward(request, response);				
			}else{
				//request.removeAttribute("busqueda");
				request.setAttribute("SearchAdvanceStatus",	"Se encontraron los siguientes resultados");
				request.setAttribute("listaPersonas", listaBusqueda);				
				request.getRequestDispatcher("/FormSearchAdvance.jsp").forward(request, response);
			}
		} catch (PersistentException e) {
			RequestDispatcher rs = request.getRequestDispatcher("/FormSearchAdvance.jsp");
			request.setAttribute("SearchAdvanceStatus","Servlet: No se pudo efectuar la busqueda ");
			rs.forward(request, response);
		}	
	}
}
