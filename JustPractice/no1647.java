import java.util.*;
import java.io.*;



class edge implements Comparable<edge>{
	
	int nodeA;
	int nodeB;
	int cost;
	
	edge(int a, int b, int cost){
		this.nodeA = a;
		this.nodeB = b;
		this.cost = cost;
	}
	
	public int compareTo(edge a) {
		
		return this.cost - a.cost;
		
	}
	
}






public class no1647 {
	
	static int[] parent;
	
	static int find(int a) {
		
		if(parent[a] == a) return a;
		
		else {
			return find(parent[a]);
		}
	}
	
	static boolean union(int a, int b) {
		
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		else if(a>b) {
			parent[a] = b; return true;
		}
		else {
			parent[b] = a; return true;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		parent = new int[N+1];
		
		for(int i = 0 ; i< N+1; i++) {
			parent[i] = i;
		}
	
		edge[] arr = new edge[M];
	
		for(int i = 0 ; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int d = Integer.valueOf(st.nextToken());
			
			
			arr[i] = new edge(a,b,d);
			
			
		}
		
		Arrays.sort(arr);

		Stack<Integer> costTotal = new Stack<>();
		
		
		for(int i =0; i< M; i++) {
			
			int a = arr[i].nodeA;
			int b = arr[i].nodeB;
			int c = arr[i].cost;
			
			boolean flag = union(a,b);
			
			if(flag) {
			costTotal.push(c);
			}
		}
		
		costTotal.pop();
		
		int sum = 0;
		
		while(!costTotal.isEmpty()) {
			
			sum +=costTotal.pop();
			
		}
		
		
		System.out.println(sum);
		
	}
	

}



