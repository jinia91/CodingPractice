package JustPractice;

import java.util.*;

public class teste {

	public static void main(String[] args) {
		int amount = 0;
		int pay = 0;
		int balance = amount - pay;

		while (true) {
			System.out.println("������ ������ �Է��Ͻÿ�.");
			Scanner sc1 = new Scanner(System.in);
			amount = sc1.nextInt();

			System.out.println("���� �ݾ��� �Է��Ͻÿ�.");
			Scanner sc2 = new Scanner(System.in);
			pay = sc2.nextInt();

			if (pay < amount) {
				System.out.println("�ݾ��� �����մϴ�.�ٽ� �Է����ּ���.");
			}

         else if(pay >= amount){
            System.out.println("���� �ݾ���"+pay+"�Դϴ�.");
            System.out.println("�Ž�������"+balance+"�Դϴ�.");
            
            int result1 = balance/5000;
            int result2= (balance%5000)/1000;
            int result3 = ((balance%5000)%1000)/500;
            int result4 = (((balance%5000)%1000)%500)/100;
            
            System.out.println("�ܵ��� 5000��¥��"+result1+"��");
            System.out.println("�ܵ��� 1000��¥��"+result2+"��");
            System.out.println("�ܵ��� 500��¥��"+result3+"��");
            System.out.println("�ܵ��� 100��¥��"+result4+"��");
         }
		}
	}
}