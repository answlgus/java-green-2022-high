package site.metacoding.bubble.ex02;

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
	
	private int x; //���� �����ؼ� ���� �����ϰ� ���� �ʱ� ����
	private int y;
	private ImageIcon playerR;
	
	public Player() {
		initObject();
		initSetting();
	}
	

	private void initObject() {
		playerR = new ImageIcon("image/playerL.png");
	}
	
	private void initSetting() {
		x= 70;
		y = 535;
		setIcon(playerR); //plyer��ü�� JLabel
		setSize(50,50);
		setLocation(x,y);
	}
	

}

