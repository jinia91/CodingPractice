package JustPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class no6549 {

	public static int[] histogram;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		int N;
		while (true) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());

			if (N == 0) {
				break;
			}
			histogram = new int[N];

			for (int i = 0; i < N; i++) {
				histogram[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(getArea(0, N - 1)).append('\n');
			histogram = null;

		}
		System.out.println(sb);
	}

	public static long getArea(int lo, int hi) {

		// ���� ���� 1�ϰ��
		if (lo == hi) {
			return histogram[lo];
		}

		// [1�� ����]
		int mid = (lo + hi) / 2; // �߰�����

		/*
		 * [2�� ����] mid�� �������� �������� ������ ���� ���� �� ū ���̸� ���� ���� �κ� : lo ~ mid ������ �κ� : mid + 1
		 * ~ hi
		 */
		long leftArea = getArea(lo, mid);
		long rightArea = getArea(mid + 1, hi);

		// [3�� ����]
		long max = Math.max(leftArea, rightArea);

		// ���� ���� �� ū ���� �߰� ������ ���Ͽ� �� ū ���̷� ����
		max = Math.max(max, getMidArea(lo, hi, mid));

		return max;

	}

	// �߰����� ������ ���̸� ���ϴ� �޼ҵ�
	public static long getMidArea(int lo, int hi, int mid) {

		int toLeft = mid; // �߰� �������κ��� �������� �� ����
		int toRight = mid; // �߰� �������κ��� ���������� �� ����

		long height = histogram[mid]; // ����

		// [�ʱ� ���� (���� ���� 1�̹Ƿ� ���̴� ���̰� ������ ��)
		long maxArea = height;

		// �� �� ������ ����� ������ �ݺ�
		while (lo < toLeft && toRight < hi) {

			/*
			 * ���� ����ĭ�� ���� �� ���� ���� �����ϵ�, ���ŵǴ� height�� ���� height���� �۰ų� ���ƾ� �Ѵ�.
			 */
			if (histogram[toLeft - 1] < histogram[toRight + 1]) {
				toRight++;
				height = Math.min(height, histogram[toRight]);
			} else {
				toLeft--;
				height = Math.min(height, histogram[toLeft]);
			}

			// �ִ� ���� ����
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}

		// ������ ������ ������ Ž�� ���ߴٸ� ���� Ž���Ѵ�.
		while (toRight < hi) {
			toRight++;
			height = Math.min(height, histogram[toRight]);
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}

		// ���� ������ ������ Ž�� ���ߴٸ� ���� Ž���Ѵ�.
		while (lo < toLeft) {
			toLeft--;
			height = Math.min(height, histogram[toLeft]);
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
		}

		return maxArea;
	}

}
