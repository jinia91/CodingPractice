package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no1966 {

	static StringTokenizer st;

	static int N, M, cnt;

	static PriorityQueue<Docu> pq;
	static LinkedList<Docu> q;

	static class Docu implements Comparable<Docu> {

		int num;
		int priority;

		public Docu(int num, int priority) {
			this.num = num;
			this.priority = priority;
		}

		@Override
		public int compareTo(Docu o) {
			return o.priority - this.priority;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			
			st = new StringTokenizer(br.readLine(), " ");
		
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		
			pq = new PriorityQueue<>();
			q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i =0; i<N; i++) {
				
				int p = Integer.parseInt(st.nextToken());
				
				pq.add(new Docu(i,p));				
				q.add(new Docu(i,p));
			}
			
			printing();
						
			System.out.println(cnt);
			cnt=0;
		}

	}

	static void printing() {

		while (true) {
			Docu checkDocu = null;
			Docu target = pq.poll();

			while (true) {

				checkDocu = q.poll();
				
				if (checkDocu.priority != target.priority) {
					q.add(checkDocu);
				}

				else {
					break;
				}

			}
			
			
			cnt++;
			if(checkDocu.num == M) {
				
				break;
				
			}
			
		}

	}

}
