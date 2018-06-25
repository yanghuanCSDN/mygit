package com.oracle.checking.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;



//import unit.YinLiao;

public class ShuiFrame extends JInternalFrame {

	private JTree tree;

	public ShuiFrame() {
		super();
		setBackground(Color.lightGray);
		setClosable(true);
		getContentPane().setLayout(null);
		// 树
		// 设置窗口宽高
		setSize(522, 394);

		// 得到屏幕宽高
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int ww = getSize().width;
		// 得到窗口宽高。要放在设置屏幕宽高语句后面
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
		int wh = getSize().height;
		final JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 49, 490, 300);
		getContentPane().add(splitPane);

		final JDesktopPane tab = new JDesktopPane();
		tab.setMinimumSize(new Dimension(0, 0));
		tab.setMaximumSize(new Dimension(0, 0));
		splitPane.setRightComponent(tab);

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setMinimumSize(new Dimension(150, 100));
		splitPane.setLeftComponent(panel);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("酒水");

		DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("VIP特供");

		DefaultMutableTreeNode root2 = new DefaultMutableTreeNode("白酒");

		DefaultMutableTreeNode root3 = new DefaultMutableTreeNode("红酒");

		root.add(root1);
		root.add(root2);
		root.add(root3);
		DefaultTreeModel model = new DefaultTreeModel(root);
		tree = new JTree(model);
		tree.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				TreePath path = tree.getSelectionPath();

				String str[] = path.toString().split(",");
				if (str.length != 0) {
					String str1 = str[str.length - 1];
					str1 = str1.substring(0, str1.length() - 1).trim();
					vipbaijiu v = null;
					baijiu v1 = null;
					JInternalFrame arr[] = tab.getAllFrames();
					int i;
					if (str1.equals("VIP特供")) {
						for (i = 0; i < arr.length; i++) {
							if (arr[i] instanceof vipbaijiu) {
								arr[i].toFront();
								return;
							}
						}
						v = new vipbaijiu();

						tab.add(v);
						v.toFront();
					}
					if (str1.equals("白酒")) {
						for (i = 0; i < arr.length; i++) {
							if (arr[i] instanceof baijiu) {
								arr[i].toFront();
								return;
							}
						}
						v1 = new baijiu();

						tab.add(v1);
						v1.toFront();

					}

				}
			}

		});
		tree.setBounds(5, 25, 140, 157);
		panel.add(tree);

		final JLabel label = new JLabel();
		label.setFont(new Font("", Font.BOLD, 22));
		label.setText("欢迎光临");
		label.setBounds(24, 10, 653, 33);
		getContentPane().add(label);

		// 关闭窗口，则程序结束
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// 将窗体显示出来。该语句最好放在末尾。
		setVisible(true);

	}

}
