package Baekjoon_coding.step.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_11022 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		//입력
		
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		//출력 방식
		
		for(int i=1; i<=t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//bw.write("Case #"+i+": ");
			//bw.write(a+" + "+b+" = "); 
			//bw.write((a+b)+"\n"); //보기 복잡하니 분리 + 분리하는 것이 더 빠름..
			sb.append("Case #").append(i).append(": ")
			.append(a).append(" + ").append(b).append(" = ")
			.append(a+b).append("\n");
		}
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();
		//1. bufferReader + for + bufferWriter - 164ms
		//2. bufferReader + for + StringBuilder - 124ms	
	}
}
//A+B-8 - 단순 반복 입, 출력 문제 (11021의 변형 문제)

/* 이 문제는 11021의 변형 문제로 11021번 문제를 "Case #x: A + B = C" 형식으로 바꿔 출력하는 거다. 

- 입력방법
	Scanner,  BufferedReader가 가능하나 buffer가 성능상 좋으므로 코드에는 buffer만 사용
	  
-출력방법
	기본 System.out, BufferWriter, StringBuilder이 있다. //기본은 제외, 비효율
	* bw.writer() 와 sb.append() 모두 - BufferWriter, StringBuilder
	  문자열을 내부에서 ("내용1" + "내용2" ...) 이런식이 아닌
	  - bw.writer("내용1"); bw.writer("내용2")...;
	  - sb.append("내용1").append("내용2")...;
	  이런 형식으로 써야, 최대한 내부의 문자열 결합이 없어야 수행시간이나 메모리 모두 효율적인 것을 알 수 있다.
	  
	  -> 정확힌 모르겠지만, 아마도 + 를 이용하다보면 문자열의 결합이 일어나 수행시간이 느려지는 듯.. 
	 

*/