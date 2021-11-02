package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2792 {

	static int[] jAmount;
	static int max;
	static int M, N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		jAmount = new int[M];

		int sum = 0;

		for (int i = 0; i < M; i++) {

			jAmount[i] = Integer.parseInt(br.readLine());

			max = Math.max(jAmount[i], max);
			sum += jAmount[i];
		}

		// �������� ã�� �̺�Ž���� ���鶧 �������� 1~max���� ����

		System.out.println(binarySearch(max));

	}

	private static int binarySearch(int max) {

		int start = 1;
		int end = max;
		
		while (start<end) {
			int mid = (start + end)/2;


			if (isMaxJealousy(mid) > N) {

				start = mid+1;
				
			}
			
			else {
				
				end = mid;
				
			}

		}
		
		return end;
	}

	// ���������� �й������� ������ ���̵� ��
	private static int isMaxJealousy(int jealousy) {

		int count = 0;

		for (int i = 0; i < M; i++) {

			if (jAmount[i] % jealousy != 0) {

				count += jAmount[i] / jealousy + 1;

			}
			
			else {
				count += jAmount[i] / jealousy;
			}
			;
		}

		return count;

	}

}
