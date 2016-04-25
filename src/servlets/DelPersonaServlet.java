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
 * Servlet implementation class DelPersonaServlet
 */
@WebServlet("/DelPersonaServlet")
public class DelPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelPersonaServlet() {
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
		String idP = request.getParameter("idP");
		String runP = request.getParameter("run");
		Persona persona = new Persona();
		
		
		if(!idP.trim().equals("")){
			persona.setIdP(Integer.parseInt(idP));
			try {
				persona.delPersonaBusinessIdP(persona);
				RequestDispatcher rs = request.getRequestDispatcher("/FormSearchSimple.jsp");
				request.setAttribute("SearchSimpleStatus", "Datos Eliminados");
				rs.forward(request, response);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			persona.setRun(runP);
			try {
				persona.delPersonaBusinessRun(persona);
				RequestDispatcher rs = request.getRequestDispatcher("/FormSearchSimple.jsp");
				request.setAttribute("SearchSimpleStatus", "Datos Eliminados");
				rs.forward(request, response);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
