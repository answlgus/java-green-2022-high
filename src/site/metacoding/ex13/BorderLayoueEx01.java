package site.metacoding.ex13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BorderLayoueEx01 extends MyFrame{
	
	public BorderLayoueEx01() { //������
		
	JPanel panel = (JPanel) getContentPane();
	panel.setLayout(new BorderLayout());
	
	JButton btnNorth = new JButton("����");
	JButton btnEast = new JButton("����");
	JButton btnWest= new JButton("����");
	JButton btnSouth = new JButton("����");
	JButton btnCenter = new JButton("�߾�");
	
	panel.add(btnNorth, BorderLayout.NORTH);
	panel.add(btnEast, BorderLayout.EAST);
	panel.add(btnWest, BorderLayout.WEST);
	panel.add(btnSouth, BorderLayout.SOUTH);
	panel.add(btnCenter, BorderLayout.CENTER);
	
	setVisible(true); //�׸� �׸���
	
	}
	
	public static void main(String[] args) {
		new BorderLayoueEx01();

	}

}
