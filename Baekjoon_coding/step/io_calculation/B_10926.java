package Baekjoon_coding.step.io_calculation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class B_10926 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		String id = sc.next();
		System.out.println(id+"??!");
		sc.close()*/
		//1. Scanner - 208ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String id = br.readLine();
		/*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//bw.append(id).append("??!"); // 문자열 뒤에 이어 붙여서 출력.. 128
		bw.write(id+"??!"); //이게 .append보다 조금더 빠름.. 124
		bw.flush();
		bw.close();*/
		br.close();
		//2. Buffer - 124ms
		
		StringBuilder sb = new StringBuilder();
		sb.append(id).append("??!");
		System.out.print(sb);
		//3. StringBuilder - 120ms
	}
}
//문자열 이어 붙여 출력하기 -> StringBuilder가 가장 효율적
