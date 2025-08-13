package Programmers_coding.lv1.page1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_RunningRace {

	public static String[] solution(String[] players, String[] callings) {
		String[] answer = new String[players.length];
		Map<String, Integer> nameRank = new HashMap<String, Integer>(); //이름 - 순위
		Map<Integer, String> numRank = new HashMap<Integer, String>(); //순위 - 이름
		
		for(int i=0; i<players.length; i++) {
			nameRank.put(players[i], i);
			numRank.put(i, players[i]);
		}//초기 랭킹 순위 세팅
		
		for(int i=0; i<callings.length; i++) {
			String winner = callings[i];
			int rank = nameRank.get(winner); //바꿀 순위
			String loser = numRank.get(rank-1); //추월당한 사람의 이름 (바로 앞 사람을 추월하니.. -1)
			
			numRank.put(rank, loser); 
			numRank.put(rank-1, winner); //순위에 맞는 이름 바꿔주기
			nameRank.put(winner, rank-1);
			nameRank.put(loser, rank); //이름에 맞는 순위 바꿔주기
		}
		
		for(int i=0; i<players.length; i++) {
			answer[i] = numRank.get(i); 
		} //배열에 변환된 이름 넣기
		
		return answer;
	}

	public static void main(String[] args) {
		String[] players = { "mumu", "soe", "poe", "kai", "mine" };
		String[] callings = { "kai", "kai", "mine", "mine" };

		String[] result = solution(players, callings);
		System.out.println(Arrays.toString(result));
	}

}

//[달리기 경주] : 입력값에 맞게 기존의 배열의 순서를 바꿔서 출력하는 문제
/* 
  초기 이 문제를 제한사항을 제대로 보지 않고 아 그냥 calling의 idx를 찾아 idx-1과 바꿔주면
  되는 간단한 문제라 생각해 초기 배열을 asList로 바꿔 indexOf로 찾아 변경해줌 
  -> 하지만 calling(추월 이름)의 길이가 최대 1,0000,000 이므로 이 방식을 사용하게 되면
  최악의 경우 O(n^2)번 계산해 총 50,000,000,000연산해야 하므로 시간초과로 통과하지 못함
  배열의 시간 복잡도는 O(n), 즉 데이터양이 많아질 수록 찾는 시간이 오래걸림.
  반면 Hash를 이용하면 O(1), 즉 상수 시간으로 계산됨.
  
  시간 초과가 안나야 문제 통과가 되므로 HashMap을 사용한 풀이를 생각함
  1. nameRank(이름-순위) & numRank(순위-이름) 두 가지 HashMap을 세팅함
  2. callings로 추월한 이름의 순위 rank를 nameRank.get으로 키값으로 가져옴.
  3. numRank에서 추월당한 이름을 rank-1로 가져옴 -> (이름이 불린사람이 앞사람을 추월한거니 불린 이름의 사람의 순위에 -1하면 됨)
  4. 가져온 정보를 통해 nameRank, numRank를 각각 바뀐 순위에 맞게 변경해줌
  5. 경주가 끝난 후 순위-이름을 .get으로 answer 배열에 담아줌 ->(완성된 경주, 0위부터 players.length위까지 순서대로 .get으로 담아서 넣음 됨)
 */
