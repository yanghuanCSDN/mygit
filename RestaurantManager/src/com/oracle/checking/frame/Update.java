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
//菜单中用于修改
public class Update extends JFrame {
	private JTextField t1;
	Service service=new Service();
	 public Update(DefaultTableModel model,JTable table) {
		super();
		//设置绝对布局
		getContentPane().setLayout(null);
		//设置大小
		setSize(497, 385);
		//获取屏幕大小
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		//获取窗口大小
		int ww = getSize().width;
		int wh = getSize().height;
		//设置位置
		setLocation((sw-ww)/2, (sh-wh)/2);

		final JLabel label = new JLabel();
		label.setFont(new Font("", Font.BOLD, 15));
		label.setText("价格");
		label.setBounds(111, 47, 55, 41);
		getContentPane().add(label);

		t1 = new JTextField();
		t1.setBounds(179, 53, 172, 30);
		getContentPane().add(t1);
        final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
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
				//改变后的price值
				Double price=Double.valueOf(t1.getText());
				//确定行号
				int row=table.getSelectedRow();
			    //得到所需修改行的id
				int id=(Integer)model.getValueAt(row, 0);
				System.out.println(id+" "+price+" "+row);
				//被选中记录的所在行
				int m=id%5;
				model.setValueAt(price, m, 3);
				JOptionPane.showMessageDialog(null,id+" "+price);
					int t=service.update(price, id);
					if(t>0){
						JOptionPane.showMessageDialog(null,"修改成功！");
					}
					if(t==0){
						JOptionPane.showMessageDialog(null,"修改失败！");
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"数据库操作失败！");
				}
			}
		});
		button.setFont(new Font("", Font.BOLD, 15));
		button.setText("提交");
		button.setBounds(187, 151, 106, 28);
		getContentPane().add(button);
		//关闭窗口，则程序结束
	     setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//将窗体显示出来。该语句最好放在末尾。
		 setVisible(true);
	}
     
}
