package site.metacoding.mpractice;

/**
 * 
 * @author User A
 * 생성자 실행 순서
 * initObject 1번 실행
 * initSetting 2번 실행
 * initListener 3번 실행(default)
 *
 */

public interface Init {
	
	void initObject(); //강제성
	void initSetting(); //강제성
	default void initListener() {}; //default가 있으면 몸체가 있는 메서드를 만들 수 있다. override 할 필요 없음
	
}
