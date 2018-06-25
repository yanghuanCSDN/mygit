package com.yanghuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yanghuan.dao.LoginDao;
import com.yanghuan.model.Coach;
import com.yanghuan.model.ForegroundPeople;
import com.yanghuan.model.Manager;
import com.yanghuan.model.ModelAndView;

/**
 * 健身房后台管理系统   1.0版本 
 * 2017-11-5~2017-11-10
 * 登录
 * @author Administrator
 *
 */
public class LoginServlet extends HttpServlet {
	LoginDao loginDao=new LoginDao();
	public LoginServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int act=0;
		String strAct=request.getParameter("act");
		act=Integer.parseInt(strAct);
		String userName=request.getParameter("loginName");
		String password=request.getParameter("password");
		String kind=request.getParameter("select");
		ModelAndView modelAndView=new ModelAndView(request, response);
		Manager manager=loginDao.getManager(userName, password);
		Coach coach=loginDao.getCoach(userName, password);
		ForegroundPeople foregroundPeople=loginDao.getForegroundPeople(userName, password);
		switch(act){
		 case 1://登录
			 if(userName.equals("")||password.equals("")){
					modelAndView
					.addObject("judge", "用户名和密码不能为空！")
					.setViewName("../Login.jsp")
					.forward();
				}else{
					if(manager==null&&kind.equals("管理员")||coach==null&&kind.equals("教练")||foregroundPeople==null&&kind.equals("前台人员")){
						modelAndView
						.addObject("judge", "此人不存在！")
						.setViewName("../Login.jsp")
						.forward();
					}else{
						if(kind.equals("管理员")){
							modelAndView
								.addObject2Session("role", manager)
								.addObject2Session("emp", 0)
								.setViewName("CoachServlet?act=1")
								.forward();
						}else{
							if(kind.equals("教练")){
								modelAndView
								.addObject2Session("role", coach)
								.addObject2Session("emp", "1")
								.setViewName("ConsumerServlet?act=1")
								.forward();
							}else{
								modelAndView
								.addObject2Session("role", foregroundPeople)
								.addObject2Session("emp", "2")
								.setViewName("ConsumerServlet?act=1")
								.forward();
					}
				 }
				 }
				 }
			 break;
		 case 2://安全退出
			 request.getSession().invalidate();//让session失效
				modelAndView.addObject("judge", "感谢使用再见!")
					.setViewName("../Login.jsp")
					.forward();
				break;
		}
	}
	public void init() throws ServletException {
		
	}

}
