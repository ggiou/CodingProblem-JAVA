package Baekjoon_coding.level.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_2075 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // N번째로 큰수
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); // 우선순위 큐

		for (int i = 0; i < N; i++) { //입력받은 모든 수 중, N번째로 큰수를 반환해야하니 입력받는 과정
			StringTokenizer st = new StringTokenizer(br.readLine()); //한줄에 N개의 숫자가 들어오니 stringTokenizer로 빠르게 분리
			while (st.hasMoreElements()) { //토큰이 있는 동안 반복
				int num = Integer.parseInt(st.nextToken());
				queue.add(num); //우선순위 큐에 우선 넣은 후 (자동으로 숫자가 가장 낮은게 맨위에 배치)
				if (queue.size() > N) { //N번째 수를 구해야하니, 크기가 클 경우
					queue.poll(); //가장 낮은 값을 제거
				}
			}
		}
		System.out.println(queue.peek()); //가상 상단엔 N번째로 큰수가 배치 되어있
		//1. Buffer + 우선순위 큐 = 1004ms
	}
}
// [N번째 큰 수] : 주어진 수들 중 N번째로 큰 수를 구하는 문제
/* 이 문제는 주어진 수들 중 N번째로 큰 수를 찾는 것이 목적인 문제이다 하지만 여기서 N*N 칸의 배열에 가득 찰정도로
   숫자가 들어오게 되는데 N(1 ≤ N ≤ 1,500) 가 가능하며, -10억 ~ 10억 까지의 수가 각 칸안에 들어올 수 있게 되어
   단순히 수를 다 받은 후 정렬해 가져오는 방법을 생각하면 주어진 메모리제한과, 속도가 느려 실패하게 된다.
   
   여기서 주어진 수중 N번째로 큰 수를 가져오는게 목적인 것을 파악하면 쉽게 문제를 해결할 수 있다.
   우선순위 큐를 사용하면된다. 우선 순위 큐는 기준에 맞게(작은, 큰과 같은 우선순위) 자동적으로 큐에 들어갈때 정렬이 되는 큐이다.
   이를 생각하면 우선순위 큐를 수가 작은걸 우선순위에 두며, 넣고 만약 크기가 N보다 크다면 가장 상단의 것을 뺴면, 자연스럽게
   마지막엔 N번째로 큰 수가 남게 된다. 이를 생각하면 위와 같이 간단하게 구현할 수 있다.
   
   ex) [2, 1, 4, 7, 11, 5] 중 3번째로 큰수를 구하고자 할때 위와 같은 알고리즘 동작
   p{2} -> p{1, 2} -> p{1, 2, 4} -> p{(1), 2, 4, 7} -> p{(2), 4, 7, 11} -> p{(4), 5, 7, 11}
   ->p{5, 7, 11} = 이니 p.peek() = 5가 반환되는 방식으로 쉽게 내부적으로 처리된다.
 */
 