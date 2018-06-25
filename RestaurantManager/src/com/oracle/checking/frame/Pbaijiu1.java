package com.oracle.checking.frame;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;




import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.oracle.checking.service.ShiService;


public class Pbaijiu1 extends JFrame {
	//Service层对象
	ShiService service =new ShiService();
	public Pbaijiu1( final DefaultTableModel model) {
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
		getContentPane().setLayout(null);
        
		final JLabel idLabel_1 = new JLabel();
		idLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		idLabel_1.setText("种类");
		idLabel_1.setBounds(90, 34, 67, 26);
		getContentPane().add(idLabel_1);

		final JLabel idLabel_2 = new JLabel();
		idLabel_2.setFont(new Font("Dialog", Font.BOLD, 12));
		idLabel_2.setText("单价");
		idLabel_2.setBounds(90, 81, 67, 26);
		getContentPane().add(idLabel_2);

		final JLabel idLabel_3 = new JLabel();
		idLabel_3.setFont(new Font("Dialog", Font.BOLD, 12));
		idLabel_3.setText("年份");
		idLabel_3.setBounds(90, 133, 67, 26);
		getContentPane().add(idLabel_3);

		final JTextPane t2 = new JTextPane();
		t2.setBounds(163, 36, 174, 24);
		getContentPane().add(t2);

		final JTextPane t3 = new JTextPane();
		t3.setBounds(163, 81, 174, 24);
		getContentPane().add(t3);

		final JTextPane t4 = new JTextPane();
		t4.setToolTipText("请按“7-8月-2017”这种格式输入");
		t4.setBounds(163, 133, 174, 24);
		getContentPane().add(t4);
		final JLabel idLabel_2_1 = new JLabel();
		idLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 12));
		idLabel_2_1.setText("度数");
		idLabel_2_1.setBounds(90, 181, 67, 26);
		getContentPane().add(idLabel_2_1);

		final JLabel idLabel_2_2 = new JLabel();
		idLabel_2_2.setFont(new Font("Dialog", Font.BOLD, 12));
		idLabel_2_2.setText("简介");
		idLabel_2_2.setBounds(90, 235, 67, 26);
		getContentPane().add(idLabel_2_2);

		final JTextPane t5 = new JTextPane();
		t5.setBounds(163, 181, 174, 24);
		getContentPane().add(t5);

		final JTextPane t6 = new JTextPane();
		t6.setBounds(163, 235, 174, 24);
		getContentPane().add(t6);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				try {
				String m2=t2.getText();
				int m3=Integer.valueOf(t3.getText());
				int m4=Integer.valueOf(t4.getText());
				Double m5=Double.valueOf(t5.getText());
				String m6=String.valueOf(t6.getText());
				model.addRow((new Object[]{m2,m3,m4,m5,m6}));
				JOptionPane.showMessageDialog(null," "+m2+" "+m3+" "+m4);
					int y=service.insert2( m2, m3, m4,m5, m6);
					if(y>0){
						JOptionPane.showMessageDialog(null, "添加成功！");
	
					if(y==0){
						JOptionPane.showMessageDialog(null, "添加失败！");
					}
			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	});
		button.setFont(new Font("", Font.BOLD, 12));
		button.setText("提交");
		button.setBounds(181, 286, 106, 28);
		getContentPane().add(button);
		//关闭窗口，则程序结束
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//将窗体显示出来。该语句最好放在末尾。
		 setVisible(true);

		
	}

}

