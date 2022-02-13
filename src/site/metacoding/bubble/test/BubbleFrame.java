package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{
   
   private JLabel backgroundmMap; // 배경화면 설정
   private Player player; //player 배치
   

   public BubbleFrame() {
      
      initObject(); //호출
      initSetting(); //호출
      initListener();
      setVisible(true); //내부에 paintComponent()호출      
      
   }
   
   // 모든 new 
   private void initObject() {
      backgroundmMap = new JLabel();
      backgroundmMap.setIcon(new ImageIcon("image/backgroundMap.png"));
      setContentPane(backgroundmMap); // background 설정 
      
      
      //player new 하기
      player = new Player();
      add(player);
   }
   
   // 모든 setting 
   private void initSetting() {
      setSize(1000,  640); //화면 사이즈 설정
      getContentPane().setLayout(null); // null을 줘야 absolute layout 가능
      setLocationRelativeTo(null); //중앙배치
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 모든 thread 같이 종료
   }
   
   private void initListener() {
      addKeyListener(new KeyListener() {

         @Override
         public void keyTyped(KeyEvent e) {
            
         }

         @Override
         public void keyReleased(KeyEvent e) { // 키보드 눌렀다 떼기
            System.out.println("키보드 릴리즈");
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
               player.setRight(false);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
               player.setLeft(false);
            }

         }

         @Override
         public void keyPressed(KeyEvent e) { // 키보드 누르면
            // 오른쪽 39, 왼쪽 37 , 위 38, 아래 40
            // System.out.println("키보드 프레스 :" + e.getKeyCode());
            
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