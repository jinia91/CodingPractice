package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no1976 {

	static int N, M;
	static int[] plan;
	static StringTokenizer st;

	static int[] pNode;
	
	
	static int findP(int x) {	
		
		if(pNode[x] == x) return x;
		
		return pNode[x] = findP(pNode[x]); 
		
	}
	
	static void union(int a, int b) {
		
		a = findP(a);
		b = findP(b);
		
		
		if (a== b) return;
		
		if(a>b) pNode[a] = b;
		else pNode[b] = a;
		
	}
	
	
	
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		pNode = new int[N + 1];
		
		for(int i =0; i< N+1; i++) {
			
			pNode[i] = i;
			
		}
		
		
		for (int i = 1; i < N + 1; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j < N + 1; j++) {

				int adj = Integer.parseInt(st.nextToken());

				if (adj == 1) {

					union(i,j);
				}

			}

		}
		
		
		
		
		st = new StringTokenizer(br.readLine(), " ");

		int pnode = findP(Integer.parseInt(st.nextToken()));
		boolean answer = true;
		
		for(int i = 0; i<M-1; i++) {
			
			if(findP(Integer.parseInt(st.nextToken())) != pnode){
				answer = false;
						break;
			}
			
			
		}
		
		if(answer) System.out.println("YES");
		else System.out.println("NO");

	}

}
