package site.metacoding.ex13;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	
	public MyFrame () {
		
		setSize(600,400); //ȭ�� ũ�� ����
		setLocationRelativeTo(null); //������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new FlowLayout());
		JButton btn1 = new JButton("��ư1");
		panel.add(btn1);
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		MyFrame mf = new MyFrame();	
		
		}

}
