package string_api;

public class Test4 {
	public static void main(String[] args) {
		String nu = "Hello\nWorld\n!";
		nu.lines().forEach(System.out::println);
		/**
		 * Hello
		 * World
		 * !
		 */
	}
}
