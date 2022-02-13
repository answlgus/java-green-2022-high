package site.metacoding.mpractice;
//어뎁터 패턴 : 안쓰는 메서드 걸러내기

interface Knife {
	void attack();
	void cook();
}

abstract class 요리사어댑터{ //추상클래스는 추상메서드 구현 할 필요 없음
	
	public void attack() {}
}
abstract class 싸움꾼{
	
	public void cook() {}
} 

class 백종원 implements Knife{

	@Override
	public void attack() {
		//사용안함
		
	}

	@Override
	public void cook() {
	 System.out.println("요리");
		
	}
	
}

class 검투사 extends 싸움꾼 {
	
	public void attack() {}
}

public class PatternTest {

}
