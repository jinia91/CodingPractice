package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2621 {

	static class card{
		String color;
		int num;

		public card(String color, int num) {
			this.color = color;
			this.num = num;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		card[] cards = new card[5];
		
		int ans =0;
		
		for(int i = 0; i < 5; i++ ) {
			
			cards[i] = new card(st.nextToken(), Integer.parseInt(st.nextToken()));
			
		}
		
		if(cards[0].color.equals(cards[1])&&
				cards[1].color.equals(cards[2])&&
				cards[2].color.equals(cards[3])&&
				cards[3].color.equals(cards[4])) {
		
			int max = 0;
			
			for(card maxCard : cards) {
				max = Math.max(maxCard.num,max);
			}
			
			ans = 900 + max;
			
		}
		
		else if()
		
		
	}

}
