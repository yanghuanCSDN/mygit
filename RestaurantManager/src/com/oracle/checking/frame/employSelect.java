package com.oracle.checking.frame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.oracle.checking.service.employService;

//import com.oracle.Service.employService;

public class employSelect extends JFrame {
	private JTextField idText;
	
	DefaultTableModel model;
	public employSelect(DefaultTableModel model1) {
		super();
		employService service = new employService();
		
		this.model = model1;
		getContentPane().setLayout(null);
		
		//���þ��Բ���
		//���ô�С
		setSize(285, 225);
		//��ȡ��Ļ��С
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		//��ȡ���ڴ�С
		int ww = getSize().width;
		int wh = getSize().height;
		//����λ��
		setLocation((sw-ww)/2, (sh-wh)/2);
		
		//�رմ���ͬʱ�رճ���
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//��ʾ����
		setVisible(true);

		idText = new JTextField();
		idText.setBounds(107, 53, 96, 28);
		getContentPane().add(idText);
		
		final JButton select = new JButton();
		select.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				//�������Ϣ
				String mname;
				int mage;
				String msex;
				String maddress;
				Date mhiredate;
				int msal;
				//��ȡID�༭���е�����
				String id = idText.getText();
				int sid = Integer.valueOf(id);
				//�жϸ�ID�ڱ����Ƿ����
				int count = model.getRowCount();
				int mid;
				int i;
				for (i = 0; i < count; i++) {
					//��ȡ��i�е�ID,���������䣬�Ա�סַ����ְ���ڣ�н��
					mid = (Integer) model.getValueAt(i, 0);
					mname = (String) model.getValueAt(i, 1);
					mage = (Integer) model.getValueAt(i, 2);
					msex = (String) model.getValueAt(i, 3);
					maddress = (String) model.getValueAt(i, 4);
					mhiredate = (Date) model.getValueAt(i, 5);
					msal = (Integer) model.getValueAt(i, 6);
					//�����ڣ�������ID��Ӧ����Ϣ����
					if(sid==mid){
						//service.
						//�رմ���
						employSelect.this.dispose();
						//������Ӧ��Ϣ
						JOptionPane.showMessageDialog(null, "Ա�����Ϊ"+mid+"����ϢΪ��\n"
								+ " ������"+mname+" \n���䣺"+mage+" \n�Ա�"+msex
								+" \nסַ��"+maddress+"\n ��ְ���ڣ�"+mhiredate+
								" \nн�ʣ�"+msal);
						break;
					}
				}
				if(i>=count){
					JOptionPane.showMessageDialog(null, "��ID�����ڣ�");
				}
				
			}
		});
		select.setText("��ѯ");
		select.setBounds(93, 119, 68, 28);
		getContentPane().add(select);

		final JLabel label = new JLabel();
		label.setText("��Ų�ѯ");
		label.setBounds(43, 58, 58, 18);
		getContentPane().add(label);

		//�رմ���ͬʱ�رճ���
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//��ʾ����
		setVisible(true);		
	}

}
