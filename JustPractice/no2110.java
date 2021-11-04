package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class no2110 {
	
	static int N, C;
	static int[] hIdx;
	static int[] d;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		hIdx = new int[N];
		
		for(int i = 0 ; i<N; i++) {
			
			hIdx[i] = Integer.parseInt(br.readLine());
			
		}
		
		
		Arrays.sort(hIdx);
		
		System.out.println(binarySearch());
		
	}

	private static int binarySearch() {

		int start = 1;
		
		int end = hIdx[hIdx.length-1]-hIdx[0]+1;
		
		while(start<end) {

			// 공유기 설치할 최소 간격
			int mid = (start+end)/2;
			
			if(cal(mid) >= C) {
				
				start = mid+1;
				
			}
			
			else {
				
				end = mid;
				
			}
			
			
		}
		
		return end-1;
		
	}

	private static int cal(int mid) {

		int cnt = 1;
				
		int start = 0;
		int idx=1;
		
		for(int i =0; i< N-1; i++) {
			
			if((hIdx[idx] - hIdx[start])>=mid) {
				
				cnt++;
				start = idx;				
			}
			
			idx++;
			
		}
		
		return cnt;
		
	}

}
