package site.metacoding.ex13;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutEx01 extends JFrame {
	
	public FlowLayoutEx01 () {
		
		super(); // �����Ǿ� ����
		System.out.println("FlowLayoutEx01");
		setSize(600, 400);
		setLocationRelativeTo(null);; //������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ�� �� main ����
		
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new FlowLayout());
		JButton btn1 = new JButton("��ư1");
		JButton btn2 = new JButton("��ư2");
		JButton btn3 = new JButton("��ư3");
		JButton btn4 = new JButton("��ư4");
		
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
