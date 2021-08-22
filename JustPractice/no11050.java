import java.util.*;
import java.io.*;


public class no11050 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		
		Long Ns=1L;
		
		for(int i = 0; i<K; i++) {
			
			Ns *=N-i;
			
		}
		
		Long Ks=1L;
		
		for(int i=0; i<K; i++) {
			
			Ks *=K-i;
			
		}
		
		
		System.out.println(Ns/Ks);
		
		
	}

}
