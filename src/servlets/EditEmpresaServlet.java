package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Empresa;

/**
 * Servlet implementation class EditEmpresaServlet
 */
@WebServlet("/EditEmpresaServlet")
public class EditEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmpresaServlet() {
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
		String idE = request.getParameter("idE");
		String rut = request.getParameter("rut");
		String nombre = request.getParameter("nombre");
		
		Empresa empresaEdit = new Empresa();
		
		empresaEdit.setIdE(Integer.parseInt(idE));
		empresaEdit.setRut(rut);
		empresaEdit.setNombre(nombre);
		
		empresaEdit.editEmpresaBusiness(empresaEdit);//string
		
		RequestDispatcher rs = request.getRequestDispatcher("/Index.jsp");
		//request.setAttribute("fieldhtmlvalue", "mensaje");
		rs.forward(request, response);
	}

}
