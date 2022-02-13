package site.metacoding.bubble.ex07;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

//��׶��� ����(�������� ������� ������ �Ѵ�)
public class BackgroundMapService implements Runnable {
	
	
	//composition
	private Player player;
	private BufferedImage image;
	
	//���������� ���� ��� => ������ ����(�����ڸ� ���ؼ� ����) =DI(Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player; //å���� ������ main�� ����
		
			try {
			
			//raw �ϰ� �д´� = �� �� �״�� �д� ��
			image = ImageIO.read(new File("image/test.png"));
			//System.out.println(image);
			//System.out.println(image.getRGB(10, 10));
			
			//�÷��̾� ��ġ
			//System.out.println("�÷��̾� ��ġ x :" + player.getX());
			//System.out.println("�÷��̾� ��ġ x :" + player.getY());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	   public void run() {
	      while(true) {
	         // ���� Ȯ��
	         Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
	         Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
	         //System.out.println("leftColor : "+leftColor);
	         //System.out.println("rightColor : "+rightColor);
	         
	         //bottom
	         System.out.println(image.getRGB(player.getX(), player.getY())); //�ٴ�üũ
	         
	         //������ �� -2�� �ƴϸ� �ٴڿ� ���� �ִ�
	         int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
	                 + image.getRGB(player.getX()+50 - 10, player.getY() + 50 + 5); // -1
	         
	         //bottom �浹 ����
	         if(bottomColor != -2) {
	        	 player.setDown(false);
	         } else if (bottomColor == -2) { //������ ����̸� down ȣ��
	        	 System.out.println();
	        	 if(player.isDown() == false && player.isUp() == false) {
	        		 player.down();
	        	 }
	         }
	         
	         if(leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
	            System.out.println("���� ���� �浹��");
	            player.setLeftWallCrash(true);
	            player.setLeft(false);
	         }else if(rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
	            System.out.println("������ ���� �浹��");
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
