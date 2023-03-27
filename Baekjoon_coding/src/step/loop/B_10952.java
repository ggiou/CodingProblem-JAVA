package step.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_10952 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력방식 - 수행시간 단축을 위해 BufferReader 사용
		
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//출력방식
		
		int a, b;
		// 입력받을 a, b 미리 생성 - 그래야 반복문의 조건으로 들어갈 수 있음.. 
		
		do {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(a==0 && b==0) break; //만약 0, 0이 들어오면 기록을 멈춰야함..
			
			sb.append(a+b).append("\n");
			
			//bufferWriter의 경우 정수를 그대로 출력하려하면 오류가 생겨 정수형 -> String형 으로 변환해줘야함..
			bw.write(String.valueOf(a+b));	
			bw.write("\n");
		}while(a!=0 && b!=0);
		
		//System.out.print(sb);
		
		bw.flush();
		bw.close();
		br.close();
	}
	//1. StringBuilder - 128ms
	//2. BufferWriter - 124ms

}
//A+B-5 - 기존의 A + B 문제(10950..)에서 조건문의 범위가 주어지지 않은 문제

/* 이 문제의 경우 기존의 반복문 문제와 다르게 반복의 조건(범위)이 정수 주어지지 않고 
   반복이 끝나는 조건을 알려줘 이에 맞는 경우에 반복을 끝내 출력해야하는 문제이다.
   
   ** 문제 풀이
      위에서 설명했든 이 문제에서는 만약 반복적으로 들어오는 입력 a, b에 0, 0이 순서대로
      들어온다면 반복을 끝내는 조건을 제시해줬다.
      이 같은 경우 for문 역시 무한으로 준 후 조건에 걸리면 break로 끝내로 되지만
      
      이 문제에서는 무저건 한번 이상의 입력이 주어져야하므로 
      이에 따라 한번의 반복은 무저건 실행되야 하는 do-while문으로 문제를 풀었다.
      
      범위가 주어졌을 경우 사용해주는 것이 좋으므로 패스해주고,
      while에 조건이 참일 경우만 반복되므로 a, b가 0이 아닐 경우로 주며 입력을 받고 이 두수의 합을 출력하면 된다.
      
      !!주의 사항
        0, 0이 들어오는 경우는 출력이 되면 안되므로 
        조건문 if를 사용해 0, 0인 경우 break로 조건문을 바로 탈출 시켜주었다.
      -> 이를 생각하면 사실, 무한 반복문을 이용하고 그냥 if문으로 끝내줘도되지만,
         나는 좀 더 문제를 확실히 하기 위해 조건을 주었다..   
         + true - 무한반복으로 주는 것보다 조금 더 수행시간도 빠름 ㅎ
         
   - 입력방법
 	Scanner,  BufferedReader가 가능하나 buffer가 성능상 좋으므로 코드에는 buffer만 사용
 	    
 	-출력방법
 	기본 System.out, BufferWriter, StringBuilder이 있다.
 	수행시간을 단축시키기 위해 기본 출력을 제외 하였다.
      
       
   ** 반복문 무한주는 법 = 무한 반복    
      (1) for (;;)        // 초깃값, 조건식, 변화식을 모두 생략하면 무한 루프
      (2) while (true)    // 조건이 true일 경우 반복이니, true로 설정
      (3) do-while(true)  // 조건이 true일 경우 반복이니, true로 설정
 
 */
