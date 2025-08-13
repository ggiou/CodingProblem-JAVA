package Baekjoon_coding.step.io_calculation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class B_10430 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		System.out.printf("%d\n%d\n%d\n%d", 
				(A+B)%C, ((A%C)+(B%C))%C, (A*B)%C, ((A%C)*(B%C))%C);*/
		//System.out.println(계산식); - 4개 가 204ms로 더 빠름..
		//1. Scanner - 212ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		/*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write((A+B)%C +"\n"+ ((A%C)+(B%C))%C +"\n"+ (A*B)%C +"\n"+ ((A%C)*(B%C))%C);
		bw.flush();
		bw.close();*/
		//2. BufferWriter - 172ms
		br.close();
		
		StringBuilder sb = new StringBuilder();
		sb.append((A+B)%C).append("\n").append(((A%C)+(B%C))%C).append("\n")
		.append((A*B)%C).append("\n").append(((A%C)*(B%C))%C);
		System.out.println(sb);
		//3. StringBuilder - 124ms
	}

}
//기본 입출력, 원하는 공식을 출력하는 문제
//역시나 스캐너, 버퍼라이터, 스트링빌더 세개로 출력이 가능하고, 문자열을 총 4개를 출력하는 거니
//많은 문자열을 이어 붙여 출력하는 것이니 stringBuilder가 가장 빠름