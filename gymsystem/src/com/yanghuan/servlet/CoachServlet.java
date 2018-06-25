package com.yanghuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yanghuan.dao.CoachDao;
import com.yanghuan.model.Coach;
import com.yanghuan.model.Manager;
import com.yanghuan.model.ModelAndView;
/**
 * 健身房后台管理系统   1.0版本 
 * 2017-11-5~2017-11-10
 * 教练
 * @author Administrator
 *
 */
public class CoachServlet extends HttpServlet {
	public CoachServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int act=0;
		CoachDao coachDao=new CoachDao(); 
		String strAct=request.getParameter("act");
		act=Integer.parseInt(strAct);
		String page=request.getParameter("page");
		int intPage=1;
		//matches("\\d{1,9}")  匹配[1-9]数字
		if(page!=null && page.matches("\\d{1,9}")){
			intPage=Integer.parseInt(page);
		}
		String name=request.getParameter("name");
		ModelAndView modelAndView=new ModelAndView(request, response);
		switch(act){
			case 1://查全部
				modelAndView
					.addObject("coaches",coachDao.getPageCoach(intPage))
					.addObject("page",intPage)
					.addObject("endPage",coachDao.getPageCount())
					.setViewName("../WEB-INF/interface/Coach.jsp")
					.forward();
				break;
			case 2://查询一个人
					modelAndView
					.addObject("coaches",coachDao.getOne(name))
					.addObject("page",intPage)
					.addObject("endPage",coachDao.getPageCount())
					.setViewName("../WEB-INF/interface/Coach.jsp")
					.forward();
				break;
			case 3://在没有修改的情况下，默认原先值
				String cid1=request.getParameter("cid1");
				//修改时的默认值
				int cid=Integer.parseInt(cid1);
				String cPhone1=request.getParameter("cPhone1");
				String cPay1=request.getParameter("cPay1");
				String endTime1=request.getParameter("endTime1");
				modelAndView
				     .addObject("cPhone1", cPhone1)
				     .addObject("cid", cid)
				     .addObject("cPay1", cPay1)
				     .addObject("endTime1", endTime1)
				     .setViewName("../coach/update.jsp")
				     .forward();
				break;
			case 4://修改
				String cPhone=request.getParameter("cPhone");
				String cPay=request.getParameter("cPay");
				String state1=request.getParameter("state");
				String time=request.getParameter("time");
				String cid2=request.getParameter("cid");
				int cid3=Integer.parseInt(cid2);
				int state;
				if(state1.equals("否")){
					state=1;
				}else{
					state=0;
				}
				Boolean boolean1=coachDao.update(cPhone, cPay, time, state, cid3);
				System.out.println(boolean1);
				if(boolean1){
					modelAndView
				     .addObject("judge", "修改成功！")
				     .setViewName("/servlet/CoachServlet?act=1")
				     .forward();
				}else{
					modelAndView
				     .addObject("judge", "修改失败！")
				     .setViewName("/servlet/CoachServlet?act=1")
				     .forward();
				}
				break;
		   default:
				break;
		}
	}
	public void init() throws ServletException {
	}

}
