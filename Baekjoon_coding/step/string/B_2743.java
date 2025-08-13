package Baekjoon_coding.step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_2743 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		String n = sc.next();*/
		//1. Scanner + syso = 204ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		//2. BufferReder + syso = 128ms
		System.out.print(n.length()); //String의 길이 반환
		br.close();
	}
}
//[단어 길이 제기] : 입력받은 문자열의 길이를 출력하는 문제
//단어를 입력받고, length() 함수를 사용하면 쉽게 문제를 풀 수 있다. +입력이 아무리 짧아도 버퍼 사용하는게 훨 속도 빠름..