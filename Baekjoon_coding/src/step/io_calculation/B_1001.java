package step.io_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class B_1001 {
	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.print(A-B);*/
		//1. Scanner -> 208ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 스페이스 기준으로 토큰에 저장
		int A = Integer.parseInt(st.nextToken()); //버퍼리더는 string으로 저장되 무저건 정수 변환해줘야 함
		int B = Integer.parseInt(st.nextToken());
		System.out.print(A-B);
		br.close();
		//2. Buffer -> 120ms, 더 효율적인것 확인
	}
}
//기본 입출력 문제, 1000번 빼기로 전환 <입력이 첫째 줄이란 것이 있어, 버퍼를 이용해 readLine으로 작성 가능>
/* 
 BufferReader 
 -> Enter만 경계로 인식하고 return되는 데이터가 String으로 고정되 int사용을 위해선 약간의 변환 필요
 사용법
 1. 하나의 값만 입력할 경우
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 String str = br.readLine(); //엔터 전까지 입력받음.. = 스캐너의 nextLine
 int a = Integer.parseInt(str); //숫자라면 String형 고정이니 변환 필수
 
 2. 여러개의 값 입력
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 StringTokenizer st = new StringTokenizer(br.readLine(),"원하는 구분자"); 
 //기본 스페이스로 구분자, readLine이니 엔터가아닌 한줄로 입력되어야 함.. -> 1 2  o, 1 \n 2 ->오류
 int a = Integer.parseInt(st.nextToken()); //구분자를 기준으로 저장되어있어 구분자 전가지 문자 받아옴.. 숫자는 숫자전환 필수
 //... 반복, 입력된 토큰 길이 만큼
 */ 
