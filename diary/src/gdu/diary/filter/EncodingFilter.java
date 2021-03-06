package gdu.diary.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")//모든 request마다 utf-8을 인코딩해준다.
public class EncodingFilter implements Filter {

	//생성자
    public EncodingFilter() {
    }
    
    //필터 시작시
  	public void init(FilterConfig fConfig) throws ServletException {
  	}
	//필터 종료시 실행되는 것
	public void destroy() {
	}

	//필터 메서드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//타겟요청이 실행전에 실행되는 코드들
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);//(request)전에 코딩하면 타겟요청 전에 실행, (response)후에 코딩하면 타겟요청 후에 실행
		//타겟요청이 실행 후에 실행되는 코드들
	}

	

}
