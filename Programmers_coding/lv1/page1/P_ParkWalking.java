package Programmers_coding.lv1.page1;

import java.util.Arrays;

public class P_ParkWalking {
	static int[] moveX = { -1, 1, 0, 0 }; // 북 남 서 동 -> x좌표 이동
	static int[] moveY = { 0, 0, -1, 1 }; // 북 남 서 동 -> y좌표 이동

	public static int[] solution(String[] park, String[] routes) {
		int[] answer = new int[2];
		int x = 0;
		int y = 0; // 로봇 강아지 좌표

		char[][] parkState = new char[park.length][park[0].length()]; // 공원 상태 담을 배열
		for (int i = 0; i < park.length; i++) {
			parkState[i] = park[i].toCharArray(); // 공원 상태 입력
			if (park[i].indexOf("S") != -1) { // 시작 지점이 있다면(indexOf는 없을 경우 -1 반환)
				x = i;
				y = park[i].indexOf("S");
			} // 시작 지점 위치 저장
		}

		for (int i = 0; i < routes.length; i++) {
			String[] opn = routes[i].split(" ");
			String op = opn[0]; // 이동할 방향
			int n = Integer.parseInt(opn[1]); // 이동할 칸 수
			int px = x; int py = y; // 로봇 강아지 수행 예상 위치

			for (int j = 0; j < n; j++) {
				if (op.equals("N")) {
					px += moveX[0]; py += moveY[0]; // x, y 이동
				} else if (op.equals("S")) {
					px += moveX[1]; py += moveY[1]; // x, y 이동
				} else if (op.equals("W")) {
					px += moveX[2]; py += moveY[2]; // x, y 이동
				} else if (op.equals("E")) {
					px += moveX[3]; py += moveY[3]; // x, y 이동
				} // 방향에 맞게 한칸씩 이동
				
				if(px>=0&&px<park.length&&py>=0&&py<park[0].length()) {
					if(parkState[px][py]!='X') {
						if(j==n-1) {
							x = px; y = py; //공원 범위안&장애물x&이동칸 수 모두 소진
						}else {
							continue; //마지막 칸 수가 아니라면 다음 불러오기
						}
					}else {
						break; //장애물이 있으면 명령 무시
					}
				}else {
					break; //공원을 벗어날 경우 명령 무시
				}
			}
		}
		answer[0] = x; answer[1] = y; //이동 후 위치 answer값 반환
		return answer;
	}

	public static void main(String[] args) {
		String[] park = {"SOO","OOO","OOO"};
		String[] routes = {"E 2","S 2","W 1"};
		
		System.out.println(Arrays.toString(solution(park, routes)));
	}
}
//[공원 산책] : 조건에 맞게 위치 이동 후 최종 x, y좌표 반환하는 문제
/* 
이 문제는 공원(park)의 크기의 정사각형 칸에 한칸 씩 이동하며, routes라는 명령어에 맞게 칸을 이동시켜
로봇강아지의 최종 x, y 좌표값을 반환하는 문제이다. 여기서 주어진 조건 (범위 out, 장애물(X)만남)에
둘중 하나라도 도달한다면 해당 명령 자체를 취소해야하는 점을 주의하며 풀어야하는 문제이다.   

이 문제는 처음에 단순하게 2차원 배열에 park의 위치(park 문자열 배열의 .length는 공원의 높이 = x가 되고
park[i].length(문자열의 길이)는 공원의 너비 = y가 된다!) 맞는 문자들을 각각 넣어주고 case문을
통해 일일히 방향별(동, 서, 남, 북)로 시작 위치에서 이동시키고, 조건에 해당하면 취소시키는 
방식으로 문제를 풀었으나, 일일히 비교해서 복잡하다보니 2가지 조건을 모두 비교하지 못하며, 취소될 경우
x, y좌표를 복구 시키는 과정에서 잘못됬는지 처음에 테스트 case 20개중 약 4개가 runtime error가
발생하며 문제 해결에 실패했다.

-> 후에 생각을 바꿔,(이동길이안에 장애물이 있으면 명령 취소!) 어처피 한칸씩 이동하며, 이동한 좌표에 장애물(X)의
   여부를 확인해야하고, 범위도 2가지 조건모두 확인해야 한다는 점에 집중하고
   1칸 씩 이동하게되면, 동,서,남,북 어처피 방향별로 이동하는 명령어의 위치 변화는 같으니
   static으로 방향별 이동 위치를 지정해, 보기 쉽고 간편하게 이동되는 것을 표현하게 했다.
   
-> 위 생각에 맞게 우선 적으로, 주어진 명령어의 이동거리 만큼 이동하며 2가지 조건을 비교하기 위해
   이동거리만큼 for문을 반복하며, 주어진 방향에 맞게 1칸씩 이동시켰다. 
   그 후 범위가 벗어난 경우는 break로 명령 취소하고, 
   범위 내부일 경우, X -> 장애물을 만날 경우도 break로 명령 취소하고,
   이동거리만큼 끝까지 이동하면서, 장애물도 만나지 않고 범위 내부인 경우에만 예상 위치에 저장시키는 방식으로 문제를 풀었다.
   그 결과 모든 조건(범위 내부며, 장애물을 만나지 않고, 주어진 이동거리만큼 방향으로 알맞게 이동된 것!)을 지키며 문제를 해결했다.
*/ 

//[문법] break는 break가 포함된 for문 만 탈출 시킴 
