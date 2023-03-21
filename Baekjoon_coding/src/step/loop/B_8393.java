package step.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_8393 {
	
	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i=1; i<=n; i++) sum += i;
		System.out.println(sum);*/
		//1. Scanner + 단순 for - 212ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = sumN(n);
		System.out.println(sum);
		//2. BufferReader + 재귀 함수 - 124ms
		//3. BufferReader + 단순 for - 120ms
	}
	
	public static int sumN(int n) {
		if(n==1) return 1;
		else return n + sumN(n-1);
	}	//재귀 함수 -> n=6일 경우 6+sumN(5)+sumN(4)+sumN(3)+sumN(2)+sumN(1)
}
//합 - 숫자를 받아 1부터 숫자까지의 합을 구하는 단순 반복 연산문제
/* 이 문제는 1부터 N까지의 합을 구하는 문제로 크게 두 가지 방식으로 연산을 할 수 있다.
   1. 단순 for문
     : 단순히 1부터 n까지 반복해 더한다 생각하면, for문을 통해
       i=1, i<=n 까지 반복해 i를 더해주면 된다.
       -> 여기서는 문제가 간단하다보니 오히려 재귀함수를 만드는 것보다 for문이 더 효율이 좋았다.
   
   2. 재귀함수
     : 1부터 n까지 더하는 것은 단순히 생각하면 현재 숫자에, 나보다 1작은 숫자를
       더한다 생각할 수 있다. 이를 n + 함수(n-1) 과 같은 형식으로 표현할 수 있다.
       -> 입력의 범위가 작다면 오히려 비효율 적일 수도있다. - 함수를 호출하는데 사용되는 시간..
 
   - 입력방법
 	Scanner,  BufferedReader가 가능하고, 입력이 작더라도 (1개니..)
 	buffer를 활용하는 게 훨씬 효율적인 것을 알 수 있다.
 	   
 	-출력방법
 	기본 System.out만 사용한다. - 출력이 딱 숫자 1개니 굳이 다른 출력방법을 사용하지 않았다.
 	
 	
 	** 재귀함수(알고리즘..)
 	   의미 : 함수가 직접 또는 간접적으로 자신을 호출하는 프로세스
 	         -> 재귀 알고리즘을 이용하면 복잡한 문제들도 간단하게 해결 가능..
 	   !반복문과 마찬가지로 재귀함수도 종료지점을 제대로 생각하지 않고 구현을 하면 
 	    스택오버플로우가 발생할 수 있으니 항시 주의해서 구현
 	   
*/
 