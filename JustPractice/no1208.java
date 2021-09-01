package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class no1208 {

	static int N, S, cnt;
	static int[] arr;

	static ArrayList<Integer> partA = new ArrayList<>();
	static ArrayList<Integer> partB = new ArrayList<>();

	static void bF(ArrayList<Integer> part, int s, int e, int sum) {
		
//		if(sum>S) return;
		
		if (s > e) {
			part.add(sum);
			return;
		}

		bF(part, s + 1, e, sum);
		bF(part, s + 1, e, sum + arr[s]);
	}
	
	static void tPointer(int target) {
		
		int sum = 0;
		int end = 0;
		boolean flag0 = false;
		
		for(int start = 0; start<partB.size(); start++) {
			
			while(sum<target&&end<partB.size()) {
								
				sum += partB.get(end);
				end++;
				
			}
			
			if(sum == target) {
				cnt++;
			
			}
			
			sum -= partB.get(start);
		}
		
		
	}
	


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		bF(partA, 0,N/2, 0);
		bF(partB, N/2+1,N-1, 0);
		
		partA.remove(0);
		partB.remove(0);
		
		Collections.sort(partA);
		Collections.sort(partB);
		
		for(int i= 0; i< partA.size(); i++) {
			Integer target = S- partA.get(i);
			tPointer(target);	
			} 
	
		

		System.out.println(cnt);
	}

}
