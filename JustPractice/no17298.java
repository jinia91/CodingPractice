package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class no17298 {

	static int N;
	static int[] answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		answer = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Stack<Integer> st1 = new Stack<>();

		for (int i = 0; i < N; i++) {

			st1.push(Integer.parseInt(st.nextToken()));

		}
		
		Stack<Integer> st2 = new Stack<>();
		
		int idx = st1.size()-1;
		
		for(int i = 0; i < N; i++) {
			
			int num = st1.pop();
			
			if(st2.size() == 0) {
				
				st2.push(num);
				answer[idx] = -1;
				idx--;
			}
			
			else if(st2.peek()> num) {
				
				answer[idx] = st2.peek();
				idx--;
				st2.push(num);
				
			}
			
			else {
				
				while(!st2.isEmpty()) {
					
					if(st2.peek()> num) {
						answer[idx] = st2.peek();
						idx--;
						st2.push(num);	
						break;	
					}
					
					else if(st2.size() == 0) {
						
						st2.push(num);
						answer[idx] = -1;
						idx--;
						break;
					}
					
					
					else {
						
						st2.pop();
						
					}
					
					
				}
				
				if(st2.isEmpty()) {
					st2.push(num);	
					answer[idx] = -1;
					idx--;
				}
				
			}
			
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int x : answer) {
			sb.append(x).append(" ");
		}

		System.out.println(sb);
		
	}

}
