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
 * Servlet implementation class ListPersonaServlet
 */
@WebServlet("/ListPersonaServlet")
public class ListPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPersonaServlet() {
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
		//ArrayList<orm.Persona> listaPersonas = null;
		Persona persona = new Persona();
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		try {
			listaPersonas = persona.listPersonaBusiness();
			
			if(listaPersonas.isEmpty()){
				RequestDispatcher rs = request.getRequestDispatcher("/ListPersona.jsp");
				request.setAttribute("ListPersonaStatus", "No hay datos en la BD");
				rs.forward(request, response);				
			}else{
				request.removeAttribute("busqueda");
				request.setAttribute("ListPersonaStatus", "Listado de Personas");
				request.setAttribute("listaPersonas", listaPersonas);				
				request.getRequestDispatcher("/ListPersona.jsp").forward(request, response);
			}
		} catch (PersistentException e) {
			RequestDispatcher rs = request.getRequestDispatcher("/ListPersona.jsp");
			request.setAttribute("ListPersonaStatus","Servlet: No se pudo efectuar la busqueda de elementos ");
			rs.forward(request, response);
		}
	}
}
