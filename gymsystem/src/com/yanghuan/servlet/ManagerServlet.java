package com.yanghuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yanghuan.dao.ForegroundPeopleDao;
import com.yanghuan.model.ForegroundPeople;
import com.yanghuan.model.ModelAndView;
/**
 * 健身房后台管理系统   1.0版本 
 * 2017-11-5~2017-11-10
 * 管理员
 * @author Administrator
 *
 */
public class ManagerServlet extends HttpServlet {
	ForegroundPeopleDao foregroundPeopleDao=new ForegroundPeopleDao();
	public ManagerServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act=request.getParameter("act");
		int actFlag=6;
		if(act!=null && act.matches("[1346]")){
			actFlag=Integer.parseInt(act);
		}
		String page=request.getParameter("page");
		int intPage=1;
		if(page!=null && page.matches("\\d{1,9}")){
			intPage=Integer.parseInt(page);
		}
		ModelAndView andView=new ModelAndView(request, response);
		switch (actFlag) {
		}
	}


	public void init() throws ServletException {
	}

}
