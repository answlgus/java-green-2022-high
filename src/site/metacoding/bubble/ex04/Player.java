package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author Administrator
 *플레이어는 좌우 이동이 가능하다
 *점프가 가능
 *방울 발사
 */

public class Player extends JLabel{
	
	private int x; //private ->직접 접근해서 상태 변경하게 하지 않기 위해 / 어떤 상태인지는 모름
	private int y;
	private ImageIcon playerR , playerL;
	
	//좌우 이동 테스트
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
		
		isRight = false; //아직 움직이는 상태 아님
		isLeft = false; //아직 움직이는 상태 아님
	}
	
	public void left() {
		setIcon(playerL);
		System.out.println("왼쪽 이동");
		x = x - 10;
		setLocation(x,y); // paintComponent 하는 중
		
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
		System.out.println("오른쪽 이동");
		
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
