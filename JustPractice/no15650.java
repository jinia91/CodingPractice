import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no15650 {

	static boolean[] marked;
	static int[] stackcall;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int N, int M, int stackcalldept) {

		if (stackcalldept == M) { // �������� �ʿ��� ���̸�ŭ ���ΰ�� ����ϱ�

			for (int i = 0; i < stackcall.length; i++) {
				sb.append(stackcall[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// Ž������

		for (int i = 1; i < N + 1; i++) {

			if(stackcalldept>0&&stackcall[stackcalldept-1]>i) continue;
			
			if (!marked[i]) {

				stackcall[stackcalldept] = i;
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
		
		marked = new boolean[N+1];
		stackcall = new int[M];
		
		dfs(N,M,0);
		
		System.out.println(sb);

	}

}
