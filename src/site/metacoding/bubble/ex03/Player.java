package site.metacoding.bubble.ex03;

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
	
	private int x; //private ->직접 접근해서 상태 변경하게 하지 않기 위해
	private int y;
	private ImageIcon playerR , playerL; 
	
	public Player() {
		initObject();
		initSetting();
	}
	
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerR = new ImageIcon("image/playerL.png");
	}
	
	private void initSetting() {
		x= 70;
		y = 535;
		setIcon(playerR);
		setSize(50,50);
		setLocation(x,y);
	}
	
	public void left() {
		setIcon(playerL);
		System.out.println("왼쪽 이동");
		x = x - 10;
		setLocation(x,y); // paintComponent 하는 중
	}
	
	public void right() {
		setIcon(playerR);
		System.out.println("오른쪽 이동");
		x =x + 10;
		setLocation(x,y);
	}

}

