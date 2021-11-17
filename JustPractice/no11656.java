package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class no11656 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		ArrayList<String> arr = new ArrayList<>();
		
		for(int i =0; i<str.length(); i++) {
			
			arr.add(str.substring(i,str.length()));
			
			
		}
		
		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : arr) {
			sb.append(s+"\n");
		}
		
		System.out.println(sb);
		
		
	}

}
