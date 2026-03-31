package operators_and_code_structure;

public class Test {
	static int x = 5;

	public Test() {}

	public static void main(String[] args) {
		Test t = new Test();
		t.test(5);
		System.out.println("Member value x = " + x); // 10
	}

	private void test(int x) {
		this.x += 5;
		System.out.println("Local value x = " + x); // 5
	}
}
