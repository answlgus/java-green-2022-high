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
 *����: �������� �¿��̵�
 *
 */

public class BubbleFrame extends JFrame{
	
	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		
		initObject();
		initSetting();
		initListener();
		setVisible(true); //���ο� paintComponent()ȣ�� �ڵ尡 ����
		
	}
	
	//new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); //��׶��� ȭ�� ����
		
		player = new Player();
		add(player);
	}
	
	private void initSetting() {
		setSize(1000,640);
		getContentPane().setLayout(null); //null�� ��� absolute layout�� ���� 
		setLocationRelativeTo(null); //��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x��ư Ŭ���� JVM ���� ����
	}
	
	private void initListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) { //Ű���忡�� ����
				System.out.println("Ű���� ������");
				
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					//isRight�� false
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					//isleft�� false
					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) { //Ű���� ������
				//���� 37, ������ 39, ��:98, �Ʒ�:40
				System.out.println("Ű���� ������" + e.getKeyCode());
				
				
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					//Ű���带 ������ �ִ� ���� right �޼��带 �� ���� �����ϰ� �ʹ�.
					if(player.isRight() == false) {
						player.right(); // right�� player�� å��
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
