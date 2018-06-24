package com.oracle.checking.frame;

import java.awt.Font;
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

public class employUpdate extends JFrame {
	private JTextField salText;
	private JTextField hiredateText;
	private JTextField addressText;
	private JTextField sexText;
	private JTextField ageText;
	private JTextField idText;
	private JTextField nameText;
	
	employService service = new employService();
	DefaultTableModel model;
	public employUpdate(DefaultTableModel model1,int id,
			String name,int age,String sex,String address,
			Date hiredate,int sal,final int count) {
		super();
		
		this.model = model1;
		//设置字体大小
		setFont(new Font("", Font.PLAIN, 7));
		//设置标题
		setTitle("修改");
		//设置绝对布局
		getContentPane().setLayout(null);
		//设置大小
		setSize(285, 434);
		//获取屏幕大小
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		//获取窗口大小
		int ww = getSize().width;
		int wh = getSize().height;
		//设置位置
		setLocation((sw-ww)/2, (sh-wh)/2);

		final JLabel label = new JLabel();
		label.setText("编号");
		label.setBounds(25, 33, 54, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("姓名");
		label_1.setBounds(25, 73, 54, 18);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("年龄");
		label_2.setBounds(25, 115, 54, 18);
		getContentPane().add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setText("性别");
		label_3.setBounds(25, 158, 54, 18);
		getContentPane().add(label_3);

		final JLabel label_4 = new JLabel();
		label_4.setText("住址");
		label_4.setBounds(25, 204, 54, 18);
		getContentPane().add(label_4);

		final JLabel label_5 = new JLabel();
		label_5.setText("入职日期");
		label_5.setBounds(25, 254, 52, 18);
		getContentPane().add(label_5);

		final JLabel label_6 = new JLabel();
		label_6.setText("薪资");
		label_6.setBounds(25, 297, 54, 18);
		getContentPane().add(label_6);

		nameText = new JTextField();
		nameText.setText(name);
		nameText.setBounds(85, 67, 136, 30);
		getContentPane().add(nameText);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setText(id+"");
		idText.setBounds(85, 27, 136, 30);
		getContentPane().add(idText);

		ageText = new JTextField();
		ageText.setText(age+"");
		ageText.setBounds(85, 109, 136, 30);
		getContentPane().add(ageText);

		sexText = new JTextField();
		sexText.setText(sex);
		sexText.setBounds(85, 152, 136, 30);
		getContentPane().add(sexText);

		addressText = new JTextField();
		addressText.setText(address);
		addressText.setBounds(85, 198, 136, 30);
		getContentPane().add(addressText);

		hiredateText = new JTextField();
		hiredateText.setText(hiredate+"");
		hiredateText.setBounds(83, 248, 136, 30);
		getContentPane().add(hiredateText);

		salText = new JTextField();
		salText.setText(sal+"");
		salText.setBounds(85, 291, 136, 30);
		getContentPane().add(salText);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				
				try {
					//获取编辑框中的内容
					int id = Integer.valueOf(idText.getText());
					String name = nameText.getText();
					int age = Integer.valueOf(ageText.getText());
					String sex = sexText.getText();
					String address = addressText.getText();
					Date hiredate = Date.valueOf(hiredateText.getText());
					int sal = Integer.valueOf(salText.getText());
					
					//修改数据库中的信息
					service.UpdateInfo(name, age, sex, address, hiredate, sal, id);
						
					//将该内容添加到对应框中
					model.setValueAt(Integer.valueOf(id), count, 0);
					model.setValueAt(name, count, 1);
					model.setValueAt(Integer.valueOf(age), count, 2);
					model.setValueAt(sex, count, 3);
					model.setValueAt(address, count, 4);
					model.setValueAt(hiredate, count, 5);
					model.setValueAt(Integer.valueOf(sal), count, 6);
					
					//关闭该窗口
					employUpdate.this.dispose();
						
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					employUpdate.this.dispose();
					return;
				}
				
			}
		});
		button.setText("修改");
		button.setBounds(85, 340, 81, 28);
		getContentPane().add(button);
		
		//关闭窗口同时关闭程序
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//显示窗口
		setVisible(true);
	}

}
