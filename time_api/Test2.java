package time_api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test2 {
	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		String newDateTime = dateTime.format(formatter);

		System.out.println(newDateTime);
	}
}
