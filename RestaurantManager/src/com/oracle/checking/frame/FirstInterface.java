package com.oracle.checking.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;
//主界面
public class FirstInterface extends JFrame {
	public FirstInterface() {
		super();
		//设置绝对布局
				getContentPane().setLayout(null);
				//设置大小
				setSize(766, 480);
				//获取屏幕大小
				int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
				int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
				//获取窗口大小
				int ww = getSize().width;
				int wh = getSize().height;
				//设置位置
				setLocation((sw-ww)/2, (sh-wh)/2);
		getContentPane().setLayout(null);
		final JDesktopPane k = new JDesktopPane();
		k.setBounds(192, 35, 522, 396);
		getContentPane().add(k, BorderLayout.CENTER);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				MenuFrame m1=new MenuFrame();
			    JInternalFrame[] t=k.getAllFrames();
			    for(int i=0;i<t.length;i++){
		    	  if(t[i] instanceof MenuFrame ){
		    		  t[i].toFront();
		    		  	return;
		    	  }
			   }
				k.add(m1);
				m1.toFront();
			}
		});
		button_1.setText("菜单信息");
		button_1.setFont(new Font("", Font.BOLD, 16));
		button_1.setBounds(45, 141, 119, 38);
		getContentPane().add(button_1);

		final JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				ShuiFrame m=new ShuiFrame();
				JInternalFrame[] t2=k.getAllFrames();
			    for(int i=0;i<t2.length;i++){
		    	  if(t2[i] instanceof ShuiFrame ){
		    		  t2[i].toFront();
		    		  	return;
		    	  }
			   }
				k.add(m);
				m.toFront();
			}
		});
		button_2.setFont(new Font("", Font.BOLD, 16));
		button_2.setText("酒水信息");
		button_2.setBounds(45, 232, 119, 38);
		getContentPane().add(button_2);

		final JButton button_3 = new JButton();
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				employFrame m=new employFrame();
				JInternalFrame[] t3=k.getAllFrames();
			    for(int i=0;i<t3.length;i++){
		    	  if(t3[i] instanceof employFrame ){
		    		  t3[i].toFront();
		    		  	return;
		    	  }
			   }
				k.add(m);
				m.toFront();
			}
		});
		button_3.setFont(new Font("", Font.BOLD, 16));
		button_3.setText("员工信息");
		button_3.setBounds(45, 321, 119, 38);
		getContentPane().add(button_3);

		final JButton button_1_1 = new JButton();
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				Client1 t=new Client1();
				JInternalFrame[] t1=k.getAllFrames();
			    for(int i=0;i<t1.length;i++){
		    	  if(t1[i] instanceof Client1 ){
		    		  t1[i].toFront();
		    		  	return;
		    	  }
			   }
				k.add(t);
				t.toFront();
				
			}
		});
		button_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		button_1_1.setText("会员信息");
		button_1_1.setBounds(45, 59, 119, 38);
		getContentPane().add(button_1_1);

		final JLabel label = DefaultComponentFactory.getInstance().createTitle("欢迎李明登录餐厅后台管理！");
		label.setFont(new Font("", Font.BOLD, 14));
		label.setBounds(10, 0, 233, 29);
		getContentPane().add(label);
       //关闭窗口，则程序结束
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//将窗体显示出来。该语句最好放在末尾。
		 setVisible(true);
	}

}
