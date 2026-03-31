package string_api;

public class Test2 {
	public static void main(String[] args) {
		String hello = " hello ";
		System.out.println(hello.strip()); // "hello"
		System.out.println(hello.stripLeading()); // "hello "
		System.out.println(hello.stripTrailing()); // " hello"
	}
}
