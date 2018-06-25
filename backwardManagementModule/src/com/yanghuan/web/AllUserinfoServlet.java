package com.yanghuan.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;
import com.yanghuan.dao.BackwardManagementDao;
import com.yanghuan.model.ModelAndView;
import com.yanghuan.model.User;
public class AllUserinfoServlet extends HttpServlet {
	private static final String CHARSET = "UTF-8";
	private	BackwardManagementDao backwardManagement=new BackwardManagementDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int act=1;//默认查全部用户信息
		String strAct=request.getParameter("act");
		if(strAct!=null && strAct.matches("[1-8]")){
			act=Integer.parseInt(strAct);
		}
		String QQNumber = request.getParameter("QQNumber");
		String time = request.getParameter("time");
		String id=request.getParameter("personId");
		int personId=0;
		if(id!=null && id.matches("\\d{1,9}")){
			personId=Integer.parseInt(id);
		}
		
		ModelAndView modelAndView = new ModelAndView(request, response);
		
		switch (act) {
			case 1://查全部用户信息
				modelAndView.addObject("userinfos",backwardManagement.getAll())
					.setViewName("../allUserinfo/allUserinfo.jsp")
					.forward();
				break;
			case 2://查已开通用户信息
				modelAndView.addObject("userinfos",backwardManagement.getAllDredge())
					.setViewName("../allUserinfo/allUserinfoDredge.jsp")
					.forward();
				break;
			case 3://查未开通用户信息
				modelAndView.addObject("userinfos",backwardManagement.getAllNotDredge())
					.setViewName("../allUserinfo/allUserinfoNotDredge.jsp")
					.forward();
				break;
			case 4://申请开通公众空间
				modelAndView.addObject("userinfos",backwardManagement.getAll())
					.setViewName("../allUserinfo/applicationPublicSpace.jsp")
					.forward();
				break;
			case 5://通过QQ查询用户
				if(backwardManagement.getUserinfoByQQ(QQNumber).isEmpty()){
					modelAndView.addObject("msg", "此用户不存在！");
				}
				modelAndView.addObject("userinfos",backwardManagement.getUserinfoByQQ(QQNumber))
							.setViewName("../allUserinfo/applicationPublicSpace.jsp")
							.forward();
				break;
			case 6://通过提交时间查询用户
				if(backwardManagement.getUserinfoByTime(time).isEmpty()){
					modelAndView.addObject("msg", "此用户不存在！");
				}
				modelAndView.addObject("userinfos",backwardManagement.getUserinfoByTime(time))
					.setViewName("../allUserinfo/applicationPublicSpace.jsp")
					.forward();
				break;
				case 7://开通
					if(backwardManagement.applicationPublicSpace(0,personId)){
						modelAndView
							.addObject("msg", "开通成功！")
							.addObject("userinfos",backwardManagement.getAll())
							.setViewName("../allUserinfo/applicationPublicSpace.jsp")
							.forward();
					}
					break;
				case 8://修改成待开通状态（拒绝）
					if(backwardManagement.applicationPublicSpace(1,personId)){
						modelAndView
							.addObject("msg", "修改成功！")
							.addObject("userinfos",backwardManagement.getAll())
							.setViewName("../allUserinfo/applicationPublicSpace.jsp")
							.forward();
						break;
					}
					break;
				default:
					modelAndView.setViewName("../nav.jsp")
								.forward();
				}
			}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
