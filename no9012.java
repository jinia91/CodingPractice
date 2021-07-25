import java.util.*;
import java.io.*;

public class no9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		Stack st = new Stack();
		
		String ps;
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i< N; i++) {
			
			ps = br.readLine();
			boolean answer=true;
			
			for(int j = 0 ; j< ps.length();j++) {

				
				char x = ps.charAt(j);
				if (x=='(') {
					st.push(1);}
				else if(x==')'&&!st.isEmpty())
					st.pop();
				else {answer = false; 
				break;
				}
				
			}
			
			if (!st.isEmpty()) answer = false;
			st.clear();
			
			if(answer) {
				sb.append("YES").append("\n");
				}
			else sb.append("NO").append("\n");

		}
		
		System.out.println(sb);
		
	}

}
