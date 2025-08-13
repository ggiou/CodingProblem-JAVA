package Baekjoon_coding.step.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class B_2525 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); //현재 시각의 시
		int b = sc.nextInt(); //현재 시각의 분
		int c = sc.nextInt(); //요리하는데 필요한 시간
		
		b += c; //요리하는데 필요한 시간 더해주기
		if(b>=60) { //한 시간이 지난다면..
			a += b / 60;
			b = b % 60;
		}
		
		if(a>23) a -= 24; //하루가 지난 시간이라면.. 24시일경우 0
		
		System.out.println(a+" "+b);*/
		//1. if + scanner - 228ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine());
		
		b += c;
		if(b>59) {
			a += b / 60;	//1시간은 60분이니 총 분(b+c)를 60으로 나눈 몫을 현재 시간에 더해주면 요리 완료 시각
			b = b % 60;		//총 분(b+c)를 60으로 나눈 몫이 요리 완료되는 분이 된다..
		}
		
		a = a > 23 ? a - 24 : a;	//하루는 24시간, 24시 부터 0으로 시작 -> 삼항 연산자로 표현
		
		System.out.println(a + " " + b);
		//2. if + 삼항 + buffer - 148ms
		
	}
}
// 2884번의 업그레이드 문제 - 같지만 여기서 변화해야할 시간을 입력받는거만 차이..
/* 현재 시각과 요리 시간을 입력받아 요리 완료 시각을 구하는 문제로 2884번과 로직은 비슷하다.
  - 입력방법
  Scanner,
  BufferedReader - StringTokenizer,
  BufferedReader - 문자열 배열로 받아 - .split 
  이 있으나 여기서 scanner가 가장 성능이 안좋고 버퍼의 두가지 방법은 비슷해 StringTokenizer 방식만으로 작성
  
  - 출력방법
  여러 출력 방법이 있지만 출력하는 내용이 적어 간편한 System.out을 사용
  
  * 여기서도 2884와 같이 2가지를 확인하면된다, 단지 시간이 + 된다는 개념이 바뀐다.
  1. 현 시각에 요리시간을 더 했을 때 60 이상인 경우 = 1시간이 초과 된경우
     이 경우에는 2884 처럼 시간을 정해줘 1시간만 주는 경우가 아닌 그 이상의 시간이 늘수 있다.
     그래서 크게 늘어나는 시간을 확인 후 남은 분을 현재 분으로 넣어주면된다.
     이는 간단히 
     (현 시각 + 요리시간) % 60 = 총 분을 시, 분으로 나눴을 때의 시
     (현 시각 + 요리시간) / 60 = 그 남은 분  
     으로 계산가능하며 여기서 나온 시간은 현재 시간 h에 더해주면된다.
  
  2. 2884와 동일하고 하루는 24시이니 23시 이상은 0시로 리셋된다는 것을 주의해야한다.
     이는 if문과 삼항연산자 switch로 표현이 가능한데 switch문은 코드가 더 복잡해지므로 제외했다.
*/
