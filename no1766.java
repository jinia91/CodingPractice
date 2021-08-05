import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1766 {

	
	static int[] degree;
	static ArrayList<ArrayList<Integer>> edgelist = new ArrayList<>(); 
	static ArrayList<Integer> result = new ArrayList<>();
	
	
	
	static void TS() {
		
		PriorityQueue<Integer> sorting = new PriorityQueue<Integer>();
		
		for(int i = 1 ; i<degree.length; i++) {
			

			if(degree[i] == 0) {
				
				sorting.offer(i);
				
			}
			
			
		}
		
		
		
		while(!sorting.isEmpty()) {
			
			int now = sorting.poll();
			result.add(now);
			
			
			for(int i =0; i< edgelist.get(now).size(); i++) {
				

				degree[edgelist.get(now).get(i)] -=1;
					
				if(degree[edgelist.get(now).get(i)]==0) {
					
					sorting.offer(edgelist.get(now).get(i));
				}
				
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		degree = new int[N+1];
		
		for(int i=0; i< N+1; i++) {
			
			edgelist.add(new ArrayList<Integer>());
			
		}
		
		
		
		for(int i =0; i< M; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int sA = Integer.valueOf(st.nextToken());
			int sB = Integer.valueOf(st.nextToken());
			
			degree[sB]++;
			edgelist.get(sA).add(sB);
			
		}
		
		
		TS();
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<Integer> it = result.iterator();
		
		while(it.hasNext()) {
			
			sb.append(it.next()).append(" ");
			
		}
		
		
		System.out.println(sb);
		
	}

}
