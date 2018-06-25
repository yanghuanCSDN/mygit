package com.yanghuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yanghuan.dao.CoachDao;
import com.yanghuan.dao.EquipmentDao;
import com.yanghuan.model.ModelAndView;
/**
 * 健身房后台管理系统   1.0版本 
 * 2017-11-5~2017-11-10
 * 器材
 * @author Administrator
 *
 */
public class EquipmentServlet extends HttpServlet {
	public EquipmentServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int act=0;
		EquipmentDao equipmentDao=new EquipmentDao(); 
		String strAct=request.getParameter("act");
		act=Integer.parseInt(strAct);
		String page=request.getParameter("page");
		int intPage=1;
		//matches正则表达式
		if(page!=null && page.matches("\\d{1,9}")){
			intPage=Integer.parseInt(page);
		}
		String name=request.getParameter("name");
		ModelAndView modelAndView=new ModelAndView(request, response);
		switch(act){
			case 1://查全部
				modelAndView
					.addObject("equipments",equipmentDao.getPageEquipment(intPage))
					.addObject("page",intPage)
					.addObject("endPage",equipmentDao.getPageCount())
					.setViewName("../WEB-INF/interface/equipment.jsp")
					.forward();
				break;
			case 2://查询一个人
					modelAndView
					.addObject("equipments",equipmentDao.getOne(name))
					.addObject("page",intPage)
					.addObject("endPage",equipmentDao.getPageCount())
					.setViewName("../WEB-INF/interface/equipment.jsp")
					.forward();
				break;
		   default:
				break;
		}
		
	}
	public void init() throws ServletException {
	}
}
