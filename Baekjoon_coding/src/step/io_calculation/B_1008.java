package step.io_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class B_1008 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.printf("%.9f", (double)A/B ); //1. 소수점 출력 printf
		sc.close();*/
		//1. Scanner - 208ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		//String result = String.format("%.9f", (double)A/B); //2. 소수점 출력 String.format
		//double div = Math.round(((A/B)*1000000000)); //3. Math를 통한 소수점 출력
		//System.out.println(div/1000000000); 
		System.out.print(A/B);
		//2. Buffer - 128ms
		
		/*
		String[] num = br.readLine().split(" ");
		double A = Double.parseDouble(num[0]);
		double B = Double.parseDouble(num[1]);
		System.out.print(A/B);*/
		//3. 문자열 배열, br.readLine().split(" ") - 136ms
	}
}
//기본 입력 후 출력 문제 1000번 나누기 변환 <입력이 첫째 줄이란 것이 있어, 버퍼를 이용해 readLine으로 작성 가능>
//총 3가지 방법 - scanner, buffer, String[] / 출력은 애초에 double로 받거나 출력 포맷 통해 소수점 원하는 길이까지 출력가능

/* 소숫점 출력 방법 (double, float과 같은 형식으로 받으면 애초에 소수점 전체 출력..)
 1. printf
 	System.out.printf("%n1.n2f", 실수); 
 	-> n1만큼 출력(왼쪽기준), 자리수가 부족하면 채워짐 & n2만큼 자리수 출력 n2-1에서 반올림
 	
 	double num = 1.66666;
 	System.out.printf("% 2.3f", num); -> " 1.667"									 = 

 2. String.format
    String result = String.format("%n1.n2f", 실수);
 	-> printf와 똑같이 포맷에 맞게 출력됨, 간단히 생각하면 printf의 내용을 string리턴값에 저장해 출력한다 생각..
 
 3. Math
    Math.ceil(a) : 올림 (전달된 실수의 소수 부분을 무조건 올림)
    Math.round(a) : 반올림 (전달된 실수의 소수점 첫번째 자리를 반올림하여 정수로 리턴)
    Math.floor(a) : 내림 (전달된 실수의 소수 부분을 무조건 버림)
    Math.abs(a) : 절대값 (전달된 값이 음수이면 절댓값으로 반환하고 양수이면 그대로 반환)
    
    - Math의 올림 내림 기준은 무조건 소수점을 기준으로 한다. 
      즉 123.4 = 124가 가능하지만 123.56 = 124 o, 올림해서 123.5가 되게 할 수 없다.
      따라서 원하는 연산을 위해서는 적절히 10등 자리수를 곱해주거나 나누어준뒤 다시 반대로 10을 나누어주거나 곱해서 원하는 형태로 변경
    
  ex) double a = 123.567; 를 소수점 둘째자리까지 반올림 하시오..
      double num = (Math.round(a*100))/100; = (Math.round(12356.7))/100 = 12357 = 123.57
*/


