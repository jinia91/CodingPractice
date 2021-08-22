import java.util.*;
public class no08 {

	public static void main(String[] args) {

		Scanner S = new Scanner(System.in);
		String N = S.nextLine();

		int u = N.indexOf("U",0);
		int c1 = N.indexOf("C",u+1);
		int p = N.indexOf("P",c1+1);
		int c2 = N.indexOf("C",p+1);
		
		if(c2>0)
		{System.out.print("I love UCPC");}
		else
		{System.out.print("I hate UCPC");}
		
 
		
	}

}
