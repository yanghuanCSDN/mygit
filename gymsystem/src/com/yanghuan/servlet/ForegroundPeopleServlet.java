package com.yanghuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yanghuan.dao.CoachDao;
import com.yanghuan.dao.ForegroundPeopleDao;
import com.yanghuan.model.ModelAndView;

/**
 * ������̨����ϵͳ   1.0�汾 
 * 2017-11-5~2017-11-10
 * ǰ̨��Ա
 * @author Administrator
 *
 */
public class ForegroundPeopleServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int act=0;
		ForegroundPeopleDao foregroundPeopleDao=new ForegroundPeopleDao(); 
		String strAct=request.getParameter("act");
		act=Integer.parseInt(strAct);
		String page=request.getParameter("page");
		int intPage=1;
		if(page!=null && page.matches("\\d{1,9}")){
			intPage=Integer.parseInt(page);
		}
		String name=request.getParameter("name");
		ModelAndView modelAndView=new ModelAndView(request, response);
		switch(act){
			case 1://��ȫ��
				modelAndView
					.addObject("foreground",foregroundPeopleDao.getPageForegroundPeople(intPage))
					.addObject("page",intPage)
					.addObject("endPage",foregroundPeopleDao.getPageCount())
					.setViewName("../WEB-INF/interface/ForegroundPeople.jsp")
					.forward();
				break;
			case 2://��ѯһ����
					modelAndView
					.addObject("foreground",foregroundPeopleDao.getOne(name))
					.addObject("page",intPage)
					.addObject("endPage",foregroundPeopleDao.getPageCount())
					.setViewName("../WEB-INF/interface/ForegroundPeople.jsp")
					.forward();
				break;
			case 3://��û���޸ĵ�����£�Ĭ��ԭ��ֵ
				String cid1=request.getParameter("cid1");
				//�޸�ʱ��Ĭ��ֵ
				int cid=Integer.parseInt(cid1);
				System.out.println(cid);
				String cPhone1=request.getParameter("cPhone1");
				String cPay1=request.getParameter("cPay1");
				String endTime1=request.getParameter("endTime1");
				modelAndView
				     .addObject("cPhone1", cPhone1)
				     .addObject("cid", cid)
				     .addObject("cPay1", cPay1)
				     .addObject("endTime1", endTime1)
				     .setViewName("../foregroundPeople/update.jsp")
				     .forward();
				break;
			case 4://�޸�
				String cPhone=request.getParameter("cPhone");
				String cPay=request.getParameter("cPay");
				String state1=request.getParameter("state");
				String time=request.getParameter("time");
				String cid2=request.getParameter("cid");
				int cid3=Integer.parseInt(cid2);
				int state;
				if(state1.equals("��")){
					state=1;
				}else{
					state=0;
				}
				Boolean boolean1=foregroundPeopleDao.update(cPhone, cPay, time, state, cid3);
				System.out.println(boolean1);
				System.out.println(cid3);
				if(boolean1){
					modelAndView
				     .addObject("judge", "�޸ĳɹ���")
				     .setViewName("/servlet/ForegroundPeopleServlet?act=1")
				     .forward();
				}else{
					modelAndView
				     .addObject("judge", "�޸�ʧ�ܣ�")
				     .setViewName("/servlet/ForegroundPeopleServlet?act=1")
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
