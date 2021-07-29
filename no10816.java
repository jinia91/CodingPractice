import java.util.*;
import java.io.*;



public class no10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int N = Integer.valueOf(br.readLine());
	   
				
		int[] count = new int[20000001];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		
		
		for(int i = 0; i<N; i++) {
				
			int x = Integer.valueOf(st.nextToken());

			count[x+10000000]++;
			
		}	
		
		
		int M = Integer.valueOf(br.readLine());

		StringBuilder sb = new StringBuilder();


		st = new StringTokenizer(br.readLine(), " ");

		
		
		
		for(int i = 0; i<M; i++) {
			
				
			int x = Integer.valueOf(st.nextToken());
			
			int cnt=0;
			
			cnt = count[x+10000000];
					
			sb.append(cnt).append(" ");
				
		}
			
		

		
		
		System.out.println(sb.toString().trim());
		
		
		
		
		
	}

}
