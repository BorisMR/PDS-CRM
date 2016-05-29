package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditEmpresaMiddleServlet
 */
@WebServlet("/EditEmpresaMiddleServlet")
public class EditEmpresaMiddleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmpresaMiddleServlet() {
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
		/*
		<input type="hidden" value="${empresa.idE}" name="idE">
		<input type="hidden" value="${empresa.rut}" name="rut">
		<input type="hidden" value="${empresa.nombre}" name="nombre">
		*/
		String idE = request.getParameter("idE");
		String rut = request.getParameter("rut");
		String nombre = request.getParameter("nombre");
		
		RequestDispatcher rs = request.getRequestDispatcher("/FormEditEmpresa.jsp");
		request.setAttribute("idE", idE);
		request.setAttribute("rut", rut);
		request.setAttribute("nombre", nombre);
		rs.forward(request, response);
	}

}