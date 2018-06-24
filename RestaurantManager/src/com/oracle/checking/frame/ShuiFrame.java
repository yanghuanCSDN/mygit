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
		// ��
		// ���ô��ڿ��
		setSize(522, 394);

		// �õ���Ļ���
		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int ww = getSize().width;
		// �õ����ڿ�ߡ�Ҫ����������Ļ���������
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

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("��ˮ");

		DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("VIP�ع�");

		DefaultMutableTreeNode root2 = new DefaultMutableTreeNode("�׾�");

		DefaultMutableTreeNode root3 = new DefaultMutableTreeNode("���");

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
					if (str1.equals("VIP�ع�")) {
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
					if (str1.equals("�׾�")) {
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
		label.setText("��ӭ����");
		label.setBounds(24, 10, 653, 33);
		getContentPane().add(label);

		// �رմ��ڣ���������
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// ��������ʾ�������������÷���ĩβ��
		setVisible(true);

	}

}
