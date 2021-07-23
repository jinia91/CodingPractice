
import java.util.*;
import java.io.*;

public class no2108 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		int[] arr = new int[N];
		
		int[] count = new int[8001];
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i<N; i++) {
			int x = Integer.valueOf(br.readLine());
			arr[i] = x;
			sum += x;
			if (arr[i]<min)min = arr[i];
			if (arr[i]>max)max = arr[i];
			count[x+4000]+=1;
			
		}
		
		System.out.println(Math.round(((double)sum/N))); // 산술 평균
		
		
		int counting = 0;
		
		int mid = 0;
		
		for(int i = min+4000; i< max+4000;i++) {
			
			if(count[i]>0) {
				
				if(counting < N/2+1) {
					counting += count[i];
					mid = i;
					
				}// 중위값
			}	
		}
		System.out.println(mid-4000);
		
		int counting2 = 0;
		boolean check = false;
		int index = 0;
		
		for(int i = min+4000 ; i <= max+4000; i++ ) {
			
			if(count[i] > counting2) {
				counting2 = count[i];
				check = true;
				index = i-4000;
			
			} else if (count[i]==counting2&&check==true) {
				check = false;
				counting2 = count[i];
				index = i -4000;
			}
			
		}
		System.out.println(index);

		System.out.println(max-min);
		
		

		
	}

		
		
		
		
		
}


