package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class starEdge2 implements Comparable<starEdge2> {

	int s;
	int e;
	int d;

	public starEdge2(int s, int e, int d) {
		this.s = s;
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(starEdge2 o) {
		return this.d - o.d;
	}

}

class star2 {

	int idx, x, y, z;

	public star2(int idx, int x, int y, int z) {
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.z = z;
	}

}

public class no2887 {

	static ArrayList<star2> nodes = new ArrayList<>();
	static ArrayList<starEdge2> edges = new ArrayList<>();
	static int n;
	static StringTokenizer st;
	static int[] pNode;
	static int cnt;



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		pNode = new int[n];
		

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			nodes.add(new star2(i,
								Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken())));
			
			pNode[i] = i;
		}

		// 스패닝트리를 만들수 있는 3가지 케이스 노선 전부 삽입후 정렬하여 유니온 파인드하기
		Collections.sort(nodes, (n1, n2) -> n1.x-n2.x);
		for(int i = 0; i< n-1; i++) {
			edges.add(new starEdge2(nodes.get(i).idx, nodes.get(i+1).idx, 
					Math.abs(nodes.get(i).x-nodes.get(i+1).x)));
		}
		Collections.sort(nodes, (n1, n2) -> n1.y-n2.y);
		for(int i = 0; i< n-1; i++) {
			edges.add(new starEdge2(nodes.get(i).idx, nodes.get(i+1).idx, 
					Math.abs(nodes.get(i).y-nodes.get(i+1).y)));
		}
		Collections.sort(nodes, (n1, n2) -> n1.z-n2.z);
		for(int i = 0; i< n-1; i++) {
			edges.add(new starEdge2(nodes.get(i).idx, nodes.get(i+1).idx, 
					Math.abs(nodes.get(i).z-nodes.get(i+1).z)));
		}
		
		
		
// 메모리 초과남 n2 이라 그런듯		
//		for (int i = 0; i < n - 1; i++) {
//			for (int j = i + 1; j < n; j++) {
//				edges.add(new starEdge2(i, j, caldis(nodes.get(i), nodes.get(j))));
//			}
//		}
		
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

	// 개별 시나리오로 거리계산을했으므로 필요 없음
//	static int caldis(star2 a, star2 b) {
//
//		return Math.min(Math.abs(a.x-b.x), Math.min(Math.abs(a.y-b.y), Math.abs(a.z-b.z)));
//		
//	}
	
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

}
