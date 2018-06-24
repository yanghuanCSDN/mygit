package com.oracle.checking.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.oracle.checking.service.ClientManagerService;
import com.oracle.checking.unit.Client;


//会员顾客表单界面
public class Client1 extends JInternalFrame {
	private JTable table;
	DefaultTableModel model;
	ClientManagerService service=new ClientManagerService();
	public Client1(){
		super();
		//面板背景颜色
		setBackground(Color.lightGray);
		try {
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 30, 440, 229);
		getContentPane().add(scrollPane);
		model=new DefaultTableModel();
		model.addColumn("顾客编号");
		model.addColumn("顾客密码");
		model.addColumn("顾客名字");
		model.addColumn("顾客生日");
		model.addColumn("顾客等级");
		model.addColumn("顾客类型");
		table = new JTable(model);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(null);
		setTitle("普通顾客");
		setClosable(true);
		setSize(523, 394);
		setLocation(0, 0);
		setVisible(true);
		//清空表中的数据
       int all=model.getRowCount();
	   for(int i=0;i<all;i++){
		//永远移除第一行的
			model.removeRow(0);
		}
	  ArrayList<Client> arr=service.getClient();
	     for(int i=0;i<arr.size();i++){
	    	 Client c=arr.get(i);
	    	 model.addRow(new Object[]{
	    			 c.getClientid(),
	    			 c.getClientpwd(),
	    			 c.getClientname(),
	    			 c.getClientbirthday(),
	    			 c.getClientgrade(),
	    			 c.getClientkind()
	    	 });
	     }
		} catch (SQLException e) {
				e.printStackTrace();
	}
			
		
		
        final JButton select = new JButton();
        select.addActionListener(new ActionListener() {
        	public void actionPerformed(final ActionEvent e) {
        		new ClientSelect(model);
        	}
        });
		select.setText("查找");
		select.setBounds(43, 294, 106, 28);
		getContentPane().add(select);

		final JButton delete = new JButton();
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				try {
					//获取到选中的行数
					int hs=table.getSelectedRowCount();
					if(hs==0){
						JOptionPane.showMessageDialog(null, "请先选择一行");
						return;
					}
					else if(hs>1){
						JOptionPane.showMessageDialog(null, "只能选择一行");
						return;
					}else{
					//获取到选中的行号
					int row=table.getSelectedRow();
					
					int clientid=(Integer) model.getValueAt(row, 0);
					
						service.deleteUser(clientid);
						model.removeRow(row);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		delete.setText("删除");
		delete.setBounds(195, 294, 106, 28);
		getContentPane().add(delete);

		final JButton insert = new JButton();
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int hang=table.getRowCount();
				int maxid = 0;
				for(int i=0;i<hang;i++){
					int mid=(Integer) model.getValueAt(i, 0);
					if(maxid<mid){
						maxid=mid;
					}
				}
				JOptionPane.showMessageDialog(null, "按要求添加，信息要完整哟！");
				new ClientInsert(model,maxid+1);
			}
		});
		insert.setText("增加");
		insert.setBounds(369, 294, 106, 28);
		getContentPane().add(insert);


	}

}
