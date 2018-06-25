package com.oracle.checking.frame;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.oracle.checking.service.Service;
import com.oracle.checking.unit.AllFoodMenu;
//菜单中用于查找
public class SelectOne extends JFrame {
	private JTextField t2;
	Service service=new Service();
	public SelectOne() {
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
		setLocation((sw-ww)/2, (sh-wh)/2);
        final JLabel t1 = new JLabel();
		t1.setFont(new Font("", Font.BOLD, 15));
		t1.setText("编号");
		t1.setBounds(122, 64, 53, 37);
		getContentPane().add(t1);
        t2 = new JTextField();
		t2.setBounds(211, 69, 140, 29);
		getContentPane().add(t2);
        final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				try {
				int	m1=Integer.parseInt(t2.getText());
					AllFoodMenu obj=service.getMenuInfo(m1);
					int id=obj.getId();
					String name=obj.getName();
					Double price=obj.getPrice();
					Double discount=obj.getDiscount();
					JOptionPane.showMessageDialog(null,"编号:"+id+"\n"+"菜名："+name+"\n"+"价格:"+price+"\n"+"折扣"+discount);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"数据库操作失败！");
				}
			}
		});
		button.setFont(new Font("", Font.BOLD, 15));
		button.setText("提交");
		button.setBounds(226, 166, 106, 28);
		getContentPane().add(button);
		//关闭窗口，则程序结束
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//将窗体显示出来。该语句最好放在末尾。
		 setVisible(true);
	}

}
