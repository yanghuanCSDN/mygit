package com.oracle.checking.frame;


import java.awt.Color;
import java.awt.Font;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.SQLException;
	import java.util.ArrayList;

	import javax.swing.JButton;
	import javax.swing.JInternalFrame;
import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.WindowConstants;
	import javax.swing.table.DefaultTableModel;
	import javax.xml.ws.Service;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class VIPyinliao extends JInternalFrame {
		/*DefaultTableModel��JTable��ģ�ͣ��൱������
		 * һ��洢���ݶ���DefaultTableModelȥ�洢������ˣ�����JTable��ȥ�ͺ���
		 */
		 private JTable table;
		
		int page=3;
		final int LINES = 5;
		//������
		DefaultTableModel model;
		//������ť
		JButton next;
		JButton previous;
		public VIPyinliao() {
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
			setLocation(0, 0);
			//getContentPane()��ʼ��һ����������������������ӿؼ�
			//setLayout(null)��ղ��ֹ�����������֮��������
			getContentPane().setLayout(null);
			//�ڲ�������ӱ���
			setTitle("");
			setClosable(true);
	        //��һ��������
			final JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 44, 416, 144);
			//����������ӹ�����
			getContentPane().add(scrollPane);

			final JButton button = new JButton();
			button.setFont(new Font("", Font.BOLD, 15));
			button.setText("����");
			button.setBounds(32, 233, 106, 42);
			getContentPane().add(button);

			final JButton button_1 = new JButton();
			button_1.setFont(new Font("Dialog", Font.BOLD, 15));
			button_1.setText("ɾ��");
			button_1.setBounds(162, 234, 106, 42);
			getContentPane().add(button_1);

			final JButton button_1_1 = new JButton();
			button_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
			button_1_1.setText("����");
			button_1_1.setBounds(298, 234, 106, 42);
			getContentPane().add(button_1_1);

			final JLabel label = DefaultComponentFactory.getInstance().createTitle("VIP�ع�");
			label.setFont(new Font("", Font.BOLD, 18));
			label.setBounds(39, 5, 99, 33);
			getContentPane().add(label);
	        model = new DefaultTableModel();
			//����ؼ�������ж���
			model.addColumn("����");
			model.addColumn("����");
			model.addColumn("���");
			table = new JTable(model);
			//��ӹ�������
			;
	    }
	}
