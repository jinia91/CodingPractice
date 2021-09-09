	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1074 {
	
	static int cnt = 0;
	static int R,C;
	static int dept = 0;
	
	static void divQ(int r, int c, int N) {

		
		if(N!=1) {
		N = N/2;
		
		if(R<r+N&&C<c+N) divQ(r,c,N);
		else if(R<r+N&&C>=c+N) {cnt+=N*N;divQ(r,c+N,N);}
		else if(R>=r+N&&C<c+N) {cnt+=2*N*N;divQ(r+N,c,N);}
		else if(R>=r+N&&C>=c+N) {cnt+=3*N*N;divQ(r+N,c+N,N);}
		}
		
		else if(N==1) {
			cnt++;
			
			if(R==r&&C==c) { 
				System.out.println(cnt-1);
			System.exit(0);
			}
		}
		
	}
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		
		
		int x = (int) Math.pow(2, N);
		
		divQ(0,0,x);
		
	}

}
