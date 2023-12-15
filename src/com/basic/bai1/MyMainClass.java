package com.basic.bai1;


import java.util.Scanner;

public class MyMainClass {
	public static void main(String[] args){
		double x = 0,y=0,z = 0;
		String action;
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Input first number: ");
			while (!scan.hasNextDouble()) {
				System.out.println("Invalid input.\nPlease enter a valid number for x:");
	            scan.next();
			}
			x=scan.nextDouble();
			System.out.println("Input second number: ");
			while (!scan.hasNextDouble()) {
				System.out.println("Invalid input.\nPlease enter a valid number for y:");
				scan.next();
			}
			y=scan.nextDouble();
			System.out.println("Input action (CONG, TRU, NHAN, CHIA, +, -, *, /): ");
			scan.nextLine();
			action=scan.nextLine();
			action=action.toUpperCase();
			if(action.equals("CONG") || action.equals("+") ){
				z=CalculateUtils.CONG(x,y);
			}else
			if(action.equals("TRU") || action.equals("-")){
				z=CalculateUtils.TRU(x,y);
			}else
			if(action.equals("NHAN") || action.equals("*")){
				z=CalculateUtils.NHAN(x,y);
			}else
			if(action.equals("CHIA") || action.equals("/")){
				z=CalculateUtils.CHIA(x,y);
			}
			else {
				throw new IllegalArgumentException("Action's value invalid.");
			}
			System.out.println("Result is: "+z);
		} 
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} 
		finally {
			scan.close();
		}
	}
}
