package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import business.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		Usuario usuarioAVerificar = new Usuario();
		usuarioAVerificar.setUser(user);
		usuarioAVerificar.setPassword(pass);
		
		String LoginStatus = "";
		
		try {
			if(usuarioAVerificar.validarUsuarioBusiness(usuarioAVerificar)){
				RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
				rs.forward(request, response);
			}else{				
				RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
				request.setAttribute("LoginStatus",	" Error en los datos ingresados. Saludos "+usuarioAVerificar.getUser()+"!!!");
				rs.forward(request, response);
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

}
