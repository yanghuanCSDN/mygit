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
//顾客信息的查找
public class ClientSelect extends JFrame {
	private JTextField idtext;
	DefaultTableModel model;

	public ClientSelect(DefaultTableModel model1) {
		super();
		this.model = model1;
		// 得到屏幕宽高
		int pmg = Toolkit.getDefaultToolkit().getScreenSize().height;
		int pmk = Toolkit.getDefaultToolkit().getScreenSize().width;
		// 得到窗体宽高
		int ctk = getSize().width;
		int ctg = getSize().height;
		// 设置窗体的位置
		setLocation((pmk - ctk) / 2, (pmg - ctg) / 2);
		setSize(221, 241);
		setVisible(true);

		getContentPane().setLayout(null);

		final JLabel label = new JLabel();
		label.setText("编号查询");
		label.setBounds(10, 49, 66, 25);
		getContentPane().add(label);

		idtext = new JTextField();
		idtext.setBounds(82, 47, 100, 29);
		getContentPane().add(idtext);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// 获取到查询框的ID

				String sid = idtext.getText();
				int  id;
				try {
					id = Integer.valueOf(sid);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "输入的ID有误");
					return;
				}

				// 获取到记录的总条数
				int count = model.getRowCount();
				System.out.println(count);
				int i;
				for (i = 0; i < count; i++) {
					int num = (Integer) model.getValueAt(i, 0);
					int pwd = (Integer) model.getValueAt(i, 1);
					String name = (String) model.getValueAt(i, 2);
					Date time = (Date) model.getValueAt(i, 3);
					int grade = (Integer) model.getValueAt(i, 4);
					String kind = (String) model.getValueAt(i, 5);
					if (id == num) {
						ClientSelect.this.dispose();
						JOptionPane.showMessageDialog(null, "编号:" + num + "密码:"
								+ pwd + "\n名字:" + name + "生日:" + time + "\n等级:"
								+ grade + "类型:" + kind);
						break;
					}
				}
				if (i >= count) {
					ClientSelect.this.dispose();
					JOptionPane.showMessageDialog(null, "找不到这个ID");
				}
			}
		});
		button.setText("查询");
		button.setBounds(50, 121, 81, 32);
		getContentPane().add(button);

		// 关闭窗口同时关闭程序
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// 显示窗口
		setVisible(true);

	}
}

