import java.util.*;

public class no19 {
	
	static int count = 0;
	
	
	
	static void self(int n) {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count-n;i++)  sb.append("____");
		if(n==0) {
			System.out.println(sb+"\"����Լ��� ������?\"");
			System.out.println(sb+"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
		}
		else {
		System.out.println(sb+"\"����Լ��� ������?\"");
		System.out.println(sb+"\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		System.out.println(sb+"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		System.out.println(sb+"���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		n--;
		
		if(n!=-1) {
		self(n);}
		}
		
		
		System.out.println(sb+"��� �亯�Ͽ���.");
		
	}
	
	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		count=S.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		self(count);
	}
}
