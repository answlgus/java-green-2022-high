package site.metacoding.bubble.ex04;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Administrator
 * 
 *목적: 스무스한 좌우이동
 *
 */

public class BubbleFrame extends JFrame{
	
	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		
		initObject();
		initSetting();
		initListener();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 클릭시 JVM 같이 종료
	}
	
	private void initListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) { //키보드에서 떼면
				System.out.println("키보드 릴리즈");
				
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					//isRight를 false
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					//isleft를 false
					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) { //키보드 누르면
				//왼쪽 37, 오른쪽 39, 위:98, 아래:40
				System.out.println("키보드 프레스" + e.getKeyCode());
				
				
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					//키보드를 누르고 있는 동안 right 메서드를 한 번만 실행하고 싶다.
					if(player.isRight() == false) {
						player.right(); // right는 player의 책임
					}
					
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.left();
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();

	}

}
