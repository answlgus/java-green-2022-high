package site.metacoding.ex13;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NullLayouytEx01 extends MyFrame{
	
	public NullLayouytEx01() {
		
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(null);
		
		JButton btn1 = new JButton("��ư1");
		
		btn1.setSize(100, 50); //ũ�⼳��
		btn1.setLocation(0, 0); //��� ��ġ ���� 
		
		panel.add(btn1);
		
		setVisible(true); 
		
		
	}

	public static void main(String[] args) {
		new NullLayouytEx01();

	}

}
