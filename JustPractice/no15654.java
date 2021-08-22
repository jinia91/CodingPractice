import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no15654 {

	static boolean[] marked;
	static int[] stackcall;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int N, int M, int stackcalldept) {

		if (stackcalldept == M) { // 스택콜이 필요한 깊이만큼 쌓인경우 출력하기

			for (int i = 0; i < stackcall.length; i++) {
				sb.append(stackcall[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// 탐색로직

		for (int i = 1; i < N + 1; i++) {

			if(stackcalldept>0&&stackcall[stackcalldept-1]>arr[i]) continue;

			if (!marked[i]) {

				stackcall[stackcalldept] = arr[i];
				marked[i] = true;

				dfs(N, M, stackcalldept+1);
				marked[i] = false;
			}
			

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		arr = new int[N+1];
		
		for(int i=1; i< N+1; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(arr);
		
		marked = new boolean[N+1];
		stackcall = new int[M];
		
		dfs(N,M,0);
		
		System.out.println(sb);

	}

}
