package Programmers_coding.lv1.page1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_PorrlyMadeKeyboard {
	
	public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> clickKeyMinMap = new HashMap<String, Integer>(); //해당 키의 최소 횟수를 가지고 있는 맵
        int totalClick = 0; //i 번째 target의 총 클릭 횟수
        int minClick = 999; //해당 키를 만들기 위해 누르는 최소 클릭 횟수 
        
        for(int i=0; i<targets.length; i++) {
        	char[] target = targets[i].toCharArray(); //i번째 구해야하는 문자열을 우선 배열에 저장
        	
        	nextTarget:
        	for(int j=0; j<target.length; j++) {
        		String t = String.valueOf(target[j]); //타겟 문자열의 j번째 문자
        
        		if(clickKeyMinMap.getOrDefault(t, -1) == -1) { //해당 키의 최소 클릭 횟수가 저장되어있지 않다면
        			
        			for(int k = 0; k<keymap.length; k++) {
        				if(keymap[k].indexOf(t)!=-1){ //해당 문자가 포함되어 있다면
        					int clkNum = keymap[k].indexOf(t)+1; //해당 문자를 클릭하는 횟수 (idx가 0부터 시작이니 +1 해줘야함)
        					if(minClick>clkNum) { //최소 클릭 횟수보다 작다면
        						minClick = clkNum;
        					}
        				}
        				if(k == keymap.length-1) { //마지막 인덱스라면
        					if(minClick == 999) { //해당 문자가 keymap에 존재하지 않을때
        						totalClick = -1;  //문자를 만들 수 없다면 -1로 반환하고 다음 target을 세야함
        						break nextTarget; //다음 타겟의 최소 횟수 반환을 위해 outerLoop 사용
        					}else {
        						totalClick += minClick; //총 클릭 수에 더해주기
        					}
							clickKeyMinMap.put(t, minClick); //최소값 중복 검사를 막기 위해, 해당 문자의 최소 클릭횟수 넣음
        				}
        			}
        			
        		}
        		else {
        			int mc = clickKeyMinMap.get(t);
        			if(mc == 999) { //구할 수 없는 문자열이 있다면, -1로 반환하고 다음 taget 문자열 클릭 횟수 구해야함
        				totalClick = -1; 
        				break;
        			}else {	
					totalClick += mc; //있다면 최소 횟수 더해주기
        			}
				}//targets의 i번째 문자열의 k번째 문자의 최소 클릭횟수를 구해서 totalclick에 더해주기
        		
        		minClick = 999; //개별 키의 최소 횟수 초기화 시켜줘야함
        	}
        	answer[i] = totalClick; //i번째 문자열을 만들기 위한 최소 총 클릭 횟수 answer에 저장
        	totalClick = 0; //전체 클릭횟수 초기화
        }
        
        return answer;
    }

	public static void main(String[] args) {
		String[] keymap = {"ABACD", "BCEFD"};
		String[] targets = {"ABCD","AABBG"};
		int[] answer = solution(keymap, targets);
		System.out.println(Arrays.toString(answer));
	}

}
//[대충 만든 자판] : 주어진 문자배열의 순서를 통해 이를통해 원하는 문자열을 만들기 위해서는 최소 몇번 이동해야하는지 구하는 문제
/*
이 문제를 보고 처음에는 index of를 통해 비교하면 되겠다 생각했으나, 문자열 키패드(순서 = 몇번 클릭해야하는지 횟수)가 되는 keymap이 
최대 100개 까지 가능하니 이를 비교하기 위해서는 각 조건을 걸어 여러 부분에 대해 생각하며 문제를 풀어야하고, 
몇번 횟수가 필요한지 구해야하는 target 역시도 100개까지 가능하니 map을 통해 각 keymap에서 각 문자를 클릭하기 까지의 최소 횟수를 구해
담고, targets을 통해 구하고자 하는 문자열을 가져와 각 문자를 하나씩 해당 map에서 최소 몇번 누르면 해당 문자를 얻을수 있는지 가져와 풀면되겠다 생각했다.
= 어처피 문자를 한번 클릭하고나면 리셋되기 때문에... 그냥 각 문자에 대해 keymap에서 가져올려면 가장 작은 index(해당문자가 가장앞에 있는..)를 가져와
이를 총 더해주면 되는 간단한문제라 판단했다. 이를 통해

1. targets의 문자열이 keymap대로 칠수있는 문자판이 있다면 해당 문자열을 만들기 위해 최소 몇번 클릭해야하는지 구하는게 목표이니
   targets의 길만큼 for문을 통해 각 최소 몇회인지 구해야한다. 그래서 for문을 선언하고 index번째 문자열을 우선 가져온다.(2번을 통해 char배열로 가져옴..)

2. 그 후 문자열의 각각 문자를 구하는데 필요한 최소 클릭횟수를 모두 구해 더해야하니 for문을 통해 각 문자열의 index의 char을 가져온다.
   가져온 문자열을 각 문자를 구하기 위해 필요한 최소 클릭 횟수를 담은 map에서 값이 없다면,(아직 해당문자가 등록된 최소 횟수가 없다면..)
   -> keymap을 통해 keymap을 for문으로 전체 탐색하며 해당 문자열이 있다면 => indexOf != -1  
      가장 첫번째 index가 최소 클릭횟수가 될테니 넣어주고, 하지만 keymap에는 여러 패턴이 존재하니, 전체를 탐색하며 가장 작은 index를
      계속 끝까지 비교해 작은걸 map에 넣으면된다. 또한 이때 넣어준 클릭수 = index+1은 최소 횟수이니 현재 문자의 최소 횟수와 같으니 총 클릭수에 index+1을 더해주면된다.
   -> 만약 구해놓은 최소 클릭횟수가 있다면 map에서 가져온 클릭수를 총 클릭수에 더해주면된다.
   -> 만약 하나라도 keymap에 존재하지 않는 문자가 있다면 이는 구하지 못하는 문자니 -1을 반환해준다
   이 과정을 반복해 targets의 각 문자열의 전체 클릭횟수를 각각 구해 int[] 배열에 각 구한 횟수를 넣어줘 반환해주면 문제를 해결할 수 있다.
*/
 