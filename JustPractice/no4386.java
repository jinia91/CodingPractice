package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class starEdge implements Comparable<starEdge> {

	int s;
	int e;
	double d;

	public starEdge(int s, int e, double d) {
		this.s = s;
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(starEdge o) {
		return (int)(this.d*100 - o.d*100);
	}

}

class star {

	double x, y;

	public star(double x, double y) {
		this.x = x;
		this.y = y;
	}

}

public class no4386 {

	static ArrayList<star> nodes = new ArrayList<>();
	static ArrayList<starEdge> edges = new ArrayList<>();
	static int n;
	static StringTokenizer st;
	static int[] pNode;
	static double cnt;

	static double caldis(star a, star b) {

		double x = (a.x - b.x);
		double y = (a.y - b.y);

		return Math.sqrt(x * x + y * y);
	}
	
	static int find(int x) {
		
		if(pNode[x] == x) return x;
		
		else return pNode[x] = find(pNode[x]);
	
	}
	
	static void union(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if(x == y) return;
		
		if(x>y) pNode[x] = y;
		else pNode[y] = x;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		pNode = new int[n];
		

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			nodes.add(new star(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
			
			pNode[i] = i;
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				edges.add(new starEdge(i, j, caldis(nodes.get(i), nodes.get(j))));
			}
		}
		
		Collections.sort(edges);
		
		for(int i =0; i< edges.size(); i++) {
			
			int a = edges.get(i).s;
			int b = edges.get(i).e;
			
			if(find(a) != find(b)) {
			
				union(a,b);
				
				cnt += edges.get(i).d;
			}
		}

		System.out.println(cnt);
		
	}

}
