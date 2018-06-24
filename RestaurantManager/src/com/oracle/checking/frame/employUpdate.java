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
		//���������С
		setFont(new Font("", Font.PLAIN, 7));
		//���ñ���
		setTitle("�޸�");
		//���þ��Բ���
		getContentPane().setLayout(null);
		//���ô�С
		setSize(285, 434);
		//��ȡ��Ļ��С
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		//��ȡ���ڴ�С
		int ww = getSize().width;
		int wh = getSize().height;
		//����λ��
		setLocation((sw-ww)/2, (sh-wh)/2);

		final JLabel label = new JLabel();
		label.setText("���");
		label.setBounds(25, 33, 54, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("����");
		label_1.setBounds(25, 73, 54, 18);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("����");
		label_2.setBounds(25, 115, 54, 18);
		getContentPane().add(label_2);

		final JLabel label_3 = new JLabel();
		label_3.setText("�Ա�");
		label_3.setBounds(25, 158, 54, 18);
		getContentPane().add(label_3);

		final JLabel label_4 = new JLabel();
		label_4.setText("סַ");
		label_4.setBounds(25, 204, 54, 18);
		getContentPane().add(label_4);

		final JLabel label_5 = new JLabel();
		label_5.setText("��ְ����");
		label_5.setBounds(25, 254, 52, 18);
		getContentPane().add(label_5);

		final JLabel label_6 = new JLabel();
		label_6.setText("н��");
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
					//��ȡ�༭���е�����
					int id = Integer.valueOf(idText.getText());
					String name = nameText.getText();
					int age = Integer.valueOf(ageText.getText());
					String sex = sexText.getText();
					String address = addressText.getText();
					Date hiredate = Date.valueOf(hiredateText.getText());
					int sal = Integer.valueOf(salText.getText());
					
					//�޸����ݿ��е���Ϣ
					service.UpdateInfo(name, age, sex, address, hiredate, sal, id);
						
					//����������ӵ���Ӧ����
					model.setValueAt(Integer.valueOf(id), count, 0);
					model.setValueAt(name, count, 1);
					model.setValueAt(Integer.valueOf(age), count, 2);
					model.setValueAt(sex, count, 3);
					model.setValueAt(address, count, 4);
					model.setValueAt(hiredate, count, 5);
					model.setValueAt(Integer.valueOf(sal), count, 6);
					
					//�رոô���
					employUpdate.this.dispose();
						
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					employUpdate.this.dispose();
					return;
				}
				
			}
		});
		button.setText("�޸�");
		button.setBounds(85, 340, 81, 28);
		getContentPane().add(button);
		
		//�رմ���ͬʱ�رճ���
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//��ʾ����
		setVisible(true);
	}

}
