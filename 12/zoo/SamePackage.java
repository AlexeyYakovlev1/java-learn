package zoo;

public class SamePackage {
	public static void main(String[] args) {
		Animal animal = new Animal();

		System.out.println(animal.publicName); // OK
		System.out.println(animal.protectedName); // OK
		System.out.println(animal.packageName); // OK
		// System.out.println(animal.privateName); // ERROR

		animal.publicMethod(); // OK
		animal.protectedMethod(); // OK
		animal.packageMethod(); // OK
		// animal.privateMethod(); // ERROR
	}
}
