package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/principal/*"}) /*filta tudo*/
public class FilterAutenticacao extends HttpFilter {
    public FilterAutenticacao() {
    }
    /* destroy tudo*/
	public void destroy() {
	}
	
	/* onde tudo acontece */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session2 = req.getSession();
		
		String usuarioLogado = (String) session2.getAttribute("usuario");
		String urlParaAutenticar = req.getServletPath(); /* URL que está sendo acessada */
		
		/* validar se esta logado e redirecionar */
		if(usuarioLogado == null || (usuarioLogado != null && usuarioLogado.isEmpty()) && 
				!urlParaAutenticar.contains("ServletLogin"))
		{
			RequestDispatcher redireciona1 = request.getRequestDispatcher("/index.jsp?url" + urlParaAutenticar);
			
			request.setAttribute("msg", "Por favor faça o Login!");
			redireciona1.forward(request, response);
			return;
			
		}else {
			chain.doFilter(request, response);			
		}
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
