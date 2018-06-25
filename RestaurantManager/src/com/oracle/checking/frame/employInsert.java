package com.oracle.checking.frame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.oracle.checking.service.employService;

//import com.oracle.Service.employService;

public class employInsert extends JFrame {
	private JTextField esalText;
	private JTextField t1;
	private JTextField eaddressText;
	private JTextField esexText;
	private JTextField eageText;
	private JTextField enameText;
	private JTextField eidText;

	employService service = new employService();
	DefaultTableModel model;
	public employInsert(DefaultTableModel model1,final int maxid) {
		super();
		
		this.model = model1;
		//设置绝对布局
		getContentPane().setLayout(null);
		//设置大小
		setSize(297, 434);
		//获取屏幕大小
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		//获取窗口大小
		int ww = getSize().width;
		int wh = getSize().height;
		//设置位置
		setLocation((sw-ww)/2, (sh-wh)/2);
		

		final JLabel one = new JLabel();
		one.setText("编号");
		one.setBounds(24, 26, 52, 18);
		getContentPane().add(one);

		final JLabel tow = new JLabel();
		tow.setText("姓名");
		tow.setBounds(24, 68, 52, 18);
		getContentPane().add(tow);

		final JLabel three = new JLabel();
		three.setText("年龄");
		three.setBounds(24, 110, 52, 18);
		getContentPane().add(three);

		final JLabel four = new JLabel();
		four.setText("性别");
		four.setBounds(24, 161, 52, 18);
		getContentPane().add(four);

		final JLabel five = new JLabel();
		five.setText("住址");
		five.setBounds(24, 207, 52, 18);
		getContentPane().add(five);

		final JLabel six = new JLabel();
		six.setText("入职日期");
		six.setBounds(24, 246, 52, 18);
		getContentPane().add(six);

		final JLabel seven = new JLabel();
		seven.setText("薪资");
		seven.setBounds(24, 283, 52, 18);
		getContentPane().add(seven);

		eidText = new JTextField();
		//往行编辑框中添加ID
		eidText.setText(maxid+"");
		eidText.setBounds(94, 23, 136, 25);
		getContentPane().add(eidText);

		enameText = new JTextField();
		enameText.setBounds(94, 65, 136, 25);
		getContentPane().add(enameText);

		eageText = new JTextField();
		eageText.setBounds(94, 107, 136, 25);
		getContentPane().add(eageText);

		esexText = new JTextField();
		esexText.setBounds(94, 158, 136, 25);
		getContentPane().add(esexText);

		eaddressText = new JTextField();
		eaddressText.setBounds(94, 204, 136, 25);
		getContentPane().add(eaddressText);

		t1 = new JTextField();
		t1.setBounds(94, 239, 136, 25);
		t1.setToolTipText("请按“yyyy-mm-dd”这种格式输入");
		getContentPane().add(t1);

		esalText = new JTextField();
		esalText.setBounds(94, 280, 136, 25);
		getContentPane().add(esalText);

		final JButton insert = new JButton();
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				try {
					//获取行编辑框中的内容
					int id = Integer.valueOf(eidText.getText());
					String name = enameText.getText();
					int age = Integer.valueOf(eageText.getText());
					String sex = esexText.getText();
					String address = eaddressText.getText();
					Date hiredate = Date.valueOf(t1.getText());
					int sal = Integer.valueOf(esalText.getText());
					
					//向数据库中添加信息
					service.InsertInfo(id,name,age,sex,address, hiredate,sal);
					//关闭该窗口
					employInsert.this.dispose();
					
					//添加到model中
					model.addRow(new Object[]{id,name,age,sex,address,hiredate,sal});
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					employInsert.this.dispose();
					return;
				}
				
			}
		});
		insert.setText("添加");
		insert.setBounds(97, 344, 83, 28);
		getContentPane().add(insert);
		
		//关闭窗口同时关闭程序
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//显示窗口
		setVisible(true);
	}

}

