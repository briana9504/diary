package gdu.diary.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/auth/*")// /Auth/IndexController -> 요청 EncodingFilter 2. AuthFilter 3.IndexController
//4.AuthFilter 5.EncodingFilter (response필터링)
public class AuthFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//로그인이 되어있지 않은상태 "/Auth/"문자로 시작하는 요청이 들어오면 redirect
		//request가 HttpServletRequest의 부모타입인 ServletRequest이여서 session을 못쓰므로 형변환 해줘야함
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		if(session.getAttribute("sessionMember") == null) {
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/login");
			return;//새로운 요청발생으로 doFilter매서드를 종료
		}
		chain.doFilter(request, response);
	}
	
    public AuthFilter() {
    }

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
