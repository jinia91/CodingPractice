import java.util.*;

public class no06 {

	public static void main(String[] args) {
		
		Scanner S = new Scanner(System.in);
		int sum = 0;

		ArrayList<Integer> List = new ArrayList<>();
		Integer x = 0;
		Integer y = 0;
		
		
		for(int i = 0; i <9; i++) {
			int height = S.nextInt();
			sum += height;
			List.add(Integer.valueOf(height));}
			
		
		for(int i = 0; i <9; i++) {
			for(int j = i+1; j<9; j++) {
				if(sum - 100 == List.get(i)+List.get(j)) {
					
					x = i;
					y = j;
					break;
					}
			}
		}
		
		List.remove((int)y);		
		List.remove((int)x);

		List.sort(null);
		for(int i = 0; i<7;i++) {
			System.out.println(List.get(i));
		}
	}
}
