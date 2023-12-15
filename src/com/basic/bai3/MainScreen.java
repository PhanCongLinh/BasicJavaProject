package com.basic.bai3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class MainScreen {
	static String fullName, address, dob, gender, temp;
	static float finalGrade;
	static Date date;
	static ArrayList<student> studentList = new ArrayList<>();
	
	public static void inputInfo(){
		date=null;
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Input student infomation.");
		System.out.println("Full name: ");
		fullName = scan.nextLine();
		System.out.println("Address: ");
		address = scan.nextLine();
		System.out.println("Date of birth: ");
		dob = scan.nextLine();
		while(date==null){
			try {
				date = dateFormat.parse(dob);
			} catch (ParseException e) {
				System.out.println("Day of birth entered with wrong format(dd/MM/yy), please try agian:");
				dob = scan.nextLine();
			}
		}
		System.out.println("Gender: ");
		gender = scan.nextLine();
		System.out.println("Final Grade: ");
		while(!scan.hasNextDouble()) {
			System.out.println("Please input a number: ");
			scan.next();
		}
		finalGrade = scan.nextFloat();
		student student = new student(fullName, address, dob, gender,finalGrade);
		studentList.add(student);
		System.out.print("Do you want to continue (Y/N):");
		scan.nextLine();
		temp = scan.nextLine();
		while(!temp.equalsIgnoreCase("Y")&&!temp.equalsIgnoreCase("N")){
			System.out.println("Please input Y or N:");
			temp = scan.nextLine();
		}
		if(temp.equalsIgnoreCase("Y"))
		inputInfo();
		scan.close();
	}
	
	public static void showInfor(){
		for(student student:studentList){
			System.out.println("\nStudent infomation:");
			System.out.println("FullName: "+ student.getFullName());
			System.out.println("Address: "+ student.getAddress());
			System.out.println("Day of birth: "+ student.getDob());
			System.out.println("Gender: "+ student.getGender());
			System.out.println("Final Grade: "+ student.getFinalGrade()+"\n");
		}
	}
	
	public static void ranking(){
		for(student student:studentList){
			float grade=student.getFinalGrade();
			String name= student.getFullName();
			if(grade<4.0)
				System.out.println("Student " + name +" learn ability is poor.");
			if(grade>=4.0 && grade< 5.0)
				System.out.println("Student " + name +" learn ability is weak.");
			if(grade>=5.0 && grade< 5.5)
				System.out.println("Student " + name +" learn ability is little weak.");
			if(grade>=5.5 && grade<6.5)
				System.out.println("Student " + name +" learn ability is average.");
			if(grade>=6.5 && grade<7.0)
				System.out.println("Student " + name +" learn ability is above average.");
			if(grade>=7.0 && grade<8.0)
				System.out.println("Student " + name +" learn ability is good.");
			if(grade>=8.0 && grade<8.5)
				System.out.println("Student " + name +" learn ability is pretty good.");
			if(grade>=8.5 && grade<=10)
				System.out.println("Student " + name +" learn ability is excellent.");
		}
	}
	public static void avgGrade(){
		double grade = 0, avg;
		for(student student:studentList){
			grade+=student.getFinalGrade();
		}
		avg= grade/studentList.size();
		System.out.print("\nStudents's average grade is: " + avg);
	}
	public static void main(String[] args){
		inputInfo();
		showInfor();
		ranking();
		avgGrade();
	}
}
