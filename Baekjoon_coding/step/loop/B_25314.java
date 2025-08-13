package Baekjoon_coding.step.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_25314 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //정수 = 맞게 자료형 출력
		
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//String dataType = ""; //bw는 문자열을 다 출력해야하니, 문자열을 붙이기 위한 변수 지정 -> long long ... int
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<n/4; i++) {
			//dataType += "long ";
			sb.append("long ");
		}
		//dataType += "int";
		//bw.write(dataType);
		//bw.flush();
		//bw.close();
		
		sb.append("int");
		
		System.out.println(sb);
		
		br.close();
		//1. BufferReader + BufferWriter = 128ms
		//2. BufferReader + StringBuilder = 124ms
		
	}

}
// 코딩은 체육과목 입니다 - 이 문제는 주어진 횟수만큼 반복된 문자를 출력하는 문제이다.
/*
   이 문제는 간단히 n이 입력되면 그 만큼 반복해 long을 출력해주면 되는 기본적인 반복 출력 문제이다.
  
    ** 해결 과정
       문제가 길어 헷갈릴 수 있지만 결론적으로 long int가 4바이트이니 4의 배수만큼 long을 붙여 자료형을 표현한다!
       라고 생각했을 때 이를 출력하는 문제로, 간단히 자료형으로 변환할 = 반복할 횟수인 n을 받아
       n/4 만큼 반복해 long을 출력하고 마지막에 int를 출력하면 되는 쉬운 문제이다.
     
    ** 고려사항
       1. 여기서 n/4만큼의 반복은 for, while, do-while 모두 상관없으나 
          반복 횟수를 알고 있으니 가장 적합한 for을 사용하였다.
       
    - 입력방법
 	Scanner,  BufferedReader가 가능하나 buffer가 성능상 좋으므로 코드에는 buffer만 사용
 	  - Scanner 사용시 방법 
 	    	Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
 	   
 	    = 입력이 하나더라도 어쩄든 scanner보다 buffer가 훨 좋음 - 같은 조건의 출력이라해도
 	      scanner - 208ms, buffer - 128ms 거진 80ms 차이나니 왠만해서 buffer가 좋음
 	    
 	- 출력방법
 	기본 System.out, BufferWriter, StringBuilder이 있다.
 	여기서는 개행문자 = 줄이 바뀌는.. 형식의 출력이 아니라 문자열을 이어 붙여 출력하는 것이다 보니
 	System.out.print - 124ms, Buffer - 128ms, StringBuilder - 128ms로
    개행문자가 없이 한줄 출력이라면 실질적인 출력의 수행 속도는 크게 차이가 나지 않는다는 것을 확인할 수 있었다.
  
 */
