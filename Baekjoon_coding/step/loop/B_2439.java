package Baekjoon_coding.step.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class B_2439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //별의 높이
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n-i; j++) {
				bw.write(" ");
				sb.append(" ");
			}
			for(int k=1; k<=i; k++) {
				bw.write("*");
				sb.append("*");
			}
			bw.write("\n");
			sb.append("\n");
		}
		System.out.print(sb);
		
		bw.flush();
		bw.close();
		br.close();
		//1. bufferWriter - 136ms
		//2. StringBuilder - 128ms
	}
	
}
//별 찍기-2 - 2438번 문제의 출력 모형만 달라진 문제다.

/* 이 문제는 기본 * 찍기의 업그레이드 문제로 출력 형태가 달라진것이 기존 문제와 차이이다.
   -> 2438번 문제의 출력을 좌우 반전한 모양으로 출력해야 한다.
   
  ** 문제 풀이
     여기서는 2가지로 구분해 출력을 넣어줘야한다. 
     1. " " -> 빈공간의 경우
        빈 공간 = 높이; 빈공간 -= 1 처럼 한칸씩 점점 줄어들며 빈공간을 출력해줘야 하므로
        for(int j=1; j<=n-i; j++) 의 형식으로 작성한다.
        -> *이 하나씩 늘어남에 따라 빈공간의 자리가 하나씩 줄어드는 거고
           이는 높이만큼 반복되니 n-i로 표현해주면 된다.
     2. "*" -> *의 경우
        *은 2438의 방법을 그대로 가져가면 된다.
        하지만 여기서 좌우반전된 모양이므로
     
      !! 빈공간 -> * -> 개행문자 순으로 출력되야한다.
        
		또한 i가 변할 때마다 엔터로 입력이 들어가야하니 안쪽 for문 바깥에 \n(개행문자)을 넣어줘야 한다.

	- 입력방법
	  Scanner, BufferReader -> 스캐너 비효율적이라 생략
	  
	- 출력방법
	  마찬가지로 기본출력은 효율성이 떨어지므로 
	  bufferWriter와 StringBuilder를 통해 작성하였다.
*/