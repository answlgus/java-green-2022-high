package site.metacoding.bubble.ex07;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel{
   
   private int x; //�¿��̵� (���� ���� �������� �ʰ� �ϱ� ����)
   private int y; //����
   private ImageIcon playerR, playerL;
   
   private boolean isRight;
   private boolean isLeft;
   private boolean up; //����(up down)
   private boolean down;
   
   //boolean�� get -> x is
   public boolean isUp() {
	return up;
}

public void setUp(boolean up) {
	this.up = up;
}

public boolean isDown() {
	return down;
}

public void setDown(boolean down) {
	this.down = down;
}

private boolean leftWallCrash;
private boolean rightWallCrash;

private static final int JUMPSPEED = 2;
private static final int SPEED = 4;
   
 public boolean isLeftWallCrash() {
	return leftWallCrash;
}

public void setLeftWallCrash(boolean leftWallCrash) {
	this.leftWallCrash = leftWallCrash;
}

public boolean isRightWallCrash() {
	return rightWallCrash;
}

public void setRightWallCrash(boolean rightWallCrash) {
	this.rightWallCrash = rightWallCrash;
}


   
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
      
      x= 90;
      y = 535;
      setIcon(playerR); // player = label
      setSize(50,50); 
      setLocation(x,y); //��ġ ���ϱ�
      
      isRight = false; //�����̴� ����X
      isLeft = false;
      up = false; //�ʱ�ȭ
      down = false; //�ʱ�ȭ
      
      leftWallCrash = false; //���� �ε��� ���� �ƴ�
      rightWallCrash = false;
      
   }
   
   public void right() {
      isRight = true;
      //leftWallCrash = false 
      setIcon(playerR);
      System.out.println("������ �̵�");
      setLocation(x,y);
      
      new Thread(() -> {
         while (isRight) {
            x = x + SPEED;
            setLocation(x, y);
            try {
               Thread.sleep(10);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }).start();
   }
   
   public void left() {
      isLeft = true;
      setIcon(playerL);
      System.out.println("���� �̵�");
      setLocation(x,y); // paintComponent �ϴ� ��
      
      new Thread(() -> {
         while (isLeft) {
            x = x - SPEED;
            setLocation(x, y);
            try {
               Thread.sleep(10);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }).start();

   }
   
   //for������ �ϱ�! -> ������ �ö󰡴°� �ƴϱ� ����
   public void up() {
      setIcon(playerR);
      up = true;
      System.out.println("up");

      new Thread(() -> {
         for (int i = 0; i < 130 / JUMPSPEED; i++) {
            y = y - JUMPSPEED;
            setLocation(x, y);
            try {
               Thread.sleep(5);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }

         //down -> backgroundsevice ���� ���� (�浹�� ���� ���� ������)
         
         up = false; //
         down();
      }).start();
   
   }
   
   public void down() {
	      setIcon(playerR);
	      down = true;
	      System.out.println("down");

	      new Thread(() -> {
	         //down -> backgroundsevice ���� ���� (�浹�� ���� ���� ������)
	         while(down) {
	            y = y + JUMPSPEED;
	            setLocation(x, y);
	            
	            try {
	               Thread.sleep(3);
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	         
	         down = false;
	         //down false ����� backgroundservice����
	      }).start();
	   
	   }

}