import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.math.*;

public class no11286 {

	static int[] heaptree;
	static int Lidx;
	
	
	
	private static void heapify(int[] a, int Pidx) {

		int lidx;
		int ridx;
		int Asmallidx;

		while (Pidx * 2 + 1 <= Lidx) {

			lidx = Pidx * 2 + 1;
			ridx = Pidx * 2 + 2;
			Asmallidx = Pidx;

			if (lidx <= Lidx && Math.abs(a[Asmallidx]) > Math.abs(a[lidx]))
				Asmallidx = lidx;
			if (ridx <= Lidx && Math.abs(a[Asmallidx]) > Math.abs(a[ridx]))
				Asmallidx = ridx;
			

			if (Asmallidx>a[lidx] && lidx <= Lidx && Math.abs(a[Asmallidx]) == Math.abs(a[lidx]))
				Asmallidx = lidx;
			if (Asmallidx>a[ridx] && ridx <= Lidx && Math.abs(a[Asmallidx]) == Math.abs(a[ridx]))
				Asmallidx = ridx;
			
			
			
			
			if (Pidx != Asmallidx) {
				swap(a, Pidx, Asmallidx);
				Pidx = Asmallidx;
			}
			
			else return;
			
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
		
		for(int i = Lidx; i>=0; i=(i-1)/2) {
			if((Math.abs(a[(i-1)/2])>Math.abs(a[i]))) {
				swap(a,(i-1)/2,i);
			}
			if(a[(i-1)/2]>a[i]&&(Math.abs(a[(i-1)/2])==Math.abs(a[i]))) {
					swap(a,(i-1)/2,i);
			}
			else break;

		
		}
	}
	
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());
		
		heaptree= new int[N];

		StringBuilder sb = new StringBuilder();
		Lidx=-1;
		
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
