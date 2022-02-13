package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{
   
   private JLabel backgroundmMap; // ���ȭ�� ����
   private Player player; //player ��ġ
   

   public BubbleFrame() {
      
      initObject(); //ȣ��
      initSetting(); //ȣ��
      initListener();
      setVisible(true); //���ο� paintComponent()ȣ��      
      
   }
   
   // ��� new 
   private void initObject() {
      backgroundmMap = new JLabel();
      backgroundmMap.setIcon(new ImageIcon("image/backgroundMap.png"));
      setContentPane(backgroundmMap); // background ���� 
      
      
      //player new �ϱ�
      player = new Player();
      add(player);
   }
   
   // ��� setting 
   private void initSetting() {
      setSize(1000,  640); //ȭ�� ������ ����
      getContentPane().setLayout(null); // null�� ��� absolute layout ����
      setLocationRelativeTo(null); //�߾ӹ�ġ
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� ��� thread ���� ����
   }
   
   private void initListener() {
      addKeyListener(new KeyListener() {

         @Override
         public void keyTyped(KeyEvent e) {
            
         }

         @Override
         public void keyReleased(KeyEvent e) { // Ű���� ������ ����
            System.out.println("Ű���� ������");
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
               player.setRight(false);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
               player.setLeft(false);
            }

         }

         @Override
         public void keyPressed(KeyEvent e) { // Ű���� ������
            // ������ 39, ���� 37 , �� 38, �Ʒ� 40
            // System.out.println("Ű���� ������ :" + e.getKeyCode());
            
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
               if (player.isRight() == false) {
                  player.right();
               }
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
               if (player.isRight() == false) {
                  player.left();
               }
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
               if (player.isJump() == false) {
                  player.jump();
               }

            }
         }
      });

   }

   public static void main(String[] args) {
      new BubbleFrame();

   }

}