package step.io_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class B_1000 {
	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.print(A+B);
		sc.close(); //프로그램상에서 다시는 scanner 사용못하는거 생각
		*/
		// 1. scanner
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //reader = scanner
		
		StringTokenizer st = new StringTokenizer(bf.readLine()," "); // tokenizer 선언, space기준으로 구분
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
			
		System.out.print(A+B);
		bf.close(); //close는 명시적으로 최적화를 위해 꼭 붙여주는게 좋음
		//2. Buffer -> 속도 거의 2배 차이남, 버퍼쓰는게 더 이득
		//bufferwriter을 사용시 형변환이 필수라 속도 저하되 그냥 print 사용
	}
}

// 기본 입력 후 출력 문제
/*
1. Scanner : 키보드의 입력이 있을 때 마다 한 문자씩 버퍼로 전송
(space,enter 모두를 경계로 입력값을 인식)
: 즉 데이터를 키보드 입력시마다 전송되 속도가 매우 느린편이니 입출력이 많은 코드에선 지양

2. *Buffer : 버퍼가 가득하거나, 개행문자가 나타나면 버퍼의 내용을 한번에 전송
(enter만을 경계로 입력값을 인식 -> 가공 작업 추가 필요<구분하여 나누기>)
= 데이터의 양이 적을 때는 차이가 미미하지만, 양이 많을 경우에는 
  하나하나씩 전달하지 않고 버퍼에 한번에 모아서 전달하는 buffer가 속도면에서 빠르고 효율적
: 즉 데이터를 한번에 입력해 속도가 빠르니, 입출력이 많은 코드, 데이터의 양이 많은 경우에서 지향

*/