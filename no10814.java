import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class no10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.valueOf(br.readLine());
		
		String[] arr = new String[N];
		
		for (int i =0; i<N; i++) {
			
			String S = br.readLine();
			
			arr[i] = S;
		
			
		}
		
		Arrays.sort(arr, new Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
			
				String[] A0 = arg0.split(" ");
				String[] A1 = arg1.split(" ");
			
				return Integer.valueOf(A0[0]) - Integer.valueOf(A1[0]);
			}
			
		});
		
		StringBuilder SB = new StringBuilder();
		
		for(int i =0; i< arr.length; i++) {
			
			SB.append(arr[i]).append("\n");
		}
		
		System.out.println(SB);
	}

}


/* �ӵ��� 3�質 ����
 * 
 * ������ ��ü�� String[] �� �����ѵ� �̸� �ٽ� ������ �ɰ����� ���ϴ� ������� ���Ҷ����� �ٽ� �ɰ��Ƿ� ���ʿ��� �޸� �Һ�� ������ ����
 * �ݸ� ó������ �ɰ��� �����ϸ� �̸� ���డ��
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
            return getAge() - o.getAge();
    }

    public String toString() {
        return age + " " + name;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        Person[] person = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(person);
        
        for (int i = 0; i < n; i++) {
            sb.append(person[i]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
*/
