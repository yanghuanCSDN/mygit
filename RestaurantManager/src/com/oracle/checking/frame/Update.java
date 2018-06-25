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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.oracle.checking.service.Service;
//�˵��������޸�
public class Update extends JFrame {
	private JTextField t1;
	Service service=new Service();
	 public Update(DefaultTableModel model,JTable table) {
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

		final JLabel label = new JLabel();
		label.setFont(new Font("", Font.BOLD, 15));
		label.setText("�۸�");
		label.setBounds(111, 47, 55, 41);
		getContentPane().add(label);

		t1 = new JTextField();
		t1.setBounds(179, 53, 172, 30);
		getContentPane().add(t1);
        final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				try {
				//ȷ��ѡ���˼���
				int count=table.getSelectedRowCount();
				if(count==0){
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����У�");
				}
				if(count>1){
					JOptionPane.showMessageDialog(null, "һ��ֻ��ɾ��һ��");
						return;
				}
				//�ı���priceֵ
				Double price=Double.valueOf(t1.getText());
				//ȷ���к�
				int row=table.getSelectedRow();
			    //�õ������޸��е�id
				int id=(Integer)model.getValueAt(row, 0);
				System.out.println(id+" "+price+" "+row);
				//��ѡ�м�¼��������
				int m=id%5;
				model.setValueAt(price, m, 3);
				JOptionPane.showMessageDialog(null,id+" "+price);
					int t=service.update(price, id);
					if(t>0){
						JOptionPane.showMessageDialog(null,"�޸ĳɹ���");
					}
					if(t==0){
						JOptionPane.showMessageDialog(null,"�޸�ʧ�ܣ�");
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"���ݿ����ʧ�ܣ�");
				}
			}
		});
		button.setFont(new Font("", Font.BOLD, 15));
		button.setText("�ύ");
		button.setBounds(187, 151, 106, 28);
		getContentPane().add(button);
		//�رմ��ڣ���������
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//��������ʾ�������������÷���ĩβ��
		 setVisible(true);
	}
     
}
