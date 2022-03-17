package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
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
		
		String usuarioLogado = session2.getAttribute("usuario");
				
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
