package step.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_14681 {

	public static void main(String[] args) throws IOException {
		
		/*Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int result = 0;
		if (x>0&&y>0) {
			result = 1;
		}else if (x<0&&y>0) {
			result = 2;
		}else if (x<0&&y<0) {
			result = 3;
		}else {
			result = 4;
		}
		System.out.println(result);*/
		//1. 단순 조건문 - 208ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int result = (x>0&&y>0) ? 1 : ((x<0&&y>0) ? 2 : ((x<0&&y<0 ? 3 : 4)));
		System.out.println(result);
		//2. 삼항 연산자 + buffer - 120ms
		
	}
}
//단순 조건에 대한 출력값 변환 문제 - (이 문제는 조건이 동시에 여러개라 switch의 경우 제외)
/* 문제에서 x, y 의 위치에 따라 사분면에 어디에 위치하는지 판단하는 문제로
 위 풀이와 같이 && 연산자로 x, y가 각각 양이거나 음일 경우를 지정해 풀어도 되고
 아니면 if(x>0){if(y>0) 1 else 4}.. 이런식으로 if 조건문안에 조건문을 넣어 풀어도 된다.
 또한 삼항 연산자를 통해 문제를 풀 수 있지만 식이 길고 복잡해져 알아보기 어려우니
 if문을 사용하는 것이 좋을 것 같다 판단한다.
 
 모든 입력 문제에서는 scanner보다 buffer를 쓰는게 기본적으로 속도가 더 빨리 수행된다..
 */
