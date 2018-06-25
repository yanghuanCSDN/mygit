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
 * 健身房后台管理系统   1.0版本 
 * 2017-11-5~2017-11-10
 * 顾客
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
			case 1://查全部
				modelAndView
					.addObject("consumers",consumerDao.getPageConsumer(intPage))
					.addObject("page",intPage)
					.addObject("endPage",consumerDao.getPageCount())
					.setViewName("../WEB-INF/interface/consumer.jsp")
					.forward();
				break;
			case 2://查询一个人
					modelAndView
					.addObject("consumers",consumerDao.getOne(name))
					.addObject("page",intPage)
					.addObject("endPage",consumerDao.getPageCount())
					.setViewName("../WEB-INF/interface/consumer.jsp")
					.forward();
				break;
			case 3://在没有修改的情况下，默认原先值
				String cid1=request.getParameter("cid1");
				//修改时的默认值
				int cid=Integer.parseInt(cid1);
				System.out.println(cid);
				String course=request.getParameter("course");
				modelAndView
					 .addObject("cid", cid)
				     .addObject("course", course)
				     .setViewName("../consumer/update.jsp")
				     .forward();
				break;
			case 4://修改
				String detail=request.getParameter("detail");
				String cid2=request.getParameter("cid");
				int cid3=Integer.parseInt(cid2);
				Boolean boolean1=consumerDao.update(cid3,detail);
				System.out.println(boolean1);
				System.out.println(cid3);
				if(boolean1){
					modelAndView
				     .addObject("judge", "更新成功！")
				     .setViewName("/servlet/ConsumerServlet?act=1")
				     .forward();
				}else{
					modelAndView
				     .addObject("judge", "更新失败！")
				     .setViewName("/servlet/ConsumerServlet?act=1")
				     .forward();
				}
				break;
			/*case 5://图片上传
				System.out.println("55");
				得到上传路径的保存目录
				String savePath=this.getServletContext().getRealPath("/upload");
				String filename=null;
				File file=new File(savePath);
				//判断上传文件的保存目录是否存在
				if(file.exists()&&!file.isDirectory()){
					System.out.println("目录不存在，需要创建！");
					//创建目录
					file.mkdir();
				}
				//创建一个DiskFileItemFactory工厂
				DiskFileItemFactory factory=new DiskFileItemFactory();
				//创建一个文件上传解析器
			ServletFileUpload upload=new ServletFileUpload(factory);
				//解决上传文件名的中文乱码
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
						//处理获得道德上传文件的文件名路径部分，只保留文件名部分
						filename=filename.substring(filename.lastIndexOf("\\")+1);
						//获取item中的上传文件的输入流
						InputStream in=item.getInputStream();
						//创建一个文件输出流
						FileOutputStream out=new FileOutputStream(savePath+"\\"+filename);
						//创建一个缓冲区
						byte buffer[]=new byte[1024];
						//判断输入流中数据是否已经读完的标识
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
