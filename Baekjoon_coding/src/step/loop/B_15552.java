package step.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class B_15552 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine()); //테스트 케이스
		
		for (int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			bw.write(a+b+"\n");
			sb.append(a+b).append("\n");
		}
		
		//bw.flush();
		//bw.close();
		
		//System.out.println(sb);
		br.close();
		//1. BufferReader + BufferWriter - 888ms
		//2. BufferReader + StringBuilder - 868ms
		
	}

}
//빠른 A + B - 제한된 시간 안에 수행해야하는 함정 문제! - 자세한 설명
//(왜 Scanner와 단독 System.out.println을 사용하면 느린지 추후에 블로그에 정리할 예정)

/* 이 문제는 단순히 테스트 케이스만큼 반복해 입력받고 이를 + 연산해 출력한다 생각할 수 있지만,
   실질적으로 과정이 중요한 것이 아닌 수행 시간안에 되야하는! 함정문제이다.
   
   ** 주의 사항
   이 문제는 생각 없이 scanner와 println를 사용한다면 시간제한에 걸려 틀리게 된다.
   여기서 테스트 케이스는 무려 1,000,000개 까지 가능하다.
   이를 유의하여 시간안에 해결하려면 빠른 입, 출력이 중요하므로 그에 맞는 입출력 방식으로 코드를 짜는게 중요하다.
   
   - 입력방법
 	여기서는 속도 제한으로 입출력방식이 가장 문제를 해결하는데 중요한 요소이다.
 	Scanner를 사용할 경우 버퍼사이즈가 작다보니 빈번히 비워줘야하며 
 	정규식을 통해 입력값을 파싱하다보니 속도가 느려진다.
 	이렇기에 이 문제를 해결하기 위해서는
 	여기서는 꼭 BufferReader를 사용해야 한다.   
 	    
 	- 출력방법
 	마찬가지로 속도가 중요하므로 기본 출력법인 println을 사용해서는 안된다.
 	System.out.println을 사용하면 반복 횟수만큼 호출을 해줘야 하니 속도가 느려진다.(최대 테스트 케이스가 큼 ㅠ)
 	그러므로 상대적으로 버퍼에 담았다가 한번에 출력하는 BufferWriter나
 	마찬가지로 문자열을 저장해둬 한번에 출력하는 StringBuilder을 사용해야 문제를 해결할 수 있다.

*/
