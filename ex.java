
public class ex {

	public static void main(String[] args) {

		
		int x = 7;
		
		int y = 5;

		
		String time = x>y? "�Ϳ�":"��";
		
		
		
		
		
		
		checktype(y);
		
		checktype(y+4);
		
		checktype(y+'2');
		
		System.out.println(0.1+0.1);
		
		System.out.println(x-'0');
		
	}

	static void checktype(String x) {
		System.out.println("String �Դϴ�.");
	}
	static void checktype(int x) {
		System.out.println("int�Դϴ�.");
	}
	static void checktype(char x) {
		System.out.println("char�Դϴ�.");
	}
	
}
