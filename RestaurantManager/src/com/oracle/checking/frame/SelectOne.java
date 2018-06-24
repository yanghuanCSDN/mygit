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
//�˵������ڲ���
public class SelectOne extends JFrame {
	private JTextField t2;
	Service service=new Service();
	public SelectOne() {
		super();
		//���þ��Բ���
	    getContentPane().setLayout(null);
	    //���ô�С
		setSize(497, 385);
		//��ȡ��Ļ��С
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		//��ȡ���ڴ�С
		int ww = getSize().width;
		int wh = getSize().height;
		//����λ��
		setLocation((sw-ww)/2, (sh-wh)/2);
        final JLabel t1 = new JLabel();
		t1.setFont(new Font("", Font.BOLD, 15));
		t1.setText("���");
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
					JOptionPane.showMessageDialog(null,"���:"+id+"\n"+"������"+name+"\n"+"�۸�:"+price+"\n"+"�ۿ�"+discount);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"���ݿ����ʧ�ܣ�");
				}
			}
		});
		button.setFont(new Font("", Font.BOLD, 15));
		button.setText("�ύ");
		button.setBounds(226, 166, 106, 28);
		getContentPane().add(button);
		//�رմ��ڣ���������
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//��������ʾ�������������÷���ĩβ��
		 setVisible(true);
	}

}
