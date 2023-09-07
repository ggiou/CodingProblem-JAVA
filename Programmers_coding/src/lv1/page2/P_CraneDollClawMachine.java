package lv1.page2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P_CraneDollClawMachine {
	public static int[][] boardState;
	public static Map<Integer, Integer> lastX;	//효율성을 위해 x의 마지막 위치(인형이 존재하는 위치)를 판별하면 map에 저장
	public static int x;
	public static int doll;

	public static int getDoll(int y) {
		if (lastX.getOrDefault(y, -99) == -99) { // 저장된 마지막 x의 위치가 없다면
			for (int i = 0; i < boardState.length; i++) {
				if (boardState[i][y] != 0) { // 인형이 있다면
					lastX.put(y, i); // 마지막 y위치를 현재 위치로 지정
					doll = boardState[i][y];	//인형 값을 가져오고
					boardState[i][y] = 0;		//인형을 봅았으니 0 처리
					return doll;
				}
				if (i == boardState.length - 1) {
					lastX.put(y, i); // 마지막 위치일때 인형없어도 탐색한거니 저장
					return 0;
				}
			}
		} else {
			x = lastX.get(y);
			if (x == boardState.length - 1) { // 마지막 칸이면, 어처피 인형이 없으니 0 반환
				doll = boardState[x][y];
				boardState[x][y] = 0;
				return doll;
			}
			lastX.put(y, x + 1); // 마지막 위치 재 설정
			doll = boardState[x + 1][y];	//인형값 가져오기
			boardState[x + 1][y] = 0;		//인형을 뽑았으니 0으로 설정
			return doll; // 마지막 위치이니, 다음칸에서 뽑아야한다.
		}
		return 0;
	}// board에서 인형을 가져오는 함수

	public static int solution(int[][] board, int[] moves) {
		int answer = 0; // 터진 인형의 개수
		boardState = board;
		Stack<Integer> basket = new Stack<Integer>(); // 뽑을 인형을 담을 바구니
		lastX = new HashMap<Integer, Integer>(); // 마지막 y위치를 임시로 담을 맵

		for (int i = 0; i < moves.length; i++) {
			int m = moves[i]-1;		//인덱스는 0부터 시작하니 -1 해줘야함
			doll = getDoll(m);
			if (doll != 0) {
				if (basket.size() > 0 && doll == basket.peek()) { // 가장 위의 인형이 현재 넣을 인형과 같다면 = 동일한 인형이 2개가 쌓이면
					basket.pop(); // 인형 삭제
					answer += 2; // 인형은 2개씩 사라지니 2를 더해준다.
				}else {
					basket.add(doll);	//인형 넣기
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}
}
//[크레인 인형뽑기 게임] : 이 문제는 주어진 2차원 배열에서 주어진 위치의 값들을 가져올떄 2개가 연속으로 같은 값이 가져와질때 해당 숫자의 개수(2배수)를 구하는 문제이다.
/*
 이 문제에서 보자마자 3가지 포인트를 중점으로 두고 문제를 해결했다.
 1. 인형이 들어가있는 board에서 인형을 뽑을(y축) 위치 moves를 제공해주지만, 인형이 없다면 있을때까지 내려가서 뽑아야한다. == (i++, y)로 값들을 가져와 마지만 칸까지 탐색해 0이 아니여야 반환된다.
 2. 1번의 과정을 통해 뽑은 인형을 바구니에 넣었을때 바구니의 그전 인형과 같은 종류 일때 (같은 숫자) 해당 인형이 터지며, answer에 터진 인형의 개수를 더해줘야한다 == stack 사용
 3.  moves의 개수만큼 1, 2번을 반복해야하며, board 크기는 최대 30x30, moves의 개수는 1000까지 가능하다 
      == 1번의 과정을 (0, y)부터 인형을 만날때까지 반복하면 효율성이 좋지 않음 = x축의 마지막 위치를 map에 저장 (map에 .get(y)가 없을때만 반복 (주어진 y 위치의 마지막 집게가 내려간 x위치가 없을때만 반복됨))
 
 이렇게 3가지에 포인트를 두어 문제를 해결했다. 로직 과정을 설명하자면
 1. 총 크레인의 이동횟수인 move의 길이만큼 for문을 반복하며
 2. getDoll() 함수를 통해 move[i] = y축의 위치의 인형이 존재하거나, 마지막 칸일때까지 판별해 인형의 종류를 가져온다.
    [getDoll() 내부 로직]
    [1] 전달된 y를 통해 lastX의 map에서 해당 y축의 위치에 마지막으로 움직인 x축의 위치가 있는지 확인한다. getOrDefault 사용 -> 이를 통해 한번이라도 x축의 위치를 찾았으면 반복해 찾을 필요 x
    	[1-1] 만약 x축의 위치가 없다면 board의 맨위부터 아래까지 for문을 통해 탐색하며, 인형이 존재할때 까지 반복한다. (or 마지막 높이 까지)
    		  -> 인형이 있다면 (boardState != 0)
    	[1-2] 만약 저장된 x축의 위치가 있다면
    		  -> x의 위치를 가져와, 만약 위치가 끝 위치와 같다면 이미 다뽑힌거니 0을 반환
    		  -> 아니라면, 마지막 위치를 +1(마지막 위치가 반환되니 다음칸을 뽑아야함..) 재설정하고, 해당 칸의 인형을 뽑았으니 0으로 세팅, 그 후 인형의 종류를 반환해준다.
    [2] 가져온 인형을 (만약 내부 basket에 1개라도 인형이 존재한다면)  .peek를 통해 가장 상단의 인형을 가져와, 
        [2-1] 비교해 동일하다면 터져야하니 -> 인형이 터진다=꼭대기의 인형이 사라져야하니, .pool을 이용해 없애주고, 한번에 2개씩 인형이 사라지니 answer에 +2를 해주고 다음 move를 비교한다.
        [2-2] 다르다면, 해당 인형을 바구니에 넣고 다음 move를 비교한다.
 이 과정을 move의 크기만큼 반복하면 터진 인형의 수 answer이 반환된다.  
 */
 