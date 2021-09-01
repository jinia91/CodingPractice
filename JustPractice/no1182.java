package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1182 {

	static int N,S, cnt;
	static int[] arr;
	
	static void bF(int idx, int sum) {
		
//		if (sum >S) return;
		
		if(idx == N) {
			if(sum ==S) {
				cnt++;
			}
			return;
		}
		
		bF(idx+1,sum);
		bF(idx+1,sum+arr[idx]);
	}
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i =0; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bF(0,0);
		
		if(S==0) System.out.println(cnt-1);
		
		else System.out.println(cnt);
		
		
	}

}
