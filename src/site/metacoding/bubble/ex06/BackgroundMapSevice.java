package site.metacoding.bubble.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

//백그라운드 서비스(독립적이 스레드로 돌려야 한다)
public class BackgroundMapSevice implements Runnable {
	
	
	//composition
	private Player player;
	private BufferedImage image;
	
	//컴포지션을 위한 기술 => 의존성 주입(생성자를 통해서 주입) =DI(Dependency Injection)
	public BackgroundMapSevice(Player player) {
		this.player = player; //책임이 없으면 main에 띄우기
		
			try {
			
			//raw 하게 읽는다 = 날 것 그대로 읽는 것
			image = ImageIO.read(new File("image/test.png"));
			//System.out.println(image);
			//System.out.println(image.getRGB(10, 10));
			
			//플레이어 위치
			//System.out.println("플레이어 위치 x :" + player.getX());
			//System.out.println("플레이어 위치 x :" + player.getY());
			
			//색상계산(while)
			while(true) {
				Color color = new Color(image.getRGB(player.getX()+50, player.getY()));
				System.out.println(color.getRed());
				System.out.println(color.getGreen());
				System.out.println(color.getBlue());
				System.out.println("==============");
				Thread.sleep(10); //충돌감지를 미세하게 하는 조절법
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		
	}
}
