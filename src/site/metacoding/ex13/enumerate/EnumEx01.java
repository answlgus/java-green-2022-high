package site.metacoding.ex13.enumerate;

interface Direction {
	String LEFT = "Left";
	String RIGHT = "Right";
}

public class EnumEx01 {
	
	public static void add(String direction) {
		if (direction.equals("Left") || direction.equals("Right")) {
			System.out.println("잘 들어옴");
		} else {
			System.out.println("잘 못 입력");
		}
	}

	public static void main(String[] args) {
		add(Direction.LEFT);

	}

}
