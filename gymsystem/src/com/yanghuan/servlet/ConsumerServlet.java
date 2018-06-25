package com.yanghuan.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yanghuan.dao.CoachDao;
import com.yanghuan.dao.ConsumerDao;
import com.yanghuan.model.ModelAndView;
/**
 * ������̨����ϵͳ   1.0�汾 
 * 2017-11-5~2017-11-10
 * �˿�
 * @author Administrator
 *
 */
public class ConsumerServlet extends HttpServlet {
	public ConsumerServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int act=0;
		ConsumerDao consumerDao=new ConsumerDao(); 
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
					.addObject("consumers",consumerDao.getPageConsumer(intPage))
					.addObject("page",intPage)
					.addObject("endPage",consumerDao.getPageCount())
					.setViewName("../WEB-INF/interface/consumer.jsp")
					.forward();
				break;
			case 2://��ѯһ����
					modelAndView
					.addObject("consumers",consumerDao.getOne(name))
					.addObject("page",intPage)
					.addObject("endPage",consumerDao.getPageCount())
					.setViewName("../WEB-INF/interface/consumer.jsp")
					.forward();
				break;
			case 3://��û���޸ĵ�����£�Ĭ��ԭ��ֵ
				String cid1=request.getParameter("cid1");
				//�޸�ʱ��Ĭ��ֵ
				int cid=Integer.parseInt(cid1);
				System.out.println(cid);
				String course=request.getParameter("course");
				modelAndView
					 .addObject("cid", cid)
				     .addObject("course", course)
				     .setViewName("../consumer/update.jsp")
				     .forward();
				break;
			case 4://�޸�
				String detail=request.getParameter("detail");
				String cid2=request.getParameter("cid");
				int cid3=Integer.parseInt(cid2);
				Boolean boolean1=consumerDao.update(cid3,detail);
				System.out.println(boolean1);
				System.out.println(cid3);
				if(boolean1){
					modelAndView
				     .addObject("judge", "���³ɹ���")
				     .setViewName("/servlet/ConsumerServlet?act=1")
				     .forward();
				}else{
					modelAndView
				     .addObject("judge", "����ʧ�ܣ�")
				     .setViewName("/servlet/ConsumerServlet?act=1")
				     .forward();
				}
				break;
			/*case 5://ͼƬ�ϴ�
				System.out.println("55");
				�õ��ϴ�·���ı���Ŀ¼
				String savePath=this.getServletContext().getRealPath("/upload");
				String filename=null;
				File file=new File(savePath);
				//�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
				if(file.exists()&&!file.isDirectory()){
					System.out.println("Ŀ¼�����ڣ���Ҫ������");
					//����Ŀ¼
					file.mkdir();
				}
				//����һ��DiskFileItemFactory����
				DiskFileItemFactory factory=new DiskFileItemFactory();
				//����һ���ļ��ϴ�������
			ServletFileUpload upload=new ServletFileUpload(factory);
				//����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8");
				if(!ServletFileUpload.isMultipartContent(request)){
					request.getParameter("upload");
					return;
				}
			try {
				List<FileItem> list=upload.parseRequest(request);
				for (FileItem item : list) {					if(item.isFormField()){
						String name1=item.getFieldName();
						String value=item.getString("UTF-8");
					}else{
						 filename=item.getName();
						if(filename==null||filename.trim().equals("")){
							continue;
						}
						//�����õ����ϴ��ļ����ļ���·�����֣�ֻ�����ļ�������
						filename=filename.substring(filename.lastIndexOf("\\")+1);
						//��ȡitem�е��ϴ��ļ���������
						InputStream in=item.getInputStream();
						//����һ���ļ������
						FileOutputStream out=new FileOutputStream(savePath+"\\"+filename);
						//����һ��������
						byte buffer[]=new byte[1024];
						//�ж��������������Ƿ��Ѿ�����ı�ʶ
						int len=0;
						while((len=in.read(buffer))>0){
							out.write(buffer,0,len);
						}
						in.close();
						out.flush();
						out.close();
						item.delete();
					}
				}			} catch (FileUploadException e) {
				e.printStackTrace();			}
				break;
				default:
				break;*/
		}
		
	}
	public void init() throws ServletException {
	}

}
