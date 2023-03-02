package step.io_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class B_10998{

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.print(A*B);*/
		//1. Scanner -> 212ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); //IOException 필수
		int A = Integer.parseInt(st.nextToken()); //문자열 정수변환 parseInt
		int B = Integer.valueOf(st.nextToken()); //문자열 정수변환 valueOf
		System.out.print(A*B);
		br.close();
		//2. Buffer -> 120ms
	}
}
//기본 입출력 문제, 1000번 곱하기 변형 <입력이 첫째 줄이란 것이 있어, 버퍼를 이용해 readLine으로 작성 가능>
/* 문자열 정수 변환
 1. Integer.parseInt(숫자로 변환할 문자열)
 : 문자열을 기본형 정수(primitive type int)로 리턴
   문자열이 유효한 숫자(ex. 12A)로 포함하지 않으면 NumberFormatException 에러 -> try-catch로 익셉션 처리 필요
   
 2. Integer.valueOf(숫자로 변환할 문자열)
 : 문자열을 정수 객체(integer object)로 리턴 = new Interger(Integer.parseInt(s))
 
 ** 객체 String 변환
 toString() - 대상 값이 null이면 Null PointerException을 발생시키고 Object에 담긴 값이 String이 아니여도 출력 
 valueOf() - 파라미터가 null이면 문자열 "null"을 만들어서 반환
 */