package operators_and_code_structure;

public class Test3 {
	static int x = 5;

	public Test3() {}

	public static void main(String[] args) {
		Test3 t = new Test3();

		int x;
		int y = 5;
		if (y > 3)
			x = 1;

		// System.out.println(x); // Ошибка инициализации
	}
}
