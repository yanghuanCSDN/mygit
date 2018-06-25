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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.oracle.checking.service.ClientManagerService;


//顾客信息的添加
public class ClientInsert extends JFrame {
	private JTextField t1;
	private JTextField t5;
	private JTextField t4;
	private JTextField t3;
	private JTextField t2;
	private JTextField numtext;
	DefaultTableModel model;
	public ClientInsert(DefaultTableModel model2,int maxid) {
		super();
		this.model=model2;
		
		final ClientManagerService vic=new ClientManagerService();
		//得到屏幕宽高
		int pmg=Toolkit.getDefaultToolkit().getScreenSize().height;
		int pmk=Toolkit.getDefaultToolkit().getScreenSize().width;
		//得到窗体宽高
		int ctk=getSize().width;
		int ctg=getSize().height;
		//设置窗体的位置
		setLocation((pmk-ctk)/2, (pmg-ctg)/2);
		setSize(267, 345);
		setVisible(true);
		
		getContentPane().setLayout(null);

		final JLabel label = new JLabel();
		label.setText("编号");
		label.setBounds(22, 28, 35, 27);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("密码");
		label_1.setBounds(22, 61, 35, 27);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("名字");
		label_2.setBounds(22, 95, 35, 27);
		getContentPane().add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setText("生日");
		label_3.setBounds(22, 128, 35, 27);
		getContentPane().add(label_3);

		final JLabel label_4 = new JLabel();
		label_4.setText("等级");
		label_4.setBounds(22, 161, 35, 27);
		getContentPane().add(label_4);

		final JLabel label_5 = new JLabel();
		label_5.setText("类型");
		label_5.setBounds(22, 194, 35, 27);
		getContentPane().add(label_5);

		numtext = new JTextField();
		//设置输入框不可被编辑
		numtext.setEditable(false);
		numtext.setText(maxid+"");
		numtext.setBounds(93, 30, 105, 22);
		getContentPane().add(numtext);
		
		t1 = new JTextField();
		t1.setBounds(93, 63, 105, 22);
		getContentPane().add(t1);

		t2 = new JTextField();
		t2.setBounds(93, 97, 105, 22);
		getContentPane().add(t2);

		t3 = new JTextField();
		//给该输入框添加提示语句
		t3.setToolTipText("请按“yyyy-mm-dd”这种格式输入");
		t3.setBounds(93, 130, 105, 22);
		getContentPane().add(t3);

		t4 = new JTextField();
		t4.setBounds(93, 163, 105, 22);
		getContentPane().add(t4);

		t5 = new JTextField();
		t5.setBounds(93, 196, 105, 22);
		getContentPane().add(t5);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				 
				int num;
				int pwd=0;
				String name;
				Date date;
				int grade=0;
				String type;
				int n=Integer.valueOf(t1.getText());
				num=Integer.valueOf(numtext.getText());
				name=t2.getText();
				date=Date.valueOf(t3.getText());
				int p2=Integer.parseInt(t4.getText());
				String p3=t5.getText();
				type=t5.getText();
				//限定输入的密码只能为数字类型
				try{
				pwd=Integer.valueOf(t1.getText());
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "输入的密码不是数字，请输入数字");
				}
				//限定输入的等级只能是数字类型
				try{
					grade=Integer.valueOf(t4.getText());
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "输入的等级不是数字，请输入数字");
				}
				try {
					vic.insertUser(num,pwd,name,date,grade,type);
					model.addRow(new Object[]{num,pwd,name,date,grade,type});
					ClientInsert.this.dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setBorderPainted(false);
		button.setText("添加");
		button.setBounds(68, 258, 106, 28);
		getContentPane().add(button);
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		
	}
	

}
