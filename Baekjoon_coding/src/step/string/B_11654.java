package step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_11654 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		char given = sc.next().charAt(0);*/
		//1. scanner = 200ms
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char given = br.readLine().charAt(0);
		System.out.println((int)given);
		//2. buffer = 124ms
		//->한글자라도 buffer가 빠른 걸 확인 가능
	}
}
//[아스키 코드] : 입력 받은 하나의 문자를 아스키코드 값으로 출력하는 간단한 문제
//아스키코드는 char을 숫자로 변환한 값과 동일하니, 문자를 char형으로 입력 받고 int로 변환해 출력해주면 됨    
