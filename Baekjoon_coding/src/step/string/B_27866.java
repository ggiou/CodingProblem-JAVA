package step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_27866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력이 적어도, 버퍼가 scanner보다 훨씬 효율이 좋음..
		String en = br.readLine();
		int i = Integer.parseInt(br.readLine())-1; //글자의 index가 0부터 시작인데 i번째 글자니 -1을 해줘야함
		System.out.print(en.charAt(i));
		//1.BufferReder + syso = 124ms 
	}
}
//[문자와 문자열] : 입력받은 문자에서 입력받은 숫자번째의 글자를 반환하는 문제
//i번째의 글자를 구하는 거니, charAt으로 i번째 인덱스의 글자를 가지고오면(idx는 0부터 시작되니 -1해줘야함..) 되는 간단한 문제다