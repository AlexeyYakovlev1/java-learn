package missions;

import zoo.Animal;

public class SubAnimal extends Animal {
	public void testAccess() {
		System.out.println(publicName); // OK
		System.out.println(protectedName); // OK
		// System.out.println(packageName); // ERROR
		// System.out.println(privateName); // ERROR

		publicMethod(); // OK
		protectedMethod(); // OK
		// packageMethod(); // ERROR
		// privateMethod(); // ERROR
	}
}
