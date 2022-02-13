package site.metacoding.ex13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BorderLayoueEx01 extends MyFrame{
	
	public BorderLayoueEx01() { //생성자
		
	JPanel panel = (JPanel) getContentPane();
	panel.setLayout(new BorderLayout());
	
	JButton btnNorth = new JButton("북쪽");
	JButton btnEast = new JButton("동쪽");
	JButton btnWest= new JButton("서쪽");
	JButton btnSouth = new JButton("남쪽");
	JButton btnCenter = new JButton("중앙");
	
	panel.add(btnNorth, BorderLayout.NORTH);
	panel.add(btnEast, BorderLayout.EAST);
	panel.add(btnWest, BorderLayout.WEST);
	panel.add(btnSouth, BorderLayout.SOUTH);
	panel.add(btnCenter, BorderLayout.CENTER);
	
	setVisible(true); //그림 그리기
	
	}
	
	public static void main(String[] args) {
		new BorderLayoueEx01();

	}

}
