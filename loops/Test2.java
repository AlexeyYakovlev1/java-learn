package loops;

public class Test2 {
	public static void main(String[] args) {
		int x = 50;
		do {
			System.out.println("X: " + x);
			x--;
			if (x % 2 == 0)
				continue;
			System.out.println("SOME STRING");
		} while(x > 0);
	}
}
