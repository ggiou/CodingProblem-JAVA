package step.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class B_2438 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //별의 높이
		
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				//bw.write("*");
				sb.append("*");
			}
			//bw.write("\n");
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		//bw.flush();
		//bw.close();
		br.close();	//reader 닫기
		//1. BufferReader + 이중 for - 124ms 
		//2. StringBuilder + 이중 for -124ms -> 메모리 100KB정도 더 적게듬
		//Scanner + 기본출력 - 308ms로 확연한 차이로 제외..
		
	}
}
//별 찍기-1 - loop문의 기본 문제중 하나로, 입력받은 수만큼 반복해 *을 찍어주면된다.

/* 이 문제는 이중 loop문의 기본 문제로, 입력받은 만큼 *을 찍어 주면 되는 간단한 문제다.
 
   ** 문제 풀이 
      여기서 입력받은 만큼 *이 한개씩 늘어나게 반복해 출력할 수 있도록 해야하므로
      (* \n ** \n ***\n ...) 기본적으로 입력 받은 높이에 대한 for문을
      만든 후 하나씩 늘어가는 것을 생각해보면 상위 for문의 초기화 부문의 값을 받아오면
      자연스레 하나씩 늘어나므로 이중 for문을 통해 풀면된다.
      -> for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				//i = 1일 경우 -> *
				//    2일 경우 -> **
				//    3일 경우 -> ***
			}
			    // 엔터 필요    -> "\n"
		}		
		또한 i가 변할 때마다 엔터로 입력이 들어가야하니 안쪽 for문 바깥에 \n을 넣어줘야 한다.
 
 	- 입력방법
 	  scanner, bufferReader가 있는데 위에 적어논 것을 보면 알 수 있듯
 	  scanner 사용시 수행시간이 많이 느려져 비효율적이므로 위의 코드는 제외
 	  
 	- 출력방법
 	  마찬가지로 기본출력은 효율성이 떨어지므로 
 	  bufferWriter와 StringBuilder를 통해 작성하였다.
 	  또한 위의 알고리즘상 문자열로 -> "내용1"+"내용2"가 아닌
 	  입력이 반복될떄마다 .append, .write 메서드가 호출되므로 둘의 수행시간이 같은 것을 알 수 있다.
 	  -> 문자열로 + 하는 것보다 메서드 호출해 작성하는게 훨 효율적.. 
 */
