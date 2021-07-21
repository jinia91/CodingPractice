import java.util.*;
public class no10 {

	public static void main(String[] args) {
		
		Scanner S = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();	
		int count = 0;
		
		
		ListMake:
		for(int i = 1; true ; i++) {
			for(int j = 1; j<=i; j++) {
				if (count == 1000) break ListMake;
				list.add(Integer.valueOf(i));
				count ++;				
				}
		}	
		
		int A = S.nextInt();
		int B = S.nextInt();
		int AnswerSum = 0; 
		
		ArrayList Answerlist = new ArrayList(list.subList(A-1, B));
		
		Iterator it = Answerlist.iterator();
		
		while (it.hasNext()) {
		AnswerSum += (int)it.next();	
		}
		
		System.out.println(AnswerSum);
		
	}
}