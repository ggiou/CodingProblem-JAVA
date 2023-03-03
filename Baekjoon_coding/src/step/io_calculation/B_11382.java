package step.io_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class B_11382 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
	    long A = sc.nextLong();
	    long B = sc.nextLong();
	    long C = sc.nextLong();
	    System.out.println(A+B+C);*/
		//1. Scanner - 212ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A  = Long.parseLong(st.nextToken());
		long B  = Long.parseLong(st.nextToken());
		long C  = Long.parseLong(st.nextToken());
		System.out.println(A+B+C);
		//2. Buffer - 120ms 
	}
}
//<함정> 기본 입출력 문제, 숫자 3개를 한줄에 입력받아 이의 합을 구하는 문제
/* 함정 문제 
   1. 입력의 범위가 1 <= x <= 10의12승 즉 long으로 받아줘야함
   2. 시간제한 1초, 메모리제한 512mb로 제한이 있음, 이를 유의해 최대한 효율적인 방법을 제출하는게 중요
     : 여기서는 제한이 넓다보니 scanner도 가능하지만 상대적으로 빠른 buffer을 이용하는게 좋음
*/