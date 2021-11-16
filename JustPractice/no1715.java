package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class no1715 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		while(N-->0) {
			
			pq.add(Long.parseLong(br.readLine()));
			
		}

		long sum =0l;
		
		while(pq.size() != 1) {
			
			long a = pq.poll();
			
			long b = 0L;
			if(!pq.isEmpty()) {
				b = pq.poll();
			}
			
			sum += a+b;
			
			pq.add(a+b);
		}
		
		System.out.println(sum);
		
	}


}
