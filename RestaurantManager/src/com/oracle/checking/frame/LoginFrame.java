package com.oracle.checking.frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.oracle.checking.service.LoginService;
import com.oracle.checking.unit.Manager;
//登录界面
public class LoginFrame extends JFrame {
	private JPasswordField t2;
	private JTextField t1;
	private Manager t;
	LoginService m=new LoginService();
	public LoginFrame() {
		super();
		setFont(new Font("", Font.BOLD, 18));
		setTitle("餐饮后台管理");
		setBackground(Color.LIGHT_GRAY);
		//设置绝对布局
				getContentPane().setLayout(null);
				//设置大小
				setSize(676, 389);
				//获取屏幕大小
				int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
				int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
				//获取窗口大小
				int ww = getSize().width;
				int wh = getSize().height;
				//设置位置
				setLocation((sw-ww)/2, (sh-wh)/2);
		getContentPane().setLayout(null);

		final JLabel lable = new JLabel();
		lable.setFont(new Font("", Font.BOLD, 18));
		lable.setText("用户");
		lable.setBounds(157, 65, 75, 44);
		getContentPane().add(lable);

		t1 = new JTextField();
		t1.setBounds(255, 67, 225, 35);
		getContentPane().add(t1);
		t2 = new JPasswordField();
		t2.setBounds(255, 127, 225, 35);
		getContentPane().add(t2);

		final JLabel lable_1 = new JLabel();
		lable_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lable_1.setText("密码");
		lable_1.setBounds(157, 127, 75, 44);
		getContentPane().add(lable_1);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				try {
					t=m.resiveBossDate();
				    String name=t.getName();
				    String pwd=t.getPwd();
				    String name1=t1.getText();
				    String pwd1=t2.getText();
				    if((name.equals(name1))&&(pwd.equals(pwd1))){
				    new  FirstInterface();
				    LoginFrame.this.dispose();;
	              }else{
	            	  if(name.equals(name1)){
	            		  JOptionPane.showMessageDialog(null, "密码不正确！");
	            		  return;
	            	  }else{
	            		  JOptionPane.showMessageDialog(null, "用户名不正确！");
	            		  return;
	            	  }
	              }
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "数据库操作有误！");
				}
			}
		});
		button.setFont(new Font("", Font.BOLD, 18));
		button.setText("登录");
		button.setBounds(309, 237, 116, 44);
		getContentPane().add(button);
		//关闭窗口，则程序结束
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//将窗体显示出来。该语句最好放在末尾。
		 setVisible(true);

		
	}

}
