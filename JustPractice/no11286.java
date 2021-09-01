package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.math.*;

public class no11286 {

	static int[] heaptree;
	static int Lidx;

	private static void heapify(int[] a, int pNode) {

		int l;
		int r;
		int small;

		while (pNode * 2 + 1 <= Lidx) {

			l = pNode * 2 + 1;
			r = pNode * 2 + 2;
			small = pNode;

			if (Math.abs(a[small]) > Math.abs(a[l]))
				small = l;
			if (r <= Lidx && Math.abs(a[small]) > Math.abs(a[r]))
				small = r;

			// 절대값이 같은 상황
			if (a[small] > a[l] && Math.abs(a[small]) == Math.abs(a[l]))
				small = l;
			if (a[small] > a[r] && Math.abs(a[small]) == Math.abs(a[r]) && r <= Lidx)
				small = r;

			if (pNode != small) {
				swap(a, pNode, small);
				pNode = small;
			}

			else
				return;
		}
	}

	private static void swap(int[] a, int Pidx, int Asmallidx) {
		int tmp = a[Pidx];
		a[Pidx] = a[Asmallidx];
		a[Asmallidx] = tmp;
	}

	private static int heapD(int[] a) {

		swap(a, 0, Lidx);
		int x = a[Lidx];
		Lidx--;
		if (Lidx < 1)
			return x;

		heapify(a, 0);
		return x;
	}

	private static void heapADD(int[] a, int x) {
		Lidx++;
		a[Lidx] = x;

		if (Lidx < 1)
			return;

		for (int i = Lidx; i >= 0; i = (i - 1) / 2) {
			if ((Math.abs(a[(i - 1) / 2]) > Math.abs(a[i]))) {
				swap(a, (i - 1) / 2, i);
//				heapify(a, (i - 1) / 2);
			}
			else if (a[(i - 1) / 2] > a[i] && (Math.abs(a[(i - 1) / 2]) == Math.abs(a[i]))) {
				swap(a, (i - 1) / 2, i);
//				heapify(a, (i - 1) / 2);
			} else
				break;

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());

		heaptree = new int[N];

		StringBuilder sb = new StringBuilder();
		Lidx = -1;

		for (int i = 0; i < N; i++) {
			int X = Integer.valueOf(br.readLine());

			if (X == 0) {
				if (Lidx != -1) {
					sb.append(heapD(heaptree)).append("\n");
				} else
					sb.append("0").append("\n");

			}

			else {
				heapADD(heaptree, X);
			}
		}

		System.out.println(sb);

	}

}
