package com.yanghuan.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//过滤器（可以理解为特殊的servlet）
public class CharSetFilter implements Filter {
	private String charset="UTF-8";

	public void destroy() {
		System.out.println("destroy");
	}
	public void doFilter(ServletRequest request, 
			ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);
		chain.doFilter(request, response);//让请求响应过程继续下去
	}

	public void init(FilterConfig config) throws ServletException {
		System.out.println("init");
		ServletContext application = config.getServletContext();
		charset = application.getInitParameter("charset");
	}

}
