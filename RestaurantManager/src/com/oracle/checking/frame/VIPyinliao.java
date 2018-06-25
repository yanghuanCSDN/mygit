package com.oracle.checking.frame;


import java.awt.Color;
import java.awt.Font;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.SQLException;
	import java.util.ArrayList;

	import javax.swing.JButton;
	import javax.swing.JInternalFrame;
import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.WindowConstants;
	import javax.swing.table.DefaultTableModel;
	import javax.xml.ws.Service;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class VIPyinliao extends JInternalFrame {
		/*DefaultTableModel是JTable的模型，相当于替身
		 * 一般存储数据都用DefaultTableModel去存储，存好了，放在JTable里去就好了
		 */
		 private JTable table;
		
		int page=3;
		final int LINES = 5;
		//创建表
		DefaultTableModel model;
		//创建按钮
		JButton next;
		JButton previous;
		public VIPyinliao() {
			super();
			//设置绝对布局
			getContentPane().setLayout(null);
			//设置大小
			setSize(497, 385);
			//获取屏幕大小
			int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
			int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
			//获取窗口大小
			int ww = getSize().width;
			int wh = getSize().height;
			//设置位置
			setLocation(0, 0);
			//getContentPane()初始化一个容器，用来在容器上添加控件
			//setLayout(null)清空布局管理器，用于之后添加组件
			getContentPane().setLayout(null);
			//在布局中添加标题
			setTitle("");
			setClosable(true);
	        //绑定一个滚动条
			final JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 44, 416, 144);
			//在容器中添加滚动条
			getContentPane().add(scrollPane);

			final JButton button = new JButton();
			button.setFont(new Font("", Font.BOLD, 15));
			button.setText("增加");
			button.setBounds(32, 233, 106, 42);
			getContentPane().add(button);

			final JButton button_1 = new JButton();
			button_1.setFont(new Font("Dialog", Font.BOLD, 15));
			button_1.setText("删除");
			button_1.setBounds(162, 234, 106, 42);
			getContentPane().add(button_1);

			final JButton button_1_1 = new JButton();
			button_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
			button_1_1.setText("查找");
			button_1_1.setBounds(298, 234, 106, 42);
			getContentPane().add(button_1_1);

			final JLabel label = DefaultComponentFactory.getInstance().createTitle("VIP特供");
			label.setFont(new Font("", Font.BOLD, 18));
			label.setBounds(39, 5, 99, 33);
			getContentPane().add(label);
	        model = new DefaultTableModel();
			//向表格控件中添加列对象
			model.addColumn("种类");
			model.addColumn("单价");
			model.addColumn("简介");
			table = new JTable(model);
			//添加滚动窗格
			;
	    }
	}
