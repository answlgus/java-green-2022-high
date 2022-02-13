package site.metacoding.ex13;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NullLayouytEx01 extends MyFrame{
	
	public NullLayouytEx01() {
		
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(null);
		
		JButton btn1 = new JButton("버튼1");
		
		btn1.setSize(100, 50); //크기설정
		btn1.setLocation(0, 0); //출력 위치 설정 
		
		panel.add(btn1);
		
		setVisible(true); 
		
		
	}

	public static void main(String[] args) {
		new NullLayouytEx01();

	}

}
