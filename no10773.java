import java.io.*;
import java.util.*;

public class no10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.valueOf(br.readLine());
		
		Stack<Integer> S = new Stack<>();
		
		for(int i =0; i<K; i++) {
			int X = Integer.valueOf(br.readLine());
			
			if(X == 0) S.pop();
			else
			S.push(X);
			
		}
		
		int sum = 0;
		
		int Size = S.size();
		
		for(int i=0; i<Size;i++) {
			
			sum+= S.pop();
			
		}
		
		System.out.println(sum);
		
	}

}
