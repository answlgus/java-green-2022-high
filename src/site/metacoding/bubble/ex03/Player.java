package site.metacoding.bubble.ex03;

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
	
	private int x; //private ->���� �����ؼ� ���� �����ϰ� ���� �ʱ� ����
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
		System.out.println("���� �̵�");
		x = x - 10;
		setLocation(x,y); // paintComponent �ϴ� ��
	}
	
	public void right() {
		setIcon(playerR);
		System.out.println("������ �̵�");
		x =x + 10;
		setLocation(x,y);
	}

}

