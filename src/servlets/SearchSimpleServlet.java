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
 * Servlet implementation class SearchSimplePersonaServlet
 */
@WebServlet("/SearchSimpleServlet")
public class SearchSimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSimpleServlet() {
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
		String busqueda="";
		Persona persona = new Persona();
		List<Persona> listaBusqueda = new ArrayList<Persona>();
		
		busqueda = request.getParameter("busqueda");
		
		try {
			listaBusqueda = persona.busquedaSimple(busqueda);
			
			if(listaBusqueda.isEmpty()){
				RequestDispatcher rs = request.getRequestDispatcher("/FormSearchSimple.jsp");
				request.setAttribute("SearchSimpleStatus",	"No se encontraron datos asociados a la busqueda");
				rs.forward(request, response);				
			}else{
				request.removeAttribute("busqueda");
				request.setAttribute("SearchSimpleStatus",	"Se encontraron los siguientes resultados");
				request.setAttribute("listaPersonas", listaBusqueda);				
				request.getRequestDispatcher("/FormSearchSimple.jsp").forward(request, response);
			}
		} catch (PersistentException e) {
			RequestDispatcher rs = request.getRequestDispatcher("/FormSearchSimple.jsp");
			request.setAttribute("SearchSimpleStatus","Servlet: No se pudo efectuar la busqueda ");
			rs.forward(request, response);
		}		
	}
}
