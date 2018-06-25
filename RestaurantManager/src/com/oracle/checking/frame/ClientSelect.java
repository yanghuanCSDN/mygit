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
//�˿���Ϣ�Ĳ���
public class ClientSelect extends JFrame {
	private JTextField idtext;
	DefaultTableModel model;

	public ClientSelect(DefaultTableModel model1) {
		super();
		this.model = model1;
		// �õ���Ļ���
		int pmg = Toolkit.getDefaultToolkit().getScreenSize().height;
		int pmk = Toolkit.getDefaultToolkit().getScreenSize().width;
		// �õ�������
		int ctk = getSize().width;
		int ctg = getSize().height;
		// ���ô����λ��
		setLocation((pmk - ctk) / 2, (pmg - ctg) / 2);
		setSize(221, 241);
		setVisible(true);

		getContentPane().setLayout(null);

		final JLabel label = new JLabel();
		label.setText("��Ų�ѯ");
		label.setBounds(10, 49, 66, 25);
		getContentPane().add(label);

		idtext = new JTextField();
		idtext.setBounds(82, 47, 100, 29);
		getContentPane().add(idtext);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// ��ȡ����ѯ���ID

				String sid = idtext.getText();
				int  id;
				try {
					id = Integer.valueOf(sid);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "�����ID����");
					return;
				}

				// ��ȡ����¼��������
				int count = model.getRowCount();
				System.out.println(count);
				int i;
				for (i = 0; i < count; i++) {
					int num = (Integer) model.getValueAt(i, 0);
					int pwd = (Integer) model.getValueAt(i, 1);
					String name = (String) model.getValueAt(i, 2);
					Date time = (Date) model.getValueAt(i, 3);
					int grade = (Integer) model.getValueAt(i, 4);
					String kind = (String) model.getValueAt(i, 5);
					if (id == num) {
						ClientSelect.this.dispose();
						JOptionPane.showMessageDialog(null, "���:" + num + "����:"
								+ pwd + "\n����:" + name + "����:" + time + "\n�ȼ�:"
								+ grade + "����:" + kind);
						break;
					}
				}
				if (i >= count) {
					ClientSelect.this.dispose();
					JOptionPane.showMessageDialog(null, "�Ҳ������ID");
				}
			}
		});
		button.setText("��ѯ");
		button.setBounds(50, 121, 81, 32);
		getContentPane().add(button);

		// �رմ���ͬʱ�رճ���
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// ��ʾ����
		setVisible(true);

	}
}

