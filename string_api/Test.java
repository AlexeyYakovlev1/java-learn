package string_api;

public class Test {
	public static void main(String[] args) {
		int s = 1;

		for (int i = 4; i >= 0; i--) {
			System.out.print(" ".repeat(i));
			System.out.print("*".repeat(s));
			s += 2;
			System.out.println();
		}

		// 	   *
		//    ***
		//   *****
		//  *******
		// *********
	}
}
