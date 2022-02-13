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
	JButton btn1 , btn2; // 같은 타입의 경우 , 를 사용해서 나열 가능
	JCheckBox checkBox1; // 체크박스 만들기 
	
	public EventEx01() {
		
		setSize(300, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myPanel =new JPanel();
		add(myPanel);
		
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		checkBox1 = new JCheckBox();
		
		//mypanel에 붙이기
		myPanel.add(btn1);
		myPanel.add(btn2);
		myPanel.add(checkBox1);
		
		//리스너 생성 (리스너가 있으면 운연체계가 주시)
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("버튼1이 클릭되었습니다");
				
			}
		});
		
		//버튼 2 리스너 생성
		btn2.addActionListener((ActionEvent e)->{
			System.out.println("버튼2가 클릭되었습니다");
		});
		
		//체크박스 리스너 생성
		checkBox1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.toString());
				System.out.println(e.getStateChange());
				
				if(e.getStateChange() == 1) {
					System.out.println("체크되었습니다");
				} else {
					System.out.println("체크가 해제되었습니다");
				}
				
			}
		});
		 
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new EventEx01();

	}

}
