package operators_and_code_structure;

public class Test2 {
	static int x = 5;

	public Test2() {}

	public static void main(String[] args) {
		Test2 t2 = new Test2();
		{
			int x = 1;
			System.out.println("First block x = " + x); // 1
		}
		{
			int x = 2;
			System.out.println("Second block x = " + x); // 2
		}
		System.out.println("For cycle x = "); // 0-4
		for (int x = 0; x < 5; x++) {
			System.out.println(x);
		}
	}
}
