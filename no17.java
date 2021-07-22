import java.util.*;
import java.util.Arrays;

public class no17{
    public static void main(String[] args) {

    	Scanner S = new Scanner(System.in);

        int N = S.nextInt();
        
        
        int[][] man = new int[50][2];
        
        for(int i = 0; i <N ; i++) {        	
        	int kg = S.nextInt();
            int height = S.nextInt();

            man[i][0] = kg;
            man[i][1] = height;
        }
        
        
        
        for(int i=0; i<N;i++) {
        	int count = 1;
        	for(int j = 0; j < N;j++) {
        		
        		if(man[i][0]<man[j][0]&&man[i][1]<man[j][1]) {
        		count++;
        		}
        	}
        	
        	System.out.print(count + " ");
        }
        
        
        
    }
}