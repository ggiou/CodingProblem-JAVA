package step.oneArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class B_10871 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력 방식 - 효율을 위해 사용  
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //정수의 개수
		int x = Integer.parseInt(st.nextToken()); //비교할 수 x
		
		// 기본 입력된 조건
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		//출력
		
		st = new StringTokenizer(br.readLine());	//한줄로 n개의 정수 입력되니, 토큰으로 나눠 저장해야함

		/*int[] a = new int[n];	//수열 a, 정수 n개만큼 존재	

		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());	//수열 a 배열에 담기
		}
		for(int i=0; i<n; i++) {
			if(a[i]<x) bw.write(a[i]+" ");	//만약 수 x보다 작다면 출력
		}
		bw.flush();
		bw.close();*/
		//1. bufferReader + 배열 + bufferWriter - 208ms
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num<x) sb.append(num).append(" ");
		}
		System.out.print(sb);
		//2. bufferReader + StringBuiler - 168ms
		
	}
}
//x보다 작은 수 - 입력받은 수를 수열과 비교해 작다면 출력 하는 문제
/*
  이 문제는 입력받은 x 정수와 n개의 정수로 이루어진 수열 a의 수를 비교해 작으면 출력하도록하는 문제이다.
  여기서 크게 두가지 방법으로 풀 수 있는데 배열을 이용한 방법, 바로 비교하는 방법이 있다.
  
  ** 해결 과정
  *1. 배열을 이용한 과정
      : 10807문제처럼 배열에 담은 후 하나하나 비교해주면된다.
      (1) n크기의 정수형 배열을 만들어 입력받은 수열 a를 저장한다. 
      (2) 배열에서 수를 하나씩 꺼내와 x와 비교해 x가 더 크다면 출력한다.
      
   2. 바로 비교하는 과정
     : 어처피 비교할 수와, 대상, 대상의 크기가 모두 주어지니 바로 비교해도 무관하다.
     (1) 수열 a의 수를 하나 가져와 x와 비교해 x가 더 크다면 출력한다.
      
  ** 주의 사항
     - 위 과정 모두 반복되는 횟수, n을 아니 for문을 사용하는 것이 더 쉽고 효율적이다.
     - 입력받는 수들이 한줄로 이루어져있으니 효율을 위해 버퍼리더를 사용할 경우
       stringTokenizer로 ' ' 공백으로 문자열로 쪼개서 토큰으로 만들어 위의 과정을 수행한다.
       ! 버퍼리더의 경우 문자열로 밖에 못읽어 꼭 정수형 변환이 필수 
  
  - 입력방법 (입력이 많을 수록 더 버퍼리더가 효율적, 그렇다고 입력이 하나여도 버퍼리더가 좋긴 함..)
 	Scanner,  BufferedReader가 가능하나 buffer가 성능상 훨씬 좋으므로 코드에는 buffer만 사용
  
   - 출력방법
     출력이 반복되야 하니 stringBuilder로 문자열을 만들어 한번에 출력하든, BufferWriter로
     버퍼에 문자열을 넣어두면서 작성하다가 한번에 flush로 출력하는 방식이 일반출력보다 훨 효율적이다. 둘을 이용해 풀이..
  
 
*/