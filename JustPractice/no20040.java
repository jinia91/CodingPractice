import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no20040 {

	static int[] parent;
	
	
	static int find (int x) {
		
		if(x==parent[x]) return x;
		
		else return parent[x] = find(parent[x]);
	}
	
	static void union (int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if(x > y) parent[x] = y;
		else parent[y] =x;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		parent = new int[N];
		
		for(int i=0; i<N; i++) {
			
			parent[i] = i;
			
		}
		
		int cnt = 0;
		boolean flag = false;
		
		for(int i = 0; i< M ;i++) {
			
			cnt++;
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			if(find(a) != find(b)) {
				union(a,b);
			}
			
			else {flag = true; break;}
		}
	
		if (flag) System.out.println(cnt);
		else System.out.println(0);
		
	
	
	}
	
	

}
