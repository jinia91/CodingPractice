package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2908 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		sb.append(a.charAt(2)).append(a.charAt(1)).append(a.charAt(0));
		sb2.append(b.charAt(2)).append(b.charAt(1)).append(b.charAt(0));
		
		int c = Integer.parseInt(sb.toString());
		int d = Integer.parseInt(sb2.toString());
		
		System.out.println(Math.max(c, d));
		
		
	}

}
