package Baekjoon_coding.step.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_11021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		//입력
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		//출력 방식
		
		for(int i=1; i<=t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//bw.write("Case #"+i+": "+(a+b)+"\n");
			sb.append("Case #").append(i).append(": ").append(a+b).append("\n");
		}
		
		System.out.println(sb);
		
		bw.flush();
		bw.close();
		br.close();
		//1. bufferReader + for + bufferWriter - 148ms
		//2. bufferReader + for + StringBuilder - 124ms	
	}
}
// A+B-7 - 단순 반복 입, 출력 문제

/* 이 문제는 단순히 처음에 반복할 테스트 케이스를 입력받고 그만큼 반복해
   입력 받은 두 수를 정해진 규칙 "Case #인덱스: 두 수를 더한 합" 방식으로 출력하는 문제이다.
   
   **고려사항
     이 문제도 역시 TestCase만을 고려해주면 쉽게 풀 수 있다. 
     반복되는 횟수를 알고 있으니 역시 for문을 사용해주는 것이 더 쉽고 효율적으로 코드를 작성할 수 있다.
  
   - 입력방법
 	Scanner,  BufferedReader가 가능하나 buffer가 성능상 좋으므로 코드에는 buffer만 사용
 	  
   -출력방법
 	기본 System.out, BufferWriter, StringBuilder이 있다.
 	역시 기본 출력은 효율성에서 떨어지니 여기서는 제외했고 
 	또한 문자의 출력 (\n가 포함된)이다 보니 StringBuilder가 더 효율적임을 알 수 있다. (메모리도 대략 1800KB 정도 이득..)
 
 */
 
  
 
