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
//import unit.VipBaijiu;



import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.oracle.checking.service.ShiService;
import com.oracle.checking.unit.VipBaijiu;


public class vipbaijiu extends JInternalFrame {
		/*DefaultTableModel��JTable��ģ�ͣ��൱������
		 * һ��洢���ݶ���DefaultTableModelȥ�洢������ˣ�����JTable��ȥ�ͺ���
		 */
		 private JTable table;
		 ShiService vipbai=new ShiService();
		
		int page=3;
		final int LINES = 5;
		//������
		DefaultTableModel model;
		//������ť
		JButton next;
		JButton previous;
		public vipbaijiu() {
			super();
			setBackground(Color.PINK);
			try {
			//���þ��Բ���
			getContentPane().setLayout(null);
			//���ô�С
			//setSize(436, 386);
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
			scrollPane.setBounds(10, 52, 284, 138);
			//����������ӹ�����
			getContentPane().add(scrollPane);
         //�������
			final JButton button = new JButton();
			button.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					JOptionPane.showMessageDialog(null, "��Ҫ����ӣ���ϢҪ����Ӵ��");
					new vipbaijiu1(model);
				}
			});
			button.setFont(new Font("", Font.BOLD, 15));
			button.setText("����");
			button.setBounds(39, 214, 75, 33);
			getContentPane().add(button);
         //ɾ��
			final JButton button_1 = new JButton();
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
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
						//ȷ���к�
							int row=table.getSelectedRow();
						//�õ���ɾ���е�zhonglei
							String zhonglei=(String) model.getValueAt(row, 1);
							System.out.println(zhonglei);
						//��id����ɾ�����
							int judge=vipbai.delete1(zhonglei);
								if(judge>0){
									JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
								}else{
									JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
								}
								
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, "���ݿ��������");
							}
					
				}
			});
			button_1.setFont(new Font("Dialog", Font.BOLD, 15));
			button_1.setText("ɾ��");
			button_1.setBounds(201, 214, 75, 33);
			getContentPane().add(button_1);

			final JLabel label = DefaultComponentFactory.getInstance().createTitle("VIP�ع�");
			label.setFont(new Font("", Font.BOLD, 18));
			label.setBounds(39, 5, 75, 33);
			getContentPane().add(label);
	        model = new DefaultTableModel();
			//����ؼ�������ж���
	        model.addColumn("ʱ��");
			model.addColumn("����");
			model.addColumn("����");
			model.addColumn("���");
			model.addColumn("����");
			model.addColumn("���");
			table = new JTable(model);
				ArrayList<VipBaijiu>  vipbaijiu=vipbai.vipBaiJiu1();
				for (int i=0; i< vipbaijiu.size(); i++){
					VipBaijiu e = vipbaijiu.get(i);
					model.addRow(new Object[]{
						e.getShijian()
						, e.getZhonglei()
						, e.getDanjia()
						, e.getNianfen()
						, e.getDushu()
						, e.getJianjie()
					});
					table = new JTable(model);
					scrollPane.setViewportView(table);
					
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
		    			"���ݿ��������");
			}
			//�رմ���ͬʱ�رճ���
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			//��ʾ����
			
			
			
			setVisible(true);
			setBounds(0, 0, 319, 296);
	    }
	}
