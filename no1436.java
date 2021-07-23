import java.util.ArrayList;
import java.util.Scanner;

public class no1436 {

	public static void main(String[] args) {

		Scanner S = new Scanner(System.in);

		int count = 0;

		int T = S.nextInt();

		int num = 0;

		while (T != count) {

			num++;

			String N = num + "";
			if (N.contains("666")) {
				count++;
			}
		}
		;

		System.out.println(num);
		
		
	}

}