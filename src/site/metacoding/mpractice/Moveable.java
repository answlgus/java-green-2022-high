package site.metacoding.mpractice;

public interface Moveable {
	void left();
	void right();
	void up();
	default void down() {}; //������ �ٿ� ����
}
