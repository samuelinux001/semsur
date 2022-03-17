package Servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {

    }
    /* recebe os dados por url*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
	
	/* recebe os dados por formulário*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()){
			
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			
			RequestDispatcher redirecionar = request.getRequestDispatcher("principal/principal.jsp");
			redirecionar.forward(request, response);
			
	}else {
		RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg", "Informe o login e senha!");
		redirecionar.forward(request, response);
	}		
	}	
}

