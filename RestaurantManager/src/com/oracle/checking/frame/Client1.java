package com.oracle.checking.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.oracle.checking.service.ClientManagerService;
import com.oracle.checking.unit.Client;


//��Ա�˿ͱ�����
public class Client1 extends JInternalFrame {
	private JTable table;
	DefaultTableModel model;
	ClientManagerService service=new ClientManagerService();
	public Client1(){
		super();
		//��屳����ɫ
		setBackground(Color.lightGray);
		try {
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 30, 440, 229);
		getContentPane().add(scrollPane);
		model=new DefaultTableModel();
		model.addColumn("�˿ͱ��");
		model.addColumn("�˿�����");
		model.addColumn("�˿�����");
		model.addColumn("�˿�����");
		model.addColumn("�˿͵ȼ�");
		model.addColumn("�˿�����");
		table = new JTable(model);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(null);
		setTitle("��ͨ�˿�");
		setClosable(true);
		setSize(523, 394);
		setLocation(0, 0);
		setVisible(true);
		//��ձ��е�����
       int all=model.getRowCount();
	   for(int i=0;i<all;i++){
		//��Զ�Ƴ���һ�е�
			model.removeRow(0);
		}
	  ArrayList<Client> arr=service.getClient();
	     for(int i=0;i<arr.size();i++){
	    	 Client c=arr.get(i);
	    	 model.addRow(new Object[]{
	    			 c.getClientid(),
	    			 c.getClientpwd(),
	    			 c.getClientname(),
	    			 c.getClientbirthday(),
	    			 c.getClientgrade(),
	    			 c.getClientkind()
	    	 });
	     }
		} catch (SQLException e) {
				e.printStackTrace();
	}
			
		
		
        final JButton select = new JButton();
        select.addActionListener(new ActionListener() {
        	public void actionPerformed(final ActionEvent e) {
        		new ClientSelect(model);
        	}
        });
		select.setText("����");
		select.setBounds(43, 294, 106, 28);
		getContentPane().add(select);

		final JButton delete = new JButton();
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				try {
					//��ȡ��ѡ�е�����
					int hs=table.getSelectedRowCount();
					if(hs==0){
						JOptionPane.showMessageDialog(null, "����ѡ��һ��");
						return;
					}
					else if(hs>1){
						JOptionPane.showMessageDialog(null, "ֻ��ѡ��һ��");
						return;
					}else{
					//��ȡ��ѡ�е��к�
					int row=table.getSelectedRow();
					
					int clientid=(Integer) model.getValueAt(row, 0);
					
						service.deleteUser(clientid);
						model.removeRow(row);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		delete.setText("ɾ��");
		delete.setBounds(195, 294, 106, 28);
		getContentPane().add(delete);

		final JButton insert = new JButton();
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int hang=table.getRowCount();
				int maxid = 0;
				for(int i=0;i<hang;i++){
					int mid=(Integer) model.getValueAt(i, 0);
					if(maxid<mid){
						maxid=mid;
					}
				}
				JOptionPane.showMessageDialog(null, "��Ҫ����ӣ���ϢҪ����Ӵ��");
				new ClientInsert(model,maxid+1);
			}
		});
		insert.setText("����");
		insert.setBounds(369, 294, 106, 28);
		getContentPane().add(insert);


	}

}
