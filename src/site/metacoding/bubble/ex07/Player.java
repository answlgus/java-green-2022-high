package site.metacoding.bubble.ex07;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel{
   
   private int x; //좌우이동 (직접 상태 변경하지 않게 하기 위해)
   private int y; //점프
   private ImageIcon playerR, playerL;
   
   private boolean isRight;
   private boolean isLeft;
   private boolean up; //점프(up down)
   private boolean down;
   
   //boolean은 get -> x is
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
      setLocation(x,y); //위치 정하기
      
      isRight = false; //움직이는 상태X
      isLeft = false;
      up = false; //초기화
      down = false; //초기화
      
      leftWallCrash = false; //아직 부딪힌 상태 아님
      rightWallCrash = false;
      
   }
   
   public void right() {
      isRight = true;
      //leftWallCrash = false 
      setIcon(playerR);
      System.out.println("오른쪽 이동");
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
      System.out.println("왼쪽 이동");
      setLocation(x,y); // paintComponent 하는 중
      
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
   
   //for문으로 하기! -> 끝까지 올라가는게 아니기 때문
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

         //down -> backgroundsevice 에서 제어 (충돌이 날때 까지 떨어짐)
         
         up = false; //
         down();
      }).start();
   
   }
   
   public void down() {
	      setIcon(playerR);
	      down = true;
	      System.out.println("down");

	      new Thread(() -> {
	         //down -> backgroundsevice 에서 제어 (충돌이 날때 까지 떨어짐)
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
	         //down false 제어는 backgroundservice에서
	      }).start();
	   
	   }

}