package step.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class B_2739 {

	public static void main(String[] args) throws IOException{
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1; i<10; i++) {
			System.out.printf("%d * %d = %d\n", n, i, n*i);
		}*/
		//1. Scanner + for - 216ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int i = 1;
		/*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (i<10) {
			String s = n+" * "+i+" = "+n*i;
			bw.write(s+"\n");
			i++;
		}
		bw.flush();
		bw.close();*/
		br.close();
		//2. Buffer_Reader&Writer + while - 164ms
		
		StringBuilder sb = new StringBuilder();
		
		do {
			sb.append(n).append(' ').append('*').append(' ').append(i);
			sb.append(' ').append('=').append(' ').append(n*i).append('\n');
			i++;
		}while(i<10);
		
		System.out.print(sb);
		//3. Buffer_Reader + StringBuilder + do~while
	}
}
//구구단 - 반복문을 통해 입력받은 수의 1~9까지의 구구단을 출력하는 문제
/*
	이 문제는 간단히, 들어온 수에 대해 구구단형식의 출력만 해주면 되므로 반복문 방식과 입출력을 생각하고 풀면 좋다.
 	- 입력방법
 	Scanner,  BufferedReader가 가능하며 역시 buffer가 빨라 기본 for을 통한 풀이 외 buffer 사용
 	
 	-출력방법
 	기본 System.out, BufferWriter, StringBuilder이 있다.
 	출력값이 많다면(반복문) StringBuilder를 사용하는 것이 더 속도가 빨라 여기서는 이 출력이 가장 좋은 것 같다.
 	* StringBuilder는 가변속성이 있어 문자열을 append, delete를 통해 문자열을 변경하는게 가능
 	  -> 문자열의 추가, 수정 삭제가 빈번하게 발생할 경우 유용하다! (여기서는 반복문으로 지속적인 문자열 추가..)
 	
 	**반복문 
 	 : 어떤 작업을 반복적으로 실행하고  싶을 때 사용하는 문장으로 
 	   제어문 처음으로 되돌아가 반복 실행하는데 이것을 루핑(looping)이라고 한다.
 	 
 	*1. for : 반복 횟수를 알고 있을 때 주로 사용! 
 	          /정수 변수를 사용하는 것이 좋음
 	 - 사용법
 	    for (초기화식;  조건식; 증감식) {실행문;}
 	    	- 초기화식 : 반복의 시작 지점 지정
			- 조건식 : 언제까지 반복하는가
			- 증감식 : 얼만큼 증가하는가 
			
	*2. while - 조건에 따라 반복할 때 사용, true일 경우 반복, false일 경우 종료
	            /조건식에는 주로 비교 연산식, 논리 연산식 사용
 	 - 사용법
 	    while(조건식) { 실행문; }
 	
 	*3. do-while - while문과 유사하나 조건을 나중에 검사
	            /블록 내부 실행문을 우선 실행하고 그 결과에 따라 반복 실행 여부를 결정함
 	 - 사용법
 	    do {실행문} while (조건식);  
 	       - 조건식이 뒤로 오며 조건식이 true일 경우 반복, false일 경우 탈출
 	         = 무저건 한번은 실행 될 수 밖에 없음!
 	         
 	 !! 반복문 제어
 	 	1. break 문
 	    - for, while, do-while, switch문의 실행을 중지할 때 사용
 	    - 주로 if문과 함께 사용
 	    
 		2. break-label
 	    - for문을 작성하기 전 label을 선언해놓으면 이중 반복문에서 특정 조건이 
 	      만족할 때 반복문을 빠져나갈 수 있음
 	    - 사용법(ex) - label이름을 설정한 곳으로 빠져나옴
 	      label이름:
 	      for(초기화식;  조건식; 증감식) {
			 for(초기화식;  조건식; 증감식){
			 	if(조건식){
			 		break label이름;
			 	}
			 }
		  }
		  
		3. continue문
		- for, while, do-while문에서만 사용
		- for문의 증감 식이나 while, do-while문의 조건식으로 이동
		- if문과 함께 사용
		  = 그냥 무시하고 다음 문장 진행된다 생각!
 */