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
//��¼����
public class LoginFrame extends JFrame {
	private JPasswordField t2;
	private JTextField t1;
	private Manager t;
	LoginService m=new LoginService();
	public LoginFrame() {
		super();
		setFont(new Font("", Font.BOLD, 18));
		setTitle("������̨����");
		setBackground(Color.LIGHT_GRAY);
		//���þ��Բ���
				getContentPane().setLayout(null);
				//���ô�С
				setSize(676, 389);
				//��ȡ��Ļ��С
				int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
				int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
				//��ȡ���ڴ�С
				int ww = getSize().width;
				int wh = getSize().height;
				//����λ��
				setLocation((sw-ww)/2, (sh-wh)/2);
		getContentPane().setLayout(null);

		final JLabel lable = new JLabel();
		lable.setFont(new Font("", Font.BOLD, 18));
		lable.setText("�û�");
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
		lable_1.setText("����");
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
	            		  JOptionPane.showMessageDialog(null, "���벻��ȷ��");
	            		  return;
	            	  }else{
	            		  JOptionPane.showMessageDialog(null, "�û�������ȷ��");
	            		  return;
	            	  }
	              }
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "���ݿ��������");
				}
			}
		});
		button.setFont(new Font("", Font.BOLD, 18));
		button.setText("��¼");
		button.setBounds(309, 237, 116, 44);
		getContentPane().add(button);
		//�رմ��ڣ���������
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//��������ʾ�������������÷���ĩβ��
		 setVisible(true);

		
	}

}
