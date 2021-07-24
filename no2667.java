import java.util.*;
import java.io.*;

public class no2667 {

	static private int[][] map;

	static private void mapmake(int n) {
		map = new int[n][n];
	}

	static int count;

	static private int dfs(int x, int y, int n) {
		
		
		if (map[x][y] == 1) {
			map[x][y] = 0;
			count++;

			if (y + 1 < n) {
				int right = map[x][y + 1];
				if (right == 1) {
					right = 0;
					dfs(x, y + 1, n);
				}
			}
			if (y - 1 >= 0) {
				int left = map[x][y - 1];
				if (left == 1) {
					left = 0;
					dfs(x, y - 1, n);
				}
			}
			if (x - 1 >= 0) {
				int top = map[x - 1][y];
				if (top == 1) {
					top = 0;
					dfs(x - 1, y, n);
				}
			}
			if (x + 1 < n) {
				int down = map[x + 1][y];
				if (down == 1) {
					down = 0;
					dfs(x + 1, y, n);
				}
			}
			
			
			// ÁÂÇ¥ ÀÌµ¿ ¸®ÆåÅä¸µ
			// static int dy = [1,-1,0,0]
			// static int dx = [0,0,-1,+1]
			// ÇöÀç ÁÂÇ¥ now
			// now.
			// 
		}
		
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());

		mapmake(n);

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String mapline = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = (int) mapline.charAt(j)-'0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int answer = dfs(i, j, n);
				
				if (answer!=0) list.add(answer);
				
				count=0;
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
