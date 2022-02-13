package site.metacoding.ex13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventEx01 extends JFrame{
	
	JPanel myPanel;
	JButton btn1 , btn2; // ���� Ÿ���� ��� , �� ����ؼ� ���� ����
	JCheckBox checkBox1; // üũ�ڽ� ����� 
	
	public EventEx01() {
		
		setSize(300, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myPanel =new JPanel();
		add(myPanel);
		
		btn1 = new JButton("��ư1");
		btn2 = new JButton("��ư2");
		checkBox1 = new JCheckBox();
		
		//mypanel�� ���̱�
		myPanel.add(btn1);
		myPanel.add(btn2);
		myPanel.add(checkBox1);
		
		//������ ���� (�����ʰ� ������ �ü�谡 �ֽ�)
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("��ư1�� Ŭ���Ǿ����ϴ�");
				
			}
		});
		
		//��ư 2 ������ ����
		btn2.addActionListener((ActionEvent e)->{
			System.out.println("��ư2�� Ŭ���Ǿ����ϴ�");
		});
		
		//üũ�ڽ� ������ ����
		checkBox1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.toString());
				System.out.println(e.getStateChange());
				
				if(e.getStateChange() == 1) {
					System.out.println("üũ�Ǿ����ϴ�");
				} else {
					System.out.println("üũ�� �����Ǿ����ϴ�");
				}
				
			}
		});
		 
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new EventEx01();

	}

}
