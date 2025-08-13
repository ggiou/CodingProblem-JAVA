package Baekjoon_coding.step.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class B_2480 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int result = 0;
		
		if(a==b && b==c) {
			result = a * 1000 + 10000;
		}else if(a==b || b==c || c==a) {
			if(a!=b) result = c * 100 + 1000;
			else result = a * 100 + 1000;
		}else {
			int max = a;
			if(max<b) max = b;
			if(max<c) max = c;
			result = max * 100;
		}
		
		System.out.println(result);*/
		//1. if + scanner - 208ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int result = 0; //상금
		
		if(a==b && b==c) {	//만약 3개의 숫자 모두 같은 숫자라면..
			result = a * 1000 + 10000;
		}else if(a==b || b==c || c==a) {	//2개의 숫자가 같은 숫자라면..
			if(a!=b) result = c * 100 + 1000;	//3개중 2개의 수가 같으니 a!b가 일치 하지 않으면 
			else result = a * 100 + 1000;		//나머지 하나는 무저건 같은 숫자중 하나..
		}else {	//3개의 숫자가 다 다르면
			int max = Math.max(Math.max(a, b), c); //Math.max를 통해 3중 가장 큰 수 채택
			result = max * 100;
		}
		
		System.out.println(result);
		//2. if + max + buffer - 128ms
	}
}
//주사위 세개 - 입력 값에 대한 조건에 따라 달라지는 출력..
/* 이 문제는 우선 총 2개의 조건을 확인해야한다.
   1. 3개의 주사의의 동일 수 개수 -> 동일한 숫자의 개수에 따라 상금 계산 과정이 다름
     이는 간단히 논리 연산자를 통해 지정해줄 수 있으며, 이때 동시 충족 조건 &가 있으므로 switch는 사용하기 부적절해 if를 사용했다.
     
   2. 2개 경우 같은 값, 다 다를경우 가장 큰 값을 구하기 -> 상금 계산 조건에 해당..
     1) 2개 같을 땐 - 간단히 숫자 3개중 2개의 수가 서로 다르면 나머지 하나의 수는 같은 수에
                    포함 될 수 밖에 없으므로 if문과 !(not) 연산자를 통해 풀었다.
                    
     2) 모두 다를때 - 가장 큰 수를 구해야 하니 크게 3수를 비교하거나 max 함수를 통해 계산할 수 있다.
       		(1) max를 지정 후 max의 값과 비교해 가장 큰 값을 갱신
       		(2) Math.max(비교수1, 비교수2) 함수를 통해 큰 값을 찾음
   
    - 입력방법
    Scanner,  BufferedReader - StringTokenizer || .split
    여기서 한 줄에 3개의 수가 입력되므로  StringTokenizer || .split가 필요하다
    scanner는 가장 성능이 안좋고 이 둘의 성능은 비슷하므로 흔한 st를 사용
    
    - 출력방법
    여러 방법이 있지만 출력이 상금, 하나만 출력하니 간단한 System.out 사용
    
    
    ** Math.max
     * Math
     : Math 클래스는 java.lang.Math의 수학에서 자주 사용하는 상수들과 함수들을 미리 구현해 놓은 클래스다.
       또한 모든 메소드는 클래스 메소드이므로, 객체를 생성하지 않고도 바로 사용가능하다. + lang 이므로 import 필요 없음
     
     * Max() / Min()
     : Math 클래스 안의 메서드 중 하나로 두 개의 인자를 비교하여 큰 값을 리턴하거나 작은 값을 리턴해준다.
         <오로지 숫자(정수, 실수)만 비교가능하며, 문자열은 비교가 불가능하다.>
         <두 값이 같을 경우는 동일한 값을 리턴을 해준다.>
      
      - 사용법
      Math.Max(double a, double b); // Math.Min(double a, double b);
      Math.Max(float a, float b); // Math.Min(float a, float b);
      Math.Max(int a, int b); // Math.Min(int a, int b);
      Math.Max(long a, long b); // Math.Min(long a, long b);

	  = double, float, int, long 총 4개의 타입으로 입력이 가능!
*/
