package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no8979 {

	static class rank implements Comparable<rank> {

		int num;
		int gold;
		int silver;
		int bronze;
		int rank;

		@Override
		public int compareTo(rank o) {

			if (this.gold == o.gold) {

				if (this.gold+this.silver == o.gold+o.silver) {

					return o.bronze - this.bronze;

				}

				return o.silver -  this.silver;

			}

			return o.gold-this.gold;

		}

		public rank(int num, int gold, int silver, int bronze) {
			super();
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
		

	}

	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<rank> pq = new PriorityQueue<>();
		
		for(int i = 0; i< N; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			pq.add(new rank(Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken())));
					
		}
		
	    List<rank> list = new ArrayList<>();

	    rank a = pq.poll();
	    
	    a.rank=1;
	    
	    if(target == 1) {System.out.println(a.num);
	    return;}
	    
	    list.add(a);
	    
	    int cnt = 1;
	    
	    
		for(int i = 1; i< N; i++) {
			
			rank x = pq.poll();
			
			
			if(list.get(i-1).compareTo(x) == 0) {
				
				x.rank = list.get(i-1).rank;
				cnt++;
			}
			
			else {
				
				x.rank = list.get(i-1).rank+cnt;
				
				cnt = 1;
			}
			
			if(x.num == target) {
				System.out.println(x.rank);
				return;
			}
			
			list.add(x);
			
		}
		
		
	}

}
