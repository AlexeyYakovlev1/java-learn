package operators_and_code_structure;

public class Test5 {
	public static void main(String[] args) {
		int age = 4;
		if (age < 18)
			System.out.println("Child");
		else
			System.out.println("Adult");

		boolean isAdult = age >= 18;
		if (isAdult)
			System.out.println("adult");
		else
			System.out.println("child");

		int val = 5;
		switch (val) {
			case 5:
				System.out.println("val is 5");
				break;
			case 3:
			case 4:
				System.out.println("val is 3 or 4");
				break;
			default:
				System.out.println("val is invalid");
				break;
		}
	}	
}
