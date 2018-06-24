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

//import service.ShiService;
//import unit.Pbaijiu;
//import unit.VipBaijiu;



import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.oracle.checking.service.ShiService;
import com.oracle.checking.unit.Pbaijiu;

public class baijiu extends JInternalFrame {
	/*
	 * DefaultTableModel��JTable��ģ�ͣ��൱������
	 * һ��洢���ݶ���DefaultTableModelȥ�洢������ˣ�����JTable��ȥ�ͺ���
	 */
	
	private JTable table;
	ShiService Pbai = new ShiService();

	int page = 3;
	final int LINES = 5;
	// ������
	DefaultTableModel model;
	// ������ť
	JButton next;
	JButton previous;

	public baijiu() {
		super();
		setBackground(Color.PINK);
		// ���þ��Բ���
		getContentPane().setLayout(null);
		// ���ô�С
		//setSize(431, 333);
		// ��ȡ��Ļ��С
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		// ��ȡ���ڴ�С
		int ww = getSize().width;
		int wh = getSize().height;
		// ����λ��
		setLocation(0, 0);
		// getContentPane()��ʼ��һ����������������������ӿؼ�
		// setLayout(null)��ղ��ֹ�����������֮��������
		getContentPane().setLayout(null);
		// �ڲ�������ӱ���
		setTitle("");
		setClosable(true);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 275, 123);
		
//		
//		final JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(38, 44, 406, 170);
//		getContentPane().add(scrollPane_1);
		model = new DefaultTableModel();
		// ����ؼ�������ж���
		model.addColumn("����");
		model.addColumn("����");
		model.addColumn("���");
		model.addColumn("����");
		model.addColumn("���");
		
		ArrayList<Pbaijiu> Pbaijiu;
		try {
			Pbaijiu = Pbai.Pbaijiu();
			for (int i=0; i< Pbaijiu.size(); i++){
			Pbaijiu e = Pbaijiu.get(i);
				model.addRow(new Object[]{
			        e.getZhonglei()
					, e.getDanjia()
					, e.getNianfen()
					, e.getDushu()
					, e.getJianjie()
					
				});
				System.out.println(e.getZhonglei());
		} }catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			table = new JTable(model);
			scrollPane.setViewportView(table);
//
//			table = new JTable();
//			scrollPane_1.setViewportView(table);

		// ��һ��������
		
		// ����������ӹ�����
		// �������
		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				JOptionPane.showMessageDialog(null, "��Ҫ����ӣ���ϢҪ����Ӵ��");
				new Pbaijiu1(model);
			}
		});
		
		getContentPane().add(scrollPane);
		
		
		
		button.setFont(new Font("", Font.BOLD, 15));
		button.setText("����");
		button.setBounds(27, 194, 75, 33);
		getContentPane().add(button);
		// ɾ��
		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				try{
					// ȷ��ѡ���˼���
					int count = table.getSelectedRowCount();
					if (count == 0) {
						JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����У�");
					}
					if (count > 1) {
						JOptionPane.showMessageDialog(null, "һ��ֻ��ɾ��һ��");
						return;
					}
					// ȷ���к�
					int row = table.getSelectedRow();
					// �õ���ɾ���е�zhonglei
					String zhonglei = (String) model.getValueAt(row, 0);
					System.out.println(zhonglei);
					// ��id����ɾ�����
					int judge = Pbai.delete2(zhonglei);
					if (judge > 0) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					} else {
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "���ݿ��������");
				}

			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 15));
		button_1.setText("ɾ��");
		button_1.setBounds(200, 194, 75, 33);
		getContentPane().add(button_1);

		final JLabel label = DefaultComponentFactory.getInstance().createTitle(
				"�׾�");
		label.setFont(new Font("", Font.BOLD, 18));
		label.setBounds(39, 5, 75, 33);
		getContentPane().add(label);

	//�رմ���ͬʱ�رճ���
	 setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	//��ʾ����
	setVisible(true);
	setBounds(0, 0, 316, 296);

		
		
	
}
}
