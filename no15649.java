import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no15649 {

	static boolean[] check;

	static int[] arr;

	
	static StringBuilder sb = new StringBuilder();

	static void dfs(int n, int m, int dept) {
		if(dept == m) {
			
			for(int i = 0; i< arr.length; i++) {
				sb.append(arr[i]).append(" ");     // 앞자리부터 순서대로 출력
			}

			sb.append("\n");
			return;
		}
		
		for (int i=1; i< n+1; i++) {    // 재귀 돌리는 구문, 깊이만큼 전순환을 돌아야하므로 
			
			if(!check[i]) {  // 1234 식으로 파고들게끔 체크 확인
				
				check[i] = true;  // i 를 거르면서 체크안된 수를 찾아왔으므로 해당 수 체크
				arr[dept] = i;  // 출력을 담당하는 배열. 앞자리부터 스택을 쌓아가득차면 위의 if 절에서 출력
				
				dfs(n,m, dept+1);             // 재귀 진입, 스택쌓기
				check[i] = false;             // 재귀 빠져나올때 방문해제
			}
			
			
		}
		

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());

		
		arr = new int[M];
		check = new boolean[N+1];
		dfs(N,M,0);
		
		System.out.println(sb);
	}

}
