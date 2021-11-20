package JustPractice;

import java.util.*;
import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;



public class ex {

	
	public static void main(String[] args) throws NumberFormatException, IOException {

		Date time1 = new Date(2021-1900, 10, 19, 10, 13, 10);
		Timestamp time2 = new Timestamp(2021-1900, 10, 19, 10, 13, 10,11);
		Timestamp time3 = new Timestamp(2021-1900, 10, 19, 10, 13, 10,16);
		
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
		
		System.out.println(time1.equals(time2));
		System.out.println(time1.equals(time3));
		
		System.out.println(time2.equals(time1));
		System.out.println(time2.equals(time3));
		
		System.out.println(time3.equals(time1));
		System.out.println(time3.equals(time2));
		
		
	}

}
