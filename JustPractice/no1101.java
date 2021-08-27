package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1101 {

	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
		
			st= new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int dis = b-a;
			
			double maxMove = Math.sqrt(dis);
			
			if(maxMove == (int)maxMove) {
				System.out.println(((int)maxMove-1)*2+1);
			}
			
			else if (dis<= (int)maxMove + (int)maxMove*(int)maxMove)
				System.out.println((int)maxMove*2);
			else System.out.println((int)maxMove*2+1);
		}
		
		
	}

}
