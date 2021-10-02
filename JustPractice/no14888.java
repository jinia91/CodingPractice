package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14888 {

	static StringBuilder query = new StringBuilder();

	static int idx = 1;
	static int[] oper;
	static int[] arr;
	static int N;

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		arr = new int[2 * N - 1];
		oper = new int[4];

		for (int i = 0; i < 2 * N - 1; i += 2) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1);
		
		System.out.println(max);
		System.out.println(min);
		
	}

	static void dfs(int d) {

		if(d == N) {
			
			calcul(); 
			return;
			
		}
		
		
		if (oper[0] > 0) {
			arr[idx] = 0;
			oper[0]--;
			idx += 2;
			dfs(d+1);
			idx -= 2;			
			oper[0]++;
		}
		if (oper[1] > 0) {
			arr[idx] = 1;
			oper[1]--;
			idx += 2;
			dfs(d+1);
			idx -= 2;
			oper[1]++;
		}
		if (oper[2] > 0) {
			arr[idx] = 2;
			oper[2]--;
			idx += 2;
			dfs(d+1);
			idx -= 2;
			oper[2]++;
		}
		if (oper[3] > 0) {
			arr[idx] = 3;
			oper[3]--;
			idx += 2;
			dfs(d+1);
			idx -= 2;
			oper[3]++;

		}

	}
	
	static void calcul() {
		
		int leftN = arr[0];
		
		for(int i = 1; i< 2*N-1; i += 2) {
			
			if(arr[i] == 0 ) {
				
			   leftN = leftN + arr[i+1];
				
			}
			
			else if(arr[i] == 1) {

				   leftN = leftN - arr[i+1];
				
			}
			else if(arr[i] == 2) {

				   leftN = leftN * arr[i+1];
				
			}
			else if(arr[i] == 3) {
				
				   leftN = leftN / arr[i+1];

			}
			
		}
		
		max = Math.max(max, leftN);
		min = Math.min(min, leftN);
		
	}

}
