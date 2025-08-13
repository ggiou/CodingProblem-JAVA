package Baekjoon_coding.step.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_25304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine()); //영수증에 적힌 총 금액
		int n = Integer.parseInt(br.readLine()); //물건의 종류 수 = 반복해 받아야할 횟수..
		int total = 0; //실제 총 가격
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());	//물건의 가격
			int num = Integer.parseInt(st.nextToken());		//물건의 개수
			
			total += price*num;
		}
		
		if(total == x) System.out.println("Yes");
		else System.out.println("No");
		//1. BufferReader + for - 124ms
	}
}
// 영수증 - 입력받은 값과 나중에 입력받은 값들의 총합이 같은지 보는 단순한 반복 연산 문제
/*
  이 문제는 크게 3개의 입력을 받고 이를 통해 입력받은 값과 연산한 값이 같은지 확인하는 문제이다.
  문제 안에서는 영수증의 총액과 실제 물건의 개수와 값을 통해 얻은 실제 총 금액이 같은지 확인하는 문제이다.
 
  ** 해결 과정
     문제를 보면 알 수 있듯이 여기에는 
     1. 영수증의 총금액 = x, 2. 구매한 물건의 종류의 수 = n, 3. 각 물건의 가격 a, 개수 b를 입력받아야한다.
     문제의 목적은 구매한 물건의 실제 가격과 영수증의 적인 총 금액이 일치하는지 확인하는 것이므로
     n번만큼 반복해 각 물건에 맞는 가격 = a(가격) * b(개수)를 다 더한 값을 총 금액 x와 비교하면 쉽게 풀 수 있다. 
 
  ** 고려사항
     1. 물건의 종류
        종류만큼 반복해 가격과 개수를 입력받으니 테스트 케이스처럼 생각해주면된다.
        즉 종류가 몇개인지, 반복횟수 n을 알고있으니 for문을 사용하는 것이 가장 좋다.
        
   - 입력방법
 	Scanner,  BufferedReader가 가능하나 buffer가 성능상 좋으므로 코드에는 buffer만 사용
 	  - Scanner 사용시 
 	    	Scanner sc = new Scanner(System.in);
			int x = sc.nextInt();  int n = sc.nextInt();
 			int price = sc.nextInt(); int num = sc.nextInt();
 	    과 같은 형식으로 작성하면 되지만 성능은 buffer에 비해 안좋음..
 	    
 	- 출력방법
 	여기서는 영수증의 총액과 실제 총 금액이 같다면 Yes, 아니면 No처럼 단순히 하나의 출력을 하니
 	기본 System.out을 통해 처리하는 것이 코드도 간단하고 더 효율적이다.
 	** 실제 bufferWriter사용시 132ms -> 사용하기 위해 불러오고 그런것땜에 그런듯..?
 */
