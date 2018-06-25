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

//import service.ShiService;
//import unit.Pbaijiu;
//import unit.VipBaijiu;



import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.oracle.checking.service.ShiService;
import com.oracle.checking.unit.Pbaijiu;

public class baijiu extends JInternalFrame {
	/*
	 * DefaultTableModel是JTable的模型，相当于替身
	 * 一般存储数据都用DefaultTableModel去存储，存好了，放在JTable里去就好了
	 */
	
	private JTable table;
	ShiService Pbai = new ShiService();

	int page = 3;
	final int LINES = 5;
	// 创建表
	DefaultTableModel model;
	// 创建按钮
	JButton next;
	JButton previous;

	public baijiu() {
		super();
		setBackground(Color.PINK);
		// 设置绝对布局
		getContentPane().setLayout(null);
		// 设置大小
		//setSize(431, 333);
		// 获取屏幕大小
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		// 获取窗口大小
		int ww = getSize().width;
		int wh = getSize().height;
		// 设置位置
		setLocation(0, 0);
		// getContentPane()初始化一个容器，用来在容器上添加控件
		// setLayout(null)清空布局管理器，用于之后添加组件
		getContentPane().setLayout(null);
		// 在布局中添加标题
		setTitle("");
		setClosable(true);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 275, 123);
		
//		
//		final JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(38, 44, 406, 170);
//		getContentPane().add(scrollPane_1);
		model = new DefaultTableModel();
		// 向表格控件中添加列对象
		model.addColumn("种类");
		model.addColumn("单价");
		model.addColumn("年份");
		model.addColumn("度数");
		model.addColumn("简介");
		
		ArrayList<Pbaijiu> Pbaijiu;
		try {
			Pbaijiu = Pbai.Pbaijiu();
			for (int i=0; i< Pbaijiu.size(); i++){
			Pbaijiu e = Pbaijiu.get(i);
				model.addRow(new Object[]{
			        e.getZhonglei()
					, e.getDanjia()
					, e.getNianfen()
					, e.getDushu()
					, e.getJianjie()
					
				});
				System.out.println(e.getZhonglei());
		} }catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			table = new JTable(model);
			scrollPane.setViewportView(table);
//
//			table = new JTable();
//			scrollPane_1.setViewportView(table);

		// 绑定一个滚动条
		
		// 在容器中添加滚动条
		// 添加数据
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				JOptionPane.showMessageDialog(null, "按要求添加，信息要完整哟！");
				new Pbaijiu1(model);
			}
		});
		
		getContentPane().add(scrollPane);
		
		
		
		button.setFont(new Font("", Font.BOLD, 15));
		button.setText("增加");
		button.setBounds(27, 194, 75, 33);
		getContentPane().add(button);
		// 删除
		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				try{
					// 确定选择了几行
					int count = table.getSelectedRowCount();
					if (count == 0) {
						JOptionPane.showMessageDialog(null, "请选择要删除的行！");
					}
					if (count > 1) {
						JOptionPane.showMessageDialog(null, "一次只能删除一行");
						return;
					}
					// 确定行号
					int row = table.getSelectedRow();
					// 得到所删除行的zhonglei
					String zhonglei = (String) model.getValueAt(row, 0);
					System.out.println(zhonglei);
					// 将id传给删除语句
					int judge = Pbai.delete2(zhonglei);
					if (judge > 0) {
						JOptionPane.showMessageDialog(null, "删除成功！");
					} else {
						JOptionPane.showMessageDialog(null, "删除失败！");
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作有误");
				}

			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 15));
		button_1.setText("删除");
		button_1.setBounds(200, 194, 75, 33);
		getContentPane().add(button_1);

		final JLabel label = DefaultComponentFactory.getInstance().createTitle(
				"白酒");
		label.setFont(new Font("", Font.BOLD, 18));
		label.setBounds(39, 5, 75, 33);
		getContentPane().add(label);

	//关闭窗口同时关闭程序
	 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	//显示窗口
	setVisible(true);
	setBounds(0, 0, 316, 296);

		
		
	
}
}
