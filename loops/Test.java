package loops;

public class Test {
	public static void main(String[] args) {
		int x = 50;
		while (x > 0) {
			System.out.println("X: " + x);
			x--;
			if (x % 2 == 0)
				continue;
			System.out.println("SOME STRING");
		}
	}
}
