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

import business.Bitacora;
import business.Persona;

/**
 * Servlet implementation class ListBitacoraServlet
 */
@WebServlet("/ListBitacoraServlet")
public class ListBitacoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBitacoraServlet() {
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
		RequestDispatcher rs = request.getRequestDispatcher("/ListBitacora.jsp");
		
		String idP = request.getParameter("idP");
		String run = request.getParameter("run");
		Bitacora bitacora = new Bitacora();
		List<Bitacora> listaBitacoras = new ArrayList<Bitacora>();
		
		Persona persona = new Persona();
		
		persona.setRun(run);
		
		try {
			persona = persona.getPersonaBusinessByRun(persona);
			listaBitacoras = bitacora.ListBitacorasByIDP(Integer.parseInt(idP));
			request.setAttribute("listaBitacoras", listaBitacoras);
			request.setAttribute("persona",	persona);			
			rs.forward(request, response);
		} catch (PersistentException e) {
			rs.forward(request, response);
		}		
	}
}
