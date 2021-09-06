import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no1927 {

	static int[] heaptree;
	static int Lidx;

	private static void heapify(int[] a, int Pidx) {

		int lidx;
		int ridx;
		int smallidx;

		while (Pidx * 2 + 1 <= Lidx) {

			lidx = Pidx * 2 + 1;
			ridx = Pidx * 2 + 2;
			smallidx = Pidx;

			if (lidx <= Lidx && a[smallidx] > a[lidx])
				smallidx = lidx;
			if (ridx <= Lidx && a[smallidx] > a[ridx])
				smallidx = ridx;

			if (Pidx != smallidx) {
				swap(a, Pidx, smallidx);
				Pidx = smallidx;
			}

			else
				return;

		}
	}

	private static void swap(int[] a, int Pidx, int smallidx) {
		int tmp = a[Pidx];
		a[Pidx] = a[smallidx];
		a[smallidx] = tmp;
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
			if ((a[(i - 1) / 2] > a[i])) {
				swap(a, (i - 1) / 2, i);
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
