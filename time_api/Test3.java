package time_api;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Test3 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2036, 12, 22);
		System.out.println(date);

		LocalDateTime dateTime1 = LocalDateTime.of(2036, 12, 22, 9, 0, 0);
		System.out.println(dateTime1);

		LocalDateTime dateTime2 = LocalDateTime.of(2036, 11, 22, 12, 0, 0);

		if (dateTime1.isBefore(dateTime2)) {
			System.out.println(dateTime1 + " is earlier than " + dateTime2);
		} else if (dateTime1.isAfter(dateTime2)) {
			System.out.println(dateTime1 + " is later than " + dateTime2);
		} else if (dateTime1.isEqual(dateTime2)) {
			System.out.println(dateTime1 + " is equal to " + dateTime2);
		}
	}
}
