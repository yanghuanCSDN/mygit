package com.yanghuan.servlet;
/*
 * 在Servlet作为过滤器使用时，它可以对客户的请求进行处理。处理完成后，它会交给下一个过滤器处理，
 * 这样，客户的请求在过滤链里逐个处理，直到请求发送到目标为止。
 */
import javax.servlet.Filter;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//过滤器（可以理解为特殊的servlet）
public class CharSetFilter implements Filter {
	private String charset;
	public void destroy() {
		System.out.println("destroy");
	}
	public void doFilter(ServletRequest request, 
			ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);//决定了后台servlet的http服务返回到前台的数据类型
		chain.doFilter(request, response);//让请求响应过程继续下去
	}
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init");
		ServletContext application = config.getServletContext();
		charset = application.getInitParameter("charset");
		// config.getInitParameter(name) 得到servlet初始化参数
	}

}
