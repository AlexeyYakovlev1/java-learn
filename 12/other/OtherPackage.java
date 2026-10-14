package other;

import zoo.Animal;

public class OtherPackage {
	public static void main(String[] args) {
		Animal animal = new Animal();

		System.out.println(animal.publicName); // OK

		// System.out.println(animal.protectedName); // ERROR
		// System.out.println(animal.packageName); // ERROR
		// System.out.println(animal.privateName); // ERROR

		animal.publicMethod(); // OK

		// animal.protectedMethod(); // ERROR
		// animal.packageMethod(); // ERROR
		// animal.privateMethod(); // ERROR
	}
}
