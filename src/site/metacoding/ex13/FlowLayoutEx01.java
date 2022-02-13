package site.metacoding.ex13;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutEx01 extends JFrame {
	
	public FlowLayoutEx01 () {
		
		super(); // 생략되어 있음
		System.out.println("FlowLayoutEx01");
		setSize(600, 400);
		setLocationRelativeTo(null);; //프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭 시 main 종료
		
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new FlowLayout());
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		JButton btn4 = new JButton("버튼4");
		
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new FlowLayoutEx01();
	}

}
