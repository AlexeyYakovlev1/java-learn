package loops;

public class Test3 {
	public static void main(String[] args) {
		int x = 10;
		for (int i = 0; i < x; i++) {
			System.out.println("i: " + i);
			if (i >= 5)
				break;
		}
	}
}
