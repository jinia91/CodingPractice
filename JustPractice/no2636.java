import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no2636 {

	static int total;
	static int time;
	static int cnt;
	static int map[][];
	static boolean meltingCheck[][];

	static void MCZcheck(int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				meltingCZ(i, j);
			}
		}
	}

	static boolean meltingCZ(int n, int m) {

		if (map[n][m] == 1 && map[n][m + 1] == 1 && map[n][m - 1] == 1 && map[n + 1][m] == 1 && map[n - 1][m] == 1)
			return false;

		if (map[n][m] == 1) {
			meltingCheck[n][m] = true;
			cnt++;
			return true;
		} else
			return false;
	}

	static void melting(int N, int M) {

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				if (meltingCheck[i][j]) {
					meltingCheck[i][j] = false;
					map[i][j] = 0;
				}
			}
		}
		
		time++;
		total-=cnt;
		cnt = 0;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());

		map = new int[N][M];
		meltingCheck = new boolean[N][M];
		

		for (int i = 0; i < N; i++) {
			String mapLine = br.readLine();
			mapLine = mapLine.replaceAll(" ", "");

			for (int j = 0; j < M; j++) {
				int x = mapLine.charAt(j) - '0';
				if (x==1) total++;
				map[i][j] = x;
			}
		}

		MCZcheck(N,M);
		
		while(!(total==cnt)){
		melting(N, M);		
		MCZcheck(N, M);
		}
		
		System.out.println(time+1);
		System.out.println(total);
		
	}
	
	

}
