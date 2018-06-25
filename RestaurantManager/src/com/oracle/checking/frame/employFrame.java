package com.oracle.checking.frame;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.oracle.checking.service.employService;
import com.oracle.checking.unit.Employ;

//import com.oracle.Service.employService;
//import com.oracle.Test.Employ;


public class employFrame extends JInternalFrame {
	DefaultTableModel model;
	
	employInsert eit;
	employService service = new employService();
	//employSelect est;
	employUpdate eut;
	
	private JTable table;
	
	public employFrame() {
		super();
		try {
			setClosable(true);
			setBackground(Color.LIGHT_GRAY);
			setTitle("员工信息功能表");
		
			//设置绝对布局
			getContentPane().setLayout(null);
			//设置大小
			setSize(521, 396);
			//设置位置
			setLocation(0, 0);
		    final JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBackground(Color.PINK);
			scrollPane.setBounds(10, 40, 491, 202);
			getContentPane().add(scrollPane);
			
			model = new DefaultTableModel();
			model.addColumn("员工编号");
			model.addColumn("员工姓名");
			model.addColumn("员工年龄");
			model.addColumn("员工性别");
			model.addColumn("员工住址");
			model.addColumn("员工入职日期");
			model.addColumn("员工薪资");
	
			ArrayList<Employ> arr = service.GetEmployInfo();
			for (int i=0; i<arr.size(); i++){
				Employ e = arr.get(i);
				model.addRow(new Object[]{
					e.getEid()
					, e.getEname()
					, e.getEage()
					, e.getEsex()
					, e.getEaddress()
					, e.getEhiredate()
					, e.getEsal()
				});
			}
			table = new JTable(model);
			scrollPane.setViewportView(table);
			
			
			
			final JButton insert = new JButton();
			insert.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					//获取行数
					int count = model.getRowCount();
					int max = 0;
					for (int i=0; i<count; i++){
						//得到该行记录中的学号
						int id = (Integer)model.getValueAt(i, 0);
						if (max < id)
							max = id;
					}
					//给添加函数传参
					JOptionPane.showMessageDialog(null, "按要求添加，信息要完整哟！");
					new employInsert(model,max+1);
				}
			});
			insert.setText("增加");
			insert.setBounds(42, 290, 64, 28);
			getContentPane().add(insert);
	
			final JButton delete = new JButton();
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
						try {
							//获得选中行数
						    int row = table.getSelectedRowCount();
						    if(row == 0){
						    	JOptionPane.showMessageDialog(null,
						    			"请选择一行！");
						    }else if(row > 1){
						    	JOptionPane.showMessageDialog(null,
						    			"请勿多选！");
						    }else{
						    	//获得选中行号
						    	int count = table.getSelectedRow();
						    	//获取该行的id
						    	int id = (Integer) model.getValueAt(count, 0);
						        //根据id删除数据库中的信息
						    	service.DeleteInfo(id);
						    	//删除界面中的信息
						        model.removeRow(count);
						    	JOptionPane.showMessageDialog(null,
						    			"删除成功！");
						    }
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					
				}
			});
			delete.setText("删除");
			delete.setBounds(153, 290, 64, 28);
			getContentPane().add(delete);
	
			final JButton update = new JButton();
			update.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					//定义参数
					int id = 0;
					String name = null;
					int age = 0;
					String sex = null;
					String address = null;
					Date hiredate = null;
					int sal = 0;
					int count = 0;
					
					//获取选中行数并判断
					int row = table.getSelectedRowCount();
				    if(row == 0){
				    	JOptionPane.showMessageDialog(null,
				    			"请选择一行！");
				    	return;
				    }else if(row > 1){
				    	JOptionPane.showMessageDialog(null,
				    			"请勿多选！");
				    	return;
				    }else{
				    	//获得选中行号
				    	count = table.getSelectedRow();
				    	//获取该行的id
				    	id = (int) model.getValueAt(count, 0);
				    	name = (String) model.getValueAt(count, 1);
				    	age = (Integer) model.getValueAt(count, 2);
				    	sex = (String) model.getValueAt(count, 3);
				    	address = (String)model.getValueAt(count, 4);
				    	hiredate = (Date) model.getValueAt(count, 5);
				    	sal = (Integer) model.getValueAt(count, 6);
				    }
					//修改显示界面中的内容
					new employUpdate(model,id,name,age,sex,address,
							hiredate,sal,count);
				}
			});
			update.setText("修改");
			update.setBounds(270, 290, 64, 28);
			getContentPane().add(update);
	
			final JButton select = new JButton();
			select.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					//弹出employSelect（根据ID查找信息）窗口
					new employSelect(model);
				}
			});
			select.setText("查询");
			select.setBounds(379, 290, 64, 28);
			getContentPane().add(select);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
			//关闭窗口同时关闭程序
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			//显示窗口
			setVisible(true);
		
	}

}
