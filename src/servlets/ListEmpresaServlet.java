package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import business.Empresa;

/**
 * Servlet implementation class ListEmpresaServlet
 */
@WebServlet("/ListEmpresaServlet")
public class ListEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmpresaServlet() {
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
		ArrayList<orm.Empresa> listaEmpresas = null;
		Empresa empresa = new Empresa();
		
		try {
			listaEmpresas = empresa.listEmpresaArray();
			
			if(listaEmpresas.isEmpty()){
				RequestDispatcher rs = request.getRequestDispatcher("/ListEmpresa.jsp");
				request.setAttribute("ListEmpresaStatus", "No hay datos en la BD");
				rs.forward(request, response);				
			}else{
				request.removeAttribute("busqueda");
				request.setAttribute("ListEmpresaStatus", "Listado de Empresas");
				request.setAttribute("listaEmpresas", listaEmpresas);				
				request.getRequestDispatcher("/ListEmpresa.jsp").forward(request, response);
			}
		} catch (PersistentException e) {
			RequestDispatcher rs = request.getRequestDispatcher("/ListEmpresa.jsp");
			request.setAttribute("ListEmpresaStatus","Servlet: No se pudo efectuar la busqueda de elementos ");
			rs.forward(request, response);
		}
	}

}
