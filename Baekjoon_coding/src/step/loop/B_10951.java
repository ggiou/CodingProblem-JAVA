package step.loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_10951 {

	public static void main(String[] args) throws IOException {	
		/*Scanner sc = new Scanner(System.in);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			bw.write(String.valueOf(a+b));
			bw.write("\n");
		}
		bw.flush();
		bw.close();*/
		//1. Scanner의 hasNext() + bufferWriter - 216ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String next = ""; //내장 함수가 없으므로 값을 입력받아 입력받은 값이 없다면(null)이라면 그만..
		
		while ((next=br.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(next);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(a+b).append("\n");
		}
		
		System.out.println(sb);
		br.close();
		//2. BufferReaderd로 null 여부 확인 + StringTokenizer - 124ms 
		
		
	}

}
//A+B-5 - 기존의 A + B 문제(10950..)의 입력이 EOF인 문제

/* 이 문제의 경우 반복을 끝내는 조건이 따로 존재하지 않고 아무것도 입력되지 않는
   경우 반복을 끝내는 EOF를 활용해 A+B문제에 접목시켰다.
   
   ** 문제 풀이
      이 문제는 반복문이 종료되는 시점이 들어오는 값이 없을 경우이다.
      이 경우를 EOF라 칭하고 데이터 소스로부터 더 이상 읽을 수 있는 데이터가 없음을 의미한다.
      여기서는 크게 2가지 방법으로 문제를 풀 수 있다.
      
      1. Scanner 사용
         scanner의 경우 내부 메소드중 
         hasNext()는 입력된 토큰이 있으면  true를 반환하고, 그렇지 않을 경우 false를 반환 한다.
         이를 이용해 while문에 hasNext로 조건을 넣어주면 입력이 있는 동안 반복된다.
         - while (sc.hasNext()) { 내부 동작 }
      
      2. BufferReader 사용
         bufferReader는 scanner와 달리 내부적으로 입력을 확인하는 메소드가 없으므로
         입력되어진 값이 = null이라면 반복문을 종료하도록 조건을 임의로 주면된다.
         - String next = "";
		   while ((next=br.readLine())!=null){ 내부 동작 }
          !!주의 사항
            - readLine은 공백을 포함에 한행을 전부 읽기 때문에 공백을 분리해줘야 한다. - StringTokenizer 사용(성능이 좋음)
            - 반복 여부를 확인할 문자열 변수를 밖에 선언해줘야 조건부 내부에서 판단 후 반복문 내부에서도 사용이 가능하다.
            - 내부 동작시 받아온 입력을 사용하려면 새로 readLine이 아닌 변수로 받아야한다 - 여기서는 next
        
         
   - 입력방법
 	Scanner,  BufferedReader가 가능, 위에서 설명 - 역시 버퍼리더가 더 성능이 좋음
 	+ 입력받은 숫자인 문자열을 반환해줄때는 꼭 숫자형으로 변환 시켜줘야한다.
 	  - Integer.parseInt()
 	    
 	-출력방법
 	기본 System.out, BufferWriter, StringBuilder이 있다.
 	수행시간을 단축시키기 위해 기본 출력을 제외 하였다.
 	  
 	   
   !!! 이 문제에서 보면 알 수 있듯 가장 중요한 점이 파일 종료 조건이 없이 그냥 입력이 주어졌다.
       이는 즉 입력에서 더이상의 읽을 수 있는 데이터가 존재하지 않을 때 반복문을 종료하라는 것이고,
       이런 데이터가 더이상 존재하지 않는 상태를 EOF라 한다.
        	   
   ** EOF 
      : 파일의 끝. 즉 더 이상 읽을 데이터가 없는 것을 나타내는 단어
      - 예로, 알고리즘 문제에서 랜덤으로 주어지는 입력데이터를 EOF로 문제를 해결할 수 있다.   
      
      -> EOF 처리방법은 위의 Scanner, BufferedReader로 가능하며 위에 설명했으므로 여기서는 생략..
 
 */
