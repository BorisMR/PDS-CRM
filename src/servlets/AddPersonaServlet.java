package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import business.Empresa;
import business.Persona;

/**
 * Servlet implementation class AddPersonaServlet
 */
@WebServlet("/AddPersonaServlet")
public class AddPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String AddStatus = "";
		Persona persona = new Persona();
		Empresa empresa = new Empresa();
		
		String run;
		String nombre;
		String apellido;
		String email;
		String telefono;
		String direccion;
		String genero;
		String fotoB64;
		
		int empresaId;
		
		boolean validado = true;
		
		run = request.getParameter("run");
		nombre = request.getParameter("nombre");
		apellido = request.getParameter("apellido");
		email = request.getParameter("email");
		telefono = request.getParameter("fono");
		direccion = request.getParameter("direccion");
		genero = request.getParameter("genero");
		fotoB64 = request.getParameter("textArea");
		
		empresaId = Integer.parseInt(request.getParameter("empresaIde"));
				
		//--verifica campos vacios
		if( run.trim().equals("") || run.trim().length() == 0 ){
			AddStatus += "Run ";
			validado = false;
		}		
		if( nombre.trim().equals("") || nombre.trim().length() == 0 ){
			AddStatus += "Nombre ";
			validado = false;
		}
		if( apellido.trim().equals("") || apellido.trim().length() == 0 ){
			AddStatus += "Apellido";
			validado = false;
		}
		if( email.trim().equals("") || email.trim().length() == 0 ){
			AddStatus += "Email ";
			validado = false;
		}
		if( telefono.trim().equals("") || telefono.trim().length() == 0 ){
			AddStatus += "Telefono ";
			validado = false;
		}
		if( direccion.trim().equals("") || direccion.trim().length() == 0 ){
			AddStatus += "Direccion ";
			validado = false;
		}
		if( genero.trim().equals("") || genero.trim().length() == 0 ){
			AddStatus += "Error en el campo Genero";
			validado = false;
		}
		
		if( genero.trim().equals("") || genero.trim().length() == 0 ){
			AddStatus += "Error en el campo EmpresaId";
			validado = false;
		}
		
		//-FIN-verifica campos vacios
		
		persona.setRun(run);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEmail(email);
		persona.setFono(telefono);
		persona.setDireccion(direccion);
		persona.setGenero(genero);
		persona.setFoto_b64(fotoB64);
		
		empresa.setIdE(empresaId);
		
		persona.setEmpresa(empresa);
		
		if(validado){
			try {
				AddStatus = persona.addPersonaBusiness(persona);
				RequestDispatcher rs = request.getRequestDispatcher("/FormAddPersona.jsp");
				request.setAttribute("AddPersonaStatus", AddStatus);
				rs.forward(request, response);
								
			} catch (PersistentException e) {
				AddStatus = "PersistentException: "+e.getMessage();
				RequestDispatcher rs = request.getRequestDispatcher("/FormAddPersona.jsp");
				request.setAttribute("AddPersonaStatus", AddStatus);
				rs.forward(request, response);
			}
		}else{
			AddStatus = "Error en la validacion de los datos";
			RequestDispatcher rs = request.getRequestDispatcher("/FormAddPersona.jsp");
			request.setAttribute("AddPersonaStatus", AddStatus);
			rs.forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rs = request.getRequestDispatcher("Login.jsp");
		request.setAttribute("LoginStatus",	" Error, No se aceptan peticiones GET");
		rs.forward(request, response);
		*/
		
		ArrayList<orm.Empresa> listaEmpresas = null;
		Empresa empresa = new Empresa();
		
		try {
			listaEmpresas = empresa.listEmpresaArray();
			
			if(listaEmpresas.isEmpty()){
				RequestDispatcher rs = request.getRequestDispatcher("/FormAddPersona.jsp");
				rs.forward(request, response);			
			}else{
				request.setAttribute("listaEmpresas", listaEmpresas);				
				request.getRequestDispatcher("/FormAddPersona.jsp").forward(request, response);
			}
		} catch (PersistentException e) {
			RequestDispatcher rs = request.getRequestDispatcher("/FormAddPersona.jsp");
			rs.forward(request, response);
		}
	}
}
