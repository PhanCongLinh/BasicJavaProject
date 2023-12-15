package com.basic.bai2;
import java.util.Scanner;
public class MainScreen {
	public static void evenOdd(int n){
		int evenSum = 0, oddSum=0;
		for(int i=0; i<=n; i++){
			if(i%2==0)
				evenSum+=i;
			else
				oddSum+=i;
		}
		System.out.println("Sum of even numbers is: "+evenSum);
		System.out.println("Sum of even numbers is: "+oddSum);
	}
	public static void divisible(int n){
		System.out.print("Numbers divisible by 3 but not divisible by 2:");
		for(int i=0; i<=n; i++){
			if(i%3==0 && i%2!=0)
			System.out.print(" "+i);
		}
	}
	public static void main(String[] args) {
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a number:");
		n=scan.nextInt();
		while(n<=0) {
			System.out.println("Please input a number greater than 0.");
			n=scan.nextInt();
		}
		evenOdd(n);
		divisible(n);
		scan.close();
	}
}
