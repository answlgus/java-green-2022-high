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
		//System.out.println(Tag + "������ ����");
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
	      getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����
	      setLocationRelativeTo(null); // ��� ��ġ
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
		
	}
	
	@Override
	public void initListener() {
		mContext.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) { // switch�� ��, case �� ��
				case KeyEvent.VK_RIGHT:
					player.right();
					break; //switch ����
				case KeyEvent.VK_LEFT:
					player.left();
					break; //switch ����
				case KeyEvent.VK_UP:
					player.up();
					break; //switch ����
				}
			
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
		});
	}

}
