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
//菜单主页
public class MenuFrame extends JInternalFrame {
	/*DefaultTableModel是JTable的模型，相当于替身
	 * 一般存储数据都用DefaultTableModel去存储，存好了，放在JTable里去就好了
	 */
	 private JTable table;
	//Service层对象
	Service service =new Service();
	int page=3;
	final int LINES = 5;
	//创建表
	DefaultTableModel model;
	//创建按钮
	JButton next;
	JButton previous;
	public MenuFrame() {
		super();
		setBackground(Color.lightGray);
		//设置绝对布局
		getContentPane().setLayout(null);
		//设置大小
		//setSize(592, 496);
		//获取屏幕大小
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		//获取窗口大小
		int ww = getSize().width;
		int wh = getSize().height;
		//设置位置
		setLocation(0, 0);
		//getContentPane()初始化一个容器，用来在容器上添加控件
		//setLayout(null)清空布局管理器，用于之后添加组件
		getContentPane().setLayout(null);
		//在布局中添加标题
		setTitle("菜单信息");
		setClosable(true);
        //绑定一个滚动条
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 29, 436, 181);
		//在容器中添加滚动条
		getContentPane().add(scrollPane);
        model = new DefaultTableModel();
		//向表格控件中添加列对象
		model.addColumn("菜单号");
		model.addColumn("菜单名");
		model.addColumn("菜单价格");
		model.addColumn("菜单折扣");
		table = new JTable(model);
		//添加滚动窗格
		//上一页的操作
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
		//将按钮背景色设为透明色
		previous.setOpaque(false);
		//将按钮背景色设为蓝色
		previous.setBackground(Color.BLUE);
		//去掉按钮的边框
		previous.setBorderPainted(false);
		previous.setText("上一页<<");
		previous.setBounds(49, 227, 106, 28);
		getContentPane().add(previous);
        //下一页的操作
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
		next.setText("下一页>>");
		next.setBounds(352, 227, 106, 28);
		getContentPane().add(next);
		setPreNextEnable();
        //增加记录
		final JButton insert = new JButton();
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				//获取行数
				int count = model.getRowCount();
				int max = 0;
				for (int i=0; i<count; i++){
					//得到该行记录中的学号
					int id = (Integer)model.getValueAt(i, 0);
					if (max < id)
						max = id;
				}
				JOptionPane.showMessageDialog(null, "按要求添加，信息要完整哟！");
				new BulltWindow(model,max+1);
			}
		});
		insert.setText("增加");
		insert.setBounds(49, 293, 74, 28);
		getContentPane().add(insert);
      
		//删除记录
		final JButton delete = new JButton();
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				try {
			//确定选择了几行
				int count=table.getSelectedRowCount();
				if(count==0){
					JOptionPane.showMessageDialog(null, "请选择要删除的行！");
				}
				if(count>1){
					JOptionPane.showMessageDialog(null, "一次只能删除一行");
					return;
				}
			//确定行号
				int row=table.getSelectedRow();
			//得到所删除行的id
				int id=(Integer)model.getValueAt(row, 0);
				System.out.println(id);
			//将id传给删除语句
				int judge=service.delete1(id);
					if(judge>0){
						JOptionPane.showMessageDialog(null, "删除成功！");
					}else{
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "数据库操作有误");
				}
			}     
					
		});
		delete.setText("删除");
		delete.setBounds(158, 293, 74, 28);
		getContentPane().add(delete);
        //修改
		final JButton update = new JButton();
		update.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
			 new Update(model,table);
			 }
		});
		update.setText("修改");
		update.setBounds(268, 293, 74, 28);
		getContentPane().add(update);

		final JButton select = new JButton();
		select.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				new SelectOne();
			}
		});
		select.setText("查找");
		select.setBounds(384, 293, 74, 28);
		//getContentPane()初始化一个容器，用来在容器上添加控件
		//把select按钮添加到容器中
		getContentPane().add(select);
		setSize(521, 396);
		setLocation(0, 0);
		setVisible(true);
	}
     private void putMenuInfoToTable(int page, int lines, DefaultTableModel model){
		try {
			//清空表中的数据
			int count = model.getRowCount();
			for (int j=0; j<count; j++)
				model.removeRow(0);	//不能写j
			
			//显示本页内容
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
			JOptionPane.showMessageDialog(null, "数据库操作有误");
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
			JOptionPane.showMessageDialog(null, "数据库操作有误yyyyyyyyyyy");
		}
		//关闭窗口，则程序结束
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//将窗体显示出来。该语句最好放在末尾。
		 setVisible(true);
    }
}
