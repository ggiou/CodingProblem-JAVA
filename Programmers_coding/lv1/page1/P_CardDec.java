package Programmers_coding.lv1.page1;

import java.util.HashMap;
import java.util.Map;

public class P_CardDec {

	public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        int order1 = 0;	//cards1의 카드 순서를 기억하는 변수 (현재 몇번쨰 순서의 카드가 들어와야하는지)
        int order2 = 0;	//cards2의 카드 순서를 기억하는 변수
        
        Map<String, String> cardOrderMap = new HashMap<String, String>();
        for(int i=0; i<cards1.length; i++) {
        	cardOrderMap.put(cards1[i], "1 "+i);	//1번 카드덱의 문자열 맵에 저장 (구분을 위해 1을 붙임)
        }
        for(int i=0; i<cards2.length; i++) {
        	cardOrderMap.put(cards2[i], "2 "+i);	//2번 카드덱의 문자열 맵에 저장 (구분을 위해 2을 붙임)
        }
        
        
        for(int i=0; i<goal.length; i++) {
        	String word = goal[i];	//문자를 순서대로 가져옴
        	String[] order = cardOrderMap.get(word).split(" ");	//해당 문자를 맵에 가져옴 / order[0] : 몇번째 카드 뭉치 / order[1] : 해당 문자의 순서
        	if(order[0].equals("1")) {				//1번 카드뭉치에서 가져왔으면
        		if(!order[1].equals(order1+"")) {	//현재 들어와야하는 카드 순서와, 해당 가져온 카드의 순서가 같지 않다면
        			return answer;	//NO 반환
        		}
        		order1 ++;
        	}else if(order[0].equals("2")) {		//2번 카드뭉치에서 가져왔으면
        		if(!order[1].equals(order2+"")) {	//현재 들어와야하는 카드 순서와, 해당 가져온 카드의 순서가 같지 않다면
        			return answer;	//NO 반환
        		}
        		order2 ++;
			}else {
				return answer;	//해당 문자가 없다면 Map에 없다면 NO 반환
			}
        	
        	if(i == goal.length-1) {	//만약 목표 배열의 모든 문자를 통과한다면
        		answer = "Yes";	//만들수 있으니 YES 반환
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] cards1 = {"i", "water", "drink"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		
		String answer = solution(cards1, cards2, goal);
		System.out.println(answer);
	}

}
//[카드덱] : 주어진 문자 배열 두가지를 활용해 요구하는 문자를 만들수 있는지 여부를 판단하는 문제
/*
  이 문제는 주어진 문자 배열 cards1, 2 내부의 문자들이 들어간 순서대로 하나씩 빼서 목표 문자 goal을
  만들수 있는지 판별하는 문제이다. 이 문제를 처음보고 주어진 조건에서는 카드덱의 길이가 짧아 괜찮지만
  효율성을 위해 cards1, 2의 문자열을 앞에 문자(1 or 2)를 붙여주고 몇번째 idx인지와 함께 map에 넣어주고
  해당 goal의 모든 원소들이 map에서 동일한 문자와, 현재 위치가 같다면 (order1 - 1번 카드덱에서 와야하는 카드의 순서 / order2 - 2번 카드덱에서 와야하는 카드의 순서)
  1번 카드덱이라면 order1의 순서와 동일 / 2번 카드덱이면 order2의 순서와 동일 하다면 다음 goal의 문자를 가져오고, 
  이렇게 goal의 모든 원소가 map에서 가져와진다면, 해당 문자를 만들 수 있는 거니 Yes 반환, 하나라도 안되면 못만드니 바로 return No를 반환하는 형식으로 문제를 풀었다.
 */
