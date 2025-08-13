package Baekjoon_coding.step.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_10950 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t = Integer.parseInt(br.readLine()); //test case
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(a+b).append("\n");
			//bw.write(a+b+"\n");
		}
		System.out.print(sb);
		br.close();
		//bw.flush();
		//bw.close();
		//1. BufferReader + StringBuilder - 120ms
		//2. BufferReader + BufferedWriter - 144ms
	}
}
//A+B-3 - 테스트 케이스 횟수를 받아 반복해 입력을 받아 연산을 출력하는 문제
/*
  이 문제는 첫째 줄에 테스트 케이스 개수가 주어지고, 그 개수만큼 반복해 연산할 수 
  a, b를 입력받아 이를 연산해 출력하는 간단한 문제다.
  
  **고려 사항
    1. 테스트 케이스
       테스트 케이스를 먼저 입력 받고, 그만큼 반복해야하니 
       즉 반복 횟수를 알게 되, for문을 이용해 입력된 수만큼 반복해주는 것이 가장 효율적이다.
       -> 연산은 간단히 입력받은 두수를 더하는 것이니 테스트 케이스를 위한 반복문, 
          하나만 신경쓰고 그 안에서 간단히 코드와 같이 처리하면 된다. 
  
  - 입력방법
 	Scanner,  BufferedReader가 가능하나 buffer가 성능상 좋으므로 코드에는 buffer만 사용
 	  - Scanner 사용시 
 	    	Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
 			int a = sc.nextInt(); int b = sc.nextInt();
 	    과 같은 형식으로 작성하면 되지만 성능은 buffer에 비해 안좋음..
 	    
 	-출력방법
 	기본 System.out, BufferWriter, StringBuilder이 있다.
 	단순한 System.out은 성능이 제일 안 좋을 것이니 코드에선 제외하였다. 
 		- 사용하고 싶으면 그냥 for문 내부에 System.out.println(a+b); 만 적어주면 된다. 
 	반복문과 같이 문자열의 추가와 출력량이 많아지는 경우는 역시 StringBuilder가 더
 	효율적인 것을 확인 할 수 있었다.
 */
