package Baekjoon_coding.step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2675 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());//테스트케이스
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); //한 줄에 반복해야할 수, 문자들어와서 구분을 위해서..
			int r = Integer.parseInt(st.nextToken()); //문자하나당 반복해야할 횟수
			String[] word = st.nextToken().split(""); //문자 분리
			for(int j=0; j<word.length; j++) { //문자열의 각 문자들을 r번 반복해 새로운 문자열을 만드는 과정
				for(int k=0; k<r; k++) {
					sb.append(word[j]);
				}
			}
			sb.append("\n"); //다음 테스트케이스로 넘어갈땐 개행문자 "\n" 필요
		}
		//1. buffer + stringBuilder = 120ms
		System.out.println(sb);
	}
}
//[문자열 반복] : 주어진 테스트케이스만큼 들어온 "숫자 문자열"을 문자열의 각 문자를 숫자만큼 반복한 새로운 문자열을 만들어 출력하는 문제 
//stringTokenizer로 숫자, 문자열을 구분해주고 숫자만큼 반복해서 문자열의 각 문자를 출력해주면 된다.(문자열을 split으로 나눠 배열로 바꿔서 각 인덱스를 반복하면 쉬움)