package Baekjoon_coding.step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11720 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] words = br.readLine().split("");
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum+=Integer.parseInt(words[i]);
		}
		//1.Buffer + split = 124ms
		System.out.print(sum);
	}

}
//[숫자의 합] : 입력받은 한줄의 문자열에서 ""을 기준으로 분리해 모든 숫자를 더하는 문제
//split을 통해 문자열을 분리하고 이를 더해주면 된다. -> stringtokenizer은 안됨 (밑에 보기)...
//StringTokenizer은 기본적으로 공백을 기준으로 토큰을 분리 -> 공백없음 하나의 문자열로 인식.. = "가나다"->빈칸이 없으니 "가나다"로 인식..