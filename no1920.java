import java.util.*;
import java.io.*;



public class no1920 {

	static int[] a;
	static int[] b;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		a= new int[N];
		for(int i = 0 ; i< N; i++) {
			a[i] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(a);
		
		int M = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		b= new int[M];
		for(int i=0; i<M; i++) {
			
			int x = Integer.valueOf(st.nextToken());
			
			int y = Arrays.binarySearch(a, x);
			
			int T = y>=0? 1:0; 
			
			sb.append(T).append("\n");
			
		}
		
		System.out.println(sb);

	}

}
