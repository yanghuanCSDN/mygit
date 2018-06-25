package com.oracle.checking.frame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.oracle.checking.service.employService;

//import com.oracle.Service.employService;

public class employSelect extends JFrame {
	private JTextField idText;
	
	DefaultTableModel model;
	public employSelect(DefaultTableModel model1) {
		super();
		employService service = new employService();
		
		this.model = model1;
		getContentPane().setLayout(null);
		
		//设置绝对布局
		//设置大小
		setSize(285, 225);
		//获取屏幕大小
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		//获取窗口大小
		int ww = getSize().width;
		int wh = getSize().height;
		//设置位置
		setLocation((sw-ww)/2, (sh-wh)/2);
		
		//关闭窗口同时关闭程序
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//显示窗口
		setVisible(true);

		idText = new JTextField();
		idText.setBounds(107, 53, 96, 28);
		getContentPane().add(idText);
		
		final JButton select = new JButton();
		select.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				//定义各信息
				String mname;
				int mage;
				String msex;
				String maddress;
				Date mhiredate;
				int msal;
				//获取ID编辑框中的内容
				String id = idText.getText();
				int sid = Integer.valueOf(id);
				//判断该ID在表中是否存在
				int count = model.getRowCount();
				int mid;
				int i;
				for (i = 0; i < count; i++) {
					//获取第i行的ID,姓名，年龄，性别，住址，入职日期，薪资
					mid = (Integer) model.getValueAt(i, 0);
					mname = (String) model.getValueAt(i, 1);
					mage = (Integer) model.getValueAt(i, 2);
					msex = (String) model.getValueAt(i, 3);
					maddress = (String) model.getValueAt(i, 4);
					mhiredate = (Date) model.getValueAt(i, 5);
					msal = (Integer) model.getValueAt(i, 6);
					//若存在，弹出该ID对应的信息窗口
					if(sid==mid){
						//service.
						//关闭窗口
						employSelect.this.dispose();
						//弹出对应信息
						JOptionPane.showMessageDialog(null, "员工编号为"+mid+"的信息为：\n"
								+ " 姓名："+mname+" \n年龄："+mage+" \n性别："+msex
								+" \n住址："+maddress+"\n 入职日期："+mhiredate+
								" \n薪资："+msal);
						break;
					}
				}
				if(i>=count){
					JOptionPane.showMessageDialog(null, "该ID不存在！");
				}
				
			}
		});
		select.setText("查询");
		select.setBounds(93, 119, 68, 28);
		getContentPane().add(select);

		final JLabel label = new JLabel();
		label.setText("编号查询");
		label.setBounds(43, 58, 58, 18);
		getContentPane().add(label);

		//关闭窗口同时关闭程序
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//显示窗口
		setVisible(true);		
	}

}
