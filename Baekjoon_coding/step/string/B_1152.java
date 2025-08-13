package Baekjoon_coding.step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); //구분자를 안주면 기본적으로 공백을 기준으로 나눔 " "
		System.out.println(st.countTokens()); //분리된 토큰의 개수를 반환해주는 함수
		//1. buffer = 256ms
	}
}
//[단어의 개수] : 입력받은 문자열을 공백" "을 기준으로 구분해, 총 몇개의 단어가 있는지 개수를 출력하는 문제
//문자열을 입력받아 stringTokenizer로 공백을 기준으로 문자열을 토큰으로 나눈 후, countTokens를 사용하면 총 분리된 토큰개수를 반환해줘 이를 출력하면 된다. 