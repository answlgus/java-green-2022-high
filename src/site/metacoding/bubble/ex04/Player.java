package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author Administrator
 *�÷��̾�� �¿� �̵��� �����ϴ�
 *������ ����
 *��� �߻�
 */

public class Player extends JLabel{
	
	private int x; //private ->���� �����ؼ� ���� �����ϰ� ���� �ʱ� ���� / � ���������� ��
	private int y;
	private ImageIcon playerR , playerL;
	
	//�¿� �̵� �׽�Ʈ
	private boolean isRight;
	private boolean isLeft;
	
	
	
	public boolean isRight() {
		return isRight; 
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Player() {
		initObject();
		initSetting();
	}
	
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}
	
	private void initSetting() {
		x= 70;
		y = 535;
		setIcon(playerR);
		setSize(50,50);
		setLocation(x,y);
		
		isRight = false; //���� �����̴� ���� �ƴ�
		isLeft = false; //���� �����̴� ���� �ƴ�
	}
	
	public void left() {
		setIcon(playerL);
		System.out.println("���� �̵�");
		x = x - 10;
		setLocation(x,y); // paintComponent �ϴ� ��
		
		new Thread(()->{
			while(isLeft) {
				x =x - 10;
				setLocation(x,y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public void right() {
		isRight = true; //
		setIcon(playerR);
		System.out.println("������ �̵�");
		
		new Thread(()->{
			while(isRight) {
				x =x + 10;
				setLocation(x,y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		
	}

}
