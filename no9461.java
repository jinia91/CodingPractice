import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no9461 {

	
	static long[] padovalue = new long[101];
	
	
	
	static long pado(int a) {
		
		if (a==1) return 1;
		if (a==2) return 1;
		if (a==3) return 1;
		
		
		if(padovalue[a]!=0) 
			return padovalue[a];
		
		else {
			long x =  pado(a-3) + pado(a-2);
			padovalue[a] = x;
			return x;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int N = Integer.valueOf(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			
			int a = Integer.valueOf(br.readLine());

			sb.append(pado(a)).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
