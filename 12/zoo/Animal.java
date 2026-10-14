package zoo;

// класс верхнего уровня может быть только public или package-private
public class Animal {
	public String publicName = "Доступно всем";
	protected String protectedName = "Только для наследников и пакета";
	String packageName = "Только для пакета";
	private String privateName = "Только для Animal";

	public void publicMethod() {
		System.out.println("Публиный метод");
	}

	protected void protectedMethod() {
		System.out.println("Защищенный метод");
	}

	void packageMethod() {
		System.out.println("Пакетный метод");
	}

	private void privateMethod() {
		System.out.println("Приватный метод");
	}
}
