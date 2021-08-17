import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class node_1 {
	int x;
	int y;

	node_1(int a, int b) {

		x = a;
		y = b;

	}
}

public class no7562 {

	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[][] marked;
	static int N;
	static StringTokenizer st;

	static void bfs(int a, int b, int c, int d) {

		LinkedList<node_1> que = new LinkedList<>();

		que.offer(new node_1(a, b));
		marked[a][b] = 1;
		
		if(a==c&&b==d) {
			
			return;
			
		}
		
		
		while (!que.isEmpty()) {

			node_1 node = que.poll();
			
			for(int i =0; i<8; i++) {
				
				int nextx = node.x+dx[i];
				int nexty = node.y+dy[i];
				
				
				
				if(nextx>=0&&nextx<N&&
				   nexty>=0&&nexty<N&&
				   marked[nextx][nexty] == 0) {
					
					
					
					marked[nextx][nexty] = marked[node.x][node.y]+1;
					
					if(nextx == c&& nexty == d) {
						return;
					}
					
					
					que.offer(new node_1(nextx, nexty));
					
					
				}
				
			}
			
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<T; i++) {
			
			N = Integer.parseInt(br.readLine());
			marked = new int[N][N];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
				
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			bfs(a,b,c,d);
			
			sb.append(marked[c][d]-1).append("\n");
			
		}
		
		System.out.println(sb);
		

	}

}
