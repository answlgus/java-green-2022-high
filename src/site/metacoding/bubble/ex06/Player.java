package site.metacoding.bubble.ex06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel{
   
   private int x; //�¿��̵� (���� ���� �������� �ʰ� �ϱ� ����)
   private int y; //����
   private ImageIcon playerR, playerL;
   
   private boolean isRight;
   private boolean isLeft;
   private boolean isJump;
   
   private static final int JUMPSPEED = 2;
   private static final int SPEED = 2;
   
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
   
   public boolean isJump() {
      return isJump;
   }
   
   public void setJump(boolean isJump) {
      this.isJump = isJump;
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
      
      x= 70;
      y = 535;
      setIcon(playerR); // player = label
      setSize(50,50); 
      setLocation(x,y); //��ġ ���ϱ�
      
      isRight = false; //�����̴� ����X
      isLeft = false;
      isJump = false;
      
   }
   
   public void right() {
      isRight = true;
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
   
   public void jump() {
      setIcon(playerR);
      isJump = true;
      System.out.println("����");

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

         for (int i = 0; i < 130 / JUMPSPEED; i++) {
            y = y + JUMPSPEED;
            setLocation(x, y);
            try {
               Thread.sleep(3);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         
         isJump = false;
         
      }).start();
   
   }

}