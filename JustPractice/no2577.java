package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2577 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int multiple = a*b*c;
		
		String change = String.valueOf(multiple);
		
		int[] arr = new int[10];
		
		
		for(int i =0; i<change.length(); i++) {
			

			
			arr[Integer.parseInt(change.charAt(i)+"")]++;
		
		}
		
		for(int x : arr) {
			System.out.println(x);
		}
		
		
		
	}

}
