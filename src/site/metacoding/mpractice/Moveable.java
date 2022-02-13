package site.metacoding.mpractice;

public interface Moveable {
	void left();
	void right();
	void up();
	default void down() {}; //버블은 다운 없음
}
