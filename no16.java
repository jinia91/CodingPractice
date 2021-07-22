import java.util.*;
import java.io.*;

public class no16{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.valueOf(br.readLine());
        int[] check = new int[10001];
        
        
        for(int i = 1; i<=N; i++){
            int x = Integer.valueOf(br.readLine());
            check[x] += 1;
        }      
        
        for(int i = 0;i<check.length;i++) {
        if(check[i]>0)
            for(int j = 1; j<=check[i];j++)
        	     {sb.append(i).append('\n');}
        }     
        System.out.println(sb);
    }   
    
}