package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.orm.PersistentException;

import business.Empresa;

/**
 * Servlet implementation class DelEmpresaServlet
 */
@WebServlet("/DelEmpresaServlet")
public class DelEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelEmpresaServlet() {
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
		
		String idE;
		boolean validado = true;
				
		idE = request.getParameter("idE");
		
		Empresa empresa = new Empresa();
		
		empresa.setIdE(Integer.parseInt(idE));
		
		if( idE.trim().equals("") || idE.trim().length() == 0 ){
			 out.println("Error en el campo ID");
			 validado = false;
		}
		
		if(validado){
			try {
				out.println(empresa.delEmpresaBusiness(empresa));
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			out.print("Error en la validacion de los datos");
		}
	}
}