import java.util.*;
import java.io.*;



public class no11047 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		int cnt =0;
		
		for(int i = 0 ; i<N; i++) {
			
			int x = Integer.valueOf(br.readLine());
			
			if(x<=K)		
			list.add(x);
			
		}
		
		while(K!=0) {
			int X =list.pollLast();
			while(K>=X) {
				cnt++;
				K=K-X;
			}
		}
		
		System.out.println(cnt);
	}

}
