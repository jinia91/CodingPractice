
import java.util.*;

public class no1{
    public static void main(String args[]){
    	
    	Scanner scan = new Scanner(System.in);
    	
    	
        int N = scan.nextInt();
        int K = scan.nextInt();
//        int count = 0;             // ��� ������������ ���ڼ��� ī����
//        for(int i = 1; i<=N;i++){  
//            if (N%i == 0){count++;} // ����������� ī���� +1            
//            if (count == K){        
//                System.out.print(i);
//                break;
//                }          
//        }
//        
//        if (count < K) {
//        	System.out.println(0);
//        }
//    }
//   
        int count = 0;
        int[] arr = new int[N + 1];
        for (int i = 1; i < N; i++) {
        	if (N%i == 0) {
        		count++;
        		arr[count]= i;}
        }
        
    System.out.println(arr[K]);
    
    }
        
        
        
}