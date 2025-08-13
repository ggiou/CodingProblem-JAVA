package Baekjoon_coding.step.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_9498 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		char grade;
		if(score>= 90) grade = 'A';
		else if (score >= 80) grade = 'B';
		else if (score >= 70) grade = 'C';
		else if (score >= 60) grade = 'D';
		else grade = 'F';
		System.out.println(grade);*/
		//1. 단순 조건문 + Scanner - 212ms
		//else if는 위에 조건을 탐색 후 탐색되니 score<90 && score>80 하지않아도 80~90 범위 조건으로 실행
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int score = Integer.parseInt(br.readLine());
		char grade;
		/*switch (score/10) {
		case 9: case 10: 
			grade = 'A';break;
		case 8:
			grade = 'B';break;
		case 7:
			grade = 'C';break;
		case 6:
			grade = 'D';break;
		default:
			grade = 'F';
			break;
		}
		System.out.println(grade);*/
		//2. switch + Buffer - 128ms
		//score/10을 해주면 1자리로 표현되니 범위를 직접 지정(grade>90)하지 못하는 switch문에서도 사용가능
		//case 9 : case 10 -> grade가 9, 10일 경우 조건 / break문이 없으면 조건 걸리는 이후 쭉 실행..
		
		grade = (score>=90) ? 'A' : (score>=80) ? 'B' : (score>=70) ? 'C' : (score>=60) ? 'D' : 'F'; 
		System.out.println(grade);
		//3. 삼항연산자 + Buffer - 124ms
		//조건이 많아지다보니, 식이 길어지고 보기 복잡해짐..
	}
}
//입력 수를 통해 범위 지정해주는 단순 조건문 문제 - if, switch, 삼항사용 (버퍼가 실행속도 더 좋음)

/* 조건문
*switch~case 문
: 변수의 값이 case의 값과 일치하면 true로 실행문이 실행된다.
case = if, default = else로 생각
ex) switch (변수) {	// 조건
		case 값:		// if 변수 = 값 불일치(미실행)
			실행문;
			break;
		case 값:		// if 변수 = 값 일치 (실행)
			실행문;
			break; // 종료
		...
		default:
			실행문;
		}

** 스위치 문은 case의 조건이 true가 되면 그 시점부터 밑의 실행문을 모두 실행시키는 
   성질을 가지고 있다, 해당 case만 실행 시킬려면 break문으로 탈출시켜야 1개만 실행되고 종료된다.
*/