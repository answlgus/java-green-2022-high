package site.metacoding.mpractice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleApp extends JFrame implements Init{

	private static final String Tag ="BubbleApp: ";
	private BubbleApp mContext = this;
	
	private BackgroundMap backgrouMap;
	private Player player;
	
	private JLabel backgroundMap;
	
	
	public BubbleApp() {
		//System.out.println(Tag + "생성자 실행");
		initObject();
		initSetting();
		initListener();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BubbleApp();
		
	}

	@Override
	public void initObject() {
		
		backgroundMap = new BackgroundMap();
		setContentPane(backgrouMap);
		
		
	    player = new Player();
	    add(player);
		
		
	}

	@Override
	public void initSetting() {
		
		setSize(1000, 640);
	      getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
	      setLocationRelativeTo(null); // 가운데 배치
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
		
	}
	
	@Override
	public void initListener() {
		mContext.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) { // switch의 값, case 값 비교
				case KeyEvent.VK_RIGHT:
					player.right();
					break; //switch 종료
				case KeyEvent.VK_LEFT:
					player.left();
					break; //switch 종료
				case KeyEvent.VK_UP:
					player.up();
					break; //switch 종료
				}
			
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
		});
	}

}
