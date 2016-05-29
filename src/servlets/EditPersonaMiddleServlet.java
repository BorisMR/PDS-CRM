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
 * Servlet implementation class EditPersonaMiddleServlet
 */
@WebServlet("/EditPersonaMiddleServlet")
public class EditPersonaMiddleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonaMiddleServlet() {
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
		String run = request.getParameter("run");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String fono = request.getParameter("fono");
		String direccion = request.getParameter("direccion");
		String genero = request.getParameter("genero");
		String empresanombre = request.getParameter("empresanombre");
		String foto_b64 = request.getParameter("foto_b64");
		
		RequestDispatcher rs = request.getRequestDispatcher("/FormEditPersona.jsp");
		
		request.setAttribute("idP", idP);
		request.setAttribute("run", run);
		request.setAttribute("nombre", nombre);
		request.setAttribute("apellido", apellido);
		request.setAttribute("email", email);
		request.setAttribute("fono", fono);
		request.setAttribute("direccion", direccion);
		request.setAttribute("genero", genero);
		request.setAttribute("foto_b64", foto_b64);
		request.setAttribute("empresanombre", empresanombre);
		
		ArrayList<orm.Empresa> listaEmpresas = null;
		Empresa empresa = new Empresa();
		
		try {
			listaEmpresas = empresa.listEmpresaArray();
			
			if(listaEmpresas.isEmpty()){
				rs.forward(request, response);			
			}else{
				request.setAttribute("listaEmpresas", listaEmpresas);
				
				String outList = "<div class='form-group'>"
						+ "<label>Empresa:</label>"
						+ "<select multiple class='form-control' name='empresaIde'>'";
				for (orm.Empresa empresaL : listaEmpresas) {
					if(empresaL.getNombre().equals(empresanombre)){
						outList += "<option value='"+empresaL.getIdE()+"' selected>"+empresaL.getNombre()+"</option>";
					}else{
						outList += "<option value='"+empresaL.getIdE()+"'>"+empresaL.getNombre()+"</option>";
					}
				}
				outList += "</select></div>";
				
				request.setAttribute("LISTA", outList);
				request.getRequestDispatcher("/FormEditPersona.jsp");
				rs.forward(request, response);
			}
		} catch (PersistentException e) {
			rs.forward(request, response);
		}				
		rs.forward(request, response);
	}

}
