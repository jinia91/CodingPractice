package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class no3986 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<String> st = new Stack<>();
		int cnt = 0;
		
		while(n-->0) {
			

			String input = br.readLine();
			
			for(int i =0; i<input.length(); i++) {
				
				String str = input.charAt(i)+"";
				
				if(!st.isEmpty()&&st.peek().equals(str)) {
					st.pop();
				}
				else {
					st.push(str);
				}
			}
			
			if(st.isEmpty()) cnt++;
			
			st.clear();
		}
		
		System.out.println(cnt);
		
		
	}

}
