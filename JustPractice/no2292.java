package JustPractice;

import java.awt.Point;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class no2292 {

	public static void main(String[] args) throws NumberFormatException, ParseException {

		int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

		Set<Point> set = new HashSet<>();
		
		int maxX = -Integer.MAX_VALUE, minX = Integer.MAX_VALUE, 
				maxY = -Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
		
		for(int i = 0; i< line.length; i++) {
			
			for(int j = i+1; j<line.length; j++) {
				
				long AD_BC = line[i][0]*line[j][1] - line[i][1]*line[j][0];
				long BF_ED = line[i][1]*line[j][2] - line[i][2]*line[j][1];
				long EC_AF = line[i][2]*line[j][0] - line[i][0]*line[j][2];
				
				if(AD_BC == 0 ||
				   BF_ED%AD_BC !=0 ||
				   EC_AF%AD_BC !=0 ) continue;
				
			
				int x = (int)(BF_ED/AD_BC);
				int y = (int)(EC_AF/AD_BC);
				 set.add(new Point(x,y));
				 
				 maxX = Math.max(maxX, x);
				 maxY = Math.max(maxY, y);
				 minX = Math.min(minX, x);
				 minY = Math.min(minY, y);
				
			}
			
		}
		
		int h= maxY-minY +1;
		int w= maxX-minX +1;
		
		String[] answer = new String[h];
		
		char[] dummy = new char[w];
		Arrays.fill(dummy, '.');
		Arrays.fill(answer, new String(dummy));
		
		for(Point p : set) {
		
			char[] cArr = answer[maxY-p.y].toCharArray() ;
			cArr[p.x-minX] = '*';
			answer[maxY-p.y] = new String(cArr);
		}
		
		System.out.println(Arrays.deepToString(answer));
		
		
	}
}