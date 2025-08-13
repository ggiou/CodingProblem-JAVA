package Programmers_coding.lv1.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_NearestLetter {
	
	 public static int[] solution(String s) {
	        List<Integer> answer = new ArrayList<Integer>();
	        
	        Map<String, Integer> sMap = new HashMap<>(); //문자의 바로 전 위치를 담을 배열 (key: 해당 문자, value: 바로 전 위치)
	        String[] sArray = s.split(""); //문자열의 각 문자의 가장 가까운 문자
	        
	        for(int i=0; i<sArray.length; i++) {
	        	String ch = sArray[i];
	        	if(sMap.getOrDefault(ch, -999) == -999) {	//만약 현 위치 전에 해당 문자를 사용한 적이 없다면
	        		sMap.put(ch, i);
	        		answer.add(-1);	//-1을 반환
	        	}else {
	        		int oldIdx = sMap.get(ch);
	        		answer.add(i-oldIdx);	//전 위치가 있을 경우, 현재 내 idx기준으로 얼마나 뒤인건지 판단해야하니, i-oldIdx를 더해줘야함
	        		sMap.put(ch, i); //현 위치 기준 바로 전에 사용한 idx를 구해야하니 값 재세팅(가장 가깝게 사용한 위치가 나와 얼마나 차이나는지 반환해야 함)
	        	}
	        }
	        
	        return answer.stream().mapToInt(Integer::intValue).toArray();	//배열로 반환하기 위해 stream을 통해 list -> array 변환
	    }

	public static void main(String[] args) {
		String s = "banana";
		int[] answer = solution(s);
		System.out.println(Arrays.toString(answer));
	}

}
//[가장 가까운 같은 글자] : 주어진 문자열에서 현 idx의 문자를 사용한 가장 가까운 위치가 내 위치에서 얼마나 떨어졌는지 반환하는 문제
/*
이 문제에서 1 ≤ s의 길이 ≤ 10,000라는 조건을 보고, 많은 수의 비교가 필요할테니, string 자체에서 바로 전의 문자 위치를 
찾기 보다, map을 사용해 각 문자의 가장 최근에 사용된 위치를 저장해 가져다 쓰는 것이 더 효율적이라 판단해 map을 사용해 문제를 풀었다.

여기서 문자열 자체에서 indexOf를 해도되지만 이보단 split을 통해 "" 빈문자열을 기준으로 분리해주면, 
더 쉽게 코드를 짤 수 있어 우선 작업으로 해당 문자열의 각 문자를 담을 문자 배열 sArray 를 세팅해주고

 1. sArray의 모든 idx의 문자의 바로 전 사용 지점과 얼마나 차이가 나는지 구하는게 목표이므로 for문으로 sArray만큼 반복해주며
    (1) 이때 sMap을 통해 만약 sMap에 존재하지 않는 다면, 현재 위치의 문자 전에 사용한 적이 없으므로 주어진 대로 -1을 answer 배열에 넣어주고
    (2) sMap에 존재한다면, 내 idx를 기준으로 얼마나 차이나는지를 반환하는게 목표니 
        내 idx = i에서 sMap에 저장해둔 전에 사용된 idx를 빼서 해당 값을 answer 배열에 넣고
        가장 내 기준 가까운 거리에서 사용된 = 앞에서 부터 뒤로 비교하니 가장 최근에 사용된 문자열을 의미하게 되니
        sMap의 해당 문자의 value를 현재 index인 i로 put으로 다시 저장해주며
    위의 과정을 반복하면 answer에는 요구하는 숫자 리스트가 생성된다.
    
 2. 이때 반환되는게 숫자 배열로 반환되어야하니
    리스트명.stream().mapToInt(Integer::intValue).toArray()
    를 통해 배열로 변환해 return해주면 쉽게 문제를 해결할 수 있다.
*/
 