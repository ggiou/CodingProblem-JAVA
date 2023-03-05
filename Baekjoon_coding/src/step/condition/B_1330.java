package step.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_1330 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if (A>B) System.out.println(">");
		else if (A<B) System.out.println("<");
		else System.out.println("==");*/
		//1. 단순 조건문 + scanner - 204ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		String str = (A>B) ? ">" : ((A<B) ? "<" : "==");
		System.out.println(str);
		//2. 삼항연산자 + buffer - 124ms
	}
}
//단순 조건식을 통한 수 비교 문제
//이 문제의 경우 간단히 if문을 통해 들어온 두 수를 비교하거나, 삼항연산자를 이용해 해결할 수 있다.
//총 당연히 scanner보다 buffer가 더 효율이 좋아 삼항연산자에 buffer을 사용해 풀어보았다.

/*조건문 : 조건에 따라 코드의 실행 흐름을 다르게 동작하도록 제어하는 것
 
 *if 문  - 조건식이 true값을 가질때 중괄호 {} 안의 실행문을 작동시킨다.
 ex) if(조건식){
 		실행문; //조건식이 true일 경우 실행
 	}else if(조건식){
 		실행문; //위에 조건식들이 false가 아니며 자신의 조건식이 true일 경우 실행
 	}
 	....
 	else{
 		실행문; //조건식들이 false일 경우 실행
 	}
 	
--> 이렇게 하다보면 조건식이 많아져 코드가 의미 없이 길어지는 경우가 생김
    만약 이런 문제를 단순한 if문을 경우 라인수를 삼항연산자를 통해 획기적으로 줄일 수 있음
    
 *삼항연산자 - (조건문) ? (참 일경우 값) : (거짓 일경우 값)  
  	= 중첩사용가능..->(조건문) ? (참) : ((조건문) ? (참) : (....)) 
  유의할 점
  1. 삼항 연산자를 사용하여 코드의 라인이 줄어들었다고 컴파일 속도가 빨라지는 것은 아님.
  2. 삼항 연산자를 중복해서 처리할 경우. 가독성이 떨어질 수 있으므로 중복처리는 피하는 것이 좋다. 
 */
