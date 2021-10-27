package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class no1874 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int[] query = new int[N];
		
		for(int i =0; i<N; i++) {
			query[i] = Integer.parseInt(br.readLine());
		}
		
		int qIdx = 0;
		
		for(int i =1; i<=N; i++) {
			
			sb.append("+\n");
			st.push(i);
			
			while(!st.isEmpty()&&qIdx<N&&st.peek() == query[qIdx]) {
				st.pop();
				sb.append("-\n");
				qIdx++;
			}
			
		}
		
		
		if(st.isEmpty())
		System.out.println(sb);
		else System.out.println("NO");
	}

}
