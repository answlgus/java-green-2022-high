package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Administrator
 * 
 *목적: 배경화면 설정, 캐릭터 추가
 *
 */

public class BubbleFrame extends JFrame{
	
	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		
		initObject();
		initSetting();
		setVisible(true); //내부에 paintComponent()호출 코드가 있음
		
	}
	
	//new 하는 것
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); //백그라운드 화면 설정
		
		player = new Player();
		add(player);
	}
	
	private void initSetting() {
		setSize(1000,640);
		getContentPane().setLayout(null); //null을 줘야 absolute layout이 가능 
		setLocationRelativeTo(null); //가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 클릭시 모든 thread 같이 종료
	}

	public static void main(String[] args) {
		

	}

}
