package operators_and_code_structure;

public class Test4 {
	static int x = 5;
	static {};
	public Test4() {}
	
	public static void main(String[] args) {
		Test4 t = new Test4();
		int x = 1;
		
		// Метки
		somePoint: {
			if (x == 0)
				break somePoint;
		}
		somePoint2: {
			if (x > 0)
				break somePoint2;
		}
	}
}
