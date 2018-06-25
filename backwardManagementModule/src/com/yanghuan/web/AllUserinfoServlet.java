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
		int act=1;//Ĭ�ϲ�ȫ���û���Ϣ
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
			case 1://��ȫ���û���Ϣ
				modelAndView.addObject("userinfos",backwardManagement.getAll())
					.setViewName("../allUserinfo/allUserinfo.jsp")
					.forward();
				break;
			case 2://���ѿ�ͨ�û���Ϣ
				modelAndView.addObject("userinfos",backwardManagement.getAllDredge())
					.setViewName("../allUserinfo/allUserinfoDredge.jsp")
					.forward();
				break;
			case 3://��δ��ͨ�û���Ϣ
				modelAndView.addObject("userinfos",backwardManagement.getAllNotDredge())
					.setViewName("../allUserinfo/allUserinfoNotDredge.jsp")
					.forward();
				break;
			case 4://���뿪ͨ���ڿռ�
				modelAndView.addObject("userinfos",backwardManagement.getAll())
					.setViewName("../allUserinfo/applicationPublicSpace.jsp")
					.forward();
				break;
			case 5://ͨ��QQ��ѯ�û�
				if(backwardManagement.getUserinfoByQQ(QQNumber).isEmpty()){
					modelAndView.addObject("msg", "���û������ڣ�");
				}
				modelAndView.addObject("userinfos",backwardManagement.getUserinfoByQQ(QQNumber))
							.setViewName("../allUserinfo/applicationPublicSpace.jsp")
							.forward();
				break;
			case 6://ͨ���ύʱ���ѯ�û�
				if(backwardManagement.getUserinfoByTime(time).isEmpty()){
					modelAndView.addObject("msg", "���û������ڣ�");
				}
				modelAndView.addObject("userinfos",backwardManagement.getUserinfoByTime(time))
					.setViewName("../allUserinfo/applicationPublicSpace.jsp")
					.forward();
				break;
				case 7://��ͨ
					if(backwardManagement.applicationPublicSpace(0,personId)){
						modelAndView
							.addObject("msg", "��ͨ�ɹ���")
							.addObject("userinfos",backwardManagement.getAll())
							.setViewName("../allUserinfo/applicationPublicSpace.jsp")
							.forward();
					}
					break;
				case 8://�޸ĳɴ���ͨ״̬���ܾ���
					if(backwardManagement.applicationPublicSpace(1,personId)){
						modelAndView
							.addObject("msg", "�޸ĳɹ���")
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
