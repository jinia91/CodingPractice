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
				sb.append(arr[i]).append(" ");     // ���ڸ����� ������� ���
			}

			sb.append("\n");
			return;
		}
		
		for (int i=1; i< n+1; i++) {    // ��� ������ ����, ���̸�ŭ ����ȯ�� ���ƾ��ϹǷ� 
			
			if(!check[i]) {  // 1234 ������ �İ��Բ� üũ Ȯ��
				
				check[i] = true;  // i �� �Ÿ��鼭 üũ�ȵ� ���� ã�ƿ����Ƿ� �ش� �� üũ
				arr[dept] = i;  // ����� ����ϴ� �迭. ���ڸ����� ������ �׾ư������� ���� if ������ ���
				
				dfs(n,m, dept+1);             // ��� ����, ���ýױ�
				check[i] = false;             // ��� �������ö� �湮����
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
