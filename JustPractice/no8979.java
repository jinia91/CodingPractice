package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no8979 {

	static class rank {

		int num;
		int gold;
		int silver;
		int bronze;
		int rank;


		public rank(int num, int gold, int silver, int bronze) {
			super();
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}


		@Override
		public String toString() {
			return "rank [num=" + num + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze + ", rank="
					+ rank + "]";
		}



	}

	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		
		LinkedList<rank> pq = new LinkedList<>();
		
		for(int i = 0; i< N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			pq.add(new rank(Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken())));
					
		}
		

	    Collections.sort(pq, Comparator
	    		.comparingInt((rank o1) -> o1.gold)
	    		.thenComparingInt(o1 -> o1.silver)
	    		.thenComparingInt(o1 -> o1.bronze).reversed());

	   pq.stream().forEach(o -> System.out.println(o)); 
	    		
		
	}

}
