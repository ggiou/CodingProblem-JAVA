package Swea_coding.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S15758 {
	public static int getG(int a, int b) { //최대 공약수 구하기
		int n = a % b;
		if (n == 0) {
			return b;
		} else {
			return getG(b, n);
		}
	}
	
	public static int getL(int a, int b, int n) {
		return (a*b)/n;
	}
	
	public static String getSameLengthString(int k, String word) {
		String answer = "";
		for(int i=0; i<k; i++) {
			answer += word;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 정답문자열 담아둘 stringBuilder
		int tc = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 한줄에 들어오니, 분리시켜야함
			String s = st.nextToken(); //비교할 문자 s
			String t = st.nextToken(); //비교할 문자 t
			
			int a = s.length();
			int b = t.length();
			
			if(a<b) {
				int temp = a;
				a = b;
				b = temp;
			}//둘 중 큰 수대로, a, b 입력받아야함.. 변환 해주기
			
			int n = getG(a, b); 
			
			int length = getL(a, b, n);
			
			s = getSameLengthString(length/s.length(), s);
			t = getSameLengthString(length/t.length(), t);
			
			if(s.equals(t)){sb.append("#"+(i+1)+" yes\n");}
			else{sb.append("#"+(i+1)+" no\n");}
		}
		
		System.out.print(sb);
	}

}
//유클리드 호제법 
/*
 * 1. 최대 공약수 - G(Greatest Common Measure)
 *    : 두 수 a, b 중 큰 것으로 작은 것을 나눴을 때 나머지를 구하고 그 다음 부턴 작은 것을 나머지로 나눠서 반복한다. 이때 나머지가 0이나올때 나눈 수가 최대 공약수
 *    ex) a = 135, b = 95 의 최대 공약수를 구하시오.  
 *        : 135 % 95 = 40 -> 95 % 40 = 15 -> 40 % 15 = 10 -> 15 % 10 = 5 -> 10 % 5 = 0 
 *          이니 여기서 0으로 나눠지게 만든, 5가 두 수의 최대 공약수이다.
 * 
 * 2. 최소 공배수 - L(Least Common Multiple) 
 *    : 두 수 a, b의 최소 공배수는 a와 b의 곱을 a와 b의 최대공약수와 나눈것과 같음
 * 
 */
