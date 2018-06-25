package com.oracle.checking.frame;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.oracle.checking.service.employService;
import com.oracle.checking.unit.Employ;

//import com.oracle.Service.employService;
//import com.oracle.Test.Employ;


public class employFrame extends JInternalFrame {
	DefaultTableModel model;
	
	employInsert eit;
	employService service = new employService();
	//employSelect est;
	employUpdate eut;
	
	private JTable table;
	
	public employFrame() {
		super();
		try {
			setClosable(true);
			setBackground(Color.LIGHT_GRAY);
			setTitle("Ա����Ϣ���ܱ�");
		
			//���þ��Բ���
			getContentPane().setLayout(null);
			//���ô�С
			setSize(521, 396);
			//����λ��
			setLocation(0, 0);
		    final JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBackground(Color.PINK);
			scrollPane.setBounds(10, 40, 491, 202);
			getContentPane().add(scrollPane);
			
			model = new DefaultTableModel();
			model.addColumn("Ա�����");
			model.addColumn("Ա������");
			model.addColumn("Ա������");
			model.addColumn("Ա���Ա�");
			model.addColumn("Ա��סַ");
			model.addColumn("Ա����ְ����");
			model.addColumn("Ա��н��");
	
			ArrayList<Employ> arr = service.GetEmployInfo();
			for (int i=0; i<arr.size(); i++){
				Employ e = arr.get(i);
				model.addRow(new Object[]{
					e.getEid()
					, e.getEname()
					, e.getEage()
					, e.getEsex()
					, e.getEaddress()
					, e.getEhiredate()
					, e.getEsal()
				});
			}
			table = new JTable(model);
			scrollPane.setViewportView(table);
			
			
			
			final JButton insert = new JButton();
			insert.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					//��ȡ����
					int count = model.getRowCount();
					int max = 0;
					for (int i=0; i<count; i++){
						//�õ����м�¼�е�ѧ��
						int id = (Integer)model.getValueAt(i, 0);
						if (max < id)
							max = id;
					}
					//����Ӻ�������
					JOptionPane.showMessageDialog(null, "��Ҫ����ӣ���ϢҪ����Ӵ��");
					new employInsert(model,max+1);
				}
			});
			insert.setText("����");
			insert.setBounds(42, 290, 64, 28);
			getContentPane().add(insert);
	
			final JButton delete = new JButton();
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
						try {
							//���ѡ������
						    int row = table.getSelectedRowCount();
						    if(row == 0){
						    	JOptionPane.showMessageDialog(null,
						    			"��ѡ��һ�У�");
						    }else if(row > 1){
						    	JOptionPane.showMessageDialog(null,
						    			"�����ѡ��");
						    }else{
						    	//���ѡ���к�
						    	int count = table.getSelectedRow();
						    	//��ȡ���е�id
						    	int id = (Integer) model.getValueAt(count, 0);
						        //����idɾ�����ݿ��е���Ϣ
						    	service.DeleteInfo(id);
						    	//ɾ�������е���Ϣ
						        model.removeRow(count);
						    	JOptionPane.showMessageDialog(null,
						    			"ɾ���ɹ���");
						    }
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					
				}
			});
			delete.setText("ɾ��");
			delete.setBounds(153, 290, 64, 28);
			getContentPane().add(delete);
	
			final JButton update = new JButton();
			update.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					//�������
					int id = 0;
					String name = null;
					int age = 0;
					String sex = null;
					String address = null;
					Date hiredate = null;
					int sal = 0;
					int count = 0;
					
					//��ȡѡ���������ж�
					int row = table.getSelectedRowCount();
				    if(row == 0){
				    	JOptionPane.showMessageDialog(null,
				    			"��ѡ��һ�У�");
				    	return;
				    }else if(row > 1){
				    	JOptionPane.showMessageDialog(null,
				    			"�����ѡ��");
				    	return;
				    }else{
				    	//���ѡ���к�
				    	count = table.getSelectedRow();
				    	//��ȡ���е�id
				    	id = (int) model.getValueAt(count, 0);
				    	name = (String) model.getValueAt(count, 1);
				    	age = (Integer) model.getValueAt(count, 2);
				    	sex = (String) model.getValueAt(count, 3);
				    	address = (String)model.getValueAt(count, 4);
				    	hiredate = (Date) model.getValueAt(count, 5);
				    	sal = (Integer) model.getValueAt(count, 6);
				    }
					//�޸���ʾ�����е�����
					new employUpdate(model,id,name,age,sex,address,
							hiredate,sal,count);
				}
			});
			update.setText("�޸�");
			update.setBounds(270, 290, 64, 28);
			getContentPane().add(update);
	
			final JButton select = new JButton();
			select.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					//����employSelect������ID������Ϣ������
					new employSelect(model);
				}
			});
			select.setText("��ѯ");
			select.setBounds(379, 290, 64, 28);
			getContentPane().add(select);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
			//�رմ���ͬʱ�رճ���
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			//��ʾ����
			setVisible(true);
		
	}

}
