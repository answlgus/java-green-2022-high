package site.metacoding.bubble.test2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Bubble extends JLabel{

	private BubbleFrame context;
	private Player player;
	
	private int x;
	private int y;
	
	private ImageIcon bubble, bomb;
	
	public Bubble(BubbleFrame context) {
		this.context = context;
		this.player = context.getPlayer();
		//this.player = context.getPla
		initObject();
		initSetting();
	}
	

	private void initObject(){
		bubble = new ImageIcon("image/bubble.png");
		bomb = new ImageIcon("image/bomb.png");
	}
	private void initSetting() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);
		
			//방향체크
	if(player.getDirection()==1) {
		right();
	} else if(player.getDirection() == -1) {
		left();
	}
 }
	

	 
	public void left () {
		new Thread(() -> {
		 try {
			for (int i = 0; i < 400; i++) {
				x =  x-1;
				Thread.sleep(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	  }).start();
	}
	
	public void right () {
		
		new Thread(() -> {
			 try {
				for (int i = 0; i < 400; i++) {
					x =  x-1;
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		  }).start();
		

	}
}
