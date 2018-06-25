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
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.oracle.checking.service.Service;
import com.oracle.checking.unit.AllFoodMenu;
//�˵����������
public class BulltWindow extends JFrame {
	//Service�����
	Service service =new Service();
	public BulltWindow(DefaultTableModel model,int max) {
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
		getContentPane().setLayout(null);
        final JLabel idLabel = new JLabel();
		idLabel.setFont(new Font("", Font.BOLD, 12));
		idLabel.setText("���");
		idLabel.setBounds(104, 36, 67, 26);
		getContentPane().add(idLabel);

		final JLabel idLabel_1 = new JLabel();
		idLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		idLabel_1.setText("����");
		idLabel_1.setBounds(104, 80, 67, 26);
		getContentPane().add(idLabel_1);

		final JLabel idLabel_2 = new JLabel();
		idLabel_2.setFont(new Font("Dialog", Font.BOLD, 12));
		idLabel_2.setText("�۸�");
		idLabel_2.setBounds(104, 123, 67, 26);
		getContentPane().add(idLabel_2);

		final JLabel idLabel_3 = new JLabel();
		idLabel_3.setFont(new Font("Dialog", Font.BOLD, 12));
		idLabel_3.setText("�ۿ�");
		idLabel_3.setBounds(104, 171, 67, 26);
		getContentPane().add(idLabel_3);

		final JTextPane t1 = new JTextPane();
		t1.setText(max+"");
		t1.setBounds(176, 38, 174, 24);
		getContentPane().add(t1);

		final JTextPane t2 = new JTextPane();
		t2.setBounds(176, 81, 174, 24);
		getContentPane().add(t2);

		final JTextPane t3 = new JTextPane();
		t3.setBounds(176, 124, 174, 24);
		getContentPane().add(t3);

		final JTextPane t4 = new JTextPane();
		t4.setBounds(176, 172, 174, 24);
		getContentPane().add(t4);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				try {
				int	m1=Integer.parseInt(t1.getText());
				String m2=t2.getText();
				Double m3=Double.valueOf(t3.getText());
				Double m4=Double.valueOf(t4.getText());
				model.addRow((new Object[]{m1,m2,m3,m4}));
			    JOptionPane.showMessageDialog(null,"��ţ�"+m1+"\t"+"������ "+m2+"\t"+"�۸�"+m3+"\t"+"�ۿۣ�"+m4);
					int y=service.insert1(m1,m2,m3,m4);
					if(y>0){
						JOptionPane.showMessageDialog(null, "��ӳɹ���");
	
					if(y==0){
						JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
					}
			}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "���ݿ��������");
				}
		}
	});
		button.setFont(new Font("", Font.BOLD, 12));
		button.setText("�ύ");
		button.setBounds(143, 249, 106, 28);
		getContentPane().add(button);
		//�رմ��ڣ���������
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//��������ʾ�������������÷���ĩβ��
		 setVisible(true);
	}

}
