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

import business.Usuario;

/**
 * Servlet implementation class AddUsuarioServlet
 */
@WebServlet("/AddUsuarioServlet")
public class AddUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		String LoginStatus = "";
		RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
		request.setAttribute("LoginStatus",	" Error, No se aceptan peticiones GET");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter(); // devuelve PrinWriter para obtener encode y establecer el retorno
		
		Usuario usuario = new Usuario();
		
		String user;
		String pass;
		
		boolean validado = true;
				
		user = request.getParameter("usser");
		pass = request.getParameter("pass");		
		
		if( user.trim().equals("") || user.trim().length() == 0 ){
			 out.println("Error en el campo Usuario");
			 validado = false;
		}else{
			usuario.setUser(user);
		}

		if( pass.trim().equals("") || pass.trim().length() == 0 ){
			 out.println("Error en el campo Password");
			 validado = false;
		}else{
			usuario.setPassword(pass);
		}	
		
		if(validado){
			try {
				out.println(usuario.addUsuarioBusiness(usuario));
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			out.println("Error en la validacion de los datos");
		}
	}

}
