package site.metacoding.bubble.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel{
	
	private BubbleFrame context;
	private Player player;
	
	private int x;
	private int y;
	
	private ImageIcon bubble, bomb;
	
	
	
	public Bubble() {
		
		this.context = context;
		this.player = context.getPlayer();
		initObject();
		initSetting();
	}
	
	private void initObject() {
		
		bubble = new ImageIcon("image/bubble.png");
		bomb = new ImageIcon("image/bomb.png");
	}
	
	private void initSetting() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50,50);
		setLocation(x,y);
		
	}
	
	public void left() {
		
	}
	
	public void right() {
		
	}

}
