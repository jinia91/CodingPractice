package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14719 {

	static int H, W;
	static int lWall,rWall, water;
	static boolean flag;
	static int[] block;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		 H = Integer.parseInt(st.nextToken());
		 W = Integer.parseInt(st.nextToken());
		
		block = new int[W];
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0; i<W; i++) {
			
			block[i] = Integer.parseInt(st.nextToken());
			
		}
		
		while(!flag) {
		
			water += calcul();
			
		}
		
		System.out.println(water);
		System.out.println(water == 1);
		
	}

	private static int calcul() {
		// 왼쪽 벽 찾기
		lWall = findLWall(lWall);
		
		// 오른쪽 벽찾기
		rWall = findRWall(lWall);
		
		// 물의 양 계산하기
		int water = calWater(lWall, rWall);
		
		// lwall 갱신과 블록 마지막인지 확인
		lWall = rWall;
		if(lWall >= W-1||rWall >= W-1||lWall <=0) flag= true;
		
		return water;
	}

	private static int calWater(int lWall, int rWall) {
		int water = 0;
		int minWall = Math.min(block[rWall], block[lWall]);
		for(int i = lWall+1; i<rWall; i++) {
			
			if(minWall-block[i]>0)
			water += (minWall-block[i]);
			
		}
		return water;
	}

	private static int findRWall(int lWall) {
		int rWall = lWall+1;
		int maxR = lWall+1;
		for(int i = lWall+1; i<W; i++) {
		
			if(block[maxR] < block[i]) {
				
				maxR = i;
				rWall = maxR;
				
			}
			
			// 오른쪽벽이 더이상 갱신될 여지가 없음
			if(block[maxR]>=block[lWall]) {
				
				rWall = i;
				break;
					
			}
				
		}
		return rWall;
	}

	private static int findLWall(int start) {
		int lWall = start;
		for(int i = start; i<W-1; i++) {
		
			if (block[i] > block[i+1]) {
				
				lWall = i;
				break;
			}
			
			if(lWall == W-1) flag = true;
			
		}
		
		
		return lWall;
	}

}
