import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no9020 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		making_mask();

		int T = Integer.valueOf(br.readLine());

		
		
		for(int t = 0; t<T; t++) {
			Integer N = Integer.valueOf(br.readLine());


			int X = 0;
			int Y = 0;
			
			loop:
			for (int i = N / 2; i <= N; i++) {

				if (check_sosu[i] == false) {
					
					X = i;
					for (int j = N/2; j > 0; j--) {

						if (check_sosu[j] == false) {
							Y = j;
							
							if(X+Y==N)
								break loop;	
						}
					}

				}
			}
			
			System.out.println(Y+ " " + X);
			
		}

	}

	static boolean[] check_sosu;

	static void making_mask() {

		check_sosu = new boolean[123456 * 2 + 1];

		check_sosu[0] = true;
		check_sosu[1] = true;

		for (int i = 2; i <= Math.sqrt(check_sosu.length); i++) {

			if (check_sosu[i]) {
				continue;
			}

			for (int j = 2; i * j <= check_sosu.length; j++) {
				check_sosu[i * j] = true;
			}
		}
	}

}
