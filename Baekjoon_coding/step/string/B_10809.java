package Baekjoon_coding.step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


public class B_10809 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); //출력할 문자열 담을 곳
		char alphabet = 'a';
		List<String> words = Arrays.asList(br.readLine().split(""));
		while(alphabet<='z') {
			sb.append(words.indexOf(String.valueOf(alphabet))).append(" "); //indexOf는 없으면 -1 반환
			alphabet++; //char++해주면 다음 알파벳으로 넘어감
		}
		//1. buffer + stringBuilder = 124ms
		System.out.println(sb);
	}

}
//[알파벳 찾기] : a~z까지 각 알파벳이 주어진 문자열에서 몇번째 idx인지 위치를 반환하는 문제(없으면 -1)
//문자열을 받고 리스트로 변환 후 리스트의 indexof(변수) -> 존재하면 존재하는 해당 인덱스 반환, 없으면 -1을 반환해주는 함수를 이용하면 쉽게 풀 수 있다.
//char로 받아 ++ 해 쉽게 다음 알파벳을 비교하며, StringBuilder을 통해 반복적인 출력을 한번에 묶어 출력해 실행속도를 향상시켰다.