package time_api;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Test {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		Instant instant = Instant.now();

		System.out.println(date); // YYYY-MM-DD
		System.out.println(time); // HH:MM:SS.MS
		System.out.println(dateTime); // YYYY-MM-DDTHH:MM:SS.MS
		System.out.println(instant); // YYYY-MM-DDTHH:MM:SS.MS
	}
}
