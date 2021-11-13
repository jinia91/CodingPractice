package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		
		
		Integer a = 55555;
		Integer b = new Integer(55555);
		Integer c = 55554;
		c = c+1;
		int d = 55555;
		Integer e = 55555;
		
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a == d);
		System.out.println(b == c);
		System.out.println(b == d);
		System.out.println(c == d);
		System.out.println(a == e);
		
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(a.equals(d));
		System.out.println(b.equals(c));
		System.out.println(b.equals(d));
		System.out.println(c.equals(d));
		System.out.println(a.equals(e));
		
		
	}

}
