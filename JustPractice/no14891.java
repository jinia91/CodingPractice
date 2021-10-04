package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14891 {

	static class Gear{
		int number;
		int[] state = new int[8];
		
		public void spin(int d) {
			
			int[] tmp = new int[8];
			
			if(d == 1) {
				
				tmp[0] = state[7];
				for(int i =0; i< 7; i++) {
				tmp[i+1]=state[i];
				}
				
				state = tmp;
			}
			else if(d == -1){

				tmp[7] = state[0];
				for(int i =1; i< 8; i++) {
				tmp[i-1]=state[i];
				}
				
				state = tmp;
			}

		}
		
	}
	
	static StringTokenizer st;
	static Gear[] gearSet = new Gear[4]; 
	//-1 반시계, 0 무회전, +1 시계
	static int[] isSpinChkList = new int[4];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			
		
		for(int i =0; i<4; i++) {
			
			String str = br.readLine();
			
			gearSet[i] = new Gear();
			
			gearSet[i].number = i;
			
			for(int j = 0; j<8; j++) {
				
				gearSet[i].state[j] = Character.getNumericValue(str.charAt(j));
					
			}
			
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			isSpinChkList[n-1] = d;			
			isSpinChk(n, d);
			
			for(int j = 0 ; j< 4 ; j++) {
				
				gearSet[j].spin(isSpinChkList[j]);
				
			}
		
			isSpinChkList = new int[4];
		}
		
		int sum = 0;
		
		if(gearSet[0].state[0] == 1) sum+=1;
		if(gearSet[1].state[0] == 1) sum+=2;
		if(gearSet[2].state[0] == 1) sum+=4;
		if(gearSet[3].state[0] == 1) sum+=8;
		
		System.out.println(sum);
		
		
		
		
	}

	private static void isSpinChk(int n, int d) {

		if(isSpinChkList[n-1] != 0) {
			
			Gear cur = gearSet[n-1];
			int left = n-1;			
			int right = n+1;
			
			if(left>0&& cur.state[6] != gearSet[left-1].state[2]&&isSpinChkList[left-1] == 0) {
				
				int adjD;	
				if(d == 1) {
					
					adjD = -1;
					
				}
				else {
					adjD = 1;
				}
				
				isSpinChkList[left-1] =adjD;
				isSpinChk(left, adjD);
			}
			
			if(right<=4&&cur.state[2] != gearSet[right-1].state[6]&&isSpinChkList[right-1] == 0) {

				int adjD=0;	
				if(d == 1) {
					
					adjD = -1;
					
				}
				else {
					adjD = 1;
				}

				isSpinChkList[right-1] =adjD;
				isSpinChk(right, adjD);
			}
			
		}
		
	}

}
