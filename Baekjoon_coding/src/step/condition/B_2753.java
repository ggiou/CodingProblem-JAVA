package step.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_2753 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		int Y = 0;
		if(year%4==0 && !(year%100==0) || year%400==0) Y = 1;
		System.out.println(Y);*/
		//1. if문 + scanner - 208ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		System.out.println((year%4==0 && !(year%100==0) || year%400==0)?1:0);
		//2. 삼항연산자 + buffer - 124ms
	}
}
//조건에 따른 출력값 변환 문제 - if, 삼항 연산자 (이 문제는 조건이 동시에 여러개라 switch의 경우 제외)

/*문제에서 윤년은 4의 배수이면서(년도를 4로 나눴을때 나머지 0), 100의 배수(년도를 100로 나눴을때 나머지 0)가 아닐때 윤년이며
  또한 400의 배수일 경우는 윤년이다 라는 것을 문제에서 알려주었다. 이를
  &(AND) = 조건이 둘다 참일경우 참, |(OR) = 조건이 하나라도 참일 경우 참, !(NOT) = 거짓 = 아닐 경우
  을 통해 조건을 같이 주면 문제를 해결할 수 있다. 
  여기서는 (4의배수 && !100의 배수) || 400의 배수  
  로 표현가능하다.
  
  ** 자바에서 만약 & 하나만 사용하면 비트 연산자로 사용된다.
     논리연산자로서 사용할려면 &&과 같이 두개를 같이 사용해야한다!
*/
