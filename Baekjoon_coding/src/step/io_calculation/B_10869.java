package step.io_calculation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;



public class B_10869 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.printf("%d\n%d\n%d\n%d\n%d", A+B, A-B, A*B, A/B, A%B);
		sc.close();*/
		//1. Scanner - 208ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		/*
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String answer = (A+B)+"\n"+(A-B)+"\n"+(A*B)+"\n"+(A/B)+"\n"+(A%B);
		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();*/
		//2. buffer - 176ms
		
		StringBuilder sb = new StringBuilder();
		sb.append(A+B).append("\n").append(A-B).append("\n").append(A*B).append("\n").append(A/B).append("\n").append(A%B);
		System.out.println(sb);
		//3. StringBuilder - 132ms
	}
}
//기본 입출력_사칙연산 -> 한줄로 입력이 들어와 buffer 사용 가능
/* 2. BufferedWriter = 버퍼를 이용한 출력
   : 출력 데이터가 바로 전달되지 않고 중간에 버퍼링 후 전달 = 한번 삽질할때마다 가서 버리는 것보다 수레에 가득 채워 한번에 나르는게 더 효과적임
     한번에 모았다가 출력 가능 = (많은 양의 출력을 할때는 버퍼를 사용하는 것이 효율적)
     println()처럼 자동개행기능이 없으므로 개행이 필요할 때 \n을 통해 따로 처리해줘야 함
     
   - 예시 
   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 선언
   String str = "abcdef"; // 출력할 문자열
   bw.write(s); // 출력
   bw.newLine(); // 줄바꿈
   bw.flush(); // 남아있는 데이터 모두 출력
   bw.close();
   * 버퍼를 잡아 두었기때문에 반드시 사용한 후에 마지막에 꼭!! flush()로 다 출력 후 close()로 닫아줘야한다.

  3. StringBuilder
  : String과 문자열을 더할 떄 새로운 객체 생성이 아니라 기존의 데이터에 더하는 방식이라 속도도빠르고 상대적으로 부하 적음
    = 긴 문자열을 더하는 상황이 발생할 경우 사용시 효율적 = 여러 문자열 출력..
  - .append(): 문자열을 추가
  - .insert(int offset, String str): offset 위치에 str을 추가
  - .replace(): 첫번째와 두번째 파라미터로 받는 숫자 인덱스에 위치한 문자열을 대체 
  - .substring(int start, (int end)): 인덱싱. 파라미터가 하나라면 해당 인덱스부터 끝까지, 두개라면 시작점과 끝점-1 까지 인덱싱 
  - .deleteCharAt(int index): 인덱스에 위치한 문자 하나를 삭제
  - .delete(int start, int end): start 부터 end-1 까지의 문자를 삭제
  - .toString(): String으로 변환
  - .reverse(): 해당 문자 전체를 뒤집기
  - .setCharAt(int index, String s): index 위치의 문자를 s로 변경
  - .setLength(int len): 문자열 길이 조정, 현재 문자열보다 길게 조정하면 공백으로 채워짐, 현재 문자열보다 짧게 조정하면 나머지 문자는 삭제
  - .trimToSize(): 문자열이 저장된 char[] 배열 사이즈를 현재 문자열 길이와 동일하게 조정, String 클래스의 trim()이 앞 뒤 공백을 제거하는 것과 같이 공백 사이즈를 제공하는 것, 배열의 남는 사이즈는 공백이므로, 문자열 뒷부분의 공백을 모두 제거해준다고 보면 됨
  
  - 예시
  StringBuilder sb = new StringBuilder();
  sb.append(문자열).append(문자열)...;
  System.out.println(sb);
*/