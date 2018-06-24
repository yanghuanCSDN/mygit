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


//�˿���Ϣ�����
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
		//�õ���Ļ���
		int pmg=Toolkit.getDefaultToolkit().getScreenSize().height;
		int pmk=Toolkit.getDefaultToolkit().getScreenSize().width;
		//�õ�������
		int ctk=getSize().width;
		int ctg=getSize().height;
		//���ô����λ��
		setLocation((pmk-ctk)/2, (pmg-ctg)/2);
		setSize(267, 345);
		setVisible(true);
		
		getContentPane().setLayout(null);

		final JLabel label = new JLabel();
		label.setText("���");
		label.setBounds(22, 28, 35, 27);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("����");
		label_1.setBounds(22, 61, 35, 27);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("����");
		label_2.setBounds(22, 95, 35, 27);
		getContentPane().add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setText("����");
		label_3.setBounds(22, 128, 35, 27);
		getContentPane().add(label_3);

		final JLabel label_4 = new JLabel();
		label_4.setText("�ȼ�");
		label_4.setBounds(22, 161, 35, 27);
		getContentPane().add(label_4);

		final JLabel label_5 = new JLabel();
		label_5.setText("����");
		label_5.setBounds(22, 194, 35, 27);
		getContentPane().add(label_5);

		numtext = new JTextField();
		//��������򲻿ɱ��༭
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
		//��������������ʾ���
		t3.setToolTipText("�밴��yyyy-mm-dd�����ָ�ʽ����");
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
				//�޶����������ֻ��Ϊ��������
				try{
				pwd=Integer.valueOf(t1.getText());
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "��������벻�����֣�����������");
				}
				//�޶�����ĵȼ�ֻ������������
				try{
					grade=Integer.valueOf(t4.getText());
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, "����ĵȼ��������֣�����������");
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
		button.setText("���");
		button.setBounds(68, 258, 106, 28);
		getContentPane().add(button);
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		
	}
	

}
