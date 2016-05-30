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

import business.Bitacora;

/**
 * Servlet implementation class AddBitacoraServlet
 */
@WebServlet("/AddBitacoraServlet")
public class AddBitacoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBitacoraServlet() {
        super();
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
		RequestDispatcher rs = request.getRequestDispatcher("/FormAddBitacora.jsp");
		Bitacora bitToAdd = new Bitacora();
		
		String idP = request.getParameter("idP");
		String entrada = request.getParameter("entrada");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		request.setAttribute("idP", idP);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		
		bitToAdd.setIdP_reg(Integer.parseInt(idP));
		bitToAdd.setEntrada(entrada);
		
		try {
			bitToAdd.addBitacoraBusiness(bitToAdd);
			request.setAttribute("AddBitacoraStatus", "Entrada registrada");
			rs.forward(request, response);
		} catch (PersistentException e) {
			request.setAttribute("AddBitacoraStatus", "No se pudo registrar entrada en BD");
			rs.forward(request, response);
		}		
	}
}
