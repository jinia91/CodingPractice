import java.util.*;
public class no04 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[10];
		
		for(int i =0; i<10; i++) {
		int in = s.nextInt();
		int out = s.nextInt();
		if (i==0) {
			arr[0] = in*(-1)+out;
			continue;
		}
		
		 arr[i] = arr[i-1]+ in*(-1) + out;
		
		
		}
		
		Arrays.sort(arr);
		System.out.println(arr[9]);

	}
}