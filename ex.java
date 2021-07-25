
public class ex {

	public static void main(String[] args) {

		
		int x = 7;
		
		int y = 5;

		
		String time = x>y? "와우":"꽝";
		
		
		
		
		
		
		checktype(y);
		
		checktype(y+4);
		
		checktype(y+'2');
		
		System.out.println(0.1+0.1);
		
		System.out.println(x-'0');
		
	}

	static void checktype(String x) {
		System.out.println("String 입니다.");
	}
	static void checktype(int x) {
		System.out.println("int입니다.");
	}
	static void checktype(char x) {
		System.out.println("char입니다.");
	}
	
}
