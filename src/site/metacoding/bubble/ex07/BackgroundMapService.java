package site.metacoding.bubble.ex07;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

//백그라운드 서비스(독립적이 스레드로 돌려야 한다)
public class BackgroundMapService implements Runnable {
	
	
	//composition
	private Player player;
	private BufferedImage image;
	
	//컴포지션을 위한 기술 => 의존성 주입(생성자를 통해서 주입) =DI(Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player; //책임이 없으면 main에 띄우기
		
			try {
			
			//raw 하게 읽는다 = 날 것 그대로 읽는 것
			image = ImageIO.read(new File("image/test.png"));
			//System.out.println(image);
			//System.out.println(image.getRGB(10, 10));
			
			//플레이어 위치
			//System.out.println("플레이어 위치 x :" + player.getX());
			//System.out.println("플레이어 위치 x :" + player.getY());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	   public void run() {
	      while(true) {
	         // 색상 확인
	         Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
	         Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
	         //System.out.println("leftColor : "+leftColor);
	         //System.out.println("rightColor : "+rightColor);
	         
	         //bottom
	         System.out.println(image.getRGB(player.getX(), player.getY())); //바닥체크
	         
	         //더했을 때 -2가 아니면 바닥에 뭐가 있다
	         int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
	                 + image.getRGB(player.getX()+50 - 10, player.getY() + 50 + 5); // -1
	         
	         //bottom 충돌 상태
	         if(bottomColor != -2) {
	        	 player.setDown(false);
	         } else if (bottomColor == -2) { //바텀이 흰색이면 down 호출
	        	 System.out.println();
	        	 if(player.isDown() == false && player.isUp() == false) {
	        		 player.down();
	        	 }
	         }
	         
	         if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
	            System.out.println("왼쪽 벽에 충돌함");
	            player.setLeftWallCrash(true);
	            player.setLeft(false);
	         }else if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
	            System.out.println("오른쪽 벽에 충돌함");
	            player.setRightWallCrash(true);
	            player.setRight(false);
	         } else {
	        	 player.setRight(false);
	        	 player.setLeftWallCrash(false);
	         }
	         
	         try {
	            Thread.sleep(10);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	      }

	   }
}
