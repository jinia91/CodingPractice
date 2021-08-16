import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no11725 {

	static int[] marked;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	static StringTokenizer st;

	static void bfs() {

		LinkedList<Integer> que = new LinkedList<>();

		que.offer(1);

		while (!que.isEmpty()) {

			int nowidx = que.poll();
			marked[1] = 1;

			ArrayList<Integer> node = graph.get(nowidx);

			for (int i = 0; i < node.size(); i++) {

				int x = node.get(i);

				if (marked[x] == 0) {
					marked[x] = nowidx;
					que.offer(x);
				}

			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i =0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		marked = new int[N+1];
		
		for(int i =0; i<N-1; i++) {
		
			st = new StringTokenizer(br.readLine(), " ");
		
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
			
		}
		
		bfs();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =2; i<marked.length; i++) {
			
			sb.append(marked[i]).append("\n");
			
		}
		
		System.out.println(sb);
	}

}
