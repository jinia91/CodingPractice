import java.util.*;
import java.io.*;


public class no1003 {

	
	static int[] fibovalue1;
	static int[] fibovalue2;
	

	static int fibo1(int x) {
		
		if(x == 0) {
			return 1;
		}
		
		else if( x == 1) {
			return 0;
		}
		
		else if(fibovalue1[x]!=0) {
			
			return fibovalue1[x];
			
		}
		
		else {
		return	fibovalue1[x] = fibo1(x-1) + fibo1(x-2);
		} 
		
	}
	
	static int fibo2(int x) {
		
		if(x == 0) {
			return 0;
		}
		
		else if( x == 1) {
			return 1;
		}
		
		else if(fibovalue2[x]!=0) {
			
			return fibovalue2[x];
			
		}
		
		else {
		return	fibovalue2[x] = fibo2(x-1) + fibo2(x-2);
		} 
		
	}
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		
		fibovalue1 = new int[41];
		fibovalue2 = new int[41];
		
		
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0 ; i<N; i++) {
			
		int y = Integer.valueOf(br.readLine());	
		
			sb.append(fibo1(y)).append(" ").append(fibo2(y)).append("\n");
		
		}
		
		System.out.println(sb);
	}

}
