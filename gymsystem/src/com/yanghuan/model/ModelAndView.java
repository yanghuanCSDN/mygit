package com.yanghuan.model;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModelAndView {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String viewName;
	
	
	public String getViewName() {
		return viewName;
	}
	public ModelAndView setViewName(String viewName) {
		this.viewName = viewName;
		return this;
	}
	public ModelAndView(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}
	
	public ModelAndView( String viewName,
			HttpServletRequest request,
			HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.viewName = viewName;
	}
	public void forward() 
			throws ServletException, IOException{
		//实现jsp的页面跳转 
		request.getRequestDispatcher(viewName)
			.forward(request, response);
	}
	public void redirect() throws IOException{
		HttpSession session = request.getSession();
		Enumeration attributeNames = request.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String key = (String) attributeNames.nextElement();
			session.setAttribute(key, 
					request.getAttribute(key));
			
		}
		response.sendRedirect(viewName);
	}
	public ModelAndView addObject(String key,Object value){
		request.setAttribute(key, value);
		return this;
	}
	public ModelAndView addObject(Map<String, Object> map){
		Set<Entry<String, Object>> entrySet = map.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			request.setAttribute(entry.getKey(), 
					entry.getValue());
		}
		return this;
	}
	public ModelAndView addObject2Session(String key,Object value){
		request.getSession().setAttribute(key, value);
		return this;
	}
	public Object getAttribute(String key){
		return request.getSession().getAttribute(key);
	}
}
