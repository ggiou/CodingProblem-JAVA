package Baekjoon_coding.step.io_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class B_18108 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		System.out.print(year-543);*/
		//1. Scanner - 204ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine())-543;
		System.out.print(year);
		//2. Buffer - 124ms
	}

}
//불기년도 서기년도로 변환하는 문제 
/*
불기 원년(1년) 서기전 544년 
-> 서기를 불기로 변환할때는 서기년도 + 544
   ex) 서기 2000년 = 불기 2544년

즉 이 문제에서는 불기를 서기년도로 변환이니, 입력받은 수에 -543 해준게 서기년도
*/