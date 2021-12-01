package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class no15552 {

	public static void main(String[] args) throws IOException {

		LocalDate now = LocalDate.now();
		
		LocalDate next = LocalDate.of(2022, 1, 1);

		long between = ChronoUnit.DAYS.between(now, next);
		
		System.out.println(now);
		System.out.println(next);
		
		System.out.println(between);
		
	}

}
