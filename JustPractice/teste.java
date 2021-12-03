package JustPractice;

import java.util.*;

public class teste {

	public static void main(String[] args) {
		int amount = 0;
		int pay = 0;
		int balance = amount - pay;

		while (true) {
			System.out.println("물건의 가격을 입력하시오.");
			Scanner sc1 = new Scanner(System.in);
			amount = sc1.nextInt();

			System.out.println("지불 금액을 입력하시오.");
			Scanner sc2 = new Scanner(System.in);
			pay = sc2.nextInt();

			if (pay < amount) {
				System.out.println("금액이 부족합니다.다시 입력해주세요.");
			}

         else if(pay >= amount){
            System.out.println("내신 금액은"+pay+"입니다.");
            System.out.println("거스름돈은"+balance+"입니다.");
            
            int result1 = balance/5000;
            int result2= (balance%5000)/1000;
            int result3 = ((balance%5000)%1000)/500;
            int result4 = (((balance%5000)%1000)%500)/100;
            
            System.out.println("잔돈은 5000원짜리"+result1+"장");
            System.out.println("잔돈은 1000원짜리"+result2+"장");
            System.out.println("잔돈은 500원짜리"+result3+"장");
            System.out.println("잔돈은 100원짜리"+result4+"장");
         }
		}
	}
}