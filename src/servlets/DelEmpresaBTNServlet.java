package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import business.Empresa;
import business.Persona;

/**
 * Servlet implementation class DelEmpresaBTNServlet
 */
@WebServlet("/DelEmpresaBTNServlet")
public class DelEmpresaBTNServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelEmpresaBTNServlet() {
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
		String idE = request.getParameter("idE");
		Empresa empresa = new Empresa();
		
		
		if(!idE.trim().equals("")){
			empresa.setIdE(Integer.parseInt(idE));
			try {
				empresa.delEmpresaBusinessIdE(empresa);
				RequestDispatcher rs = request.getRequestDispatcher("/ListEmpresa.jsp");
				request.setAttribute("DelEmpresaStatus", "Empresa Eliminada");
				rs.forward(request, response);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			
		}
	}

}
