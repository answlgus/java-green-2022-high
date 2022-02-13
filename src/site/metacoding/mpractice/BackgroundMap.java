package site.metacoding.mpractice;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundMap extends JLabel{

	private ImageIcon backgroundMap;
	
	
	public BackgroundMap() {
		backgroundMap = new ImageIcon("image/backgroundMap.png");
		setIcon(backgroundMap); //div 박스에 이미지 넣기
		
	}
}
