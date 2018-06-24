package com.oracle.checking.frame;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.oracle.checking.service.Service;
import com.oracle.checking.unit.AllFoodMenu;
//�˵���ҳ
public class MenuFrame extends JInternalFrame {
	/*DefaultTableModel��JTable��ģ�ͣ��൱������
	 * һ��洢���ݶ���DefaultTableModelȥ�洢������ˣ�����JTable��ȥ�ͺ���
	 */
	 private JTable table;
	//Service�����
	Service service =new Service();
	int page=3;
	final int LINES = 5;
	//������
	DefaultTableModel model;
	//������ť
	JButton next;
	JButton previous;
	public MenuFrame() {
		super();
		setBackground(Color.lightGray);
		//���þ��Բ���
		getContentPane().setLayout(null);
		//���ô�С
		//setSize(592, 496);
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
		setTitle("�˵���Ϣ");
		setClosable(true);
        //��һ��������
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 29, 436, 181);
		//����������ӹ�����
		getContentPane().add(scrollPane);
        model = new DefaultTableModel();
		//����ؼ�������ж���
		model.addColumn("�˵���");
		model.addColumn("�˵���");
		model.addColumn("�˵��۸�");
		model.addColumn("�˵��ۿ�");
		table = new JTable(model);
		//��ӹ�������
		//��һҳ�Ĳ���
		scrollPane.setViewportView(table);
		putMenuInfoToTable(page, LINES, model);
        previous = new JButton();
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				page--;
				putMenuInfoToTable(page, LINES, model);
				setPreNextEnable();
			}
		});
		//����ť����ɫ��Ϊ͸��ɫ
		previous.setOpaque(false);
		//����ť����ɫ��Ϊ��ɫ
		previous.setBackground(Color.BLUE);
		//ȥ����ť�ı߿�
		previous.setBorderPainted(false);
		previous.setText("��һҳ<<");
		previous.setBounds(49, 227, 106, 28);
		getContentPane().add(previous);
        //��һҳ�Ĳ���
		next = new JButton();
		next.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				page++;
				putMenuInfoToTable(page, LINES, model);
				setPreNextEnable();
			}
		});
		next.setOpaque(false);
		next.setBorderPainted(false);
		next.setBackground(Color.BLUE);
		next.setText("��һҳ>>");
		next.setBounds(352, 227, 106, 28);
		getContentPane().add(next);
		setPreNextEnable();
        //���Ӽ�¼
		final JButton insert = new JButton();
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				//��ȡ����
				int count = model.getRowCount();
				int max = 0;
				for (int i=0; i<count; i++){
					//�õ����м�¼�е�ѧ��
					int id = (Integer)model.getValueAt(i, 0);
					if (max < id)
						max = id;
				}
				JOptionPane.showMessageDialog(null, "��Ҫ����ӣ���ϢҪ����Ӵ��");
				new BulltWindow(model,max+1);
			}
		});
		insert.setText("����");
		insert.setBounds(49, 293, 74, 28);
		getContentPane().add(insert);
      
		//ɾ����¼
		final JButton delete = new JButton();
		delete.addActionListener(new ActionListener() {
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
			//ȷ���к�
				int row=table.getSelectedRow();
			//�õ���ɾ���е�id
				int id=(Integer)model.getValueAt(row, 0);
				System.out.println(id);
			//��id����ɾ�����
				int judge=service.delete1(id);
					if(judge>0){
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					}else{
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
					}
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "���ݿ��������");
				}
			}     
					
		});
		delete.setText("ɾ��");
		delete.setBounds(158, 293, 74, 28);
		getContentPane().add(delete);
        //�޸�
		final JButton update = new JButton();
		update.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
			 new Update(model,table);
			 }
		});
		update.setText("�޸�");
		update.setBounds(268, 293, 74, 28);
		getContentPane().add(update);

		final JButton select = new JButton();
		select.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				new SelectOne();
			}
		});
		select.setText("����");
		select.setBounds(384, 293, 74, 28);
		//getContentPane()��ʼ��һ����������������������ӿؼ�
		//��select��ť��ӵ�������
		getContentPane().add(select);
		setSize(521, 396);
		setLocation(0, 0);
		setVisible(true);
	}
     private void putMenuInfoToTable(int page, int lines, DefaultTableModel model){
		try {
			//��ձ��е�����
			int count = model.getRowCount();
			for (int j=0; j<count; j++)
				model.removeRow(0);	//����дj
			
			//��ʾ��ҳ����
			ArrayList<AllFoodMenu> arr = service.getPageMenuInfo(page, lines);
			for (int i=0; i<arr.size(); i++){
				AllFoodMenu s = arr.get(i);
				model.addRow(new Object[]{
					s.getId()
					, s.getName()
					, s.getPrice()
					, s.getDiscount()
				});
			}
	    } catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿ��������");
	}
 }
	
	private void setPreNextEnable(){
		int count;
		try {
			count = service.getTotalMenuCount();
			if (page == 1)
				previous.setEnabled(false);
			
			if (count%LINES == 0){
				if (page == count/LINES)  
					next.setEnabled(false);
				if (page>1 && page<count/LINES){
					previous.setEnabled(true);
					next.setEnabled(true);
				}
			}  
			else{
				if (page == count/LINES+1)  
					next.setEnabled(false);
				if (page>1 && page<count/LINES+1){
					previous.setEnabled(true);
					next.setEnabled(true);
				}
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "���ݿ��������yyyyyyyyyyy");
		}
		//�رմ��ڣ���������
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//��������ʾ�������������÷���ĩβ��
		 setVisible(true);
    }
}
